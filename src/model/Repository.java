package model;

import model.VO.UsuarioVO;
import model.VO.UsuarioVONormal;

import java.util.ArrayList;

public interface Repository {

    public String getLogin(ArrayList<String> credentials);

    public UsuarioVONormal getUsuario(ArrayList<String> credentials);

    public ArrayList<String> getUsuario2(ArrayList<String> credentials);

}
