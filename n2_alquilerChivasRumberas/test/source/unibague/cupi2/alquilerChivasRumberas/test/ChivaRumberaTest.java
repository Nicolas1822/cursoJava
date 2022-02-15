/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ChivaRumberaTest.java 2012-10-15 18:00:00Z andres.arciniegas $
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

/**
 * Prueba que se encarga de verificar los métodos de la clase ChivaRumbera
 */
public class ChivaRumberaTest extends TestCase 
{
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private ChivaRumbera chivaRumbera;

    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un nueva Chiva Rumbera
     * 
     */
    private void setupEscenario1( )
    {
        chivaRumbera = new ChivaRumbera( "La Rumbera", Empresa.PEQUENIA, 100000.0 );
        
    }
	
    /**
     * Prueba 1, Se encarga de verificar que la chiva rumbera se alquila correctamente
     */
    public void testAlquilarChivaRumbera( )
    {
    	setupEscenario1();
    	
    	// Verifica valor del alquiler
    	assertEquals( "No se alquila correctamente una chiva rumbera", 200000.0, chivaRumbera.alquilarChivaRumbera( 2 ), 0.001);

    	// Verifica total recaudado
    	assertEquals( "No se alquila correctamente una chiva rumbera", 200000.0, chivaRumbera.darDineroRecaudado(), 0.001 );
    	
    	// Verifica número de veces que fue alquilado
    	assertEquals( "No se alquila correctamente una chiva rumbera", 1, chivaRumbera.darVecesAlquilado() );
    	
    	// Verifica disponibilidad 
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera.darDisponibilidad() );
    	
    }
    

    /**
     * Prueba 2, Se encarga de verificar que la chiva rumbera se devuelve correctamente
     */
    public void testDevolverChivaRumbera( )
    {
    	setupEscenario1();
    	
    	// Alquila la chiva
    	chivaRumbera.devolverChivaRumbera();

    	// Verifica disponibilidad 
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera.darDisponibilidad() );
    	
    }
    
    /**
     * Prueba 3, Se encarga de verificar que el descuento se devuelve correctamente
     */
    public void testDarDescuento( )
    {

    	setupEscenario1();
    	
    	// Verifica el descuento obtenido
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.0,  chivaRumbera.darDescuento(1 ), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.0,  chivaRumbera.darDescuento(2 ), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.05, chivaRumbera.darDescuento(4 ), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.05, chivaRumbera.darDescuento(6 ), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.08, chivaRumbera.darDescuento(10), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.08, chivaRumbera.darDescuento(12), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.10, chivaRumbera.darDescuento(20), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.10, chivaRumbera.darDescuento(24), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.15, chivaRumbera.darDescuento(25), 0.001 );
    	assertEquals( "No se calcula correctamente el descuento por alquiler de una chiva rumbera", 0.15, chivaRumbera.darDescuento(30), 0.001 );
    	
    }
    
    /**
     * Prueba 4, Se encarga de verificar que se reinicia correctamente
     */
    public void testReiniciar( )
    {

    	setupEscenario1();
    	
    	// Verifica que se reinicia correctamente después de alquilar y devolver
    	chivaRumbera.alquilarChivaRumbera( 4 );
    	chivaRumbera.devolverChivaRumbera();
    	chivaRumbera.reiniciar();
    	
    	// Verifica total recaudado
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0.0, chivaRumbera.darDineroRecaudado(), 0.001 );
    	
    	// Verifica número de veces que fue alquilado
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0, chivaRumbera.darVecesAlquilado() );
    	
    	// Verifica disponibilidad 
    	assertEquals( "No se reinicia correctamente una chiva rumbera", true, chivaRumbera.darDisponibilidad() );

    }

    
   /**
     * Prueba 5, Se encarga de verificar que se crean correctamente las chivas
     */
    public void testChivasRumberas( )
    {
    	ChivaRumbera chivaRumbera01 = new ChivaRumbera("La Chiva 01", Empresa.PEQUENIA, 100000.0 );
    	ChivaRumbera chivaRumbera02 = new ChivaRumbera("La Chiva 02", Empresa.MEDIANA,  200000.0 );
    	ChivaRumbera chivaRumbera03 = new ChivaRumbera("La Chiva 03", Empresa.GRANDE,   300000.0 );
    	
    	// Verifica Nombre
    	assertEquals( "No se crea correctamente una chiva rumbera", "La Chiva 01", chivaRumbera01.darNombre() );
    	assertEquals( "No se crea correctamente una chiva rumbera", "La Chiva 02", chivaRumbera02.darNombre() );
    	assertEquals( "No se crea correctamente una chiva rumbera", "La Chiva 03", chivaRumbera03.darNombre() );

    	// Verifica Tamanio
    	assertEquals( "No se crea correctamente una chiva rumbera", Empresa.PEQUENIA, chivaRumbera01.darTamanio() );
    	assertEquals( "No se crea correctamente una chiva rumbera", Empresa.MEDIANA,  chivaRumbera02.darTamanio() );
    	assertEquals( "No se crea correctamente una chiva rumbera", Empresa.GRANDE,   chivaRumbera03.darTamanio() );
    	
    	// Verificar Precio
    	assertEquals( "No se crea correctamente una chiva rumbera", 100000.0, chivaRumbera01.darPrecioHora(), 0.001 );
    	assertEquals( "No se crea correctamente una chiva rumbera", 200000.0, chivaRumbera02.darPrecioHora(), 0.001 );
    	assertEquals( "No se crea correctamente una chiva rumbera", 300000.0, chivaRumbera03.darPrecioHora(), 0.001 );
    	
    	// Verifica Disponibilidad
    	assertEquals( "No se crea correctamente una chiva rumbera", true, chivaRumbera01.darDisponibilidad() );
    	assertEquals( "No se crea correctamente una chiva rumbera", true, chivaRumbera02.darDisponibilidad() );
    	assertEquals( "No se crea correctamente una chiva rumbera", true, chivaRumbera03.darDisponibilidad() );
    	
    	// Verifica Número de veces alquilado
    	assertEquals( "No se crea correctamente una chiva rumbera", 0, chivaRumbera01.darVecesAlquilado() );
    	assertEquals( "No se crea correctamente una chiva rumbera", 0, chivaRumbera02.darVecesAlquilado() );
    	assertEquals( "No se crea correctamente una chiva rumbera", 0, chivaRumbera03.darVecesAlquilado() );
    	
    	// Verifica Dinero recaudado
    	assertEquals( "No se crea correctamente una chiva rumbera", 0.0, chivaRumbera01.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se crea correctamente una chiva rumbera", 0.0, chivaRumbera02.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se crea correctamente una chiva rumbera", 0.0, chivaRumbera03.darDineroRecaudado(), 0.001 );
    	
    	// Verificar que las operaciones de Alquiler y Devolución funcionan
    	double alquiler = chivaRumbera01.alquilarChivaRumbera( 1 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 100000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 100000.0, chivaRumbera01.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 1, chivaRumbera01.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera01.darDisponibilidad() );
    	
    	chivaRumbera01.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera01.darDisponibilidad() );
    	
    	alquiler = chivaRumbera01.alquilarChivaRumbera( 10 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 920000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 1020000.0, chivaRumbera01.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 2, chivaRumbera01.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera01.darDisponibilidad() );

    	chivaRumbera01.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera01.darDisponibilidad() );
    	
    	alquiler = chivaRumbera01.alquilarChivaRumbera( 4 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 380000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 1400000.0, chivaRumbera01.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 3, chivaRumbera01.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera01.darDisponibilidad() );

    	chivaRumbera01.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera01.darDisponibilidad() );


    	alquiler = chivaRumbera03.alquilarChivaRumbera( 2 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 600000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 600000.0, chivaRumbera03.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 1, chivaRumbera03.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera03.darDisponibilidad() );
    	
    	chivaRumbera03.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera03.darDisponibilidad() );
    	
    	alquiler = chivaRumbera03.alquilarChivaRumbera( 30 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 7650000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 8250000.0, chivaRumbera03.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 2, chivaRumbera03.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera03.darDisponibilidad() );

    	chivaRumbera03.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera03.darDisponibilidad() );
    	
    	alquiler = chivaRumbera03.alquilarChivaRumbera( 20 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 5400000.0, alquiler, 0.001);
    	assertEquals( "No se alquila correctamente una chiva rumbera", 13650000.0, chivaRumbera03.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se alquila correctamente una chiva rumbera", 3, chivaRumbera03.darVecesAlquilado() );
    	assertEquals( "No se alquila correctamente una chiva rumbera", false, chivaRumbera03.darDisponibilidad() );

    	chivaRumbera03.devolverChivaRumbera();
    	assertEquals( "No se devuelve correctamente una chiva rumbera", true, chivaRumbera03.darDisponibilidad() );
    	
    	// Verificar las operaciones de reinicio
    	chivaRumbera01.reiniciar();
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0.0, chivaRumbera01.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0, chivaRumbera01.darVecesAlquilado() );
    	assertEquals( "No se reinicia correctamente una chiva rumbera", true, chivaRumbera01.darDisponibilidad() );
    	
    	chivaRumbera03.reiniciar();
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0.0, chivaRumbera03.darDineroRecaudado(), 0.001 );
    	assertEquals( "No se reinicia correctamente una chiva rumbera", 0, chivaRumbera03.darVecesAlquilado() );
    	assertEquals( "No se reinicia correctamente una chiva rumbera", true, chivaRumbera03.darDisponibilidad() );
    }
    
    
}
