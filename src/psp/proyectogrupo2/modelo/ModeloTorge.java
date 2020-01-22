package psp.proyectogrupo2.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;

public class ModeloTorge {

	private final TorgeDAOJDBC daojdbc;

	ObservableList<UsuarioVO> plist = FXCollections.observableArrayList();

	public ModeloTorge() {

		this.daojdbc = new TorgeDAOJDBC();
	}

}
