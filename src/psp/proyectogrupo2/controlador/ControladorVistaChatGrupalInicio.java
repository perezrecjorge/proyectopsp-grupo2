package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;

public class ControladorVistaChatGrupalInicio {

	// Reference to the main application.
	private MainAPP mainApp;

	private ModeloTorge modelo;

	/**
	 * El constructor se llama antes de la inicializaci�n.
	 */
	public ControladorVistaChatGrupalInicio() {

	}

	/**
	 * Incializa el controlador justo depsu�s de que se cargue la vista .fxml
	 */
	@FXML
	private void initialize() {
		
	}

	/**
	 * Instancia el supercontrolador Main y el modelo de la aplicaci�n
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainAPP mainApp, ModeloTorge m) {
		this.mainApp = mainApp;
		this.modelo = m;
	}

	@FXML
	private void manejaVolver() {

		mainApp.muestraVistaMenuAlumnos();

	}

	@FXML
	private void manejaAbreAlumno1() {

		mainApp.muestraVistaChatGrupalUDPJorge();

	}

	@FXML
	private void manejaAbreAlumno2() {

		mainApp.muestraVistaChatGrupalUDPVictor();

	}
	

	





}