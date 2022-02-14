package uniandes.cupi2.zonaDeCamping.mundo;

public class Campista {

	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------
	
	/**
	 * Apellido del campista
	 * */
	private String apellido;
	/**
	 * Cedula del campista
	 * */
	private String cedula;
	/**
	 * Edad del campista
	 * */
	private int edad;
	/**
	 *Ruta de la imagen con la fotografia del campista
	 * */
	private String foto;
	/**
	 * Nombre del campista
	*/
	private String nombre;
	
	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------
	
	/**
	 * Crea un nuevo campista con la informacion dada <br>
	 * <b>post:</b>Se inicializo el campista con los datos recibidos como parametro
	 * @param nombre Nombre del campista - nombre != null
	 * @param apellido Apellido del campista - apellido != null
	 * @param cedula Cedula del campista - cedula != null
	 * @param edad Edad del campista - edad < 0
	 * @param foto Ruta de la imagen de la fotografia del campista - foto != null
	*/
	
	public Campista(String nombre, String apellido, String cedula, int edad, String foto) {
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.foto = foto;
		this.nombre = nombre;
	}


	//--------------------------------------------------------------------------
	//Metodos
	//--------------------------------------------------------------------------
	
	/**
	 * Retorna el apellido del campista
	 * @return El apellido del campista
	 */
	public String darApellido() {
		return apellido;
	}

	/**
	 * Retorna la cedula del campista
	 * @return La cedula del campista
	 */
	public String darCedula() {
		return cedula;
	}

	/**
	 * Retorna la edad del campista
	 * @return La edad del campista
	 */
	public int darEdad() {
		return edad;
	}

	/**
	 * retorna la ruta de la imagen del campista
	 * @return La ruta de la imagen del campista
	 */
	public String darFoto() {
		return foto;
	}

	/**
	 * Retorna el nombre del campista
	 * @return El nombre del campista
	 */
	public String darNombre() {
		return nombre;
	}



	/**
	 * Representacion textual de un objeto de la clase Campista
	 */
	@Override
	public String toString() {
		return nombre + " " + apellido + " ( " + cedula + " )";
	}
	
	
	
	
}
