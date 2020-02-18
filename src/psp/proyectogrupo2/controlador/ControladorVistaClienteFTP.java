package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;


public class ControladorVistaClienteFTP {

	// Reference to the main application.
	private MainAPP mainApp;
	private ModeloTorge modelo;


	/**
	 * El constructor se llama antes de la inicialización.
	 */
	public ControladorVistaClienteFTP() {

	}

	/**
	 * Incializa el controlador justo depsués de que se cargue la vista .fxml
	 */
	@FXML
	private void initialize() {

	}

	/**
	 * Instancia el supercontrolador Main y el modelo de la aplicación
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainAPP mainApp, ModeloTorge m) {
		this.mainApp = mainApp;
		this.modelo = m;
	}

	/**
	 * Botón NOTICIAS
	 */
	@FXML
	private void manejaVolver() {

		mainApp.muestraVistaMenuAlumnos();

	}

}