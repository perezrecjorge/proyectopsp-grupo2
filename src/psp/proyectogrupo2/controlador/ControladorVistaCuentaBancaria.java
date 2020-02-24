package psp.proyectogrupo2.controlador;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.productorconsumidorbanco.ConsumidorCB;
import psp.proyectogrupo2.modelo.productorconsumidorbanco.CuentaCB;
import psp.proyectogrupo2.modelo.productorconsumidorbanco.ProductorCB;


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
	@FXML
	private Label labelsaldo;

	CuentaCB cuentacb;
	double saldocuentabancaria = 0.00f;

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
		cuentacb = new CuentaCB(0,800);
		labelsaldo.setText(String.valueOf(saldocuentabancaria));
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
	 * Botón VOLVER
	 */
	@FXML
	private void manejaVolver() {

		mainApp.muestraVistaMenuAlumnos();

	}

	/**
	 * Botón INGRESAR
	 */
	@FXML
	private void manejaIngresar() {

		double saldoingresar = Double.valueOf(ingresarField.getText().toString());
		ProductorCB p1 = new ProductorCB("Productor", cuentacb, saldoingresar);
		p1.start();

		double saldototal = saldocuentabancaria + saldoingresar;
		saldocuentabancaria = saldototal;
		labelsaldo.setText(String.valueOf(saldocuentabancaria));
	}

	/**
	 * Botón RETIRAR
	 */
	@FXML
	private void manejaRetirar() {

		double saldoretirar = Double.valueOf(retirarField.getText().toString());
		ConsumidorCB p2 = new ConsumidorCB("Consumidor", cuentacb, saldoretirar);
		p2.start();

		double saldototal = saldocuentabancaria - saldoretirar;
		saldocuentabancaria = saldototal;
		labelsaldo.setText(String.valueOf(saldocuentabancaria));

	}

}