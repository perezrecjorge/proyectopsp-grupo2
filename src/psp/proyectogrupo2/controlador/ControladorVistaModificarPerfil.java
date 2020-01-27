package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;


public class ControladorVistaModificarPerfil {

	private Stage dialogStage;
	private UsuarioVO p;
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

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}


}