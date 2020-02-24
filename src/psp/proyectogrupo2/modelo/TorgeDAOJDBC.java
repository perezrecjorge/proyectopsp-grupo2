package psp.proyectogrupo2.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import psp.proyectogrupo2.modelo.tipos.ConexionJDBC;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.DateUtil;
import psp.proyectogrupo2.util.ExcepcionTorge;

/**
 * @author Jorge y Vic
 */
public class TorgeDAOJDBC implements TorgeDAO {


    private final String RETRIEVE_ALL_USERS = "SELECT id, nombre, apellido, nickname, contra, tipo FROM usuario;",
            RETRIEVE_SINGLE_USER = "SELECT id, nombre, apellido, nickname, contra, tipo FROM usuario WHERE nickname = ? and contra = ?;",
            DELETE_USER = "DELETE FROM USUARIOS WHERE id= ?",
            ADD_USER = "INSERT INTO usuario(nombre, apellido, nickname, contra, tipo) VALUES(?, ? ,?, ?, ?);",
            UPDATE_USER = "UPDATE USUARIOS SET NOMBRE=?, APELLIDO=?, NICK=?, CONT=?, TIPO=? WHERE ID=?",
            RETRIEVE_ALL_NEWS = "SELECT id, titulo, cuerpo, autor, fecha FROM noticia;",
            RETRIEVE_SINGLE_NEW = "SELECT * FROM NOTICIAS WHERE ID=?",
            ADD_NEW = "INSERT INTO noticia(titulo, cuerpo, autor, fecha) VALUES(?, ? ,?, ?);",
            DELETE_NEW = "DELETE FROM noticia WHERE id = ?",
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
        Statement comando;
        try {
            comando = conn.openConnection().createStatement();
            ResultSet registro = comando.executeQuery(RETRIEVE_ALL_USERS);

            while (registro.next() == true) {
                res.add(new UsuarioVO(registro.getInt("id"), registro.getString("nombre"), registro.getString("apellido"), registro.getString("nickname"),
                        registro.getString("contra"), registro.getString("tipo")));
            }

            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        return res;
    }


    @Override
    public UsuarioVO getUsuario(String nick, String passw) throws ExcepcionTorge {

        conn.openConnection();
        UsuarioVO res = new UsuarioVO();

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(RETRIEVE_SINGLE_USER);
            comando.setString(1, nick);
            comando.setString(2, passw);
            ResultSet registro = comando.executeQuery();

            while (registro.next()) {
                res.setId(registro.getInt(1));
                res.setNombre(registro.getString(2));
                res.setAp(registro.getString(3));
                res.setNick(registro.getString(4));
                res.setCont(registro.getString(5));
                res.setTipo(registro.getString(6));
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
        System.out.println("ENTRA GUARDAR JDBC");

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(ADD_USER);
            comando.setString(1, p.getNombreUser());
            comando.setString(2, p.getApellido());
            comando.setString(3, p.getNick());
            comando.setString(4, p.getCont());
            comando.setString(5, p.getTipo());

            comando.executeUpdate();

            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        System.out.println("INSERT REALIZADO");

    }

    //The rest of methods are left unused. They belong the to NoticiaVO class.

    @Override
    public List<NoticiaVO> cargarListaNoticias() throws ExcepcionTorge {
        List<NoticiaVO> res = new ArrayList<>();
        NoticiaVO noticia;
        Statement comando;
        try {
            comando = conn.openConnection().createStatement();
            ResultSet registro = comando.executeQuery(RETRIEVE_ALL_NEWS);

            while (registro.next() == true) {
                res.add(new NoticiaVO(registro.getInt("id"), registro.getString("titulo"),
                        registro.getString("cuerpo"), registro.getString("autor"), registro.getString("fecha")));
            }

            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        return res;


    }

    @Override
    public NoticiaVO getNoticia(Integer i) throws ExcepcionTorge {
        return null;
    }

    @Override
    public void guardarNoticia(NoticiaVO n) throws ExcepcionTorge {
        // openConnection();
        System.out.println("ENTRA GUARDAR NOTICIA JDBC");

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(ADD_NEW);
            comando.setString(1, n.getTitulo());
            comando.setString(2, n.getCuerpo());
            comando.setString(3, n.getAutor());
            comando.setString(4, n.getFecha());

            comando.executeUpdate();

            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        System.out.println("INSERT NOTICIA REALIZADO");
    }

    @Override
    public void modificarNoticia(NoticiaVO p) throws ExcepcionTorge {

    }

    @Override
    public void borrarNoticia(NoticiaVO n) throws ExcepcionTorge {

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(DELETE_NEW);
            comando.setInt(1, n.getId());
            comando.executeUpdate();

            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

    }


}
