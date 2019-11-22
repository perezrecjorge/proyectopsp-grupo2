package psp.proyectogrupo2.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

public class TorgeDAOJDBC implements TorgeDAO {

	private Connection conex = null;

	public TorgeDAOJDBC() {
	}

	@Override
	public List<UsuarioVO> cargarListaElementos() throws ExcepcionTorge {
		List<UsuarioVO> res = new ArrayList<>();

		openConnection();

		Statement comando;
		try {
			comando = conex.createStatement();
			ResultSet registro = comando.executeQuery("SELECT id, cadena FROM tablapojo;");

			while (registro.next() == true) {
				res.add(new UsuarioVO(registro.getInt("id"), registro.getString("cadena")));
			}

		} catch (SQLException e) {
			throw new ExcepcionTorge(e.getMessage());
		}

		closeConnection();

		return res;
	}

	@Override
	public UsuarioVO getElemento(int i) throws ExcepcionTorge {

		openConnection();
		UsuarioVO res = new UsuarioVO();

		Statement comando;
		try {
			comando = conex.createStatement();
			ResultSet registro = comando.executeQuery("SELECT id, cadena FROM tablapojo WHERE id=" + i + ";");

			System.out.println(registro == null);

			if (registro.next() == true) {
				res.setId(registro.getInt("id"));
				res.setN(registro.getString("cadena"));
			}

		} catch (SQLException e) {
			throw new ExcepcionTorge(e.getMessage());
		}

		closeConnection();

		return null;
	}

	@Override
	public void modificarElemento(UsuarioVO p) throws ExcepcionTorge {
		openConnection();

		Statement comando;
		try {
			comando = conex.createStatement();
			comando.executeUpdate("UPDATE tablapojo SET cadena= '" + p.getN() + "' WHERE id= " + p.getId() + ";");
		} catch (SQLException e) {
			throw new ExcepcionTorge(e.getErrorCode());
		}

		closeConnection();

	}

	@Override
	public void guardarElemento(UsuarioVO p) throws ExcepcionTorge {

		openConnection();

		Statement comando;
		try {
			comando = conex.createStatement();
			comando.executeUpdate("INSERT INTO tablaPojo(cadena) VALUES ('" + p.getN() + "');");
		} catch (SQLException e) {
			throw new ExcepcionTorge(e.getErrorCode());
		}

		closeConnection();

	}

	@Override
	public void borrarElemento(UsuarioVO p) throws ExcepcionTorge {

		openConnection();

		try

		{
			Statement comando = conex.createStatement();
			comando.executeUpdate("DELETE FROM tablaPojo WHERE id= " + p.getId() + ";");
		} catch (SQLException e) {
			throw new ExcepcionTorge(e.getErrorCode());
		}

		closeConnection();

	}

	private void openConnection() throws ExcepcionTorge {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conex = DriverManager.getConnection("jdbc:mysql://localhost/pojo", "root", ""); // TODO
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

	}

	private void closeConnection() {
		conex = null;
	}

}
