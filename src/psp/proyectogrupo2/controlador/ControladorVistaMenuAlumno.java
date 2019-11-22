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

public class ControladorVistaMenuAlumno {

	// Reference to the main application.
	private MainAPP mainApp;

	private ModeloTorge modelo;

	/**
	 * El constructor se llama antes de la inicializaci�n.
	 */
	public ControladorVistaMenuAlumno() {

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
	 * @param pm
	 * @throws AddressException
	 */
	public void setMainApp(MainAPP mainApp, ModeloTorge m) {
		this.mainApp = mainApp;
		this.modelo = m;
	}

	/**
	 * Bot�n NOTICIAS
	 */
	@FXML
	private void manejaTablonNoticias() {
		
		System.out.println("NOTICIAS OK BIEN");
			
	}
	
	/**
	 * Bot�n CHAT ALUMNOS
	 */
	@FXML
	private void manejaChatAlumnos() {

		boolean okClicked = mainApp.muestraVistaChatGrupal();
		
		if (okClicked) {

			System.out.println("CHAT GRUPAL OK BIEN");
			
		}
	}
	
	/**
	 * Bot�n CHAT PRIVADO PROFESOR
	 */
	@FXML
	private void manejaChatPrivado() {

		boolean okClicked = mainApp.muestraVistaRegistro();

		if (okClicked) {

			System.out.println("CHAT PRIV OK BIEN");
			
		}
	}
	
	/**
	 * Bot�n MODIFICAR
	 */
	@FXML
	private void manejaModificarPerfil() {

		boolean okClicked = mainApp.muestraVistaRegistro();

		if (okClicked) {

			System.out.println("MODIFICAR OK BIEN");
			
		}
	}




}