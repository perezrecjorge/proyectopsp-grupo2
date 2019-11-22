package psp.proyectogrupo2.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

public class ModeloTorge {

	private final TorgeDAOJDBC daojdbc;

	ObservableList<UsuarioVO> plist = FXCollections.observableArrayList();

	public ModeloTorge() {

		this.daojdbc = new TorgeDAOJDBC();
	}

}
