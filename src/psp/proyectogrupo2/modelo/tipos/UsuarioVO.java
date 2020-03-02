package psp.proyectogrupo2.modelo.tipos;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Jorge y Vic
 */

public class UsuarioVO {

	private Integer id;
	private final StringProperty nombre , apellido, nick, cont, email;
	private final StringProperty tipo;

	/**
	 * Default constructor.
	 */
	public UsuarioVO() {
		this(0, null, null, null, null, null, null);
	}

	public UsuarioVO(Integer id, String n, String ap, String nick, String cont, String tipo, String email) {
		this.id = id;
		this.nombre = new SimpleStringProperty(n);
		this.apellido = new SimpleStringProperty(ap);
		this.nick = new SimpleStringProperty(nick);
		this.cont = new SimpleStringProperty(cont);
		this.tipo = new SimpleStringProperty(tipo);
		this.email = new SimpleStringProperty(email);

		// this.ni = new SimpleIntegerProperty(ni);
		// this.tx = new SimpleObjectProperty<TipoX>(tx);
		// this.nf = new SimpleFloatProperty(nf);
	}

	public UsuarioVO(String n, String ap, String nick, String cont, String tipo, String email) {
		this.id = null;
		this.nombre = new SimpleStringProperty(n);
		this.apellido = new SimpleStringProperty(ap);
		this.nick = new SimpleStringProperty(nick);
		this.cont = new SimpleStringProperty(cont);
		this.tipo = new SimpleStringProperty(tipo);
		this.email = new SimpleStringProperty(email);

		// this.ni = new SimpleIntegerProperty(ni);
		// this.tx = new SimpleObjectProperty<TipoX>(tx);
		// this.nf = new SimpleFloatProperty(nf);
	}

	/*public UsuarioVO() {
		this.id = new SimpleIntegerProperty();
		this.nombre = new SimpleStringProperty();
		this.ap = new SimpleStringProperty();
		this.nick = new SimpleStringProperty();
		this.cont = new SimpleStringProperty();
		this.tipo = new SimpleObjectProperty<String>();
		// this.ni = new SimpleIntegerProperty(ni);

		// this.tx = new SimpleObjectProperty<TipoX>(tx);
		// this.nf = new SimpleFloatProperty(nf);
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//Getters y setter del nombre del usuario

	public String getNombreUser(){
		return nombre.get();
	}

	public void setNombre(String n){
		this.nombre.set(n);
	}

	//Getters y setter del apellido del usuario
	public String getApellido() {
		return apellido.getValue();
	}

	public StringProperty setApellidoProperty() {
		return apellido;
	}

	public void setAp(String ap) {
		this.apellido.set(ap);
	}

	//Getters y setter del nick del usuario

	public String getNick() {
		return nick.get();
	}

	public StringProperty getNickProperty() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick.set(nick);
	}

	//Getters y setter de la contraseña del usuario.

	public String getCont() {
		return cont.get();
	}

	public StringProperty getContProperty() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont.set(cont);
	}

	//Getters y setter del email
	public String getEmail() {
		return email.get();
	}

	public StringProperty getEmailProperty() {
		return email;
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	//Getters y setter del tipo de usuario (Alumno o profesor; solo puede haber un alumno profesor)


	public String getTipo() {
		return tipo.get();
	}

	public void setTipo(String tipo) {
		this.tipo.set(tipo);
	}





	/*
	 * public IntegerProperty niProperty() { return ni; }
	 * 
	 * public ObjectProperty<TipoX> txProperty() { return tx; }
	 * 
	 * public FloatProperty nfProperty() { return nf; }
	 * 
	 * public Integer getNi() { return ni.get(); }
	 * 
	 * public void setNi(Integer ni) { this.ni.set(ni); }
	 */

	/*
	 * public Float getNf() { return nf.get(); }
	 * 
	 * public void setNf(Float nf) { this.nf.set(nf); }
	 * 
	 * public TipoX getTx() { return tx.get(); }
	 * 
	 * public void setTx(TipoX tx) { this.tx.set(tx); ; }
	 */

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
