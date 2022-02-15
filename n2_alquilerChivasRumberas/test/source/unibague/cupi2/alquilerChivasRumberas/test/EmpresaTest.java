/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: EmpresaTest.java 2012-10-22 18:00:00Z andres.arciniegas $
 * Universidad de Ibagué (Ibagué - Colombia)
 * Programa de Ingeniería de Sistemas  
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_alquilerChivasRumberas
 * Autor: Andrés Mauricio Arciniegas - Agosto de 2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */ 
package unibague.cupi2.alquilerChivasRumberas.test;

import junit.framework.TestCase;
import unibague.cupi2.alquilerChivasRumberas.mundo.ChivaRumbera;
import unibague.cupi2.alquilerChivasRumberas.mundo.Empresa;

public class EmpresaTest extends TestCase 
{
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Empresa empresa;

    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nueva Empresa
     * 
     */
    private void setupEscenario1( )
    {
        empresa = new Empresa();
    }
	
    /**
     * Construye un nueva Empresa y realiza operaciones de alquiler y devolucion de chivas rumberas
     * 
     */
    private void setupEscenario2( )
    {
        empresa = new Empresa();
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1, 2 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1 );        

        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2, 4 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2 );        

        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_3, 8 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_3 );        

        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4, 16 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4 );        
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1, 5 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1 );        
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2, 6 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2 );        
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1, 8 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1 );        

        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4, 3 );
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4 );        
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1, 14 );		// No se devuelve intencionalmente 
        
        empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2, 1 );		// No se devuelve intencionalmente
        
    }

    
    /**
     * Prueba 1, Se encarga de verificar que el constructor de la clase funciona correctamente
     */
    public void testEmpresa( )
    {
    	setupEscenario1();
    	
        // Verifica que al momento de inicializar la empresa no falten ninguna chiva rumbera
        ChivaRumbera chivaRumbera = empresa.darChivaRumbera1( );
        assertNotNull( chivaRumbera );
        assertEquals( "No se creo correctamente la Chiva Rumbera 1", Empresa.NOMBRE_CHIVA_RUMBERA_1, chivaRumbera.darNombre( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 1", Empresa.PEQUENIA, chivaRumbera.darTamanio( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 1", 100000.0, chivaRumbera.darPrecioHora( ), 0.001 );

        
        // Verifica que al momento de inicializar la empresa no falten ninguna chiva rumbera
        chivaRumbera = empresa.darChivaRumbera2( );
        assertNotNull( chivaRumbera );
        assertEquals( "No se creo correctamente la Chiva Rumbera 2", Empresa.NOMBRE_CHIVA_RUMBERA_2, chivaRumbera.darNombre( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 2", Empresa.MEDIANA, chivaRumbera.darTamanio( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 2", 150000.0, chivaRumbera.darPrecioHora( ), 0.001 );

        // Verifica que al momento de inicializar la empresa no falten ninguna chiva rumbera
        chivaRumbera = empresa.darChivaRumbera3( );
        assertNotNull( chivaRumbera );
        assertEquals( "No se creo correctamente la Chiva Rumbera 3", Empresa.NOMBRE_CHIVA_RUMBERA_3, chivaRumbera.darNombre( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 3", Empresa.GRANDE, chivaRumbera.darTamanio( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 3", 230000.0, chivaRumbera.darPrecioHora( ), 0.001 );

        // Verifica que al momento de inicializar la empresa no falten ninguna chiva rumbera
        chivaRumbera = empresa.darChivaRumbera4( );
        assertNotNull( chivaRumbera );
        assertEquals( "No se creo correctamente la Chiva Rumbera 4", Empresa.NOMBRE_CHIVA_RUMBERA_4, chivaRumbera.darNombre( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 4", Empresa.PEQUENIA, chivaRumbera.darTamanio( ) );
        assertEquals( "No se creo correctamente la Chiva Rumbera 4", 100000.0, chivaRumbera.darPrecioHora( ), 0.001 );
        
    }
    
    
    /**
     * Prueba 2, Se encarga de verificar si se pueden alquilar y devolver Chivas Rumberas 
     */
    public void testAlquilarChivasRumberas( )
    {
    	setupEscenario1( );

        // Verificar la Chiva Rumbera 1
        ChivaRumbera chivaRumbera = empresa.darChivaRumbera1( );
        assertNotNull( chivaRumbera );
        
        double valorAlquiler = empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1, 2 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 1", 200000.0, valorAlquiler, 0.001 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 1", 1,        chivaRumbera.darVecesAlquilado( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 1", false,    chivaRumbera.darDisponibilidad( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 1", 200000.0, chivaRumbera.darDineroRecaudado( ) );
        
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 1", true,    chivaRumbera.darDisponibilidad( ) );
        
        
        // Verificar la Chiva Rumbera 2
        chivaRumbera = empresa.darChivaRumbera2( );
        assertNotNull( chivaRumbera );
        
        valorAlquiler = empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2, 4 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 2", 570000.0, valorAlquiler, 0.001 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 2", 1,        chivaRumbera.darVecesAlquilado( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 2", false,    chivaRumbera.darDisponibilidad( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 2", 570000.0, chivaRumbera.darDineroRecaudado( ) );

        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 2", true,    chivaRumbera.darDisponibilidad( ) );

        
        // Verificar la Chiva Rumbera 3
        chivaRumbera = empresa.darChivaRumbera3( );
        assertNotNull( chivaRumbera );
        
        valorAlquiler = empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_3, 8 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 3", 1692800.0, valorAlquiler, 0.001 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 3", 1,         chivaRumbera.darVecesAlquilado( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 3", false,     chivaRumbera.darDisponibilidad( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 3", 1692800.0, chivaRumbera.darDineroRecaudado( ) );
        
        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_3 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 3", true,     chivaRumbera.darDisponibilidad( ) );
        

        // Verificar la Chiva Rumbera 4
        chivaRumbera = empresa.darChivaRumbera4( );
        assertNotNull( chivaRumbera );
        
        valorAlquiler = empresa.alquilarChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4, 16 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 4", 1440000.0, valorAlquiler, 0.001 );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 4", 1,         chivaRumbera.darVecesAlquilado( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 4", false,     chivaRumbera.darDisponibilidad( ) );
        assertEquals( "No se alquila correctamente la Chiva Rumbera 4", 1440000.0, chivaRumbera.darDineroRecaudado( ) );

        empresa.devolverChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 4", true,     chivaRumbera.darDisponibilidad( ) );

    }
    
    
    /**
     * Prueba 3, verifica que el método darChivaRumbera funcione correctamente
     */
    public void testDarChivaRumbera( )
    {
        setupEscenario1( );

        // Verificar la Chiva Rumbera 1
        ChivaRumbera chivaRumbera = empresa.darChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_1 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 1", Empresa.NOMBRE_CHIVA_RUMBERA_1 , chivaRumbera.darNombre( ) );

        // Verificar la Chiva Rumbera 2
        chivaRumbera = empresa.darChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_2 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 2", Empresa.NOMBRE_CHIVA_RUMBERA_2 , chivaRumbera.darNombre( ) );

        // Verificar la Chiva Rumbera 3
        chivaRumbera = empresa.darChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_3 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 3", Empresa.NOMBRE_CHIVA_RUMBERA_3 , chivaRumbera.darNombre( ) );

        // Verificar la Chiva Rumbera 4
        chivaRumbera = empresa.darChivaRumbera( Empresa.NOMBRE_CHIVA_RUMBERA_4 );
        assertEquals( "No se devuelve correctamente la Chiva Rumbera 4", Empresa.NOMBRE_CHIVA_RUMBERA_4 , chivaRumbera.darNombre( ) );
        
    }
    
    
    /**
     * Prueba 4, verifica que el método darChivaRumberaMasAlquilada funcione correctamente
     */
    public void testDarChivaRumberaMasAlquilada( )
    {
    	setupEscenario2();
    	ChivaRumbera chivaRumbera = empresa.darChivaRumberaMasAlquilada();
    	assertEquals( "No se devuelve correctamente la Chiva Rumbera más alquilada", Empresa.NOMBRE_CHIVA_RUMBERA_1 , chivaRumbera.darNombre( ) );
    }

    
    /**
     * Prueba 5, verifica que el método darChivaRumberaMenosAlquilada funcione correctamente
     */
    public void testDarChivaRumberaMenosAlquilada( )
    {
    	setupEscenario2();
    	ChivaRumbera chivaRumbera = empresa.darChivaRumberaMenosAlquilada();
    	assertEquals( "No se devuelve correctamente la Chiva Rumbera menos alquilada", Empresa.NOMBRE_CHIVA_RUMBERA_3 , chivaRumbera.darNombre( ) );
    	
    }
    
    
    /**
     * Prueba 6, verifica que el método darTotalRecaudado funcione correctamente
     */
    public void testDarTotalRecaudado( )
    {
    	setupEscenario2();
    	assertEquals( "No se devuelve correctamente el total recaudado", 7663800.0 , empresa.darTotalRecaudado( ), 0.001 );
    }
    
    
    /**
     * Prueba 7, verifica que el método verificarDisponibilidad funcione correctamente
     */
    public void testVerificarDisponibilidad( )
    {
    	setupEscenario2();
    	
    	assertEquals( "No se verifica correctamente la disponibilidad de la Chiva Rumbera 1", false, empresa.verificarDisponibilidad( Empresa.NOMBRE_CHIVA_RUMBERA_1 ) );
    	assertEquals( "No se verifica correctamente la disponibilidad de la Chiva Rumbera 2", false, empresa.verificarDisponibilidad( Empresa.NOMBRE_CHIVA_RUMBERA_2 ) );
    	assertEquals( "No se verifica correctamente la disponibilidad de la Chiva Rumbera 3", true,  empresa.verificarDisponibilidad( Empresa.NOMBRE_CHIVA_RUMBERA_3 ) );
    	assertEquals( "No se verifica correctamente la disponibilidad de la Chiva Rumbera 4", true,  empresa.verificarDisponibilidad( Empresa.NOMBRE_CHIVA_RUMBERA_4 ) );
    }
    
    /**
     * Prueba 8, verifica que el método reiniciar funcione correctamente
     */
    public void testReiniciar( )
    {
    	setupEscenario2();

    	empresa.reiniciar();

    	assertTrue( "No reinició correctamente la Chiva Rumbera 1", empresa.darChivaRumbera1().darDisponibilidad() == true );
        assertTrue( "No reinició correctamente la Chiva Rumbera 1", empresa.darChivaRumbera1().darVecesAlquilado() == 0 );
        assertTrue( "No reinició correctamente la Chiva Rumbera 1", empresa.darChivaRumbera1().darDineroRecaudado() == 0.0 );

    	assertTrue( "No reinició correctamente la Chiva Rumbera 2", empresa.darChivaRumbera2().darDisponibilidad() == true );
        assertTrue( "No reinició correctamente la Chiva Rumbera 2", empresa.darChivaRumbera2().darVecesAlquilado() == 0 );
        assertTrue( "No reinició correctamente la Chiva Rumbera 2", empresa.darChivaRumbera2().darDineroRecaudado() == 0.0 );
        
    	assertTrue( "No reinició correctamente la Chiva Rumbera 3", empresa.darChivaRumbera3().darDisponibilidad() == true );
        assertTrue( "No reinició correctamente la Chiva Rumbera 3", empresa.darChivaRumbera3().darVecesAlquilado() == 0 );
        assertTrue( "No reinició correctamente la Chiva Rumbera 3", empresa.darChivaRumbera3().darDineroRecaudado() == 0.0 );

    	assertTrue( "No reinició correctamente la Chiva Rumbera 4", empresa.darChivaRumbera4().darDisponibilidad() == true );
        assertTrue( "No reinició correctamente la Chiva Rumbera 4", empresa.darChivaRumbera4().darVecesAlquilado() == 0 );
        assertTrue( "No reinició correctamente la Chiva Rumbera 4", empresa.darChivaRumbera4().darDineroRecaudado() == 0.0 );
        
    }
    
}
