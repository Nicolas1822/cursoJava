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

import java.util.ArrayList;

import junit.framework.*;
import uniandes.cupi2.zonaDeCamping.mundo.*;

/**
 * Clase usada para verificar la correcta implementación de Carpa
 */
public class CarpaTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * La carpa donde ser harán las pruebas
     */
    private Carpa carpa;

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Crea una carpa vacía en la zona oeste
     */
    public void setupEscenario1( )
    {
        carpa = new Carpa( Carpa.ZONA_OESTE, 3 );
    }

    /**
     * Crea una carpa compartida con 3 campistas en la zona sur
     */
    public void setupEscenario2( )
    {
        carpa = new Carpa( Carpa.ZONA_SUR, 5 );
        carpa.agregarCampista( "Carolina", "Rodriguez", "654321", 13, "foto_carolina", true );
        carpa.agregarCampista( "Camilo", "Rodriguez", "5654321", 33, "foto_camilo", true );
        carpa.agregarCampista( "Mariana", "Rodriguez", "123456", 28, "foto_mariana", true );
    }

    /**
     * Crea una carpa no compartida en la zona este
     */
    public void setupEscenario3( )
    {
        carpa = new Carpa( Carpa.ZONA_OESTE, 4 );
        carpa.agregarCampista( "Raúl", "Zapata", "23424324242", 54, "foto_raul", false );
    }

    /**
     * Prueba 1 - Prueba el método constructor <br>
     * Métodos a probar: <br>
     * Carpa, darNumero, darCapacidad, darZona, esCompartida
     */
    public void testCarpa( )
    {
        setupEscenario1( );
        assertEquals( "El número no se inicializó correctamente", 3, carpa.darNumero( ) );
        assertEquals( "La capacidad no se inicializó correctamente", 5, carpa.darCapacidad( ) );
        assertEquals( "La zona no se inicializó correctamente", Carpa.ZONA_OESTE, carpa.darZona( ) );
        assertNotNull( "La lista de campistas no fue inicializada", carpa.darCampistas( ) );
        assertTrue( "La lista de campistas debería estar vacía", carpa.darCampistas( ).isEmpty( ) );
        assertTrue( "La carpa se debe inicializar como compartida", carpa.esCompartida( ) );
    }

    /**
     * Prueba 2 - Prueba el método agregarCampista <br>
     * Métodos a probar: <br>
     * Carpa, agregarCampista, darCantidadCampistas, esCompartida
     */
    public void testAgregarCampista( )
    {
        setupEscenario1( );
        carpa.agregarCampista( "Eduardo", "Salazar", "123432", 43, "foto_eduardo", true );
        assertEquals( "No agregó al campista correctamente", 1, carpa.darCantidadCampistas( ) );
        assertTrue( "La carpa debería ser compartida", carpa.esCompartida( ) );

        carpa.agregarCampista( "Marina", "Reina", "12345", 42, "foto_marina", false );
        assertEquals( "No agregó al campista correctamente", 2, carpa.darCantidadCampistas( ) );
        assertFalse( "La carpa debería ser compartida", carpa.esCompartida( ) );
    }

    /**
     * Prueba 3 - Prueba el método agregarGrupo <br>
     * Métodos a probar: <br>
     * Carpa, agregarGrupo, darCantidadCampistas, esCompartida
     */
    public void testAgregarGrupo( )
    {
        setupEscenario3( );
        ArrayList grupo = new ArrayList( );
        for( int i = 0; i < 5; i++ )
        {
            Campista campista = new Campista( "Nombre" + i, "Apellido" + i, "Cedula" + i, i, "foto" + i );
            grupo.add( campista );
        }
        carpa.agregarGrupo( grupo, false );
        assertEquals( "La carpa debería tener 6 campistas", 6, carpa.darCantidadCampistas( ) );
        assertFalse( "La carpa no debería ser compartida", carpa.esCompartida( ) );
    }

    /**
     * Prueba 4 - Prueba el método puedeAgregar <br>
     * Métodos a probar: <br>
     * puedeAgregar, agregarGrupo <br>
     * Caso de prueba: <br>
     * La carpa está en la zona oeste
     */
    public void testPuedeAgregar1( )
    {
        setupEscenario1( );
        assertTrue( "Debería poder agregar 5 campistas a la carpa", carpa.puedeAgregar( 5, true ) );
        ArrayList grupo = new ArrayList( );
        for( int i = 0; i < 4; i++ )
        {
            Campista campista = new Campista( "Nombre" + i, "Apellido" + i, "Cedula" + i, i, "foto" + i );
            grupo.add( campista );
        }
        carpa.agregarGrupo( grupo, true );
        assertFalse( "No debería poder agregar 2 campitas a la carpa", carpa.puedeAgregar( 2, true ) );
        assertTrue( "Debería poder agregar un campista a la carpa", carpa.puedeAgregar( 1, true ) );
    }

    /**
     * Prueba 5 - Prueba el método puedeAgregar <br>
     * Métodos a probar: <br>
     * puedeAgregar, agregarGrupo<br>
     * Caso de prueba: <br>
     * La carpa está en la zona sur
     */
    public void testPuedeAgregar2( )
    {
        setupEscenario2( );
        assertTrue( "Debería poder agregar 3 campistas a la carpa", carpa.puedeAgregar( 3, true ) );
        assertFalse( "No debería poder agregar 10 campistas a la carpa", carpa.puedeAgregar( 10, true ) );
        ArrayList grupo = new ArrayList( );
        for( int i = 0; i < 4; i++ )
        {
            Campista campista = new Campista( "Nombre" + i, "Apellido" + i, "Cedula" + i, i, "foto" + i );
            grupo.add( campista );
        }
        carpa.agregarGrupo( grupo, true );
        assertFalse( "No debería poder agregar 3 campistas a la carpa", carpa.puedeAgregar( 3, true ) );
        assertTrue( "Debería poder agregar 1 campista a la carpa", carpa.puedeAgregar( 1, true ) );
    }

    /**
     * Prueba 6 - Prueba el método puedeAgregar <br>
     * Métodos a probar: <br>
     * puedeAgregar <br>
     * Caso de prueba: <br>
     * La carpa es compatida
     */
    public void testPuedeAgregar3( )
    {
        setupEscenario2( );
        assertTrue( "Debería poder agregar al campista", carpa.puedeAgregar( 1, true ) );
        assertFalse( "No debería poder agregar al campista", carpa.puedeAgregar( 1, false ) );
    }

    /**
     * Pueba 7 - Prueba el método puedeAgregar <br>
     * Métodos a probar: <br>
     * puedeAgregar <br>
     * Casos de prueba <br>
     * La carpa no es compartida
     */
    public void testPuedeAgregar4( )
    {
        setupEscenario3( );
        assertFalse( "No debería poder agregar a un campista", carpa.puedeAgregar( 1, true ) );
        assertFalse( "No debería poder agregar a un campista", carpa.puedeAgregar( 1, false ) );
    }

    /**
     * Prueba 8 - Prueba el método puedeAgregar <br>
     * Métodos a probar: <br>
     * puedeAgregar <br>
     * Casos de prueba: <br>
     * La carpa está vacía
     */
    public void testPuedeAgregar5( )
    {
        setupEscenario1( );
        assertTrue( "Debería poder agregar al campista", carpa.puedeAgregar( 1, true ) );
        assertTrue( "Debería poder agregar al campista", carpa.puedeAgregar( 1, false ) );
    }

    /**
     * Prueba 9 - Prueba el método buscarCampista <br>
     * Métodos a probar: <br>
     * buscarCampista <br>
     * Casos de prueba: <br>
     * El campista buscado existe
     */
    public void testBuscarCampista1( )
    {
        setupEscenario2( );
        Campista campista = carpa.buscarCampista( "654321" );
        assertNotNull( "Debería haber encontrado al campista", campista );
        assertEquals( "No encontró al campista correcto", "Carolina", campista.darNombre( ) );

        campista = carpa.buscarCampista( "5654321" );
        assertNotNull( "Debería haber encontrado al campista", campista );
        assertEquals( "No encontró al campista correcto", "Camilo", campista.darNombre( ) );

        campista = carpa.buscarCampista( "123456" );
        assertNotNull( "Debería haber encontrado al campista", campista );
        assertEquals( "No encontró al campista correcto", "Mariana", campista.darNombre( ) );
    }

    /**
     * Prueba 10 - Prueba el método buscarCampista <br>
     * Métodos a probar: <br>
     * buscarCampista< br>
     * Casos de prueba: <br>
     * El campista buscado no existe
     */
    public void testBuscarCampista2( )
    {
        setupEscenario2( );
        assertNull( "No debería encontrar al campista", carpa.buscarCampista( "3453534" ) );
        assertNull( "No debería encontrar al campista", carpa.buscarCampista( "6543212" ) );
        assertNull( "No debería encontrar al campista", carpa.buscarCampista( "Carolina" ) );
        assertNull( "No debería encontrar al campista", carpa.buscarCampista( "Rodriguez" ) );
    }

    /**
     * Prueba 11 - Prueba el método eliminarCampista <br>
     * Métodos a probar: <br>
     * eliminarCampista, darCantidadCampistas, darCampistas, buscarCampista <br>
     * Caso de prueba: <br>
     * Se eliminó correctamente al campista
     */
    public void testEliminarCampista1( )
    {
        setupEscenario2( );

        String cedula = "654321";
        assertTrue( "Debería haber eliminado el campista", carpa.eliminarCampista( cedula ) );
        assertEquals( "No eliminó el campista de la lista", 2, carpa.darCantidadCampistas( ) );
        assertNull( "No eliminó al campista correcto", carpa.buscarCampista( cedula ) );

        cedula = "5654321";
        assertTrue( "Debería haber eliminado el campista", carpa.eliminarCampista( cedula ) );
        assertEquals( "No eliminó el campista de la lista", 1, carpa.darCantidadCampistas( ) );
        assertNull( "No eliminó al campista correcto", carpa.buscarCampista( cedula ) );

        cedula = "123456";
        assertTrue( "Debería haber eliminado el campista", carpa.eliminarCampista( cedula ) );
        assertEquals( "No eliminó el campista de la lista", 0, carpa.darCantidadCampistas( ) );
        assertTrue( "No se eliminó el campista de la lista", carpa.darCampistas( ).isEmpty( ) );
        assertNull( "No eliminó al campista correcto", carpa.buscarCampista( cedula ) );

    }

    /**
     * Prueba 12 - Prueba el método eliminarCampista <br>
     * Métodos a probar: <br>
     * eliminarCampista, darCantidadCampistas <br>
     * Caso de prueba: <br>
     * e No se eliminó al campista
     */
    public void testEliminarCampista2( )
    {
        setupEscenario2( );
        assertFalse( "El campista no existe", carpa.eliminarCampista( "87653453" ) );
        assertEquals( "No debería eliminar un campista de la lista", 3, carpa.darCantidadCampistas( ) );

        assertFalse( "El campista no existe", carpa.eliminarCampista( "Catalina" ) );
        assertEquals( "No debería eliminar un campista de la lista", 3, carpa.darCantidadCampistas( ) );

        assertFalse( "El campista no existe", carpa.eliminarCampista( "12321312" ) );
        assertEquals( "No debería eliminar un campista de la lista", 3, carpa.darCantidadCampistas( ) );
    }

    /**
     * Prueba 13 - Prueba el método darCantidadDeAdultos <br>
     * Métodos a probar: <br>
     * darCantidadDeAdultos, agregarCampista
     */
    public void testDarCantidadDeAdultos( )
    {
        setupEscenario2( );
        assertEquals( "No calcula la cantidad de adultos correctamente", 2, carpa.darCantidadDeAdultos( ) );
        carpa.agregarCampista( "Juanito", "Gomez", "234242", 17, "foto_juanito", true );
        assertEquals( "No calcula la cantidad de adultos correctamente", 2, carpa.darCantidadDeAdultos( ) );
        carpa.agregarCampista( "Felipe", "Ramirez", "87654574", 18, "foto_felipe", true );
        assertEquals( "No calcula la cantidad de adultos correctamente", 3, carpa.darCantidadDeAdultos( ) );
    }

    /**
     * Prueba 14 - Prueba el método existeCampista <br>
     * Métodos a probar: <br>
     * existeCampista
     */
    public void testExisteCampista( )
    {
        setupEscenario2( );

        assertTrue( "El campista debería existir", carpa.existeCampista( "654321" ) );
        assertTrue( "El campista debería existir", carpa.existeCampista( "5654321" ) );
        assertFalse( "El campista no debería existir", carpa.existeCampista( "Catalina" ) );
        assertFalse( "El campista no debería existir", carpa.existeCampista( "Rodriguez" ) );
    }

    /**
     * Prueba 15 - Prueba el método darCuposRestantes <br>
     * Métodos a probar: <br>
     * darCuposRestantes, agregarCampista
     */
    public void testDarCuposRestantes( )
    {
        setupEscenario2( );
        assertEquals( "No calcula la cantidad de cupos correctamente", 5, carpa.darCuposRestantes( ) );
        carpa.agregarCampista( "Raquel", "Sanchez", "2342432", 43, "foto_raquel", true );
        assertEquals( "No calcula la cantidad de cupos correctamente", 4, carpa.darCuposRestantes( ) );
        carpa.agregarCampista( "Raquel", "Roa", "6546464", 46, "foto_raquel", true );
        assertEquals( "No calcula la cantidad de cupos correctamente", 3, carpa.darCuposRestantes( ) );
    }

    /**
     * Prueba 16 - Prueba el método darCantidadCampistas <br>
     * Métodos a probar: <br>
     * darCantidadCampistas, agregarCampista
     */
    public void testDarCantidadCampistas( )
    {
        setupEscenario2( );
        assertEquals( "No calcula la cantidad de campistas correctamente", 3, carpa.darCantidadCampistas( ) );
        carpa.agregarCampista( "Raquel", "Sanchez", "2342432", 43, "foto_raquel", true );
        assertEquals( "No calcula la cantidad de campistas correctamente", 4, carpa.darCantidadCampistas( ) );
        carpa.agregarCampista( "Raquel", "Roa", "6546464", 46, "foto_raquel", true );
        assertEquals( "No calcula la cantidad de campistas correctamente", 5, carpa.darCantidadCampistas( ) );
        carpa.eliminarCampista( "654321" );
        assertEquals( "No calcula la cantidad de campistas correctamente", 4, carpa.darCantidadCampistas( ) );
    }

    /**
     * Prueba 17 - Prueba el método darCapacidadSegunZona <br>
     * Métodos a probar: <br>
     * darCapacidadSegunZona
     */
    public void testDarCapacidadSegunZona( )
    {
        setupEscenario1( );
        assertEquals( "No retorna la capacidad correcta", Carpa.CAPACIDAD_ESTE, carpa.darCapacidadSegunZona( Carpa.ZONA_ESTE ) );
        assertEquals( "No retorna la capacidad correcta", Carpa.CAPACIDAD_OESTE, carpa.darCapacidadSegunZona( Carpa.ZONA_OESTE ) );
        assertEquals( "No retorna la capacidad correcta", Carpa.CAPACIDAD_SUR, carpa.darCapacidadSegunZona( Carpa.ZONA_SUR ) );
        assertEquals( "No retorna la capacidad correcta", Carpa.CAPACIDAD_NORTE, carpa.darCapacidadSegunZona( Carpa.ZONA_NORTE ) );
    }
}