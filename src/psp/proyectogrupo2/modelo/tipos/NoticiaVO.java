package psp.proyectogrupo2.modelo.tipos;

import javafx.beans.property.*;
import psp.proyectogrupo2.util.DateUtil;

import java.time.LocalDate;

public class NoticiaVO {


    private Integer id;
    private final StringProperty titulo, cuerpo, autor, fecha;

    public NoticiaVO() {
        this(null, null, null, null);
    }

    public NoticiaVO(String titulo, String cuerpo, String autor, String fecha) {
        this.id = null;
        this.titulo = new SimpleStringProperty(titulo);
        this.cuerpo = new SimpleStringProperty(cuerpo);
        this.autor = new SimpleStringProperty(autor);
        this.fecha = new SimpleStringProperty(fecha);
    }

    public NoticiaVO(Integer id, String titulo, String cuerpo, String autor, String fecha) {
        this.id = id;
        this.titulo = new SimpleStringProperty(titulo);
        this.cuerpo = new SimpleStringProperty(cuerpo);
        this.autor = new SimpleStringProperty(autor);
        this.fecha = new SimpleStringProperty(fecha);
    }

    //Getters y setter del id de la noticia

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //Getters y setters del titulo de la noticia


    public String getTitulo() {
        return titulo.get();
    }

    public StringProperty getTituloProperty() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
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


    //Getter y setter del autor

    public String getAutor() {
        return autor.get();
    }

    public StringProperty getAutorProperty() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor.set(autor);
    }

    //Getters y setters de la fecha de publicación de la noticia


    public String getFecha() {
        return fecha.get();
    }

    public StringProperty getFechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }
}
