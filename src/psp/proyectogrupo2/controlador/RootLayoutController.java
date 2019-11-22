package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * 
 */
public class RootLayoutController {

	// Reference to the main application
	private MainAPP mainApp;
	private ModeloTorge modelo;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 * @param pm
	 */
	public void setMainApp(MainAPP mainApp, ModeloTorge m) {
		this.mainApp = mainApp;
		this.modelo = m;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void manejaNuevo() { // Boton nuevo del menú
		mainApp.muestraVistaMenuInicio();
	}

	/**
	 * Cierra la aplicación
	 */
	@FXML
	private void manejaSalir() { // Botójn salir del menú
		System.exit(0);
	}

}