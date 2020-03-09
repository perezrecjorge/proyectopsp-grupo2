package model;

import java.util.ArrayList;

import model.VO.UsuarioVONormal;
import model.impl.TORGEJDBC;

public class Model {

    TORGEJDBC jdbc = new TORGEJDBC();

    public String getLogin(ArrayList<String> credentials) {
        return jdbc.getLogin(credentials);
    }

    public UsuarioVONormal getUsuario(ArrayList<String> credentials) {
        return jdbc.getUsuario(credentials);
    }

    public ArrayList<String> getUsuario2(ArrayList<String> credentials) {
        return jdbc.getUsuario2(credentials);
    }

}
