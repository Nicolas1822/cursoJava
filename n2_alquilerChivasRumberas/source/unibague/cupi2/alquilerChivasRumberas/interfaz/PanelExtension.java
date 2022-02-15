/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java 2012-10-01 18:00:00Z andres.arciniegas $
 * Universidad de Ibagu� (Ibagu� - Colombia)
 * Programa de Ingenier�a de Sistemas  
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_alquilerChivasRumberas
 * Autor: Andr�s Mauricio Arciniegas - Agosto de 2012
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
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando Opci�n 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opci�n 2
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando Opci�n 3
     */
    private static final String OPCION_3 = "OPCION_3";

    /**
     * Comando Opci�n 4
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
     * Ventana principal de la aplicaci�n
     */
    private InterfazAlquilerChivasRumberas principal;

    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Opci�n 1
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2
     */
    private JButton btnOpcion2;

    /**
     * Bot�n Opci�n 3
     */
    private JButton btnOpcion3;

    /**
     * Bot�n Opci�n 4
     */
    private JButton btnOpcion4;

    /**
     * Bot�n chiva rumbera m�s alquilada
     */
    private JButton btnMasAlquilada;

    /**
     * Bot�n chiva rumbera menos alquilada
     */
    private JButton btnMenosAlquilada;

    /**
     * Bot�n total recaudado
     */
    private JButton btnTotalRecaudado;

    /**
     * Bot�n reiniciar
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

        // Bot�n opci�n 1
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        organizador2.add( btnOpcion1 );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        organizador2.add( btnOpcion2 );

        // Bot�n opci�n 3
        btnOpcion3 = new JButton( "Opci�n 3" );
        btnOpcion3.setActionCommand( OPCION_3 );
        btnOpcion3.addActionListener( this );
        organizador2.add( btnOpcion3 );

        // Bot�n opci�n 4
        btnOpcion4 = new JButton( "Opci�n 4" );
        btnOpcion4.setActionCommand( OPCION_4 );
        btnOpcion4.addActionListener( this );
        organizador2.add( btnOpcion4 );

        // Bot�n chiva mas alquilada
        btnMasAlquilada = new JButton( "M�s Alquilada" );
        btnMasAlquilada.setActionCommand( MAS_ALQUILADA );
        btnMasAlquilada.addActionListener( this );
        organizador.add( btnMasAlquilada );

        // Bot�n chiva menos alquilada
        btnMenosAlquilada = new JButton( "Menos Alquilada" );
        btnMenosAlquilada.setActionCommand( MENOS_ALQUILADA );
        btnMenosAlquilada.addActionListener( this );
        organizador.add( btnMenosAlquilada );

        // Bot�n total recaudado 
        btnTotalRecaudado = new JButton( "Total Recaudado" );
        btnTotalRecaudado.setActionCommand( TOTAL_RECAUDADO );
        btnTotalRecaudado.addActionListener( this );
        organizador.add( btnTotalRecaudado );

        // Bot�n reiniciar 
        btnReiniciar = new JButton( "Reiniciar" );
        btnReiniciar.setActionCommand( REINICIAR );
        btnReiniciar.addActionListener( this );
        organizador.add( btnReiniciar );
}

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
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
