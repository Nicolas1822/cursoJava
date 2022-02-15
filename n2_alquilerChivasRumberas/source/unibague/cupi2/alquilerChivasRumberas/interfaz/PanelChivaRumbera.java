/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelChivaRumbera.java 2012-09-17 18:00:00Z andres.arciniegas $
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import unibague.cupi2.alquilerChivasRumberas.mundo.ChivaRumbera;

/**
 * Panel que contiene la información de una chiva rumbera
 */
public class PanelChivaRumbera extends JPanel implements ActionListener 
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constante para el alquiler de la chiva rumbera
     */
    private static final String ALQUILAR = "Alquiler";

    /**
     * Constante para la devolución de la chiva rumbera
     */
    private static final String DEVOLVER = "Devolver";

    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * La ventana principal
     */
    private InterfazAlquilerChivasRumberas principal;

    /**
     * Nombre de la chiva rumbera de la cual se muestra la información
     */
    private String nombreChivaRumbera;

    
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta que contiene la imagen de la chiva rumbera
     */
    private JLabel labImagen;

    /**
     * Etiqueta con la información del tamanio de la chiva rumbera
     */
    private JLabel labTamanio;

    /**
     * Etiqueta con la información del precio por hora del alquiler de la chiva rumbera
     */
    private JLabel labPrecioHora;

    /**
     * Etiqueta con la información del número de veces que ha sido alquilada la chiva rumbera
     */
    private JLabel labVecesAlquilado;

    /**
     * Etiqueta con la información del dinero total recaudado por alquiler de la chiva rumbera
     */
    private JLabel labDineroRecaudado;
    
    /**
     * Campo de texto del tamanio de la chiva rumbera
     */
    private JTextField txtTamanio;

    /**
     * Campo de texto del precio por hora del alquiler de la chiva rumbera
     */
    private JTextField txtPrecioHora;

    /**
     * Campo de texto del número de veces que ha sido alquilada la chiva rumbera
     */
    private JTextField txtVecesAlquilado;

    /**
     * Campo de texto del dinero total recaudado por alquiler de la chiva rumbera
     */
    private JTextField txtDineroRecaudado;
    
    /**
     * Botón para alquilar la chiva rumbera
     */
    private JButton butAlquilar;

    /**
     * Botón para devolver la chiva rumbera
     */
    private JButton butDevolver;

    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel, se encarga de inicializar todos los datos
     * @param ventana Una referencia de la ventana principal de la aplicación
     * @param pNombreChiva El nombre de la chiva rumbera que se esta mostrando
     */
    public PanelChivaRumbera( InterfazAlquilerChivasRumberas ventana, String pNombreChiva )
    {
        principal = ventana;
        nombreChivaRumbera = pNombreChiva;
        setPreferredSize( new Dimension( 300, 200 ) );

        setBorder( new TitledBorder( "" ) );
        setLayout( new GridBagLayout( ) );

        // Etiqueta para la imagen
        ImageIcon icono = new ImageIcon( "data/imagenes/" + nombreChivaRumbera + ".jpg" );
        labImagen = new JLabel( "" );
        labImagen.setIcon( icono );
        labImagen.setBorder( new TitledBorder( "" ) );

        // Etiqueta para el tamanio
        labTamanio = new JLabel( "Tamaño:" );

        // Etiqueta para el precio por hora
        labPrecioHora = new JLabel( "Precio/Hora:" );

        // Etiqueta para el número de veces que ha sido alquilado
        labVecesAlquilado = new JLabel( "Veces Alquilada:" );

        // Etiqueta para el dinero recaudado
        labDineroRecaudado = new JLabel( "Vr. Recaudado:" );

        // Campo para el tamanio
        txtTamanio = new JTextField( );
        txtTamanio.setEditable( false );
        txtTamanio.setForeground( Color.BLUE );
        txtTamanio.setBorder( null );
        
        // Campo para el precio por hora
        txtPrecioHora = new JTextField( );
        txtPrecioHora.setEditable( false );
        txtPrecioHora.setForeground( Color.BLUE );
        txtPrecioHora.setBorder( null );
        
        // Campo para el número de veces que ha sido alquilado
        txtVecesAlquilado = new JTextField( );
        txtVecesAlquilado.setEditable( false );
        txtVecesAlquilado.setForeground( Color.BLUE );
        txtVecesAlquilado.setBorder( null );
        
        // Campo para el dinero recaudado
        txtDineroRecaudado = new JTextField( );
        txtDineroRecaudado.setEditable( false );
        txtDineroRecaudado.setForeground( Color.BLUE );
        txtDineroRecaudado.setBorder( null );
        
        // Botón para realizar alquiler
        butAlquilar = new JButton( "Alquilar" );
        butAlquilar.setPreferredSize( new Dimension( 200, 25 ) );
        butAlquilar.setActionCommand( ALQUILAR );
        butAlquilar.addActionListener( this );
        // butAlquilar.setEnabled( false );

        // Botón para realizar alquiler
        butDevolver= new JButton( "Devolver" );
        butDevolver.setPreferredSize( new Dimension( 200, 25 ) );
        butDevolver.setActionCommand( DEVOLVER );
        butDevolver.addActionListener( this );
        butDevolver.setEnabled( false );

        // Panel para organizar los botones
        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 2, 1, 5, 5 ) );
        panelBotones.add( butAlquilar );
        panelBotones.add( butDevolver );
        
        // Organización de los objetos en el panel
        // Imagen
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 7, 0, 0, GridBagConstraints.WEST, 
        												GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labImagen, gbc );

        // Tamanio
        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, 
        							GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labTamanio, gbc );
        gbc.gridx = 2;
        add( txtTamanio, gbc );

        // Precio-Hora
        gbc = new GridBagConstraints( 1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, 
        							GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labPrecioHora, gbc );
        gbc.gridx = 2;
        add( txtPrecioHora, gbc );
        
        // Veces Alquilado
        gbc = new GridBagConstraints( 1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labVecesAlquilado, gbc );
        gbc.gridx = 2;
        add( txtVecesAlquilado, gbc );
        
        // Dinero recaudado
        gbc = new GridBagConstraints( 1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labDineroRecaudado, gbc );
        gbc.gridx = 2;
        add( txtDineroRecaudado, gbc );
        
        // Botones (organizados en el panel)
        gbc = new GridBagConstraints( 1, 5, 2, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( panelBotones, gbc );
    
    }

    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	
    /**
     * Ingresa los datos de una chiva rumbera en los campos de texto
     * @param chiva La chiva rumbera que se va mostrar
     */
    public void ingresarDatos( ChivaRumbera chiva )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
   
        if( chiva != null )
        {
            TitledBorder border = BorderFactory.createTitledBorder( chiva.darNombre() );
            border.setTitleColor( Color.BLUE );
            setBorder( border );

            txtTamanio.setText( chiva.darTamanio( ) );
            txtPrecioHora.setText( df.format( chiva.darPrecioHora( ) ) + "" ) ;
            txtVecesAlquilado.setText( chiva.darVecesAlquilado( ) + "" );
            txtDineroRecaudado.setText( df.format( chiva.darDineroRecaudado( ) ) + "" );
            if( chiva.darDisponibilidad( ) )
            {
                butAlquilar.setEnabled( true  );
                butDevolver.setEnabled( false );
            }
            else
            {
                butAlquilar.setEnabled( false );
                butDevolver.setEnabled( true  );
            }
        }
        else
        {
            setBorder( new TitledBorder( "" ) );
            txtTamanio.setText( "" );
            txtPrecioHora.setText( "" );
            txtVecesAlquilado.setText( "" );
            txtDineroRecaudado.setText( "" );
            butAlquilar.setEnabled( false );
            butDevolver.setEnabled( false );
        }

    }

    /**
     * Método que lee los eventos de los botones
     * @param e Evento generado por los botones
     */
    public void actionPerformed( ActionEvent e )
    {
        String evento = e.getActionCommand( );
        if( evento.equals( ALQUILAR ) )
        {
            principal.alquilarChivaRumbera( nombreChivaRumbera );
        }
        else if( evento.equals( DEVOLVER ) )
        {
            principal.devolverChivaRumbera( nombreChivaRumbera );
        }

    }


}
