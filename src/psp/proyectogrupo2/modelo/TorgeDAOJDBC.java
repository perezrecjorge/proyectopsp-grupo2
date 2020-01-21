package psp.proyectogrupo2.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

public class TorgeDAOJDBC implements TorgeDAO {

    private Connection conex = null;

    private final String RETRIEVE_ALL_USERS = "SELECT * FROM USUARIOS;",
            RETRIEVE_SINGLE_USER = "SELECT * FROM USUARIOS WHERE ID=?",
            DELETE_USER = "DELETE FROM USUARIOS WHERE id= ?",
	ADD_USER="INSERT INTO USUARIOS VALUES(?, ?, ? ,?, ?, ?);",
	UPDATE_USER="UPDATE USUARIOS SET NOMBRE=?, APELLIDO=?, NICK=?, CONT=?, TIPO=?";


    public TorgeDAOJDBC() {
    }

    @Override
    public List<UsuarioVO> cargarListaUsuarios() throws ExcepcionTorge {
        List<UsuarioVO> res = new ArrayList<>();
        UsuarioVO usuario;
        openConnection();

        Statement comando;
        try {
            comando = conex.createStatement();
            ResultSet registro = comando.executeQuery(RETRIEVE_ALL_USERS);

            while (registro.next()) {

                usuario = new UsuarioVO();

                usuario.setId(registro.getInt(0));
                usuario.setNombre(registro.getString(1));
                usuario.setAp(registro.getString(2));
                usuario.setNick(registro.getString(3));
                usuario.setCont(registro.getString(4));
                usuario.setTipo(registro.getString(5));


                res.add(usuario);
            }

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        closeConnection();

        return res;
    }

    @Override
    public UsuarioVO getUsuario(Integer id) throws ExcepcionTorge {

        openConnection();
        UsuarioVO res = new UsuarioVO();

        PreparedStatement comando;
        try {
            comando = openConnection().prepareStatement(RETRIEVE_SINGLE_USER);
            comando.setInt(1, id);
            ResultSet registro = comando.executeQuery();

            System.out.println(registro == null);

            while (registro.next()) {
                res.setId(registro.getInt(0));
                res.setNombre(registro.getString(1));
                res.setAp(registro.getString(2));
                res.setNick(registro.getString(3));
                res.setCont(registro.getString(4));
                res.setTipo(registro.getString(5));

            }

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        closeConnection();

        return res;
    }

    @Override
    public void modificarUsuario(UsuarioVO p) throws ExcepcionTorge {
        openConnection();

        PreparedStatement comando;
        try {
            comando = openConnection().prepareStatement(UPDATE_USER);
            comando.setString(2, p.getNombreUser());
            comando.setString(3, p.getApellido());
            comando.setString(4, p.getNick());
            comando.setString(5, p.getCont());
            comando.setString(6, p.getTipo());
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        closeConnection();

    }

    @Override
    public void guardarUsuario(UsuarioVO p) throws ExcepcionTorge {

        openConnection();

        PreparedStatement comando;
        try {
            comando = openConnection().prepareStatement(ADD_USER);
           ResultSet rs = comando.executeQuery();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        closeConnection();

    }

    @Override
    public void borrarUsuario(Integer id) throws ExcepcionTorge {

        try {
            PreparedStatement comando = openConnection().prepareStatement(DELETE_USER);
            comando.setInt(1, id);
            comando.executeUpdate();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        closeConnection();

    }


    //No se utilizan los siguientes métodos ya que corresponden a la clase NoticiaVO


	@Override
	public List<NoticiaVO> cargarListaNoticias() throws ExcepcionTorge {
		return null;
	}

	@Override
	public NoticiaVO getNoticia(Integer i) throws ExcepcionTorge {
		return null;
	}

	@Override
	public void guardarNoticia(NoticiaVO p) throws ExcepcionTorge {

	}

	@Override
	public void modificarNoticia(NoticiaVO p) throws ExcepcionTorge {

	}

	@Override
	public void borrarNoticia(Integer id) throws ExcepcionTorge {

	}

	private Connection openConnection() throws ExcepcionTorge {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/torge", "root", ""); // TODO
            // CAMBIAR
            // NOMBRE
            // DE LA
            // URL
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            throw new ExcepcionTorge("Clase no encontrada: " + e.getMessage() + "");

        } catch (Exception e) {
            System.out.println(e);
            throw new ExcepcionTorge("Error inesperado: " + e.getMessage() + "");

        }

        return conex;
    }

    private void closeConnection() {
		try {
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
