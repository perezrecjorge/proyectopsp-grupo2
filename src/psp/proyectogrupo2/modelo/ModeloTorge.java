package psp.proyectogrupo2.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

import java.util.List;

public class ModeloTorge {

    public String nicknameconectado;
    public String contraconectado;
    public String tipoconectado;

	private final TorgeDAOJDBC daojdbc;

	ObservableList<UsuarioVO> plist = FXCollections.observableArrayList();

	public ModeloTorge() {

		this.daojdbc = new TorgeDAOJDBC();
	}

    /**
     * MODELO PARA USUARIO
     */
    public ObservableList<UsuarioVO> cargarListaUsuarios() throws ExcepcionTorge {

        ObservableList<UsuarioVO> res = FXCollections.observableArrayList(daojdbc.cargarListaUsuarios());

        System.out.println("ENTRA MODELO USUARIO");

        return res;
    }

    public void guardarElemento(UsuarioVO usu) throws ExcepcionTorge {

        System.out.println("ENTRA MODELO USUARIO");
        daojdbc.guardarUsuario(usu);

    }

    public UsuarioVO getUsuario(String nick) throws ExcepcionTorge {
        UsuarioVO user = daojdbc.getUsuario(nick);
        return user;
    }

    /**
     * MODELO PARA NOTICIA
     */
    public ObservableList<NoticiaVO> cargarListaNoticias() throws ExcepcionTorge {

        ObservableList<NoticiaVO> res = FXCollections.observableArrayList(daojdbc.cargarListaNoticias());

        System.out.println("ENTRA MODELO NOTICIA");

        return res;
    }

    public void guardarNoticia(NoticiaVO n) throws ExcepcionTorge {

        System.out.println("ENTRA MODELO NOTICIA");
        daojdbc.guardarNoticia(n);

    }

    public void borrarNoticia(NoticiaVO n) throws ExcepcionTorge {

        System.out.println("ENTRA MODELO NOTICIA");
        daojdbc.borrarNoticia(n);

    }


    /**
     * GETTERS AND SETTERS USUARIO CONECTADO
     */
    public String getNicknameconectado() {
        return nicknameconectado;
    }

    public void setNicknameconectado(String nicknameconectado) {
        this.nicknameconectado = nicknameconectado;
    }

    public String getContraconectado() {
        return contraconectado;
    }

    public void setContraconectado(String contraconectado) {
        this.contraconectado = contraconectado;
    }

    public String getTipoconectado() {
        return tipoconectado;
    }

    public void setTipoconectado(String tipoconectado) {
        this.tipoconectado = tipoconectado;
    }
}
