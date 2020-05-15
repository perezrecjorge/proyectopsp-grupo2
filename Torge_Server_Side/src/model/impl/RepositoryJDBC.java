package model.impl;

import model.Conection;
import model.Repository;
import model.VO.UserVO;
import model.util.ExcepcionTorge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositoryJDBC implements Repository {


    private Conection conn;

    public RepositoryJDBC(){
        conn = new Conection();
    }

    private final String RETRIEVE_ALL_USERS = "SELECT id, name, surname, nickname, password,email, type, paid  FROM usuers;",
            RETRIEVE_SINGLE_USER = "SELECT id, name, surname, nickname, password,email, type, paid FROM users WHERE nickname = ? and password = ?;",
            RETRIEVE_SINGLE_USER_RECUPERAR_CUENTA = "SELECT id, name, surname, nickname, password,email, type, paid FROM users WHERE nickname = ?;",
            DELETE_USER = "DELETE FROM USERS WHERE id= ?",
            ADD_USER = "INSERT INTO users(id, name, surname, nickname, password,email, type, paid) VALUES(?, ? ,?, ?, ?, ?, ?);",
            UPDATE_USER = "UPDATE USUARIOS SET NAME=?, SURNAME=?, NICKNAME=?, PASSWORD=?, EMAIL=?, TYPE=?, PAID=? WHERE ID=?";


    @Override
    public void payTrip(double id) { }

    @Override
    public List<UserVO> loadUserList() throws ExcepcionTorge {







        return null;
    }

    /**
     *
     * @param nick
     * @param passw
     * @return
     * @throws ExcepcionTorge
     */
    @Override
    public UserVO getUser(String nick, String passw) throws ExcepcionTorge {

        conn.openConnection();
        UserVO res = new UserVO();

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(RETRIEVE_SINGLE_USER);
            comando.setString(1, nick);
            comando.setString(2, passw);
            ResultSet registro = comando.executeQuery();

            while (registro.next()) {
                res.setId(registro.getInt(0));
                res.setNombre(registro.getString(1));
                res.setAp(registro.getString(2));
                res.setNick(registro.getString(3));
                res.setCont(registro.getString(4));
                res.setTipo(registro.getString(6));
                res.setEmail(registro.getString(5));
                res.setPagado(registro.getBoolean(7));
            }

            conn.closeConnection();

        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getMessage());
        }

        return res;

    }

    @Override
    public UserVO getUserRecovery(String nick) throws ExcepcionTorge {
        return null;
    }

    @Override
    public void saveUser(UserVO p) throws ExcepcionTorge {


        System.out.println("ENTRA GUARDAR JDBC");

        PreparedStatement comando;
        try {
            comando = conn.openConnection().prepareStatement(ADD_USER);
            comando.setString(1, p.getNombreUser());
            comando.setString(2, p.getApellido());
            comando.setString(3, p.getNick());
            comando.setString(4, p.getCont());
            comando.setString(5, p.getTipo());
            comando.setString(6, p.getEmail());

            comando.executeUpdate();

            conn.closeConnection();
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        System.out.println("INSERT REALIZADO");






    }

    @Override
    public void modifyUser(UserVO p) throws ExcepcionTorge {

    }
}
