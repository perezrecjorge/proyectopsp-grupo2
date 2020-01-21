package psp.proyectogrupo2.modelo.tipos;

import javafx.beans.property.*;

import java.time.LocalDate;

public class NoticiaVO {


    private IntegerProperty id;
    private StringProperty nombre, cuerpo;
    private ObjectProperty<LocalDate> fecha;


    public NoticiaVO(Integer id, String nombre, String cuerpo, LocalDate fecha) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cuerpo = new SimpleStringProperty(cuerpo);
        this.fecha = new SimpleObjectProperty<LocalDate>(fecha);
    }

    public NoticiaVO() {
    }

    //Getters y setter del id de la noticia

    public int getId() {
        return id.getValue();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    //Getters y setters del nombre de la noticia


    public String getNombre() {
        return nombre.get();
    }

    public StringProperty getNombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    //Getters y setter del cuerpo de la noticia


    public String getCuerpo() {
        return cuerpo.get();
    }

    public StringProperty getCuerpoProperty() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo.set(cuerpo);
    }

    //Getters y setters de la fecha de publicación de la noticia


    public LocalDate getFecha() {
        return fecha.get();
    }

    public ObjectProperty<LocalDate> getFechaProperty() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }
}
