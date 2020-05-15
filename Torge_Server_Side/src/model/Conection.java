package model;
import model.util.ExcepcionTorge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {


private Connection conn = null;

    private String url = "jdbc:mysql://localhost/torge";
    private String user = "root";
    private String psswd = "";

    public Conection()  {
        try {

         Class.forName("com.mysql.cj.jdbc.Driver");
            conn.setAutoCommit(true);
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * Borra la conexión creada.
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        conn.close();
    }

    public Connection openConnection() throws ExcepcionTorge {
        try {
            conn = DriverManager.getConnection(url, user, psswd); // TODO
        } catch (SQLException e) {
            throw new ExcepcionTorge(e.getErrorCode());
        }

        return conn;
    }





}
