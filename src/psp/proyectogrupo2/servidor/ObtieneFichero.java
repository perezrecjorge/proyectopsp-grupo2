package psp.proyectogrupo2.servidor;

import java.io.Serializable;

public class ObtieneFichero implements Serializable {

    byte[] contenidoFichero;

    public ObtieneFichero(byte[] contenidoFichero){
        this.contenidoFichero = contenidoFichero;
    }

    public byte[] getContenidoFichero(){
        return contenidoFichero;
    }
}
