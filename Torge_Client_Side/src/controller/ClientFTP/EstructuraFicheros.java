package controller.ClientFTP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class EstructuraFicheros implements Serializable {
    private String name;
    private String path;
    private boolean isDir;
    private int numFitch;
    private EstructuraFicheros[] lista;

    public EstructuraFicheros(String name) throws FileNotFoundException {
        File file = new File(name);
        this.name = file.getName();
        this.path = file.getPath();
        this.isDir = file.isDirectory();
        this.lista = getListaFiles();

        if(file.isDirectory()){
            File[] ficheros = file.listFiles();
            this.numFitch = 0;
            if(!(ficheros == null)){
                this.numFitch = ficheros.length;
            }
        }
    }

    public EstructuraFicheros(String name, String path, boolean isDir, int numF){
        this.name = name;
        this.path = path;
        this.isDir = isDir;
        this.numFitch = numF;
    }

    public int getNumFitch(){
        return numFitch;
    }
    public boolean isDir(){
        return isDir;
    }
    public String getPath(){
        return path;
    }

    public EstructuraFicheros[] getLista() {
        return lista;
    }

    public String getName() {
        String name_dir = name;

        if (isDir){
            int l = path.lastIndexOf(File.separator);
            name_dir = path.substring(l+1,path.length());
        }
        return name_dir;
    }

    public String toString(){
        String nom = this.name;
        if(this.isDir){
            nom = "(dir)"+name;
        }
        return nom;
    }

    EstructuraFicheros[] getListaFiles(){
        EstructuraFicheros[] lista = null;
        String sDirectorio = this.path;
        File f = new File(sDirectorio);
        File[] ficheros = f.listFiles();
        int longitud = ficheros.length;
        if (longitud>0){
            lista = new EstructuraFicheros[longitud];
            for(int i = 0; i<ficheros.length; i++){
                EstructuraFicheros elemento;
                String nombre = ficheros[i].getName();
                String path= ficheros[i].getPath();
                boolean isDir = ficheros[i].isDirectory();
                int num = 0;

                if(isDir){
                    File[] fic = ficheros[i].listFiles();
                    if(!(fic==null)){
                        num = fic.length;
                    }
                }
                elemento = new EstructuraFicheros(nombre,path,isDir,num);
                lista[i] = elemento;
            }
        }
        return lista;
    }
}
