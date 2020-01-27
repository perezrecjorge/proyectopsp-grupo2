package psp.proyectogrupo2.controlador;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;


public class ControladorVistaChatGrupalUDPVictor implements Runnable {

	private ModeloTorge modelo;
	private Stage dialogStage;
	private UsuarioVO p;

	@FXML
	private TextArea textarea;
	@FXML
	private TextField mensaje;

	static MulticastSocket ms = null;
	static byte[] buf = new byte[1000];
	static InetAddress grupo = null;
	static int Puerto = 12345;// Puerto multicast

	boolean repetir = true;
	String nombre;


	public ControladorVistaChatGrupalUDPVictor() {
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		try {
			iniciarHilo();
			System.out.println("ENTRA AQUI 1");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ENTRA AQUI 2");
		}

	}

	public void iniciarHilo() throws IOException {

		// Se crea el socket multicast
		ms = new MulticastSocket(Puerto);
		grupo = InetAddress.getByName("225.0.0.1");// Grupo
		// Nos unimos al grupo
		ms.joinGroup(grupo);

		new Thread(this).start();
	}

	public void setModelo(ModeloTorge modelo) {
		this.modelo = modelo;
	}

	public void setDialogStage(Stage dialogStage) {

		this.dialogStage = dialogStage;
		this.dialogStage.initModality(Modality.NONE);

		this.dialogStage.setOnCloseRequest(evt -> {
			// prevent window from closing
			evt.consume();
		});

		this.dialogStage.setOnShown(evt -> {
			// prevent window from closing
			evt.consume();
		});
	}

	public ControladorVistaChatGrupalUDPVictor(String nombre) {
		this.nombre = nombre;
	}

	public void establecerNombre() {
		if (modelo.getTipoconectado().equalsIgnoreCase("profesor")) {
			this.nombre = "| PROFESOR | Victor";
		} else {
			this.nombre = "Victor";
		}
	}
	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void manejaEnviar() {
		System.out.println("Enviar OK\n");

		String texto = nombre + " >> " + mensaje.getText();
		try {
			// ENVIANDO mensaje al grupo
			DatagramPacket paquete = new DatagramPacket(texto.getBytes(),
					texto.length(), grupo, Puerto);
			ms.send(paquete);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	private void manejaSalir() {

		dialogStage.close();
		System.out.println("Enviar SALIR\n");

		String texto = "*** Abandona el chat: " + nombre + " ***";
		try {
			// ENVIANDO DESPEDIDA AL GRUPO
			DatagramPacket paquete = new DatagramPacket(texto.getBytes(),
					texto.length(), grupo, Puerto);
			ms.send(paquete);
			ms.close();
			repetir = false;
			System.out.println("Abandona el chat: "+ nombre);
			dialogStage.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (repetir) {
			try {
				DatagramPacket p = new DatagramPacket(buf, buf.length);
				ms.receive(p);
				String texto = new String(p.getData(), 0, p.getLength());
				textarea.appendText(texto + "\n");
			}catch (SocketException s) {
				System.out.println(s.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getTextarea() {
		return textarea.getText().toString();
	}

	public void setTextarea(String texto) {
		textarea.appendText(texto);
	}


}