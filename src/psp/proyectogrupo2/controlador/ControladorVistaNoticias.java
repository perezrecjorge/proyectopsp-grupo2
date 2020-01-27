package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.util.ExcepcionTorge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorVistaNoticias {

	// Reference to the main application.
	private MainAPP mainApp;
	private ModeloTorge modelo;

    @FXML
    private Button btnnuevo;
    @FXML
    private Button btnborrar;

    @FXML
    private TableView<NoticiaVO> noticiasTable;
    @FXML
    private TableColumn<NoticiaVO, String> autorColumn;
    @FXML
    private TableColumn<NoticiaVO, String> fechaColumn;

    @FXML
    private Label tituloLabel;
    @FXML
    private TextArea cuerpoLabel;

	/**
	 * El constructor se llama antes de la inicialización.
	 */
	public ControladorVistaNoticias() {

	}

	/**
	 * Incializa el controlador justo depsués de que se cargue la vista .fxml
	 */
	@FXML
	private void initialize() {
        // Initialize the person table with the two columns.
        autorColumn.setCellValueFactory(cellData -> cellData.getValue().getAutorProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().getFechaProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        noticiasTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

	}

	/**
	 * Instancia el supercontrolador Main y el modelo de la aplicación
	 * 
	 * @param mainApp
	 */
    public void setMainApp(MainAPP mainApp, ModeloTorge m) {
        this.mainApp = mainApp;
        this.modelo = m;

        try {
            mainApp.setListaNoticias(modelo.cargarListaNoticias());
            noticiasTable.setItems(mainApp.getListaNoticias());
        } catch (ExcepcionTorge e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(e.getTitle());
            alert.setHeaderText(e.getHeader());
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    private void showPersonDetails(NoticiaVO noticia) {
        if (noticia != null) {
            tituloLabel.setText(noticia.getTitulo());
            cuerpoLabel.setText(noticia.getCuerpo());
        } else {
            tituloLabel.setText("");
            cuerpoLabel.setText("");
        }
    }

    public void ocultarBotonesAlumnos() {
        if (modelo.getTipoconectado().equalsIgnoreCase("alumno")) {
            btnnuevo.setDisable(true);
            btnborrar.setDisable(true);

            btnnuevo.setVisible(false);
            btnborrar.setVisible(false);

        } else {
            btnnuevo.setDisable(false);
            btnborrar.setDisable(false);
        }
    }

	/**
	 * Botón NOTICIAS
	 */
	@FXML
	private void manejaVolver() {

		mainApp.muestraVistaMenuAlumnos();

	}

    @FXML
    private void manejaNuevo() {

        System.out.println("NUEVA NOTICIA PULSADO");
        NoticiaVO tempNoticia = new NoticiaVO();
        boolean okClicked = mainApp.muestraVentanaEdicionNoticia(tempNoticia);

        if (okClicked) {

            try {
                modelo.guardarNoticia(tempNoticia);
                noticiasTable.getItems().add(tempNoticia);

            } catch (ExcepcionTorge e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(e.getTitle());
                alert.setHeaderText(e.getHeader());
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void manejaBorrar() {
        int selectedIndex = noticiasTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            NoticiaVO aux = noticiasTable.getSelectionModel().getSelectedItem();

            try {
                modelo.borrarNoticia(aux);
                noticiasTable.getItems().remove(selectedIndex);
            } catch (ExcepcionTorge e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(e.getTitle());
                alert.setHeaderText(e.getHeader());
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText("Noticia no seleccionada");
            alert.setContentText("Selecciona una noticia.");
            alert.showAndWait();
        }
    }

}