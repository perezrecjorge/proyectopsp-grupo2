package psp.proyectogrupo2.modelo.tipos;

import javafx.beans.property.*;


/**
 * @author Jorge y Vic
 */

public class UsuarioVO {

	private IntegerProperty id;
	private  StringProperty nombre , ap, nick, cont;
	private  ObjectProperty<String> tipo;
	// private final IntegerProperty ni;
	// private final ObjectProperty<TipoX> tx;
	// private final FloatProperty nf;

	/**
	 * Default constructor.
	 */
	public UsuarioVO() {

	}

	public UsuarioVO(Integer id, String nombre, String ap, String nick, String cont, String tipo) {
		this.id = new SimpleIntegerProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.ap = new SimpleStringProperty(ap);
		this.nick = new SimpleStringProperty(nick);
		this.cont = new SimpleStringProperty(cont);
		this.tipo = new SimpleObjectProperty<String>(tipo);

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

	public IntegerProperty getId() {
		return id;
	}

	public int getIdUser(){
		return this.getId().getValue();
	}
	public void setId(Integer id) {
		this.id.set(id);
	}



	//Getters y setter del nombre del usuario

	public StringProperty getNombre() {
		return this.nombre;
	}
	public String getNombreUser(){
		return this.nombre.getValue();
	}

	public void setNombre(String nombre){
		this.nombre.set(nombre);
	}

	//Getters y setter del apellido del usuario
	public String getApellido() {
		return ap.getValue();
	}

	public StringProperty setApellidoProperty() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap.set(ap);
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

	//Getters y setter del tipo de usuario (Alumno o profesor; solo puede haber un alumno profesor)


	public String getTipo() {
		return tipo.get();
	}

	public ObjectProperty<String> getTipoProperty() {
		return tipo;
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

}
