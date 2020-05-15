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
	 * Constructor de la excepción. Llama al método "super()" de la clase Excepción,
	 * de la que extiende.
	 */
	public ExcepcionTorge() {
		super();

		this.title = "Error de ejecución";
		this.header = "La aplicación en su ejecución:";
		this.message = "Se ha producido un error durante la ejecución de la aplicación. Por favor vuelva a intentarlo.";

	}

	/**
	 * Constructor de la excepción. Llama al método "super()" de la clase Excepción,
	 * de la que extiende.
	 *
	 * @param ms Mensaje de error personalizado que se le pasa de forma opcional,
	 *           para que lo muestre al realizar el "throw".
	 */
	public ExcepcionTorge(String ms) {

		this.title = "Se ha producido un error";
		this.header = "La aplicación ha sufrido un error con el siguiente mensaje:";
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

			this.title = "Error de conexión";
			this.header = "El proceso de conexión ha encontrado un problema:";
			this.message = "La conexión con la base de datos no se ha podido resolver correctamente. Por facor, inténtelo de nuevo más tarde.";

			break;

		default:

			this.title = "Error en el manejo de datos";
			this.header = "La aplicación ha encontrado un problema:";
			this.message = "Se ha prodducido un error en el manejo de datos de la aplicación. Por favor, vuelva a intentarlo más tarde.";

			break;

		}

	}

}
