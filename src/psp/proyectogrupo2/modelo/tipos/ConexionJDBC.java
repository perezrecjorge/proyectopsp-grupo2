package psp.proyectogrupo2.modelo.tipos;

import psp.proyectogrupo2.util.ExcepcionTorge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJDBC {


    private Connection conn = null;
    private String url = "jdbc:mysql://localhost/torgeapp";
    private String user = "root";
    private String psswd = "";


    public ConexionJDBC() throws SQLException {
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
     * @return La conexión creada.
     * @throws SQLException
     */

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
