package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;


public class ControladorVistaCuentaBancaria {

    // Reference to the main application.
    private MainAPP mainApp;
    private ModeloTorge modelo;

    @FXML
    private Button btningresar;
    @FXML
    private Button btnretirar;
    @FXML
    private Label ingresarLabel;
    @FXML
    private Label retirarLabel;
    @FXML
    private TextField ingresarField;
    @FXML
    private TextField retirarField;

    /**
     * El constructor se llama antes de la inicialización.
     */
    public ControladorVistaCuentaBancaria() {

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

    public void ocultarBotones() {
        if (modelo.getTipoconectado().equalsIgnoreCase("alumno")) {
            retirarLabel.setDisable(true);
            btnretirar.setDisable(true);
            retirarField.setDisable(true);

            retirarField.setVisible(false);
            retirarLabel.setVisible(false);
            btnretirar.setVisible(false);
        } else {
            ingresarLabel.setDisable(true);
            ingresarField.setDisable(true);
            btningresar.setDisable(true);

            ingresarField.setVisible(false);
            ingresarLabel.setVisible(false);
            btningresar.setVisible(false);
		}
	}

    /**
     * Botón NOTICIAS
     */
    @FXML
    private void manejaVolver() {

        mainApp.muestraVistaMenuAlumnos();

	}

}