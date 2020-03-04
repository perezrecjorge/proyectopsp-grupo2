package psp.proyectogrupo2.controlador;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import psp.proyectogrupo2.MainAPP;
import psp.proyectogrupo2.modelo.ModeloTorge;

import javax.swing.*;
import java.io.*;
import java.util.List;


public class ControladorVistaClienteFTP {

    // Reference to the main application.
    private MainAPP mainApp;
    private ModeloTorge modelo;

    @FXML
    private Label labelServidor;
    @FXML
    private Label labelDirRaiz;
    @FXML
    private Label labelUsuario;
    @FXML
    private Label labelFicheroSeleccionado;
    @FXML
    private Label labelDirActual;
    @FXML
    private ListView<String> listDir;
    @FXML
    private ImageView imagenView;
    @FXML
    private Button btnsubir;
    @FXML
    private Button btndescargar;
    @FXML
    private Button btneliminar;
    @FXML
    private Button btncrearcarpeta;
    @FXML
    private Button btneliminarcarpeta;

    public void ocultarBotones() {
        if (modelo.getTipoconectado().equalsIgnoreCase("alumno")) {

            btnsubir.setDisable(true);
            btndescargar.setDisable(true);
            btneliminar.setDisable(true);
            btneliminarcarpeta.setDisable(true);
            btncrearcarpeta.setDisable(true);

            btnsubir.setVisible(false);
            btndescargar.setVisible(false);
            btneliminar.setVisible(false);
            btneliminarcarpeta.setVisible(false);
            btncrearcarpeta.setVisible(false);
        }
    }


    //Datos del servidor FTP
    static FTPClient cliente = new FTPClient();//cliente FTP
    String servidor = "localhost";
    String user = "usuario1";
    String pasw = "usuario1";
    boolean login;
    static String direcInicial = "/";

    //para saber directorio y fichero seleccionado
    static String direcSelec = direcInicial;
    static String ficheroSelec = "";

    /**
     * El constructor se llama antes de la inicialización.
     */
    public ControladorVistaClienteFTP() {

    }

    public void ponerFoto(Image imagenlogo) {
        imagenView.setImage(imagenlogo);
    }


    /**
     * Incializa el controlador justo depsués de que se cargue la vista .fxml
     */
    @FXML
    private void initialize() {
        try {
            System.out.println("Conectandose a " + servidor);

            cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
            cliente.connect(servidor);
            cliente.enterLocalPassiveMode();

            login = cliente.login(user, pasw);
            cliente.changeWorkingDirectory(direcInicial);

            FTPFile[] files = cliente.listFiles();
            //Construyendo arbol de directorios, espere un momento
            llenarLista(files, direcInicial);

            labelServidor.setText("Servidor FTP: "+servidor);
            labelUsuario.setText("Usuario: "+user);
            labelDirRaiz.setText("DIRECTORIO RAIZ: "+direcInicial);

        } catch (IOException e) {
            e.printStackTrace();
        }

        listDir.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    ficheroSelec = "";

                    //elemento seleccionado de la lista
                    String fic = listDir.getSelectionModel().getSelectedItem().toString();

                    if (listDir.getSelectionModel().getSelectedIndex() == 0) {
                        //Se hace clic en el primer elemento del JList
                        if (!fic.equals(direcInicial)) {
                            //si no estamos en el dictorio inicial, hay que
                            //subir al directorio padre
                            try {
                                cliente.changeToParentDirectory();
                                direcSelec = cliente.printWorkingDirectory();
                                cliente.changeWorkingDirectory(direcSelec);
                                FTPFile[] ff2 = cliente.listFiles();
                                labelFicheroSeleccionado.setText("");
                                //se llena la lista con fich. del directorio padre
                                llenarLista(ff2, direcSelec);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    //No se hace clic en el primer elemento del JList
                    //Puede ser un fichero o un directorio
                    else {
                        if (fic.substring(0, 6).equals("(DIR) ")) {
                            //SE TRATA DE UN DIRECTORIO
                            try {
                                fic = fic.substring(6);
                                String direcSelec2 = "";
                                if (direcSelec.equals("/"))
                                    direcSelec2 = direcSelec + fic;
                                else
                                    direcSelec2 = direcSelec + "/" + fic;
                                FTPFile[] ff2 = null;
                                cliente.changeWorkingDirectory(direcSelec2);
                                ff2 = cliente.listFiles();
                                labelFicheroSeleccionado.setText("DIRECTORIO:  " + fic + ", "
                                        + ff2.length + " elementos");
                                direcSelec = direcSelec2;
                                llenarLista(ff2, direcSelec);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            // SE TRATA DE UN FICHERO
                            ficheroSelec = direcSelec;
                            if (direcSelec.equals("/"))
                                ficheroSelec += fic;
                            else
                                ficheroSelec += "/" + fic;
                            labelFicheroSeleccionado.setText("FICHERO seleccionado:" +
                                    ficheroSelec);
                            ficheroSelec = fic;
                        }//fin else
                    }//else de fichero o directorio
                    labelDirActual.setText("DIRECTORIO ACTUAL: " + direcSelec);
                }

        });

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

    /**
     * Botón VOLVER
     */
    @FXML
    private void manejaVolver() {

        try {
            cliente.disconnect();
            System.out.println("ENTRA SALIR CLIENTE FTP");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        mainApp.muestraVistaMenuAlumnos();

    }

    /**
     * Botón SUBIR FICHERO
     */
    @FXML
    private void manejaSubirFichero() {
        System.out.println("ENTRA SUBIR FICHERO");
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.setDialogTitle("Selecciona el Fichero a SUBIR AL SERVIDOR FTP");
        int returnVal = f.showDialog(f, "Cargar");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();
            String archivo = file.getAbsolutePath();
            String nombreArchivo = file.getName();
            try {
                SubirFichero(archivo, nombreArchivo);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * Botón DESCARGAR FICHERO
     */
    @FXML
    private void manejaDescargarFichero() {
        String directorio = direcSelec;
        if (!direcSelec.equals("/"))
            directorio = directorio + "/";
        if (!ficheroSelec.equals("")) {
            DescargarFichero(directorio + ficheroSelec, ficheroSelec);
        }

    }

    /**
     * Botón ELIMINAR FICHERO
     */
    @FXML
    private void manejaEliminarFichero() {
        String directorio = direcSelec;
        if (!direcSelec.equals("/"))
            directorio = directorio + "/";
        if (!ficheroSelec.equals(""))
            BorrarFichero(directorio + ficheroSelec, ficheroSelec);
    }

    /**
     * Botón CREAR CARPETA
     */
    @FXML
    private void manejaCrearCarpeta() {
        String nombreCarpeta = JOptionPane.showInputDialog(null,
                "Introduce el nombre del directorio",
                "carpeta");
        if (!(nombreCarpeta == null)) {
            String directorio = direcSelec;
            if (!direcSelec.equals("/"))
                directorio = directorio + "/";
            directorio += nombreCarpeta.trim();

            try {
                if (cliente.makeDirectory(directorio)) {
                    String m = nombreCarpeta.trim() + " => Se ha creado correctamente ...";
                    JOptionPane.showMessageDialog(null, m);
                    labelFicheroSeleccionado.setText(m);
                    cliente.changeWorkingDirectory(direcSelec);
                    FTPFile[] ff2 = cliente.listFiles();
                    llenarLista(ff2, direcSelec);

                } else
                    JOptionPane.showMessageDialog(null, nombreCarpeta.trim()
                            + " => No se ha podido crear ...");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * Botón ELIMINAR CARPETA
     */
    @FXML
    private void manejaEliminarCarpeta() {
        String nombreCarpeta = JOptionPane.showInputDialog(null,
                "Introduce el nombre del directorio a eliminar",
                "carpeta");
        if (!(nombreCarpeta == null)) {
            String directorio = direcSelec;
            if (!direcSelec.equals("/"))
                directorio = directorio + "/";
            directorio += nombreCarpeta.trim();

            try {
                if (cliente.removeDirectory(directorio)) {
                    String m = nombreCarpeta.trim() + " => Se ha eliminado correctamente ...";
                    JOptionPane.showMessageDialog(null, m);
                    labelFicheroSeleccionado.setText(m);
                    cliente.changeWorkingDirectory(direcSelec);
                    FTPFile[] ff2 = cliente.listFiles();
                    llenarLista(ff2, direcSelec);

                } else
                    JOptionPane.showMessageDialog(null, nombreCarpeta.trim()
                            + " => No se ha podido eliminar ...");

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }


    void llenarLista(FTPFile[] files, String direc2) {
        if (files == null) return;
        //DefaultListModel modeloLista = new DefaultListModel();
        ObservableList<String> modelList = FXCollections.observableArrayList();

        try {
            cliente.changeWorkingDirectory(direc2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        direcSelec = direc2;
        //modelLista.addElement(direc2);
        modelList.add(direc2);
        for (int i = 0; i < files.length; i++) {
            if (!(files[i].getName()).equals(".")
                    && !(files[i].getName()).equals("..")) {
                String f = files[i].getName();
                if (files[i].isDirectory())
                    f = "(DIR) " + f;
                //modeloLista.addElement(f);
                modelList.add(f);
            }//if
        }// fin for
        try {
            //listDir.setItems((ObservableList<String>) modeloLista);
            listDir.setItems(modelList);

        } catch (NullPointerException n) {
            //Al llegar al �ltimo aparece excepcion
            ;
            System.out.println("linea 334 - llega al ultimo");
        }
    }//Fin llenarLista

    private void DescargarFichero(String NombreCompleto, String nombreFichero) {

        String archivoyCarpetaDestino = "";
        String carpetaDestino = "";
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Selecciona el Directorio donde DESCARGAR el fichero");

        int returnVal = f.showDialog(null, "Descargar");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();

            carpetaDestino = (file.getAbsolutePath()).toString();
            //System.out.println("carpeta destino " + carpetaDestino);
            archivoyCarpetaDestino = carpetaDestino + File.separator
                    + nombreFichero;


            try {
                cliente.setFileType(FTP.BINARY_FILE_TYPE);
                BufferedOutputStream out = null;
                out = new BufferedOutputStream(new FileOutputStream(
                        archivoyCarpetaDestino));

                if (cliente.retrieveFile(NombreCompleto, out))
                    JOptionPane.showMessageDialog(null, nombreFichero
                            + " => Se ha descargado correctamente ...");
                else
                    JOptionPane.showMessageDialog(null, nombreFichero
                            + " => No se ha podido descargar ...");

                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }// ..DescargarFichero

    private void BorrarFichero(String NombreCompleto, String nombreFichero) {
        //pide confirmacion
        int seleccion = JOptionPane.showConfirmDialog(null,
                "�Desea eliminar el fichero seleccionado?");
        if (seleccion == JOptionPane.OK_OPTION) {
            try {
                if (cliente.deleteFile(NombreCompleto)) {
                    String m = nombreFichero + " => Eliminado correctamente... ";
                    JOptionPane.showMessageDialog(null, m);
                    labelFicheroSeleccionado.setText(m);
                    cliente.changeWorkingDirectory(direcSelec);
                    FTPFile[] ff2 = cliente.listFiles();
                    llenarLista(ff2, direcSelec);
                } else
                    JOptionPane.showMessageDialog(null, nombreFichero
                            + " => No se ha podido eliminar ...");

            } catch (IOException e1) {
                System.out.println("ERROR AL ELIMINAR");
            }
        }
    }// ..BorrarFichero

    // -------------------------------------------------------------------------
    private boolean SubirFichero(String archivo, String nombreArchivo)
            throws IOException {

        System.out.println("Archivo : " + archivo);

        cliente.setFileType(FTP.BINARY_FILE_TYPE);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                archivo));
        boolean ok = false;
        // System.out.println("Directorio => " +direcSelec);
        cliente.changeWorkingDirectory(direcSelec);
        if (cliente.storeFile(nombreArchivo, in)) {
            String s = "  " + nombreArchivo + " => Subido correctamente... ";
            labelFicheroSeleccionado.setText(s);
            labelDirActual.setText("Se va a actualizar el �rbol de directorios...");
            JOptionPane.showMessageDialog(null, s);
            FTPFile[] ff2 = cliente.listFiles();
            llenarLista(ff2, direcSelec);
            ok = true;
        } else
            labelFicheroSeleccionado.setText("No se ha podido subir... " + nombreArchivo);

        return ok;
    }// SubirFichero

}