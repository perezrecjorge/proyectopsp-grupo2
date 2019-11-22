package psp.proyectogrupo2.controlador;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;



public class ControladorVistaChatGrupal {

	@FXML
	private TextArea textarea;

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

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void manejaEnviar() {
		System.out.println("Enviar OK\n");
		
		AlumnosChat ping = new AlumnosChat("Alumno 1");
		AlumnosChat pong = new AlumnosChat("Alumno 2");

        ping.start();
        pong.start();
        
		okClicked = true;
	}
	
	public String getTextarea() {
		return textarea.getText().toString();
	}

	public void setTextarea(String texto) {
		textarea.appendText(texto);
	}
	
	
	public class AlumnosChat extends Thread {

		private String mensaje;
		String chat = "";

		public AlumnosChat(String msg) {
			this.mensaje = msg;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				hablar();
			}
		}

		public synchronized void hablar() {
			try {
				Thread.currentThread().sleep(1000);
				setTextarea(mensaje);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}