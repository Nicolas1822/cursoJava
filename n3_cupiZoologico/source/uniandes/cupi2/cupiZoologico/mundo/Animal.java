package uniandes.cupi2.cupiZoologico.mundo;

/**
 * 
 * @author APRENDIZ
 * Clase que representa un animal
 *
 */
public class Animal {
	
	// -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------
	
	/**
	 * Constante que representa un animal Herbivoro
	 */
	public static final String HERBIVORO = "Herbivoro";
	
	/**
	 * Constante que representa un animal Carnivoro
	 */
	
	public static final String CARNIVORO = "Carnivoro";
	/**
	 * Constante que representa un animal Acuativo
	 */
	
	public static final String ACUATICO = "Acuatico";
	/**
	 * Constante que representa un animal Terrestre
	 */
	public static final String TERRESTRE = "Terrestre";

	// -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------
	
	/**
	 * nombre del animal
	 */
	private String nombre;
	
	/**
	 * especie a la que pertenece el animal
	 */
	private String especie;
	
	/**
	 * tipo del animal
	 */
	private String tipo;
	
	/**
	 * habitat al que pertenece el animal
	 */
	private String habitat;
	
	/**
	 * imagen del animal
	 */
	private String imagen;
	
	// -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
	
	/**
	 * Crea un nuevo animal con la informacion dada </br>
	 */
	/**
	 * @param nombre
	 * @param especie
	 * @param tipo
	 * @param habitat
	 * @param imagen
	 */
	public Animal(String nombre, String especie, String tipo, String habitat, String imagen) {
		this.nombre = nombre;
		this.especie = especie;
		this.tipo = tipo;
		this.habitat = habitat;
		this.imagen = imagen;
	}
	
	// -------------------------------------------------------------
    // Metodos
    // -------------------------------------------------------------
	
	/**
	 * retorna el nombre del animal
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * retorna la especie a la que pertenece el animal
	 * @return the especie
	 */
	public String darEspecie() {
		return especie;
	}

	/**
	 * retorna el tipo de animal
	 * @return the tipo
	 */
	public String darTipo() {
		return tipo;
	}

	/**
	 * retorna el habitat al que pertenece el animal
	 * @return the habitat
	 */
	public String darHabitat() {
		return habitat;
	}

	/**
	 * retorna la foto del animal
	 * @return the imagen
	 */
	public String darImagen() {
		return imagen;
	}

	@Override
	public String toString() {
		return "";
	}
	
	
	
}
