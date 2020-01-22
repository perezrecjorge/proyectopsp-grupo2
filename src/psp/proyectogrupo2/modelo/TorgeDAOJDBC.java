package psp.proyectogrupo2.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import psp.proyectogrupo2.modelo.tipos.ConexionJDBC;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

/**
 * @author Jorge y Vic
 */
public class TorgeDAOJDBC implements ModeloTorgeDAO {


    private final String RETRIEVE_ALL_USERS = "SELECT * FROM USUARIOS;",
            RETRIEVE_SINGLE_USER = "SELECT * FROM USUARIOS WHERE ID=?",
            DELETE_USER = "DELETE FROM USUARIOS WHERE id= ?",
            ADD_USER = "INSERT INTO USUARIOS VALUES(?, ?, ? ,?, ?, ?);",
            UPDATE_USER = "UPDATE USUARIOS SET NOMBRE=?, APELLIDO=?, NICK=?, CONT=?, TIPO=? WHERE ID=?",
            RETRIEVE_ALL_NEWS = "SELECT * FROM NOTICIAS;", RETRIEVE_SINGLE_NEW = "SELECT * FROM NOTICIAS WHERE ID=?",
            DELETE_NEW = "DELETE FROM NOTICIAS WHERE ID=?", ADD_NEW = "INSERT INTO NOTICIAS VALUES(?, ?, ?)",
            UPDATE_NEW = "UPDATE NOTICIAS SET NOMBRE=?, CUERPO=?, FECHA=? WHERE ID=?";

    private ConexionJDBC conn;

    {
        try {
            conn = new ConexionJDBC();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public TorgeDAOJDBC() {

    }

    /**
     * @return
     * @throws ExcepcionTorge
     */
    @Override
    public List<UsuarioVO> cargarListaUsuarios() throws ExcepcionTorge {
        List<UsuarioVO> res = new ArrayList<>();
        UsuarioVO usuario;
        conn.openConnection();

        Statement comando;
        try {
            comando = conn.openConnection().createStatement();
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
            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        return res;
    }

    /**
     * @param id
     * @return
     * @throws ExcepcionTorge
     */
    @Override
    public UsuarioVO getUsuario(Integer id) throws ExcepcionTorge {

        conn.openConnection();
        UsuarioVO res = new UsuarioVO();

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(RETRIEVE_SINGLE_USER);
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

            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        return res;
    }

    /**
     * @param p
     * @throws ExcepcionTorge
     */
    @Override
    public void modificarUsuario(UsuarioVO p) throws ExcepcionTorge {
        //openConnection();

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(UPDATE_USER);
            comando.setString(2, p.getNombreUser());
            comando.setString(3, p.getApellido());
            comando.setString(4, p.getNick());
            comando.setString(5, p.getCont());
            comando.setString(6, p.getTipo());
            comando.executeUpdate();


            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }


    }


    /**
     * @param p
     * @throws ExcepcionTorge
     */
    @Override
    public void guardarUsuario(UsuarioVO p) throws ExcepcionTorge {

        // openConnection();

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(ADD_USER);
            ResultSet rs = comando.executeQuery();
            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }


    }

    /**
     * @param id
     * @throws ExcepcionTorge
     */
    @Override
    public void borrarUsuario(Integer id) throws ExcepcionTorge {

        try {
            PreparedStatement comando = conn.openConnection().prepareStatement(DELETE_USER);
            comando.setInt(1, id);
            comando.executeUpdate();
            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }


    }


    //The rest of methods are left unused. They belong the to NoticiaVO class.


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


}
