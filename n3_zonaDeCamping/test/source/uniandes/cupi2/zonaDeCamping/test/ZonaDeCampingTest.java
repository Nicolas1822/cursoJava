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

import java.text.DecimalFormat;
import junit.framework.*;
import uniandes.cupi2.zonaDeCamping.mundo.*;

/**
 * Esta es la clase usada para verificar la correcta implementaci�n de Jaula ZonaDeCamping
 */
public class ZonaDeCampingTest extends TestCase
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Es la zonaDeCamping donde se har�n las pruebas
     */
    private ZonaDeCamping zonaDeCamping;

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Construye una nueva zona de camping vac�a
     */
    public void setupEscenario1( )
    {
        zonaDeCamping = new ZonaDeCamping( );
    }

    /**
     * Construye una nueva zona de camping con 10 campistas
     */
    public void setupEscenario2( )
    {
        zonaDeCamping = new ZonaDeCamping( );
        for( int i = 0; i < 10; i++ )
        {
            zonaDeCamping.agregarCampista( "nombre" + i, "apellido" + i, "cedula" + i, i, "foto" + i, false );
        }
    }

    /**
     * Prueba 1- Prueba el m�todo puedeAgregarGrupo <br>
     * M�todos a probar: <br>
     * puedeAgregarGrupo <br>
     * Caso de prueba: <br>
     * La carpa es compartida
     */
    public void testPuedeAgregarGrupo1( )
    {
        setupEscenario1( );
        assertEquals( "Deber�a poder agregar el grupo a la carpa 0", 0, zonaDeCamping.puedeAgregarGrupo( 3, true ) );
        for( int i = 0; i < 3; i++ )
        {
            zonaDeCamping.agregarCampista( 0, "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, true );
        }
        assertEquals( "Deber�a poder agregar el grupo a la carpa 0", 0, zonaDeCamping.puedeAgregarGrupo( 6, true ) );
        for( int i = 3; i < 9; i++ )
        {
            zonaDeCamping.agregarCampista( 0, "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, true );
        }
        assertEquals( "Deber�a poder agregar el grupo a la carpa 1", 1, zonaDeCamping.puedeAgregarGrupo( 6, true ) );
    }

    /**
     * Prueba 2- Prueba el m�todo puedeAgregarGrupo <br>
     * M�todos a probar: <br>
     * puedeAgregarGrupo <br>
     * Caso de prueba: <br>
     * La carpa no es compartida
     */
    public void testPuedeAgregarGrupo2( )
    {
        setupEscenario1( );
        assertEquals( "Deber�a poder agregar el grupo a la carpa 0", 0, zonaDeCamping.puedeAgregarGrupo( 3, false ) );
        for( int i = 0; i < 3; i++ )
        {
            zonaDeCamping.agregarCampista( 0, "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false );
        }
        assertEquals( "Deber�a poder agregar el grupo a la carpa 1", 1, zonaDeCamping.puedeAgregarGrupo( 6, false ) );
        for( int i = 3; i < 9; i++ )
        {
            zonaDeCamping.agregarCampista( 1, "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false );
        }
        assertEquals( "Deber�a poder agregar el grupo a la carpa 2", 2, zonaDeCamping.puedeAgregarGrupo( 6, false ) );
    }

    /**
     * Prueba 3 - Prueba el m�todo agregarCampista <br>
     * M�todos a probar: <br>
     * agregarCampista <br>
     * Caso de prueba: <br>
     * No se conoce el n�mero de la carpa. El campista fue agregado
     */
    public void testAgregarCampista1( )
    {
        setupEscenario1( );
        for( int i = 0; i < Carpa.CAPACIDAD_NORTE; i++ )
        {
            assertEquals( "No agrega al campista en la carpa correcta", 0, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, true ) );
            assertEquals( "No agreg� al campista correctamente", i + 1, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        }
        int a = 11;
        for( int i = 1; i < 4; i++ )
        {
            assertEquals( "No agrega al campista en la carpa correcta", i, zonaDeCamping.agregarCampista( "Nombre" + a, "Apellido" + a, "cedula" + a, a, "Foto" + a, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
            a++;
        }
        a = 15;
        for( int i = 1; i < 8; i++ )
        {
            assertEquals( "No agrega al campista en la carpa correcta", 4, zonaDeCamping.agregarCampista( "Nombre" + a, "Apellido" + a, "cedula" + a, a, "Foto" + a, true ) );
            assertEquals( "No agreg� al campista correctamente", i, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
            a++;
        }
    }

    /**
     * Prueba 4 - Prueba el m�todo agregarCampista <br>
     * M�todos a probar: <br>
     * agregarCampista, darCantidadCampistasPorZona <br>
     * Caso de prueba: <br>
     * No se conoce el n�mero de la carpa. El campista no fue agregado
     */
    public void testAgregarCampista2( )
    {
        setupEscenario1( );
        int a = 0;
        for( int i = 0; i < 4; i++ )
        {
            a = i + 1;
            assertEquals( "No agrega al campista en la carpa correcta", i, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        }
        for( int i = 0; i < 4; i++ )
        {
            assertEquals( "El campista existe, no lo deber�a agregar", -2, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        }
        a = 0;
        for( int i = 4; i < 7; i++ )
        {
            a++;
            assertEquals( "No agrega al campista en la carpa correcta", i, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
        }
        a = 0;
        for( int i = 7; i < 12; i++ )
        {
            a++;
            assertEquals( "No agrega al campista en la carpa correcta", i, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_OESTE ) );
        }
        a = 0;
        for( int i = 12; i < 15; i++ )
        {
            a++;
            assertEquals( "No agrega al campista en la carpa correcta", i, zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "cedula" + i, i, "Foto" + i, false ) );
            assertEquals( "No agreg� al campista correctamente", a, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_ESTE ) );
        }
    }

    /**
     * Prueba 5 - Prueba el m�todo agregarCampista <br>
     * M�todos a probar: <br>
     * agregarCampista <br>
     * Caso de prueba: <br>
     * Se conoce el n�mero de la carpa. El campista fue agregado
     */
    public void testAgregarCampista3( )
    {
        setupEscenario1( );

        assertTrue( "No agreg� el campista", zonaDeCamping.agregarCampista( 3, "Raul", "Zapata", "12345", 27, "fotoRaul", true ) );
        assertEquals( "No agreg� al campista en la carpa correcta", 3, zonaDeCamping.buscarCarpaCampista( "12345" ) );
        assertEquals( "No se agreg� el campista correctamente", 1, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );

        assertTrue( "No agreg� el campista", zonaDeCamping.agregarCampista( 5, "Mar�a", "Zapata", "123456", 25, "fotoMaria", true ) );
        assertEquals( "No agreg� al campista en la carpa correcta", 5, zonaDeCamping.buscarCarpaCampista( "123456" ) );
        assertEquals( "No se agreg� el campista correctamente", 1, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
    }

    /**
     * Prueba 6 - Prueba el m�todo agregarCampista <br>
     * M�todos a probar: <br>
     * agregarCampista <br>
     * Caso de prueba: <br>
     * Se conoce el n�mero de la carpa. El campista no fue agregado
     */
    public void testAgregarCampista4( )
    {
        setupEscenario1( );

        assertTrue( "No agreg� el campista", zonaDeCamping.agregarCampista( 3, "Raul", "Zapata", "12345", 27, "fotoRaul", true ) );
        assertEquals( "No agreg� al campista en la carpa correcta", 3, zonaDeCamping.buscarCarpaCampista( "12345" ) );
        assertEquals( "No se agreg� el campista correctamente", 1, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );

        assertFalse( "El campista existe, no lo deber�a agregar", zonaDeCamping.agregarCampista( 5, "Raul", "Zapata", "12345", 27, "fotoRaul", true ) );

        assertTrue( "No agreg� el campista", zonaDeCamping.agregarCampista( 3, "Mar�a", "Jimenez", "123456", 25, "fotoMaria", true ) );
        assertEquals( "No agreg� al campista en la carpa correcta", 3, zonaDeCamping.buscarCarpaCampista( "123456" ) );
        assertEquals( "No se agreg� el campista correctamente", 2, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );

    }

    /**
     * Prueba 7 - Prueba el m�todo eliminarCampista <br>
     * M�todos a probar: <br>
     * eliminarCampista, buscarCampista <br>
     */
    public void testEliminarCampista( )
    {
        setupEscenario2( );

        assertTrue( "Deber�a haber eliminado al campista", zonaDeCamping.eliminarCampista( "cedula" + 1 ) );
        assertNull( "No elimin� al campista", zonaDeCamping.buscarCampista( "cedula" + 1 ) );

        assertTrue( "Deber�a haber eliminado al campista", zonaDeCamping.eliminarCampista( "cedula" + 5 ) );
        assertNull( "No elimin� al campista", zonaDeCamping.buscarCampista( "cedula" + 5 ) );

        assertFalse( "No deber�a haber eliminado al campista", zonaDeCamping.eliminarCampista( "cedula" + 5 ) );

        assertFalse( "No deber�a haber eliminado al campista", zonaDeCamping.eliminarCampista( "cedula" + 300 ) );

    }

    /**
     * Prueba 8 - Prueba el m�todo buscarCarpa <br>
     * M�todos a probar: <br>
     * buscarCarpa
     */
    public void testBuscarCarpa( )
    {
        setupEscenario1( );
        assertEquals( "No encontr� la carpa buscada", 2, zonaDeCamping.buscarCarpa( 3 ) );
        assertEquals( "No encontr� la carpa buscada", 10, zonaDeCamping.buscarCarpa( 11 ) );
        assertEquals( "No encontr� la carpa buscada", 14, zonaDeCamping.buscarCarpa( 15 ) );
        assertEquals( "No deber�a encontra la carpa ", -1, zonaDeCamping.buscarCarpa( 16 ) );
    }

    /**
     * Prueba 9 - Prueba el m�todo buscarCarpaCampista <br>
     * M�todos a probar: <br>
     * buscarCarpaCampista
     */
    public void testBuscarCarpaCampista( )
    {
        setupEscenario2( );
        assertEquals( "No encontr� la carpa correcta", 1, zonaDeCamping.buscarCarpaCampista( "cedula" + 1 ) );
        assertEquals( "No encontr� la carpa correcta", 4, zonaDeCamping.buscarCarpaCampista( "cedula" + 4 ) );
        assertEquals( "El campista no existe. No debe encontrarlo", -1, zonaDeCamping.buscarCarpaCampista( "cedula" + 151 ) );
    }

    /**
     * Prueba 10 - Prueba el m�todo buscarCampista <br>
     * M�todos a probar: <br>
     * buscarCampista
     */
    public void testBuscarCampista( )
    {
        setupEscenario2( );

        Campista campista = zonaDeCamping.buscarCampista( "cedula" + 3 );
        assertNotNull( "Deber�a haber encontrado el campista", campista );
        assertEquals( "No encontr� al campista correcto", "nombre" + 3, campista.darNombre( ) );
        assertEquals( "No encontr� al campista correcto", "cedula" + 3, campista.darCedula( ) );

        campista = zonaDeCamping.buscarCampista( "cedula" + 9 );
        assertNotNull( "Deber�a haber encontrado el campista", campista );
        assertEquals( "No encontr� al campista correcto", "nombre" + 9, campista.darNombre( ) );
        assertEquals( "No encontr� al campista correcto", "cedula" + 9, campista.darCedula( ) );

        campista = zonaDeCamping.buscarCampista( "cedula" + 11 );
        assertNull( "No deber�a haber encontrado el campista", campista );
    }

    /**
     * Prueba 11 - Prueba el m�todo existeCampista<br>
     * M�todos a probar: <br>
     * existeCampista
     */
    public void testExisteCampista( )
    {
        setupEscenario2( );
        assertFalse( "El campista no existe", zonaDeCamping.existeCampista( "cedula" + 43 ) );
        assertFalse( "El campista no existe", zonaDeCamping.existeCampista( "12342" ) );
        assertTrue( "El campista existe", zonaDeCamping.existeCampista( "cedula" + 0 ) );
        assertTrue( "El campista existe", zonaDeCamping.existeCampista( "cedula" + 4 ) );
        assertTrue( "El campista existe", zonaDeCamping.existeCampista( "cedula" + 9 ) );
    }

     /**
     * Prueba 12 - Prueba el m�todo hayDosCarpasMismaCantidadAdultos <br>
     * M�todos a probar: <br>
     * hayDosCarpasMismaCantidadAdultos
     */
    public void testHayDosCarpasMismaCantidadAdultos( )
    {
        setupEscenario1( );

        int[] capacidades = new int[4];
        capacidades[ 0 ] = Carpa.CAPACIDAD_NORTE;
        capacidades[ 1 ] = Carpa.CAPACIDAD_SUR;
        capacidades[ 2 ] = Carpa.CAPACIDAD_ESTE;
        capacidades[ 3 ] = Carpa.CAPACIDAD_OESTE;

        // Caso 1. En caso de estar todas vacias
        assertFalse( "No deber�a haber la misma cantidad de adultos en 2 carpas", zonaDeCamping.hayDosCarpasMismaCantidadAdultos( ) );

        // Caso 2. Se va llenando uno a uno. Se va reduciendo en uno la cantidad de campistas que se agregan en cada una de las zonas
        int a = 0;
        for( int i = 0; i < ZonaDeCamping.CANT_CARPAS; i++ )
        {
            Carpa carpa = zonaDeCamping.darCarpa( i );
            int capacidad = zonaDeCamping.darCarpa( i ).darCapacidad( );

            if( carpa.darZona( ).equals( Carpa.ZONA_NORTE ) )
            {
                capacidad = capacidades[ 0 ];
                capacidades[ 0 ]--;
            }
            if( carpa.darZona( ).equals( Carpa.ZONA_SUR ) )
            {
                capacidad = capacidades[ 1 ];
                capacidades[ 1 ]--;
            }
            if( carpa.darZona( ).equals( Carpa.ZONA_ESTE ) )
            {
                capacidad = capacidades[ 2 ];
                capacidades[ 2 ]--;
            }
            if( carpa.darZona( ).equals( Carpa.ZONA_OESTE ) )
            {
                capacidad = capacidades[ 3 ];
                capacidades[ 3 ]--;
            }

            for( int j = 1; j <= capacidad; j++ )
            {
                zonaDeCamping.agregarCampista( i, "Nombre" + a, "Apellido" + a, "Cedula" + a, 16 + j, "Foto" + a, true );
                a++;
            }

            //Revisa si realmente hay algui�n con la misma cantidad de adultos
            boolean hayRepetido = false;
            for( int k = 0; k < ZonaDeCamping.CANT_CARPAS && !hayRepetido; k++ )
            {
                Carpa nCarpa = zonaDeCamping.darCarpa( k );
                for( int l = k + 1; l < ZonaDeCamping.CANT_CARPAS && !hayRepetido; l++ )
                {
                    Carpa mCarpa = zonaDeCamping.darCarpa( l );
                    if( nCarpa.darCantidadDeAdultos( ) > 0 && nCarpa.darCantidadCampistas( ) == mCarpa.darCantidadCampistas( ) )
                    {
                        hayRepetido = true;
                    }
                }
            }

            //Hace la validaci�n al terminar de llenar cada una de las carpas
            if( hayRepetido )
            {
                assertTrue( "Deber�a haber la misma cantidad de adultos en 2 carpas", zonaDeCamping.hayDosCarpasMismaCantidadAdultos( ) );
            } else {
                assertFalse( "NO deber�a haber la misma cantidad de adultos en 2 carpas", zonaDeCamping.hayDosCarpasMismaCantidadAdultos( ) );
            }
        }
    }

    /**
     * Prueba 13 - Prueba el m�todo calcularPorcentajeOcupacionCarpas <br>
     * M�todos a probar: <br>
     * calcularPorcentajeOcupacionCarpas, agregarCampista
     */
    public void testCalcularPorcentajeOcupacionCarpas( )
    {
        setupEscenario1( );
        assertEquals( "", ( double )0, zonaDeCamping.calcularPorcentajeOcupacionCarpas( ) );
        for( int i = 0; i < 10; i++ )
        {
            zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "Cedula" + i, i, "Foto" + i, true );
        }
        double ocupacion = zonaDeCamping.calcularPorcentajeOcupacionCarpas( );
        DecimalFormat df = new DecimalFormat( "#.#" );
        String strOcupacion = df.format( ocupacion );
        assertEquals( "No calcula el porcentaje correcto", "10,5", strOcupacion );

        for( int i = 11; i < 21; i++ )
        {
            zonaDeCamping.agregarCampista( "Nombre" + i, "Apellido" + i, "Cedula" + i, i, "Foto" + i, true );
        }
        ocupacion = zonaDeCamping.calcularPorcentajeOcupacionCarpas( );
        strOcupacion = df.format( ocupacion );
        assertEquals( "No calcula el porcentaje correcto", "21,1", strOcupacion );
    }

    /**
     * 
     * Prueba 14 - Prueba el m�todo darCantidadCampistasPorZona <br>
     * M�todos a probar: <br>
     * darCantidadCampistasPorZona
     */
    public void testDarCantidadCampistasPorZona( )
    {
        setupEscenario1( );
        assertEquals( "No deber�a haber campistas en la zona", 0, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        assertEquals( "No deber�a haber campistas en la zona", 0, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
        assertEquals( "No deber�a haber campistas en la zona", 0, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_ESTE ) );
        assertEquals( "No deber�a haber campistas en la zona", 0, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_OESTE ) );
        for(int i = 0; i < 4; i++)
        {
            zonaDeCamping.agregarCampista( "Nombre"+i, "Apellido"+i, "Cedula"+i, i, "Foto"+i, false );
        }
        int cantidad = 4;
        assertEquals( "No retorn� la cantidad correcta",  4, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        for( int i = cantidad; i < cantidad+3; i++ )
        {
            zonaDeCamping.agregarCampista( "Nombre"+i, "Apellido"+i, "Cedula"+i, i, "Foto"+i, false );
        }
        cantidad += 3;
        assertEquals( "No retorn� la cantidad correcta", 3, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
        for(int i = cantidad; i < cantidad + 15; i++)
        {
            zonaDeCamping.agregarCampista( "Nombre"+i, "Apellido"+i, "Cedula"+i, i, "Foto"+i, true );
        }
        cantidad = cantidad + 15;
        assertEquals( "No retorn� la cantidad correcta", 15, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_OESTE ) );
        for(int i = cantidad; i < cantidad +2; i++)
        {
            zonaDeCamping.agregarCampista( 14, "Nombre"+i, "Apellido"+i, "Cedula"+i, i, "Foto"+i, true );
        }
        assertEquals( "No retorn� la cantidad correcta", 2, zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_ESTE ) );
    }

    /**
     * Prueba 15 - Prueba el m�todo darCarpa <br>
     * M�todos a probar: <br>
     * darCarpa
     */
    public void testDarCarpa( )
    {
        setupEscenario1( );

        assertEquals( "No retorn� la carpa esperada", 4, zonaDeCamping.darCarpa( 3 ).darNumero( ) );
        assertEquals( "No retorn� la carpa esperada", Carpa.ZONA_NORTE, zonaDeCamping.darCarpa( 2 ).darZona( ) );
        assertEquals( "No retorn� la carpa esperada", 9, zonaDeCamping.darCarpa( 8 ).darNumero( ) );
        assertEquals( "No retorn� la carpa esperada", Carpa.ZONA_SUR, zonaDeCamping.darCarpa( 6 ).darZona( ) );
        assertEquals( "No retorn� la carpa esperada", 12, zonaDeCamping.darCarpa( 11 ).darNumero( ) );
        assertEquals( "No retorn� la carpa esperada", Carpa.ZONA_OESTE, zonaDeCamping.darCarpa( 7 ).darZona( ) );
        assertEquals( "No retorn� la carpa esperada", 14, zonaDeCamping.darCarpa( 13 ).darNumero( ) );
        assertEquals( "No retorn� la carpa esperada", Carpa.ZONA_ESTE, zonaDeCamping.darCarpa( 12 ).darZona( ) );
    }

}