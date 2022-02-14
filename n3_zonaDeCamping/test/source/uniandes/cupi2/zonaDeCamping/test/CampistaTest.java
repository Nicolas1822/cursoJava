/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: zonaDeCamping
 * Autor: Vanessa P�rez Romanello - 16-oct-2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.zonaDeCamping.test;

import junit.framework.*;
import uniandes.cupi2.zonaDeCamping.mundo.*;

/**
 * Clase usada para verificar la correcta implementaci�n de Campista
 */
public class CampistaTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * El campista donde se har�n las pruebas
     */
    private Campista campista;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Crea una nueva carpa
     */
    public void setupEscenario1( )
    {
       campista = new Campista( "Carlos", "Mu�oz", "1234567", 25, "foto" );
    }
    
    /**
     * Prueba 1 - Prueba el m�todo Campista<br>
     * M�todos a probar: <br>
     * Campista, darNombre, darApellido, darCedula, darEdad, darFoto
     */
    public void testCampista( )
    {
        setupEscenario1( );
        assertEquals( "Nombre inicializado incorrectamente", "Carlos", campista.darNombre( ) );
        assertEquals( "Apellido inicializado incorrectamente", "Mu�oz", campista.darApellido( ) );
        assertEquals( "C�dula inicializada incorrectamente", "1234567", campista.darCedula( ) );
        assertEquals( "Edad inicializada incorrectamente", 25, campista.darEdad( ) );
        assertEquals( "Imagen inicializada incorrectamente", "foto", campista.darFoto( ) );        
    }
    
    /**
     * Prueba 2 - Prueba el m�todo toString<br>
     * M�todos a probar: <br>
     * toString
     */
    public void testToString( )
    {
        setupEscenario1( );
        assertEquals( "La representaci�n String del campista no es correcta", "Carlos Mu�oz ( 1234567 )", campista.toString( ) );
    }

}