package psp.proyectogrupo2;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import psp.proyectogrupo2.controlador.*;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.NoticiaVO;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;

public class MainAPP extends Application {

	private Stage primaryStage; //
	private BorderPane rootLayout; // La vista con el menú donde se van poniendo las otras vistas

	private ObservableList<UsuarioVO> listaUsuarios = FXCollections.observableArrayList();
	private ObservableList<NoticiaVO> listaNoticias = FXCollections.observableArrayList();

	private ModeloTorge modelo;

	// SET GLOBAL TIME_ZONE="+3:00";

	public MainAPP() {

		modelo = new ModeloTorge(); // Creo el modelo de la aplicación

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Torge: Comunicación");
		this.primaryStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));

		// Set the application icon.
		// this.primaryStage.getIcons().add(new
		// Image("file:resources/images/iconfinder_contacts_1055082.png"));
		initRootLayout();
		muestraVistaMenuInicio();

	}

	/**
	 * Inicializa la vista raíz o root layout
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/RootLayout.fxml")); // Aquí cargo la vista
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this, modelo);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra la vista principal donde se muestran los datos y hay botones para la
	 * edición y etc.
	 */
	public void muestraVistaMenuInicio() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaMenuInicio.fxml"));
			AnchorPane inicio = (AnchorPane) loader.load();

			// Colocamos esta vista en el centro del rootlayout
			rootLayout.setCenter(inicio);

			// Le pasamos al controlador de esta vista este supercontrolador
			ControladorVistaMenuInicio controller = loader.getController();

			FileInputStream inputstream = new FileInputStream("resources/torgelogo2.png");
			Image imagenlogo = new Image(inputstream);
			controller.ponerFoto(imagenlogo);

			controller.setMainApp(this, modelo);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public boolean muestraVistaIniciarSesion(UsuarioVO aux) {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaIniciarSesion.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Iniciar Sesion");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaIniciarSesion controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setUsuarioLogin(aux);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean muestraVistaRegistro(UsuarioVO aux) {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaRegistroCuenta.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Registro Usuario");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaRegistro controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setUsuarioNuevo(aux);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Muestra la vista principal donde se muestran los datos y hay botones para la
	 * edición y etc.
	 */
	public void muestraVistaMenuAlumnos() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaMenuAlumno.fxml"));
			AnchorPane menualumno = (AnchorPane) loader.load();

			// Colocamos esta vista en el centro del rootlayout
			rootLayout.setCenter(menualumno);

			// Le pasamos al controlador de esta vista este supercontrolador
			ControladorVistaMenuAlumno controller = loader.getController();
			controller.setMainApp(this, modelo);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void muestraNoticias() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaNoticias.fxml"));
			AnchorPane menualumno = (AnchorPane) loader.load();

			// Colocamos esta vista en el centro del rootlayout
			rootLayout.setCenter(menualumno);

			// Le pasamos al controlador de esta vista este supercontrolador
			ControladorVistaNoticias controller = loader.getController();
			controller.setMainApp(this, modelo);
			controller.ocultarBotonesAlumnos();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void muestraChatGrupalInicio() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaChatGrupalInicio.fxml"));
			AnchorPane menualumno = (AnchorPane) loader.load();

			// Colocamos esta vista en el centro del rootlayout
			rootLayout.setCenter(menualumno);

			// Le pasamos al controlador de esta vista este supercontrolador
			ControladorVistaChatGrupalInicio controller = loader.getController();
			controller.setMainApp(this, modelo);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void muestraVistaChatGrupal() {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaChatGrupal.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("CHAT GRUPAL");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaChatGrupal controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void muestraVistaChatGrupalUDPJorge() {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaChatGrupalUDPJorge.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("CHAT GRUPAL JORGE");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaChatGrupalUDPJorge controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setModelo(modelo);
			controller.establecerNombre();

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void muestraVistaChatGrupalUDPVictor() {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaChatGrupalUDPVictor.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("CHAT GRUPAL VICTOR");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaChatGrupalUDPVictor controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setModelo(modelo);
			controller.establecerNombre();

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void muestraCuentaBancaria() {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaCuentaBancaria.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Colocamos esta vista en el centro del rootlayout
			rootLayout.setCenter(page);

			// Set the person into the controller.
			ControladorVistaCuentaBancaria controller = loader.getController();
			controller.setMainApp(this, modelo);
			controller.ocultarBotones();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ABRE LA VENTANA DE EDITAR, PARA CREAR O EDITAR UNA PERSONA
	 *
	 * @param
	 * @return
	 */
	public boolean muestraVentanaEdicionNoticia(NoticiaVO noticia) {
		try {

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainAPP.class.getResource("vista/VistaEdicionNoticia.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Nueva/Editar Noticia");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(primaryStage);
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);
				ControladorVistaEdicionNoticia controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setMainApp(this, modelo);
				controller.setNoticia(noticia);

				// Show the dialog and wait until the user closes it
				dialogStage.showAndWait();

				return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean muestraModificarPerfil() {
		try {

			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainAPP.class.getResource("vista/VistaModificarPerfil.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("MODIFICAR PERFIL");
			dialogStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ControladorVistaModificarPerfil controller = loader.getController();
			controller.setDialogStage(dialogStage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ObservableList<UsuarioVO> listaUsuarios) {
		this.listaUsuarios.addAll(listaUsuarios);
	}

	public ObservableList<NoticiaVO> getListaNoticias() {
		return listaNoticias;
	}

	public void setListaNoticias(ObservableList<NoticiaVO> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}
}
