package psp.proyectogrupo2.servidor;

import java.io.*;
import java.net.Socket;

public class HiloServidor extends Thread {
    Socket socket;
    ObjectOutputStream outObjeto;
    ObjectInputStream inObjeto;
    EstructuraFicheros NF;

    //Constructor
    public HiloServidor(Socket s, EstructuraFicheros nF) throws IOException {
        socket = s;
        NF = nF;
        inObjeto = new ObjectInputStream(socket.getInputStream());
        outObjeto = new ObjectOutputStream(socket.getOutputStream());
    }

    public void run() {
        try {
            //envio al cliente el objeto EstructuraFicheros
            outObjeto.writeObject(NF);
            while (true) {
                //Obtengo lo que me pide el cliente
                Object peticion = inObjeto.readObject();
                if (peticion instanceof PideFichero) {
                    //el cliente pide un fichero al servidor
                    PideFichero fichero = (PideFichero) peticion;
                    EnviarFichero(fichero);

                }
                if (peticion instanceof EnviaFichero){
                    //el cliente envia un fichero para cargarlo en el servidor
                    EnviaFichero fic = (EnviaFichero) peticion;
                    File d = new File(fic.getDirectorio());
                    File f1 = new File(d, fic.getNombre());

                    //Se crea el ficheor en el directorio
                    //con los bytes enviados en el objeto
                    FileOutputStream fos = new FileOutputStream(f1);
                    fos.write(fic.getContenidoFichero());
                    fos.close();
                    //Se crea nueva estructura de directorios
                    EstructuraFicheros n = new EstructuraFicheros(fic.getDirectorio());
                    outObjeto.writeObject(n); //Se envia al cliente
                }
            }//while
        } catch (IOException | ClassNotFoundException e) {
            ///cuando un cliente cierrra la conexion
            try {
                inObjeto.close();
                outObjeto.close();
                socket.close();
                System.out.println("Cerrando cliente");
            } catch (IOException ee) {
                ee.printStackTrace();
            }

        }
    }
    //este metodo envia al cliente el fichero solicitado

    private void EnviarFichero(PideFichero fich){
        File fichero = new File(fich.getNombreFichero());
        FileInputStream filein=null;
        try{
            //se abre el fichero en el servidor
            filein=new FileInputStream(fichero);
            long bytes= fichero.length(); //tamaño del fichero
            byte[] buff = new byte[(int) bytes];
            int i,j=0;
            //se van leyendo los bytes del fichero y llamando el array
            while((i=filein.read()) !=-1){
                buff[j]=(byte) i; //se almacenan en el array
                j++;
            }
            filein.close();
            Object ff = new ObtieneFichero(buff);
            //envia objeto ObtieneFichero con los bytes del fichero
            outObjeto.writeObject(ff);
        }catch (FileNotFoundException e){ e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
    }
}
