package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  Conection {


    private Connection conn = null;
    private String url = "jdbc:mysql://localhost/torgeapp";
    private String user = "root";
    private String psswd = "";


    public Conection() throws SQLException {
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

    public Connection openConnection()  {
        try {
            conn = DriverManager.getConnection(url, user, psswd); // TODO
        } catch (SQLException e) {

        }

        return conn;
    }



}