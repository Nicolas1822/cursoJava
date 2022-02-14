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

/**
 * Clase que representa a un guardia.
 */
public class Guardia
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del guardia.
     */
	private String nombre;
	
    /**
     * Años de experiencia como guardia.
     */
	private int anhosExperiencia;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa un guardia con los valores dados por parámetro. <br>
     * <b> post: </b> El guardia se inicializó con los valores nombre y anhosExperiencia dados por parámetro.<br>
     * @param pNombre Nombre del guardia. pNombre != null && pNombre != "".
     * @param pAnhosExperiencia Años de experiencia de guardia. pAnhosExperiencia >= 0.
     */
	/**
	 * @param nombre
	 * @param anhosExperiencia
	 */
	public Guardia(String nombre, int anhosExperiencia) 
	{
		this.nombre = nombre;
		this.anhosExperiencia = anhosExperiencia;
	}
	
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del guardia.
     * @return Nombre del guardia.
     */
	/**
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

    /**
     * Retorna el número de años de experiencia como guardia.
     * @return Número de años como experiencia.
     */
	/**
	 * @return the anhosExperiencia
	 */
	public int darAnhosExperiencia() {
		return anhosExperiencia;
	}

}
