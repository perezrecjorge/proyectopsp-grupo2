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
	 * El constructor se llama antes de la inicialización.
	 */
	public ControladorVistaMenuAlumno() {

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
	private void manejaTablonNoticias() {
		
		mainApp.muestraNoticias();
			
	}
	
	/**
	 * Botón CHAT ALUMNOS
	 */
	@FXML
	private void manejaChatAlumnos() {

		//mainApp.muestraVistaChatGrupal();
		//mainApp.muestraVistaChatGrupalUDPJorge();
		//mainApp.muestraVistaChatGrupalUDPVictor();
		mainApp.muestraChatGrupalInicio();
	}
	
	/**
	 * Botón CHAT CUENTA BANCARIA
	 */
	@FXML
	private void manejaCuentaBancaria() {

		boolean okClicked = mainApp.muestraCuentaBancaria();

		if (okClicked) {

			System.out.println("CUENTA BANCARIA OK");
			
		}
	}
	
	/**
	 * Botón MODIFICAR PERFIL
	 */
	@FXML
	private void manejaModificarPerfil() {

		boolean okClicked = mainApp.muestraModificarPerfil();

		if (okClicked) {

			System.out.println("MODIFICAR OK BIEN");
			
		}
	}




}