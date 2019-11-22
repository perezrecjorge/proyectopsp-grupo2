package psp.proyectogrupo2.modelo.tipos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuarioVO {

	private Integer id;
	private final StringProperty n;
	// private final IntegerProperty ni;
	// private final ObjectProperty<TipoX> tx;
	// private final FloatProperty nf;

	/**
	 * Default constructor.
	 */
	public UsuarioVO() {
		this(null);
	}

	public UsuarioVO(Integer id, String n) {
		this.id = id;

		// this.ni = new SimpleIntegerProperty(ni);
		this.n = new SimpleStringProperty(n);
		// this.tx = new SimpleObjectProperty<TipoX>(tx);
		// this.nf = new SimpleFloatProperty(nf);
	}

	public UsuarioVO(String n) {
		this.id = null;

		// this.ni = new SimpleIntegerProperty(ni);
		this.n = new SimpleStringProperty(n);
		// this.tx = new SimpleObjectProperty<TipoX>(tx);
		// this.nf = new SimpleFloatProperty(nf);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StringProperty nProperty() {
		return n;
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

	public String getN() {
		return n.get();
	}

	public void setN(String n) {
		this.n.set(n);
		;
	}

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
