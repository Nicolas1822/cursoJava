/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: zonaDeCamping
 * Autor: Vanessa Pérez Romanello - 16-oct-2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.zonaDeCamping.mundo;



/**
 * Clase que representa una zona de camping
 */
public class ZonaDeCamping
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------
    /**
     * Cantidad de carpas en la zona de camping
     */
	public static final int CANT_CARPAS = 15;
    
    /**
     * Cantidad máxima de personas admitidas en un grupo
     */
	public static final int CANT_MAX_GRUPOS = 10;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
    /**
     * La lista de carpas de la zona de camping
     */
	private Carpa[] carpas;


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Construye la zona de camping zoológico. <br>
     * <b>pos: </b> El arreglo de carpas está inicializado y todas las carpas están creadas <br>
     * Distribuye las carpas de la siguiente manera y en las siguientes posiciones:<br>
     * - pos 0) Carpa no. 1 en la zona norte <br>
     * - pos 1) Carpa no. 2 en la zona norte <br>
     * - pos 2) Carpa no. 3 en la zona norte <br>
     * - pos 3) Carpa no. 4 en la zona norte <br>
     * - pos 4) Carpa no. 5 en la zona sur <br>
     * - pos 5) Carpa no. 6 en la zona sur <br>
     * - pos 6) Carpa no. 7 en la zona sur <br>
     * - pos 7) Carpa no. 8 en la zona oeste <br>
     * - pos 8) Carpa no. 9 en la zona oeste <br>
     * - pos 9) Carpa no. 10 en la zona oeste <br>
     * - pos 10) Carpa no. 11 en la zona oeste <br>
     * - pos 11) Carpa no. 12 en la zona oeste <br>
     * - pos 12) Carpa no. 13 en la zona este <br>
     * - pos 13) Carpa no. 14 en la zona este <br>
     * - pos 14) Carpa no. 15 en la zona este
     */
	public ZonaDeCamping()
	{
		carpas = new Carpa[CANT_CARPAS];
		carpas[0] = new Carpa(Carpa.ZONA_NORTE, 1);
		carpas[1] = new Carpa(Carpa.ZONA_NORTE, 2);
		carpas[2] = new Carpa(Carpa.ZONA_NORTE, 3);
		carpas[3] = new Carpa(Carpa.ZONA_NORTE, 4);
		
		carpas[4] = new Carpa(Carpa.ZONA_SUR, 5);
		carpas[5] = new Carpa(Carpa.ZONA_SUR, 6);
		carpas[6] = new Carpa(Carpa.ZONA_SUR, 7);
		
		carpas[7] = new Carpa(Carpa.ZONA_OESTE, 8);
		carpas[8] = new Carpa(Carpa.ZONA_OESTE, 9);
		carpas[9] = new Carpa(Carpa.ZONA_OESTE, 10);
		carpas[10] = new Carpa(Carpa.ZONA_OESTE, 11);
		carpas[11] = new Carpa(Carpa.ZONA_OESTE, 12);
		
		carpas[12] = new Carpa(Carpa.ZONA_ESTE, 13);
		carpas[13] = new Carpa(Carpa.ZONA_ESTE, 14);
		carpas[14] = new Carpa(Carpa.ZONA_ESTE, 15);
	}

	// -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------
    
	/**
     * Indica a cual carpa puede se puede agregar el grupo con la cantidad de personas dada por parámetro<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @param cantidad Cantidad de personas pertenecientes al grupo - cantidad > 0 && cantidad <= CANT_MAX_GRUPOS
     * @param paraCompartir True si el grupo quiere compartir la carpa, false de lo contrario
     * @return la posición de la carpa en el arreglo donde se puede agregar al grupo o -1 si no se puede agregar a ninguna carpa
     */
	public int puedeAgregarGrupo(int cantidad, boolean paraCompartir)
	{
		int posicion = -1;
		boolean existe = false;
		
		for (int i = 0; i < carpas.length && !existe; i++) {
			if (carpas[i].puedeAgregar(cantidad, paraCompartir)) {
				posicion = i;
				existe = true; 
			}
		}
		
		return posicion;
	}

    /**
     * Indica si el campista con la cédula dada por parámetro existe en la zona de camping<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @param cedula Cédula del campista buscado - cedula != "" && cedula != null
     * @return true si el campista existe, false de lo contrario
     */
	public boolean existeCampista(String cedula)
	{
		boolean existe = false;
		
		for (int i = 0; i < carpas.length && !existe; i++) {	
			if (carpas[i].existeCampista(cedula)) {
				existe = true;
			}
		}
		
		return existe;
	}
    
    /**
     * Agrega al campista con los datos dados por parámetro a la primera carpa que cumpla con las características <br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * <b>post: </b> Se agregó el campista a la carpa que cumpla con las características <br>
     * @param nNombre Nombre del campista - nNombre != "" && nNombre != null
     * @param nApellido Apellido del campista - nApellido != "" && nApellido != null
     * @param nCedula Cédula del campista - nCedula != "" && nCedula != null
     * @param nEdad Edad del campista - nEdad > 0
     * @param nFoto Ruta donde se encuentra la foto del campista - nFoto != "" && nFoto != null
     * @param paraCompartir true si el campista desea compartir la carpa, false de lo contrario
     * @return la posición de la carpa donde se agregó al campista, -2 si ya existe un campista con la cédula dada y-1 si no se pudo agregar a ninguna carpa
     */
	public int agregarCampista(String nombre, String apellido, String cedula, int edad, String foto, boolean paraCompartir)
	{
		int posicion = -1;
		
		int resultado = buscarCarpaCampista(cedula);
		
		if (resultado != -1) 
		{
			posicion = -2;
		}
		else
		{
			boolean existe = false;
			
			for (int i = 0; i < carpas.length && !existe; i++) {
				if (carpas[i].puedeAgregar(1, paraCompartir)) {
					posicion = i;
					existe = true;
					carpas[i].agregarCampista(nombre, apellido, cedula, edad, foto, paraCompartir);
				}
			}
		}
		
		return posicion;
	}

    /**
     * Agrega al campista con los datos dados por parámetro a la carpa con la posición dada. Se debe validar que no supere la capacidad de la carpa.<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * <b>post: </b> Se agregó el campista a la carpa con la posición dada <br>
     * @param posicion Posición de la carpa donde se desea agregar al campista - posicion >= 0 && posicion < CANT_CARPAS
     * @param nNombre Nombre del campista - nNombre != "" && nNombre != null
     * @param nApellido Apellido del campista - nApellido != "" && nApellido != null
     * @param nCedula Cédula del campista - nCedula != "" && nCedula != null
     * @param nEdad Edad del campista - nEdad != "" && nEdad != null
     * @param nFoto Ruta donde se encuentra la foto del campista - nFoto != "" $$ nFoto != null
     * @param paraCompartir True si se desea compartir la carpa, false de lo contrario
     * @return true si agregó el campista, false si el campista ya está en la zona de camping
     */
	public boolean agregarCampista(int posicion, String nombre, String apellido, String cedula, int edad, String foto, boolean paraCompartir)
	{
		boolean agregado = false;
		int resultado = buscarCarpaCampista(cedula);
		
		if (resultado == -1 && carpas[posicion].puedeAgregar(1, paraCompartir)) {
			agregado = true;
			carpas[posicion].agregarCampista(nombre, apellido, cedula, edad, foto, paraCompartir);
		}
		
		return agregado;
	}

    /**
     * Elimina el campista con la cédula dada <br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * <b>post: </b> El campista fue eliminado de la zona de camping <br>
     * @param cedula Cédula del campista a eliminar - cedula != "" && cedula != null
     * @return true si se eliminó el campista, false de lo contrario
     */
	public boolean eliminarCampista(String cedula)
	{
		boolean eliminado = false;
		
		for (int i = 0; i < carpas.length && !eliminado; i++) {
			eliminado = carpas[i].eliminarCampista(cedula);
		}
		
		return eliminado;
	}

    /**
     * Retorna la posición donde se encuentra la carpa con el número dado
     * @param numero Número de la carpa buscada
     * @return posición de la carpa con el número dado, -1 si no hay ninguna carpa con ese número
     */
	public int buscarCarpa(int numero)
	{
		int posicion = -1;
		boolean encontro = false;
		
		for (int i = 0; i < carpas.length && !encontro; i++) 
		{
			if (carpas[i].darNumero() == numero) {
				encontro = true;
				posicion = i;
			}
		}
		
		return posicion;
	}

    /**
     * Busca la carpa donde se encuentra el campista con la cédula dada <br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @param cedula Cédula del campist buscado - cedula != "" && cedula != null
     * @return posición de la carpa donde se encuentra el campista, -1 si el campista no está en ninguna carpa
     */
	public int buscarCarpaCampista( String cedula)
	{
		int posicion = -1;
		boolean encontro = false;
	
		for (int i = 0; i < carpas.length && !encontro; i++) 
		{
			if (carpas[i].existeCampista(cedula) == true) 
			{
				encontro = true;
				posicion = i;
			}
		}
		
		return posicion;
	}

    /**
     * Retorna el campista con la cédula dada por parámetro<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @param cedula Cédula del campista buscado - cedula != "" && cedula != null
     * @return campista con la cédula dada, null si el campista no existe
     */
	public Campista buscarCampista(String cedula)
	{
		Campista campista = null;
		boolean encontro = false;
		
		for (int i = 0; i < carpas.length && !encontro; i++) 
		{
			campista = carpas[i].buscarCampista(cedula);
			if (campista != null) 
			{
				encontro = true;
			}
		}
		
		return campista;
	}
   

    /**
     * Indica si existen dos carpas que tienen al menos un campista adulto y la misma cantidad de campistas adultos.<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @return true si hay dos carpas con la misma cantidad de adultos y que esta cantidad sea mayor a cero, false de lo contrario
     */
	public boolean hayDosCarpasMismaCantidadAdultos()
	{
		boolean existe = false;
		
		for (int i = 0; i < carpas.length - 1 && !existe; i++) 
		{
			for (int j = i + 1; j < carpas.length && !existe; j++) {
				if (carpas[i].darCantidadDeAdultos() > 0 &&
					carpas[j].darCantidadDeAdultos() > 0 &&
					carpas[i].darCantidadDeAdultos() == carpas[j].darCantidadDeAdultos()) 
				{
					existe = true;
				}
			}
		}
		
		return existe;
	}

    /**
     * Calcula el porcentaje de ocupación de las zona de camping con respecto a su capacidad total <br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * El promedio se calcula teniendo en cuenta la cantidad total de campistas en la zona de camping y su capacidad total<br>
     * <b> pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @return porcentaje de ocupación
     */
	public double calcularPorcentajeOcupacionCarpas()
	{
		double porcentaje = 0.0;
		int cantidadCampistas = 0;
		int cupoTotal = 0;
		
		
		for (int i = 0; i < carpas.length; i++) {
			cantidadCampistas += carpas[i].darCantidadCampistas();
			cupoTotal += carpas[i].darCapacidad();
		}
		
		porcentaje = (double) cantidadCampistas/cupoTotal * 100;
		return porcentaje;
	}

	/**
     * Retorna la cantidad de campistas que se encuentran en la zona dada por parámetro<br>
     * <b>pre: </b> El arreglo de carpas se encuentra inicializado. <br>
     * @param zona Zona buscada
     * @return cantidad de campistas en la zona
     */
	public int darCantidadCampistasPorZona(String zona)
	{
		int cantidad = 0;
		
		for (int i = 0; i < carpas.length; i++) {
			if (carpas[i].darZona().equals(zona)) {
				cantidad += carpas[i].darCantidadCampistas();
			}
		}
		
		return cantidad;
	}

    /**
     * Retorna la carpa en la posición dada
     * @param posicion - Posicion de la carpa buscada- posicion >= 0 && posicion < CANT_CARPAS
     * @return la carpa en la posición dada
     */
	public Carpa darCarpa(int posicion)
	{
		return carpas[posicion];
	}

	// -------------------------------------------------------------
    // Métodos de extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}