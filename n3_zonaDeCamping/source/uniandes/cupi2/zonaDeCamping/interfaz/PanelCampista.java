package uniandes.cupi2.zonaDeCamping.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.zonaDeCamping.mundo.Campista;

/**
 * Panel con la información del campista
 */
public class PanelCampista extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La altura que debe tener la imagen de un individuo
     */
    private static final int ALTURA = 150;

    /**
     * El ancho que debe tener la imagen de un individuo
     */
    private static final int ANCHO = 150;

    /**
     * La ruta de la imagen que muestra el panel cuando no hay ningún animal seleccionado
     */
    private static final String IMAGEN = "./data/imagenes/cupiCampista.png";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    private JLabel lblNombre;

    private JLabel lblApellido;

    private JLabel lblCedula;

    private JLabel lblEdad;

    private JLabel lblImagen;

    private JTextField txtNombre;

    private JTextField txtApellido;

    private JTextField txtCedula;

    private JTextField txtEdad;

    private JPanel panelInformacion;

    private JPanel panelFoto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * 
     */
    public PanelCampista( )
    {
        setBorder( new TitledBorder( "Información Campista" ) );
        setPreferredSize( new Dimension( 250, 0 ) );

        setLayout( new BorderLayout( ) );
        inicializarPanelInformacion( );
        add( panelInformacion, BorderLayout.CENTER );
        inicializarPanelFoto( );
        add( panelFoto, BorderLayout.NORTH );
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * 
     */
    public void inicializarPanelInformacion( )
    {
        panelInformacion = new JPanel( );
        panelInformacion.setLayout( new GridLayout( 6, 2 ) );

        lblNombre = new JLabel( "Nombre:" );
        lblApellido = new JLabel( "Apellido:" );
        lblCedula = new JLabel( "Cedula:" );
        lblEdad = new JLabel( "Edad:" );
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        txtApellido = new JTextField( );
        txtApellido.setEditable( false );
        txtCedula = new JTextField( );
        txtCedula.setEditable( false );
        txtEdad = new JTextField( );
        txtEdad.setEditable( false );

        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( lblNombre );
        panelInformacion.add( txtNombre );
        panelInformacion.add( lblApellido );
        panelInformacion.add( txtApellido );
        panelInformacion.add( lblCedula );
        panelInformacion.add( txtCedula );
        panelInformacion.add( lblEdad );
        panelInformacion.add( txtEdad );
        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( new JLabel( ) );
    }

    /**
     * Inicializa el panel de las fotos
     */
    public void inicializarPanelFoto( )
    {
        panelFoto = new JPanel( );

        lblImagen = new JLabel( );
        lblImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        lblImagen.setMinimumSize( new Dimension( 230, 153 ) );
        lblImagen.setMaximumSize( new Dimension( 230, 153 ) );
        panelFoto.add( lblImagen );

        try
        {
            String imagen = IMAGEN;
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );

        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen ", "Error", JOptionPane.ERROR_MESSAGE );
        }
        add( panelFoto, BorderLayout.SOUTH );
    }

    /**
     * Actualiza la información del panel con la del campista que entra por parámetro
     * @param campista Campista cuya información se desea visualizar - campista != null
     */
    public void actualizar( Campista campista )
    {
        try
        {
            txtNombre.setText( campista.darNombre( ) );
            txtApellido.setText( campista.darApellido( ) );
            txtCedula.setText( campista.darCedula( ) );
            txtEdad.setText( campista.darEdad( ) + "" );

            String imagen = campista.darFoto( );
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen del campista " + campista.darNombre( ) + " " + campista.darApellido( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Borra los datos en el panel del campista actual
     */
    public void borrarDatos( )
    {
        try
        {
            txtNombre.setText( "" );
            txtApellido.setText( "" );
            txtCedula.setText( "" );
            txtEdad.setText( "" );

            String imagen = IMAGEN;
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen ", "Error", JOptionPane.ERROR_MESSAGE );
        }

    }
}
