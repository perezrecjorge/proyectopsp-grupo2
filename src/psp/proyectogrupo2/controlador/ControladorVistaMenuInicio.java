package psp.proyectogrupo2.controlador;

import java.io.FileInputStream;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorVistaMenuInicio {
	
	@FXML
	private ImageView imageview;

	// Reference to the main application.
	private MainAPP mainApp;

	private ModeloTorge modelo;

	/**
	 * El constructor se llama antes de la inicialización.
	 */
	public ControladorVistaMenuInicio() {

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
	 * @param pm
	 * @throws AddressException
	 */
	public void setMainApp(MainAPP mainApp, ModeloTorge m) {
		this.mainApp = mainApp;
		this.modelo = m;
	}
	
	public void ponerFoto(Image imagenlogo) {
		imageview.setImage(imagenlogo);
	}

	/**
	 * Botón INICIAR
	 */
	@FXML
	private void manejaIniciarSesion() {
		
		boolean okClicked = mainApp.muestraVistaIniciarSesion();

		if (okClicked) {
			
			System.out.println("INICIAR SESION OK BIEN");
			mainApp.muestraVistaMenuAlumnos();
			
		}
	}
	
	/**
	 * Botón REGISTRO
	 */
	@FXML
	private void manejaRegistro() {

		boolean okClicked = mainApp.muestraVistaRegistro();

		if (okClicked) {

			System.out.println("REGISTRO OK BIEN");
			
		}
	}




}