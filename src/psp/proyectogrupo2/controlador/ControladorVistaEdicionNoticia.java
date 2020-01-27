package psp.proyectogrupo2.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControladorVistaEdicionNoticia {

    @FXML
    private TextField tituloField;
    @FXML
    private TextArea cuerpoArea;

    private Stage dialogStage;
    private MainAPP mainApp;
    private ModeloTorge modelo;
    private NoticiaVO noticia;
    private boolean okClicked = false;

    /**
     * INICIALIZA EL CONTRUCTOR
     */
    @FXML
    private void initialize() {

    }

    /**
     * RECIBE EL MAIN Y EL MODELO
     */
    public void setMainApp(MainAPP mainApp, ModeloTorge m) {
        this.mainApp = mainApp;
        this.modelo = m;
    }

    /**
     * ESTABLECE EL DIALOGO
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.initModality(Modality.NONE);
    }

    /**
     * ESTABLECE LOS DATOS DE LA PERSONA EN LA VENTANA
     */
    public void setNoticia(NoticiaVO n) {
        this.noticia = n;

        tituloField.setText(n.getTitulo());
        cuerpoArea.setText(n.getCuerpo());

    }

    /**
     * DEVUELVE TRUE SI CLICKA EN OK
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
    private void handleOk() {
        if (isInputValid()) {
            noticia.setTitulo(tituloField.getText());
            noticia.setCuerpo(cuerpoArea.getText());
            noticia.setAutor(modelo.getNicknameconectado());

            DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
            Date dateobj = new Date();

            noticia.setFecha(df.format(dateobj));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * CIERRA LA VENTANA (BOTON CANCEL)
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * VALIDA LOS DATOS DE LOS TEXTFIELDS
     *
     * @return
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (tituloField.getText() == null || tituloField.getText().length() == 0) {
            errorMessage += "Titulo no valido.\n";
        }
        if (cuerpoArea.getText() == null || cuerpoArea.getText().length() == 0) {
            errorMessage += "Last name no valido.\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos no validos");
            alert.setHeaderText("Por favor, corrija los campos.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
