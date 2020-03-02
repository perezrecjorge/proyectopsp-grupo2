package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;


public class ControladorVistaRecuperarCuenta {

	@FXML
	private TextField nicknameField;

	private Stage dialogStage;
	private UsuarioVO user;
	private boolean okClicked = false;

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

	public void setUsuarioLogin(UsuarioVO aux) {
		this.user = aux;
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
	 * Called when the user clicks ok.
	 */
	@FXML
	private void manejaOk() {

		if (isInputValid()) {

			user.setNick(nicknameField.getText());

			okClicked = true;
			dialogStage.close();
		}
	
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void manejaCancelar() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (nicknameField.getText() == null || nicknameField.getText().length() == 0) {
			errorMessage += "No valid nickname!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
	
}