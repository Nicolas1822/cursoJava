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

import java.util.Iterator;

/**
 * Clase que representa un zool�gico.
 */
public class Zoologico
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la cantidad de jaulas del zool�gico.
     */
	public static final int CANT_JAULAS = 10;

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de jaulas del zool�gico.
     */
	private Jaula [] jaulas;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Construye un zool�gico. <br>
     * <b> post: </b> La lista de jaulas qued� inicializada con los siguientes valores y posiciones: <br>
     * pos 0) Jaula peque�a en el sector norte. <br>
     * pos 1) Jaula peque�a en el sector norte. <br>
     * pos 2) Jaula mediana en el sector norte. <br>
     * pos 3) Jaula grande en el sector norte. <br>
     * pos 4) Jaula grande en el sector norte. <br>
     * pos 5) Jaula grande en el sector sur. <br>
     * pos 6) Jaula grande en el sector sur. <br>
     * pos 7) Jaula grande en el sector sur. <br>
     * pos 8) Jaula mediana en el sector sur. <br>
     * pos 9) Jaula peque�a en el sector sur.
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
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de jaulas del zool�gico <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Arreglo de jaulas.
     */
	public Jaula[] darJaulas()
	{
		return jaulas;
	}

	/**
     * Retorna la jaula con el n�mero dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNumJaula N�mero de la jaula deseada. pNumJaula >= 0 && pNumJaula < CANT_JAULAS.
     * @return Jaula con el n�mero dado.
     */
	public Jaula darJaula(int numJaula)
	{
		return jaulas[numJaula];
	}

    /**
     * Retorna la cantidad total de animales que tiene el zool�gico. <br>
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
     * @param pHabitat H�bitat del animal a agregar. pHabitat != null && pHabitat != "" && (pHabitat == ACUATICO || pHabitat == TERRESTRE).
     * @param pImagen Imagen del animal a agregar. pImagen != null && pImagen != "".
     * @return N�mero de la jaula en la que se agreg� el animal, -1 si no pudo agregar el animal.
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
     * Elimina el primer animal que encuentra con el nombre dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal a eliminar. pNombre != null && pNombre != "".
     * @return True si pudo eliminar el animal, false si no encontr� un animal con el nombre dado.
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
     * Retorna el n�mero de la jaula en la que se encuentra el primer animal con el nombre dado por par�metro. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @param pNombreAnimal Nombre del animal buscado. pNombreAnimal != null && pNombreAnimal != "".
     * @return N�mero de la jaula donde se encuentra el animal, -1 si no encontr� ning�n animal con ese nombre.
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
     * Retorna la jaula que tiene m�s animales.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return N�mero de la jaula que tiene m�s animales, -1 si todas las jaulas est�n desocupadas.
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
     * Retorna el porcentaje de ocupaci�n de la jaula con respecto a su capacidad total. <br>
     * El porcentaje se calcula teniendo en cuenta la cantidad total de animales del zool�gico y la capacidad total de las jaulas del zool�gico.<br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return Porcentaje de ocupaci�n.
     */


    /**
     * Indica si hay dos jaulas con la misma cantidad (diferente a 0) de animales. <br>
     * <b> pre: </b> El arreglo de jaulas se encuentra inicializado. <br>
     * @return True si existen dos jaulas con la misma cantidad de animales, false de lo contrario.
     */


    // -------------------------------------------------------------
    // Extensi�n
    // -------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}