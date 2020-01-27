package psp.proyectogrupo2.controlador;

import java.io.FileInputStream;
import java.util.ArrayList;

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

        UsuarioVO aux = new UsuarioVO();
        boolean okClicked = mainApp.muestraVistaIniciarSesion(aux);

        if (okClicked == true) {
			
			System.out.println("INICIAR SESION OK BIEN");
            try {
                UsuarioVO veri = modelo.getUsuario(aux.getNick());

                if (veri.getCont() == null) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("LOGIN INCORRECTO");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Nickname o contraseña erroneos.");

                    alert.showAndWait();
                } else {
                    modelo.setNicknameconectado(veri.getNick());
                    modelo.setContraconectado(veri.getCont());
                    modelo.setTipoconectado(veri.getTipo());

                    System.out.println("SE HA CONECTADO EL USUARIO NICK: " + modelo.getNicknameconectado()
                            + " CONTRA: " + modelo.getContraconectado() + " TIPO: " + modelo.getTipoconectado());

                    mainApp.muestraVistaMenuAlumnos();

                }

            } catch (ExcepcionTorge excepcionTorge) {
                excepcionTorge.printStackTrace();
            }

		}
	}
	
	/**
	 * Botón REGISTRO
	 */
	@FXML
	private void manejaRegistro() {

        UsuarioVO aux = new UsuarioVO();
        boolean okClicked = mainApp.muestraVistaRegistro(aux);

		if (okClicked) {

			System.out.println("REGISTRO OK BIEN");
            try {
                modelo.guardarElemento(aux);
            } catch (ExcepcionTorge e) {

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle(e.getTitle());
                alert.setHeaderText(e.getHeader());
                alert.setContentText(e.getMessage());

                alert.showAndWait();

            }
			
		}
	}




}