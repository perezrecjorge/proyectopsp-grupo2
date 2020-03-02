package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;

import java.awt.*;


public class ControladorVistaModificarPerfil {

	private Stage dialogStage;
	private MainAPP mainApp;
	private ModeloTorge modelo;
	private UsuarioVO p;
	private boolean okClicked = false;

	@FXML
	private TextField nombreField;
	@FXML
	private TextField apellidoField;
	@FXML
	private TextField nicknameField;
	@FXML
	private TextField contraField;
	@FXML
	private TextField tipoField;
	@FXML
	private TextField emailField;

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {

		this.dialogStage = dialogStage;
		this.dialogStage.initModality(Modality.NONE);
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

	public void establecerDatos() {

		nombreField.setText(modelo.getNombreconectado());
		apellidoField.setText(modelo.getApellidoconectado());
		nicknameField.setText(modelo.getNicknameconectado());
		contraField.setText(modelo.getContraconectado());
		tipoField.setText(modelo.getTipoconectado());
		emailField.setText(modelo.getEmailconectado());

	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void manejaCancelar() {
		dialogStage.close();
	}




}