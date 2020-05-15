package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import static javafx.application.Application.launch;

public class App extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;

    @FXML
    private ImageView logo;

    @FXML
    private Button signUp;

    @FXML
    private Button signIn;

    @FXML
    private Button recover;

    private Model model;

    public App(){model = new Model();}

    public void ponerFoto(Image image){

        logo.setImage(image);

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Torge: Comunicación");
        this.primaryStage.getIcons().add(new Image("file:resources/logotorgeiconoventana.png"));

        init();
        showMainMenu();
    }

    public void init() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/view/RootLayout.fxml")); // Aquí cargo la vista
        System.out.println("aaaa");
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        System.out.println(scene);
         primaryStage.setScene(scene);

        RootLayoutController controller = loader.getController();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void showMainMenu(){

        try{

// Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/MainView.fxml"));
            AnchorPane inicio = (AnchorPane) loader.load();

            // Colocamos esta vista en el centro del rootlayout
            rootLayout.setCenter(inicio);

            // Le pasamos al controlador de esta vista este supercontrolador
                HomeController controller = loader.getController();

            FileInputStream inputstream = new FileInputStream("resources/logo_torge.png");
            Image imagenlogo = new Image(inputstream);
                        ponerFoto(imagenlogo);

            //controller.setMainApp(this, modelo);

        }catch(IOException e){
            e.printStackTrace();
        }


    }


    public void showSignUpView(){






    }

    public void showSignInView(){




    }

    public void showRecoveryView(){}


}
