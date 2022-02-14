/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.mundo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa a la jaula del zool�gico.
 */
public class Jaula
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la ubicaci�n de la jaula en el sector norte del zool�gico.
     */
	public static final String NORTE = "Norte";

    /**
     * Constante que representa la ubicaci�n de la jaula en el sector sur del zool�gico.
     */
	public static final String SUR = "Sur";

    /**
     * Constante que representa el tama�o de jaula grande.
     */
	public static final String GRANDE = "Grande";

    /**
     * Constante que representa el tama�o de jaula mediana.
     */
	public static final String MEDIANA = "Mediana";

    /**
     * Constante que representa el tama�o de jaula peque�a.
     */
	public static final String PEQUENIA = "Peque�a";

    /**
     * Constante que representa la capacidad de una jaula grande.
     */
	public static final int CAPACIDAD_GRANDE = 10;

    /**
     * Constante que representa la capacidad de una jaula mediana.
     */
	public static final int CAPACIDAD_MEDIANA = 6;

    /**
     * Constante que representa la capacidad de una jaula peque�a.
     */
	public static final int CAPACIDAD_PEQUENA = 2;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El sector donde se encuentra ubicada la jaula.
     */
	private String sector;

    /**
     * El tama�o de la jaula.
     */
	private String tamanio;


    /**
     * Vector de animales que se encuentran en jaula.
     */
	private ArrayList<Animal> animales;

    /**
     * Guardia de la jaula.
     */
	private Guardia guardia;
	
    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa la jaula usando los valores dados por par�metro. <br>
     * <b> post: </b> La jaula se inicializ� con los valores de sector y tamanio dados por par�metro. El vector de animales qued� inicializado y el guardia se inicializ� como null. 
     * @param pSector Sector donde est� ubicada la jaula. pSector != null && pSector != "" && (pSector = NORTE || pSector = SUR ).
     * @param pTamanio Tama�o de la jaula. pTamanio != null && pTamanio && (pTamanio = GRANDE || pTamanio = MEDIANA || pTamanio = PEQUE�A).
     */
    /**
	 * @param sector
	 * @param tamanio
	 */
	public Jaula(String sector, String tamanio) {
		this.sector = sector;
		this.tamanio = tamanio;
		animales = new ArrayList<>();
	}


    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna el sector donde se ubica la jaula.
     * @return Sector de la jaula.
     */
	public String darSector()
	{
		return sector;
	}



	/**
     * Retorna el guardia de la jaula.
     * @return Guardia de la jaula.
     */
	public Guardia darGuardia()
	{
		return guardia;
	}

    /**
     * Retorna el tama�o de la jaula.
     * @return Tama�o de la jaula.
     */
	public String darTamanio()
	{
		return tamanio;
	}

    /**
     * Retorna la lista de los animales que se encuentran en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return Animales que se encuentran en la jaula.
     */
	public ArrayList<Animal> darAnimales()
	{
		return animales;
	}

    /**
     * Retorna la capacidad de la jaula dependiendo del tama�o de la jaula. <br>
     * @return Capacidad de la jaula.
     */
	public int darCapacidadJaula()
	{
		int capacidad = Integer.parseInt(tamanio);
		
		if (capacidad == CAPACIDAD_GRANDE) {
			capacidad = CAPACIDAD_GRANDE;
		}
		if(capacidad == CAPACIDAD_MEDIANA)
		{
			capacidad = CAPACIDAD_MEDIANA;
		}
		if (capacidad == CAPACIDAD_PEQUENA) 
		{
			capacidad = CAPACIDAD_PEQUENA;
		}
		
		return capacidad;
	}

    /**
     * Retorna la cantidad de animales que hay en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return Cantidad de animales en la jaula.
     */
	public int darCantidadAnimales()
	{
		return animales.size();	
	}

    /**
     * Agrega un animal en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * <b> post: </b> Se agreg� un nuevo animal a la lista de animales. <br>
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat H�bitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     */
	public void agregarAnimal(String nombre, String especie, String tipo, 
							  String habitat, String imagen)
	{
		Animal nuevoAnimal = new Animal(nombre, especie, tipo, habitat, imagen);
		animales.add(nuevoAnimal);
	}

    /**
     * Asigna un guardia a la jaula actual. <br>
     * <b> post: </b> Se asign� un nuevo guardia a la jaula. <br>
     * @param pNombreGuardia Nombre del guardia. pNombreGuardia != "" && pNombreGuardia != null.
     * @param pAnhosExperiencia A�os de experiencia como guardia.
     */
	public void asignarGuardia(String nombreGuardia, int anhosExperiencia)
	{
		Guardia guardiaAsignado = new Guardia(nombreGuardia, anhosExperiencia);
		this.guardia = guardiaAsignado;
	}

    /**
     * Elimina el primer animal encontrado con el nombre dado por par�metro. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pNombre Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si elimin� el animal, false si no encontr� un animal con ese nombre para eliminar.
     */
	public boolean eliminarAnimal(String nombre) {
		boolean eliminado = false;
		
		for (int i = 0; i < animales.size() && !eliminado; i++) 
		{ 
			boolean jaulas = existeAnimalEnJaula(nombre);
			if (jaulas == true) 
			{
				animales.remove(i);
				eliminado = true;
			}
		}
		
		return eliminado;
	}

    /**
     * Indica si hay alg�n animal carn�voro en la jaula. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return True si hay alg�n carn�voro en la jaula, false de lo contrario.
     */
	public boolean hayAnimalCarnivoro()
	{
		boolean existe = false;
		
		for (int i = 0; i < animales.size() && !existe; i++) 
		{
			Animal aux = animales.get(i);
			if (aux.darTipo().equals(Animal.CARNIVORO)) 
			{
				existe = true;
			}
		}
		
		return existe;
	}

    /**
     * Indica si hay espacio en la jaula para un animal m�s.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @return True si hay espacio en la jaula, false de lo contrario.
     */
	public boolean hayEspacioEnJaula()
	{
		boolean hayEspacio = false;
		
		for (int i = 0; i < animales.size(); i++) 
		{
			if (animales.size() < darCapacidadJaula()) {
				hayEspacio = true;
			}
		}
		
		return hayEspacio;
	}

    /**
     * Indica si en la jaula existe alg�n animal con el nombre dado. <br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pNombre Nombre del animal a buscar. pNombre != null && pNombre != "".
     * @return True si encontr� el animal, false de lo contrario.
     */
	public boolean existeAnimalEnJaula(String nombre)
	{
		boolean existe = false;
		
		for (int i = 0; i < animales.size(); i++) 
		{
			Animal aux = animales.get(i);
			
			if (aux.darNombre().equals(nombre)) {
				existe = true;
			}
		}
		
		return existe;
	}

    /**
     * Indica si un h�bitat dado por par�metro es el indicado para la jaula, teniendo en cuenta las siguientes condiciones:<br>
     * Si la jaula est� en el sector norte, s�lo puede agregar animales de h�bitat acu�tico.<br>
     * Si la jaula est� en el sector sur, s�lo puede agregar animales de h�bitat terrestre.<br>
     * @param pHabitat H�bitat del animal a verificar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @return True si la jaula cumple con las condiciones indicadas, false de lo contrario.
     */
	public boolean puedeAgregarPorHabitat(String habitat)
	{
		boolean puedeAgregar = false;
		
		for (int i = 0; i < animales.size(); i++) 
		{
			Animal aux = animales.get(i);
					if (darSector().equals(Jaula.NORTE) && aux.darHabitat().equals(habitat)) {
						puedeAgregar = true;
					}
					else if (darSector().equals(Jaula.SUR) && aux.darHabitat().equals(habitat))
					{
						puedeAgregar = true;
					}
					
		}

		return puedeAgregar;
	}

    /**
     * Indica si se puede agregar un animal de cierto tipo y especie a la jaula teniendo en cuenta las siguientes condiciones: <br>
     * Si el tipo es herb�voro, s�lo lo puede agregar si no hay ning�n animal carn�voro en la jaula o si la jaula est� vac�a.<br>
     * Si el tipo es carn�voro, s�lo lo puede agregar si hay un animal de la misma especie en la jaula o si la jaula est� vac�a.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pEspecie Especie del animal a agregar. pEspecie != null y pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == CARNIVORO || pTipo == HERBIVORO).
     * @return True si se puede agregar, false de lo contrario.
     */
	public boolean puedeAgregarPorTipoYEspecie(String especie, String tipo)
	{
		boolean puedeAgregar = false;
		
		if( (tipo.equals( Animal.HERBIVORO ) && !hayAnimalCarnivoro()) || darCantidadAnimales() == 0 ) {
			puedeAgregar = true;
		}
		else if( tipo.equals( Animal.CARNIVORO ) ) 
		{
			if( darCantidadAnimales() == 0 ) 
			{
				puedeAgregar = true;
			}
			else {
				
				for( int i = 0; i < animales.size() && !puedeAgregar; i++ )
				{
					if( animales.get( i ).darEspecie().equals( especie ) )
					{
						puedeAgregar = true;
					}
				}
				
			}
		}
		
	
		return puedeAgregar;
	}

    /**
     * Indica si el animal con las caracter�sticas dadas puede ser agregado a la jaula teniendo en cuenta las restricciones enunciadas en el documento de descripci�n.<br>
     * <b> pre: </b> La lista de animales se encuentra inicializada. <br>
     * @param pEspecie Especie del animal a verificar - especie != null y especie != "".
     * @param pTipo Tipo del animal a verificar. pTipo != null && pTipo != "".
     * @param pHabitat H�bitat del animal a verificar. pHabitat != null && pHabitat != "".
     * @return true si se puede agregar al animal, false de lo contrario.
     */
	public boolean puedeAgregarAnimal(String especie, String tipo, String habitat)
	{
		boolean puedeAgregar = false;
		
		if( puedeAgregarPorHabitat(habitat) && puedeAgregarPorTipoYEspecie(especie, tipo) && 
			hayEspacioEnJaula() ) 
		{
			puedeAgregar = true;
		}
		
		return puedeAgregar;
	}
	
	
	

}