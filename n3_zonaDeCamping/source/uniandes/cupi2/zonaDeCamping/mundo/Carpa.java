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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa una carpa en la zona de camping
 */
public class Carpa
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la zona norte
     */
	public static final String ZONA_NORTE = "Norte";
	
    /**
     * Constante que representa la zona este
     */
	public static final String ZONA_ESTE = "Este";
	
    /**
     * Constante que representa la zona oeste
     */
	public static final String ZONA_OESTE = "Oeste";
	
    /**
     * Constante que representa la zona sur
     */
	public static final String ZONA_SUR = "Sur";
	
    /**
     * Constante que representa la capacidad de las carpas de la zona norte
     */
	public static final int CAPACIDAD_NORTE = 10;
	
    /**
     * Constante que representa la capacidad de las carpas de la zona este
     */
	public static final int CAPACIDAD_ESTE = 2;
	
    /**
     * Constante que representa la capacidad de las carpas de la zona oeste
     */
	public static final int CAPACIDAD_OESTE = 5; 
	
    /**
     * Constante que representa la capacidad de las carpas de la zona sur
     */
	public static final int CAPACIDAD_SUR = 8;
	
 
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * La lista de campistas
     */
	private ArrayList <Campista> campistas;
    
    /**
     * Capacidad de la carpa
     */
	private int capacidad;

    /**
     * El numero de Carpa
     */
	private int numero;
 
    /**
     * Indica si la carpa es compartida
     */
	private boolean compartida;
 
    /**
     * Zona donde se encuentra la carpa
     */
	private String zona;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Crea una nueva carpa con la información dada <br>
     * <b> post: </b> Se inicializó el vector de campistas vacío y compartida en true.
     * @param nZona Zona donde se ubicará la carpa - nZona pertenece {ZONA_NORTE, ZONA_ESTE, ZONA_OESTE, ZONA_SUR}
     * @param nNumero Número de la carpa - numero >= 0
     */
	/**
	 * @param numero
	 * @param zona
	 */
	public Carpa( String zona, int numero ) {
		this.numero = numero;
		this.zona = zona;
		compartida = true;
		capacidad = darCapacidadSegunZona(zona);
		campistas = new ArrayList<>();
	}
	
    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------
	
    /**
     * Agrega un campista con la información dada por parámetro<br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado<br>
     * <b>post:</b> Se agregó el campista a la lista <br>
     * 				Se asigno a compartida el valor que se recibe por parámetro <br>
     * @param nNombre Nombre del campista - nNombre != null && nNombre != ""
     * @param nApellido Apellido del campista - nApellido != null && nApellido != ""
     * @param nCedula Cédula del campista - nCedula != null && nCedula != ""
     * @param nEdad Edad del campista = nEdad > 0
     * @param nFoto Ruta donde se encuentra la foto del campista - nFoto != null && nFoto != ""
     * @param paraCompartir True si el campista desea compartir la carpa, false de lo contrario
     */
	public void agregarCampista(String nombre, String apellido, String cedula, 
								int edad, String foto, boolean paraCompartir)
	{
		Campista nuevoCampista = new Campista(nombre, apellido, cedula, edad, foto);
		campistas.add(nuevoCampista);
		compartida = paraCompartir;
	}


    /**
     * Agrega un grupo de campistas a la lista de campistas <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado<br>
     * <b> post:</b> El grupo de campistas fue agregada la lista<br>
     * Se asigno a compartida el valor que se recibe por parámetro <br>
     * @param grupo Lista de campistas que se quieren agregar a la carpa - grupo != null
     * @param paraCompartir true si el grupo desea compartir la carpa, false de lo contrario
     */
	public void agregarGrupo(ArrayList grupo, boolean paraCompartir)
	{
		campistas.addAll(grupo);
		compartida = paraCompartir;
	}
    
    /**
     * Retorna la cantidad de cupos disponibles en la carpa
     * @return cantidad de cupos restantes
     */
	public int darCuposRestantes()
	{
		return capacidad - campistas.size();
	}
    
    /**
     * Indica si se puede agregar la cantidad de personas dada, teniendo en cuenta si se quiere compartir la carpa<br>
     * No se debe permitir agregar personas a la carpa en los siguientes casos: <br>
     * - Si la carpa no es compartida.<br>
     * - Si la carpa ya tiene ocupantes y los nuevos integrantes no desean compartir la carpa.<br>
     * - Si no hay cupo para todos los nuevos integrantes.<br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado
     * @param cantidad Cantidad de personas que se desean agregar a la carpa - cantidad >= 0
     * @param paraCompartir Indica si se desea compartir la carpa - true si se desea compatir, false de lo contrario
     * @return true si se puede agregar la cantidad de personas, false de lo contrario
     */
	public boolean puedeAgregar(int cantidad, boolean paraCompartir)
	{
		boolean puede = true;
		
		if (compartida == false) {
			puede = false;
				
			} 
		if (darCantidadCampistas() > 0 && paraCompartir == false) {
			puede = false;
		}
		
		if (cantidad > darCuposRestantes()) {
			puede = false;
		}
		
		return puede;
	}
	

    /**
     * Buscar al campista con la cédula dada por parámetro <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado
     * @param cedula Cédula del campista buscado - cedula != "" && cedula != null
     * @return Campista con la cédula dada, null si no está en la carpa
     */
	public Campista buscarCampista(String cedula)
	{
		Campista campista = null;
		boolean encontro = false;
		
		for (int i = 0; i < campistas.size() && !encontro; i++) {
			Campista aux = campistas.get(i);
			if (aux.darCedula().equals(cedula)) {
				encontro = true;
				campista = aux;
			}
		}

		return campista;
	}

	/**
     * Elimina de la lista al campista con la cédula dada <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado 
     * <b>post:</b> El campista con la cédula dada ya no existe en la lista si este existia
     * @param cedula Cédula del campista que se desea eliminar - cedula != "" && cedula != null
     * @return true si se eliminó al campista, false si el campista no se encontraba en la carpa
     */
	public boolean eliminarCampista(String cedula)
	{
		boolean eliminado = false;
		
		Campista campista = buscarCampista(cedula);
		if (campista != null) 
		{ 
			campistas.remove(campista);
			eliminado = true;
		}
		
		return eliminado;
	}

    /**
     * Retorna la cantidad de adultos que hay en la carpa <br>
     * Se considera que un campista es adulto si tiene por lo menos 18 años <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado
     * @return cantidad de adultos en la carpa
     */
	public int darCantidadDeAdultos()
	{
		int contador = 0;
		
		for (int i = 0; i < campistas.size(); i++) {
			Campista aux = campistas.get(i);
			if (aux.darEdad() >= 18) {
				contador ++;
			}
		}
		
		return contador;
	}

    /**
     * Indica si el campista con la cédula dada existe en el campamento <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado
     * @param cedula Cédula del campista buscado - cedula != "" && cedula != null
     * @return true si el campista existe, false de lo contrario
     */
	public boolean existeCampista(String cedula)
	{
		boolean existe = false;
		
		for (int i = 0; i < campistas.size(); i++) {
			Campista aux = campistas.get(i);
			
			if (aux.darCedula().equals(cedula)) {
				existe = true;
			}
		}
		
		return existe;
	}


    /**
     * Retorna la cantidad de campistas que se encuentran en la carpa <br>
     * <b>pre:</b> El vector de campistas se encuentra inicializado
     * @return cantidad de campistas en la carpa
     */
	public int darCantidadCampistas()
	{
		return campistas.size();
	}

    /**
     * Retorna la cantidad de personas que se pueden alojar en la carpa
     * @return capacidad de la carpa
     */
	public ArrayList<Campista> darCampistas()
	{
		return campistas;
	}
	
	
    /**
     * Retorna la lista de campistas que se encuentran en la carpa
     * @return lista de campistas
     */
	public int darCapacidad()
	{
		return capacidad;
	}


    /**
     * Retorna el número de la carpa
     * @return número de la carpa
     */
	public int darNumero()
	{
		return numero;
	}

    /**
     * Retorna la zona donde se encuentra la carpa
     * @return zona donde se ubica
     */
	public String darZona()
	{
		return zona;
	}

    /**
     * Indica si la carpa es compartida
     * @return true si la carpa es compartida, false de lo contrario
     */
	public boolean esCompartida() 
	{
		return compartida;
	}

    /**
     * Retorna la capacidad de la carpa dada una zona
     * @param zona Zona buscada - zona pertenece { ZONA_NORTE, ZONA_ESTE, ZONA_OESTE, CAPACIDAD_SUR }
     * @return capacidad de la carpa según la zona
     */
	
	public int darCapacidadSegunZona(String zona)
	{
		int capacidad = 0;
		
		switch (zona) {
		case ZONA_NORTE: 
			capacidad = CAPACIDAD_NORTE;
			break;
			
		case ZONA_SUR: 
			capacidad = CAPACIDAD_SUR;
			break;
			
		case ZONA_ESTE: 
			capacidad = CAPACIDAD_ESTE;
			break;
			
		case ZONA_OESTE: 
			capacidad = CAPACIDAD_OESTE;
			break;	
		}
		return capacidad;
	}

}