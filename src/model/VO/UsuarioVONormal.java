package model.VO;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * @author Jorge y Vic
 */

public class UsuarioVONormal implements Serializable {

	private Integer id;
	private String nombre , apellido, nick, cont, email;
	private String tipo;

	/**
	 * Default constructor.
	 */
	public UsuarioVONormal() {
		this(0, null, null, null, null, null, null);
	}

	public UsuarioVONormal(Integer id, String nombre, String apellido, String nick, String cont, String email, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nick = nick;
		this.cont = cont;
		this.email = email;
		this.tipo = tipo;
	}

	public UsuarioVONormal(String nombre, String apellido, String nick, String cont, String email, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nick = nick;
		this.cont = cont;
		this.email = email;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "UsuarioVO{" +
				"nombre=" + nombre +
				", apellido=" + apellido +
				", nick=" + nick +
				", cont=" + cont +
				", tipo=" + tipo +
				'}';
	}
}
