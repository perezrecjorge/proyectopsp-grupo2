package psp.proyectogrupo2.controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;
import psp.proyectogrupo2.modelo.tipos.UsuarioVO;
import psp.proyectogrupo2.util.ExcepcionTorge;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

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
                UsuarioVO veri = modelo.getUsuario(aux.getNick(), aux.getCont());

                if (veri.getCont() == null) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("LOGIN INCORRECTO");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Nickname o contraseña erroneos.");

                    alert.showAndWait();
                } else {
                    modelo.setIdconectado(veri.getId());
                    modelo.setNicknameconectado(veri.getNick());
                    modelo.setContraconectado(veri.getCont());
                    modelo.setTipoconectado(veri.getTipo());
                    modelo.setNombreconectado(veri.getNombreUser());
                    modelo.setApellidoconectado(veri.getApellido());
                    modelo.setEmailconectado(veri.getEmail());

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
                UsuarioVO verificarNickname = modelo.getUsuarioRecuperarCuenta(aux.getNick());

                if (verificarNickname != null) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("REGISTRO INCORRECTO");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Nickname existente. Por favor, seleccione otro nickname.");

                    alert.showAndWait();
                } else {

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
            } catch (ExcepcionTorge excepcionTorge) {
                excepcionTorge.printStackTrace();
            }
        }
    }


    /**
     * Botón RECUPERAR CUENTA
     */
    @FXML
    private void manejaRecuperarCuenta() throws NoSuchAlgorithmException, UnrecoverableKeyException,
            KeyStoreException, InvalidKeyException, InvalidKeySpecException {

        UsuarioVO aux = new UsuarioVO();
        boolean okClicked = mainApp.muestraVistaRecuperarCuenta(aux);

        if (okClicked == true) {

            System.out.println("RECUPERAR CUENTA OK BIEN");
            try {
                UsuarioVO veri = modelo.getUsuarioRecuperarCuenta(aux.getNick());

                if (veri.getCont() == null) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("RECUPERAR CUENTA INCORRECTO");
                    alert.setHeaderText("ERROR");
                    alert.setContentText("No se ha encontrado ninguna cuenta con este nickname.");

                    alert.showAndWait();
                } else {
                    //FUNCION SI EL USUARIO CON EL NICKNAME INTRODUCIDO EXISTE

                    Random rng = new Random();
                    int dig6 = rng.nextInt(900000) + 100000; //siempre 6 digitos

                    // se crea cliente SMTP seguro
                    AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

                    // datos del usuario y del servidor
                    String server = "smtp.gmail.com";
                    String username = "apptorge@gmail.com";
                    String password = "pspparatodos10";
                    int puerto = 587;
                    String remitente = "apptorge@gmail.com";

                    try {
                        int respuesta;

                        // Creaci?n de la clave para establecer un canal seguro
                        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                        kmf.init(null, null);
                        KeyManager km = kmf.getKeyManagers()[0];

                        // nos conectamos al servidor SMTP
                        client.connect(server, puerto);
                        System.out.println("1 - " + client.getReplyString());
                        // se establece la clave para la comunicaci?n segura
                        client.setKeyManager(km);

                        respuesta = client.getReplyCode();
                        if (!SMTPReply.isPositiveCompletion(respuesta)) {
                            client.disconnect();
                            System.err.println("CONEXI?N RECHAZADA.");
                            System.exit(1);
                        }

                        // se env?a el commando EHLO
                        client.ehlo(server);// necesario
                        System.out.println("2 - " + client.getReplyString());

                        // NECESITA NEGOCIACI?N TLS - MODO NO IMPLICITO
                        // Se ejecuta el comando STARTTLS y se comprueba si es true
                        if (client.execTLS()) {
                            System.out.println("3 - " + client.getReplyString());

                            // se realiza la autenticaci?n con el servidor
                            if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                                System.out.println("4 - " + client.getReplyString());
                                String destino1 = veri.getEmail();
                                String asunto = "RECUPERAR CUENTA TORGE";
                                String mensaje = "Hola. \nSu codigo para recuperar su cuenta es: " + dig6 + "\n Un saludo.\n TORGE.";
                                // se crea la cabecera
                                SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);

                                // el nombre de usuario y el email de origen coinciden
                                client.setSender(remitente);
                                client.addRecipient(destino1);
                                System.out.println("5 - " + client.getReplyString());

                                // se envia DATA
                                Writer writer = client.sendMessageData();
                                if (writer == null) { // fallo
                                    System.out.println("FALLO AL ENVIAR DATA.");
                                    System.exit(1);
                                }

                                writer.write(cabecera.toString()); // cabecera
                                writer.write(mensaje);// luego mensaje
                                writer.close();
                                System.out.println("6 - " + client.getReplyString());

                                boolean exito = client.completePendingCommand();
                                System.out.println("7 - " + client.getReplyString());

                                if (!exito) { // fallo
                                    System.out.println("FALLO AL FINALIZAR TRANSACCI?N.");
                                    System.exit(1);
                                } else
                                    System.out.println("MENSAJE ENVIADO CON EXITO......");

                            } else
                                System.out.println("USUARIO NO AUTENTICADO.");
                        } else
                            System.out.println("FALLO AL EJECUTAR  STARTTLS.");

                    } catch (IOException e) {
                        System.err.println("Could not connect to server.");
                        e.printStackTrace();
                    }
                    try {
                        client.disconnect();
                    } catch (IOException f) {
                        f.printStackTrace();
                    }

                    System.out.println("Fin de env?o.");

                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("RECUPERAR CUENTA");
                    dialog.setHeaderText("Recupere el codigop enviado a su email y siga las instrucciones.");
                    dialog.setContentText("Por favor, introduzca el codigo exacto:");

                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {

                        if (String.valueOf(dig6).equalsIgnoreCase(result.get())) {

                            modelo.setIdconectado(veri.getId());
                            modelo.setNicknameconectado(veri.getNick());
                            modelo.setContraconectado(veri.getCont());
                            modelo.setTipoconectado(veri.getTipo());
                            modelo.setNombreconectado(veri.getNombreUser());
                            modelo.setApellidoconectado(veri.getApellido());
                            modelo.setEmailconectado(veri.getEmail());

                            mainApp.muestraVistaMenuAlumnos();
                        } else {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("RECUPERAR CUENTA INCORRECTO");
                            alert.setHeaderText("ERROR");
                            alert.setContentText("El codigo introducido no es correcto.");

                            alert.showAndWait();
                        }

                    }

                }

            } catch (ExcepcionTorge excepcionTorge) {
                excepcionTorge.printStackTrace();
            }

        }
    }

}