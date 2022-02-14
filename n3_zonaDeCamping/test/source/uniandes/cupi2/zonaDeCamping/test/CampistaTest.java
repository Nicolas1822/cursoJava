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
package uniandes.cupi2.zonaDeCamping.test;

import junit.framework.*;
import uniandes.cupi2.zonaDeCamping.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de Campista
 */
public class CampistaTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El campista donde se harán las pruebas
     */
    private Campista campista;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Crea una nueva carpa
     */
    public void setupEscenario1( )
    {
       campista = new Campista( "Carlos", "Muñoz", "1234567", 25, "foto" );
    }
    
    /**
     * Prueba 1 - Prueba el método Campista<br>
     * Métodos a probar: <br>
     * Campista, darNombre, darApellido, darCedula, darEdad, darFoto
     */
    public void testCampista( )
    {
        setupEscenario1( );
        assertEquals( "Nombre inicializado incorrectamente", "Carlos", campista.darNombre( ) );
        assertEquals( "Apellido inicializado incorrectamente", "Muñoz", campista.darApellido( ) );
        assertEquals( "Cédula inicializada incorrectamente", "1234567", campista.darCedula( ) );
        assertEquals( "Edad inicializada incorrectamente", 25, campista.darEdad( ) );
        assertEquals( "Imagen inicializada incorrectamente", "foto", campista.darFoto( ) );        
    }
    
    /**
     * Prueba 2 - Prueba el método toString<br>
     * Métodos a probar: <br>
     * toString
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "La representación String del campista no es correcta", "Carlos Muñoz ( 1234567 )", campista.toString( ) );
    }

}