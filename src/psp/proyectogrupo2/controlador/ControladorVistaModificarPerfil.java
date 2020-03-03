package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

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
	private TextField tipoCuentaField;
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

	public void establecerDatosUsuario() {

		nombreField.setText(modelo.getNombreconectado());
		apellidoField.setText(modelo.getApellidoconectado());
		nicknameField.setText(modelo.getNicknameconectado());
		contraField.setText(modelo.getContraconectado());
		tipoCuentaField.setText(modelo.getTipoconectado());
		emailField.setText(modelo.getEmailconectado());

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void manejaCancelar() {
		dialogStage.close();
	}

	/**
	 * Called when the user clicks accept.
	 */
	@FXML
	private void manejaAceptar() {

		try {
			p = new UsuarioVO(modelo.getIdconectado(), nombreField.getText(), apellidoField.getText(), nicknameField.getText(), contraField.getText(), tipoCuentaField.getText(), emailField.getText());
			modelo.modificarUsuario(p);

			modelo.setNombreconectado(p.getNombreUser());
			modelo.setApellidoconectado(p.getApellido());
			modelo.setNicknameconectado(p.getNick());
			modelo.setContraconectado(p.getCont());
			modelo.setTipoconectado(p.getTipo());
			modelo.setEmailconectado(p.getEmail());

		} catch (ExcepcionTorge excepcionTorge) {
			excepcionTorge.printStackTrace();
		}

		dialogStage.close();

	}




}