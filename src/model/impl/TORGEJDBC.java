package model.impl;

import model.Conection;
import model.Repository;
import model.VO.UsuarioVO;
import model.VO.UsuarioVONormal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TORGEJDBC implements Repository {

    @Override
    public String getLogin(ArrayList<String> credentials) {

        String role = "";

        try {

            Conection conn = new Conection();
            Statement statement = conn.openConnection().createStatement();

            ResultSet result = statement.executeQuery("select role from administrador where username = '" + credentials.get(0) + "' and password = '" + credentials.get(1) + "'");

            if (result.next()) {
                role = result.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public UsuarioVONormal getUsuario(ArrayList<String> credentials) {

        UsuarioVONormal res = new UsuarioVONormal();

        try {

            Conection conn = new Conection();
            Statement statement = conn.openConnection().createStatement();

            ResultSet registro = statement.executeQuery("SELECT id, nombre, apellido, nickname, contra, tipo, email FROM usuario WHERE nickname = '" + credentials.get(0) + "' and contra = '" + credentials.get(1) + "'");

            while (registro.next()) {
                res.setId(registro.getInt(1));
                res.setNombre(registro.getString(2));
                res.setApellido(registro.getString(3));
                res.setNick(registro.getString(4));
                res.setCont(registro.getString(5));
                res.setTipo(registro.getString(6));
                res.setEmail(registro.getString(7));
            }

            conn.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public ArrayList<String> getUsuario2(ArrayList<String> credentials) {

        ArrayList<String> usuariologin = new ArrayList<String>();;

        try {

            Conection conn = new Conection();
            Statement statement = conn.openConnection().createStatement();

            ResultSet registro = statement.executeQuery("SELECT id, nombre, apellido, nickname, contra, tipo, email FROM usuario WHERE nickname = '" + credentials.get(0) + "' and contra = '" + credentials.get(1) + "'");

            if (registro.next()) {
                usuariologin.add(String.valueOf(registro.getInt(1)));
                usuariologin.add(registro.getString(2));
                usuariologin.add(registro.getString(3));
                usuariologin.add(registro.getString(4));
                usuariologin.add(registro.getString(5));
                usuariologin.add(registro.getString(6));
                usuariologin.add(registro.getString(7));
            } else {
                usuariologin.add("noencontrado");
            }

            conn.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuariologin;
    }


}
