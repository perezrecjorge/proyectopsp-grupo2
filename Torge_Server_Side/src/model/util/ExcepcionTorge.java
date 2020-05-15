package model.util;

@SuppressWarnings("serial")
public class ExcepcionTorge extends Exception {

	private final String title;
	private final String header;
	private final String message;

	public String getTitle() {
		return title;
	}

	public String getHeader() {
		return header;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * Constructor de la excepci�n. Llama al m�todo "super()" de la clase Excepci�n,
	 * de la que extiende.
	 */
	public ExcepcionTorge() {
		super();

		this.title = "Error de ejecuci�n";
		this.header = "La aplicaci�n en su ejecuci�n:";
		this.message = "Se ha producido un error durante la ejecuci�n de la aplicaci�n. Por favor vuelva a intentarlo.";

	}

	/**
	 * Constructor de la excepci�n. Llama al m�todo "super()" de la clase Excepci�n,
	 * de la que extiende.
	 *
	 * @param ms Mensaje de error personalizado que se le pasa de forma opcional,
	 *           para que lo muestre al realizar el "throw".
	 */
	public ExcepcionTorge(String ms) {

		this.title = "Se ha producido un error";
		this.header = "La aplicaci�n ha sufrido un error con el siguiente mensaje:";
		this.message = ms;

	}

	public ExcepcionTorge(String title, String header, String ms) {

		this.title = title;
		this.header = header;
		this.message = ms;

	}

	public ExcepcionTorge(int sqlErrorcode) {

		switch (sqlErrorcode) {

		case 0:

			this.title = "Error de conexi�n";
			this.header = "El proceso de conexi�n ha encontrado un problema:";
			this.message = "La conexi�n con la base de datos no se ha podido resolver correctamente. Por facor, int�ntelo de nuevo m�s tarde.";

			break;

		default:

			this.title = "Error en el manejo de datos";
			this.header = "La aplicaci�n ha encontrado un problema:";
			this.message = "Se ha prodducido un error en el manejo de datos de la aplicaci�n. Por favor, vuelva a intentarlo m�s tarde.";

			break;

		}

	}

}
