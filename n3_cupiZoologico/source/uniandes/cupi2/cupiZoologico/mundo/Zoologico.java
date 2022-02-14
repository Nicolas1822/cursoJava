/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.mundo;

import java.util.Iterator;

/**
 * Clase que representa un zoológico.
 */
public class Zoologico
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la cantidad de jaulas del zoológico.
     */
	public static final int CANT_JAULAS = 10;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de jaulas del zoológico.
     */
	private Jaula [] jaulas;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un zoológico. <br>
     * <b> post: </b> La lista de jaulas quedó inicializada con los siguientes valores y posiciones: <br>
     * pos 0) Jaula pequeña en el sector norte. <br>
     * pos 1) Jaula pequeña en el sector norte. <br>
     * pos 2) Jaula mediana en el sector norte. <br>
     * pos 3) Jaula grande en el sector norte. <br>
     * pos 4) Jaula grande en el sector norte. <br>
     * pos 5) Jaula grande en el sector sur. <br>
     * pos 6) Jaula grande en el sector sur. <br>
     * pos 7) Jaula grande en el sector sur. <br>
     * pos 8) Jaula mediana en el sector sur. <br>
     * pos 9) Jaula pequeña en el sector sur.
     */
	public Zoologico()
	{
		jaulas = new Jaula[CANT_JAULAS];
		jaulas[0] = new Jaula(Jaula.PEQUENIA, Jaula.NORTE);
		jaulas[1] = new Jaula(Jaula.PEQUENIA, Jaula.NORTE);
		jaulas[2] = new Jaula(Jaula.MEDIANA, Jaula.NORTE);
		jaulas[3] = new Jaula(Jaula.GRANDE, Jaula.NORTE);
		jaulas[4] = new Jaula(Jaula.GRANDE, Jaula.NORTE);

		jaulas[5] = new Jaula(Jaula.GRANDE, Jaula.SUR);
		jaulas[6] = new Jaula(Jaula.GRANDE, Jaula.SUR);
		jaulas[7] = new Jaula(Jaula.GRANDE, Jaula.SUR);

		jaulas[8] = new Jaula(Jaula.MEDIANA, Jaula.SUR);
		jaulas[9] = new Jaula(Jaula.PEQUENIA, Jaula.SUR);
	}

	
    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de jaulas del zoológico <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Arreglo de jaulas.
     */
	public Jaula[] darJaulas()
	{
		return jaulas;
	}

	/**
     * Retorna la jaula con el número dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNumJaula Número de la jaula deseada. pNumJaula >= 0 && pNumJaula < CANT_JAULAS.
     * @return Jaula con el número dado.
     */
	public Jaula darJaula(int numJaula)
	{
		return jaulas[numJaula];
	}

    /**
     * Retorna la cantidad total de animales que tiene el zoológico. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad total de animales.
     */
	public int darCantidadAnimales()
	{
		int contador = 0;
		
		for (int i = 0; i < jaulas.length; i++) {
			contador++;
		}
		
		return contador;
	}

    /**
     * Retorna la cantidad de jaulas ubicadas en el sector sur. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad de jaulas en el sur.
     */
	public int darCantidadJaulasSur()
	{
		int cantidad = 0;
		
		for (int i = 0; i < jaulas.length; i++) {
			if (jaulas[i].darSector().equals(Jaula.SUR)) 
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}

    /**
     * Retorna la cantidad de jaulas ubicadas en el sector norte. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Cantidad de jaulas en el norte.
     */
	public int darCantidadJaulasNorte()
	{
		int cantidad = 0;
		
		for (int i = 0; i < jaulas.length; i++) 
		{
			if (jaulas[i].darSector().equals(Jaula.NORTE)) 
			{
				cantidad++;
			}
		}
		
		return cantidad;
	}

    /**
     * Agrega un animal en la primera jaula que cumpla con los requerimientos. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombre Nombre del animal a agregar. pNombre != null && pNombre != "".
     * @param pEspecie Especie del animal a agregar. pEspecie != null && pEspecie != "".
     * @param pTipo Tipo del animal a agregar. pTipo != null && pTipo != "" && (pTipo == HERBIVORO || pTipo == CARNIVORO).
     * @param pHabitat Hábitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     * @return Número de la jaula en la que se agregó el animal, -1 si no pudo agregar el animal.
     */
	public int agregarAnimal(String nombre, String especie, String tipo, 
							 String habitat, String imagen)
	{
		int posicion = -1;
		boolean existe = false;
		
		for (int i = 0; i < jaulas.length && !existe; i++) 
		{
			Jaula aux = jaulas[i];
			if (jaulas[i].puedeAgregarAnimal(especie, tipo, habitat) == true) 
			{
				aux.agregarAnimal(nombre, especie, tipo, habitat, imagen);
				posicion = i;
				existe = true;
			}
		}
		
		return posicion;
	}

    /**
     * Elimina el primer animal que encuentra con el nombre dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si pudo eliminar el animal, false si no encontró un animal con el nombre dado.
     */
	public boolean eliminarAnimal(String nombreAnimal)
	{
		boolean eliminado = false;
		
		for (int i = 0; i < jaulas.length && !eliminado; i++) 
		{
			eliminado = jaulas[i].eliminarAnimal(nombreAnimal);
		}
		
		return eliminado;
	}

    /**
     * Retorna el número de la jaula en la que se encuentra el primer animal con el nombre dado por parámetro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal buscado. pNombreAnimal != null && pNombreAnimal != "".
     * @return Número de la jaula donde se encuentra el animal, -1 si no encontró ningún animal con ese nombre.
     */
	public int buscarJaulaAnimalPorNombre(String nombreAnimal)
	{
		int posicion = -1;
		boolean encontrado = false;
		
		for (int i = 0; i < jaulas.length && !encontrado; i++) 
		{
			Jaula aux = jaulas[i];
			if (aux.existeAnimalEnJaula(nombreAnimal) == true) 
			{
				posicion = i;
				encontrado = true;
			}
		}
		
		return posicion;
	}

    /**
     * Retorna la jaula que tiene más animales.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Número de la jaula que tiene más animales, -1 si todas las jaulas están desocupadas.
     */
	public int buscarJaulaMayorCantidadAnimales()
	{
		int cantidad = -1;
		int posicion = jaulas[0].darCantidadAnimales();
		
		for (int i = 0; i < jaulas.length; i++)
		{
			if (jaulas[i].darCantidadAnimales() > posicion) 
			{
				cantidad = i;
			}
		}
		
		return cantidad;
	}

    /**
     * Retorna el porcentaje de ocupación de la jaula con respecto a su capacidad total. <br>
     * El porcentaje se calcula teniendo en cuenta la cantidad total de animales del zoológico y la capacidad total de las jaulas del zoológico.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Porcentaje de ocupación.
     */


    /**
     * Indica si hay dos jaulas con la misma cantidad (diferente a 0) de animales. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return True si existen dos jaulas con la misma cantidad de animales, false de lo contrario.
     */


    // -------------------------------------------------------------
    // Extensión
    // -------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}