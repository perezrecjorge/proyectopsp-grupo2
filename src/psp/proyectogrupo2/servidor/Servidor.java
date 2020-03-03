package psp.proyectogrupo2.servidor;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static Integer PUERTO = 44441;
    static public EstructuraFicheros NF;
    static ServerSocket servidor;

    public static void ejecurtarServidor() throws IOException {
        String Directorio = "";
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("SELECCIONA EL DIRECTORIO DONDE ESTÁN LOS FICHEROS");
        int returnVal = f.showDialog(f, "Seleccionar");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();
            Directorio = file.getAbsolutePath();
            System.out.println(Directorio);
        }
        //si no se selecciona nada salir

        if (Directorio.equals("")) {
            System.out.println("Debe seleccionar un directorio.");
            System.exit(1);
        }
        servidor = new ServerSocket(PUERTO);
        System.out.println(("Servidor iniciado en Puerto: " + PUERTO));
        while (true) {
            try {
                Socket cliente = servidor.accept();
                System.out.println("Bienvenido al cliente");
                NF = new EstructuraFicheros(Directorio);
                HiloServidor hilo = new HiloServidor(cliente, NF);
                hilo.start(); //Ejecutamos el hilo
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}
