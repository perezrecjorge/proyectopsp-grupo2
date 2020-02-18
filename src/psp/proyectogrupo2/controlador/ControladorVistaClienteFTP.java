package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;


public class ControladorVistaClienteFTP {

	// Reference to the main application.
	private MainAPP mainApp;
	private ModeloTorge modelo;

	@FXML
	private Label labelServidor;
	@FXML
	private Label labelDirRaiz;
	@FXML
	private Label labelUsuario;
	@FXML
	private Label labelFicheroSeleccionado;
	@FXML
	private Label labelDirActual;
	@FXML
	private ListView listDir;
	@FXML
	private ImageView imagenView;

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
	 * Botón VOLVER
	 */
	@FXML
	private void manejaVolver() {

		mainApp.muestraVistaMenuAlumnos();

	}

	/**
	 * Botón SUBIR FICHERO
	 */
	@FXML
	private void manejaSubirFichero() {


	}

	/**
	 * Botón DESCARGAR FICHERO
	 */
	@FXML
	private void manejaDescargarFichero() {


	}

	/**
	 * Botón ELIMINAR FICHERO
	 */
	@FXML
	private void manejaEliminarFichero() {


	}

	/**
	 * Botón CREAR CARPETA
	 */
	@FXML
	private void manejaCrearCarpeta() {


	}

	/**
	 * Botón ELIMINAR CARPETA
	 */
	@FXML
	private void manejaEliminarCarpeta() {


	}



}