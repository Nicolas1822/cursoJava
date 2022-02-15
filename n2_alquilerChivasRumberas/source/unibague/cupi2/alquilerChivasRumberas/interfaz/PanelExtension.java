/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java 2012-10-01 18:00:00Z andres.arciniegas $
 * Universidad de Ibagué (Ibagué - Colombia)
 * Programa de Ingeniería de Sistemas  
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_alquilerChivasRumberas
 * Autor: Andrés Mauricio Arciniegas - Agosto de 2012
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package unibague.cupi2.alquilerChivasRumberas.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelExtension extends JPanel implements ActionListener 
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando Opción 3
     */
    private static final String OPCION_3 = "OPCION_3";

    /**
     * Comando Opción 4
     */
    private static final String OPCION_4 = "OPCION_4";

    /**
     * Comando chiva rumbera mas alquilada
     */
    private static final String MAS_ALQUILADA = "MAS_ALQUILADA";

    /**
     * Comando chiva rumbera menos alquilada
     */
    private static final String MENOS_ALQUILADA = "MENOS_ALQUILADA";

    /**
     * Comando total dinero recaudado
     */
    private static final String TOTAL_RECAUDADO = "TOTAL_RECAUDADO";

    /**
     * Comando reiniciar
     */
    private static final String REINICIAR = "REINICIAR";

    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazAlquilerChivasRumberas principal;

    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    /**
     * Botón Opción 3
     */
    private JButton btnOpcion3;

    /**
     * Botón Opción 4
     */
    private JButton btnOpcion4;

    /**
     * Botón chiva rumbera más alquilada
     */
    private JButton btnMasAlquilada;

    /**
     * Botón chiva rumbera menos alquilada
     */
    private JButton btnMenosAlquilada;

    /**
     * Botón total recaudado
     */
    private JButton btnTotalRecaudado;

    /**
     * Botón reiniciar
     */
    private JButton btnReiniciar;

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension( InterfazAlquilerChivasRumberas ventana )
    {
        principal = ventana;

        JPanel organizador = new JPanel( );
        organizador.setLayout( new GridLayout( 1, 4 ) );
        JPanel organizador2 = new JPanel( );
        organizador2.setLayout( new GridLayout( 1, 4 ) );

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 2, 1 ) );
        add( organizador );
        add( organizador2 );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        organizador2.add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        organizador2.add( btnOpcion2 );

        // Botón opción 3
        btnOpcion3 = new JButton( "Opción 3" );
        btnOpcion3.setActionCommand( OPCION_3 );
        btnOpcion3.addActionListener( this );
        organizador2.add( btnOpcion3 );

        // Botón opción 4
        btnOpcion4 = new JButton( "Opción 4" );
        btnOpcion4.setActionCommand( OPCION_4 );
        btnOpcion4.addActionListener( this );
        organizador2.add( btnOpcion4 );

        // Botón chiva mas alquilada
        btnMasAlquilada = new JButton( "Más Alquilada" );
        btnMasAlquilada.setActionCommand( MAS_ALQUILADA );
        btnMasAlquilada.addActionListener( this );
        organizador.add( btnMasAlquilada );

        // Botón chiva menos alquilada
        btnMenosAlquilada = new JButton( "Menos Alquilada" );
        btnMenosAlquilada.setActionCommand( MENOS_ALQUILADA );
        btnMenosAlquilada.addActionListener( this );
        organizador.add( btnMenosAlquilada );

        // Botón total recaudado 
        btnTotalRecaudado = new JButton( "Total Recaudado" );
        btnTotalRecaudado.setActionCommand( TOTAL_RECAUDADO );
        btnTotalRecaudado.addActionListener( this );
        organizador.add( btnTotalRecaudado );

        // Botón reiniciar 
        btnReiniciar = new JButton( "Reiniciar" );
        btnReiniciar.setActionCommand( REINICIAR );
        btnReiniciar.addActionListener( this );
        organizador.add( btnReiniciar );
}

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        
    	if( OPCION_1.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( OPCION_3.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion3( );
        }
        else if( OPCION_4.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion4( );
        }
        else if( MENOS_ALQUILADA.equals( e.getActionCommand( ) ) )
        {
            principal.calcularChivaMenosAlquilada( );
        }
        else if( TOTAL_RECAUDADO.equals( e.getActionCommand( ) ) )
        {
            principal.calcularTotalRecaudado( );
        }
        else if( MAS_ALQUILADA.equals( e.getActionCommand( ) ) )
        {
            principal.calcularChivaMasAlquilada( );
        }
        else if( REINICIAR.equals( e.getActionCommand( ) ) )
        {
            principal.reiniciar( );
        }
        
    }


}
