/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiZoologico
 * Autor: Vanessa Pérez Romanello - 04-ago-2011
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.zonaDeCamping.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.zonaDeCamping.mundo.Campista;

/**
 * Dialogo de creación de un campista
 */
@SuppressWarnings("serial")
public class DialogoAgregarGrupo extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Aceptar
     */
    public static final String ACEPTAR = "Aceptar";

    /**
     * Comando Cancelar
     */
    public static final String CANCELAR = "Cancelar";

    /**
     * Comando Eliminar
     */
    public static final String EXAMINAR = "Examinar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazZonaDeCamping principal;

    /**
     * Cantidad de personas en el grupo
     */
    private int tamanioGrupo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de ingreso de la información
     */
    public JPanel[] panelIngreso;

    /**
     * Panel de ingreso de la imagen
     */
    public JPanel[] panelFoto;

    /**
     * Panel con la información general del grupo
     */
    public JPanel panelInfoGeneral;
    /**
     * Panel con los botones
     */
    public JPanel panelBotones;

    /**
     * Campo de texto del nombre
     */
    private JTextField[] txtNombre;

    /**
     * Campo de texto del apellido
     */
    private JTextField[] txtApellido;

    /**
     * Campo de texto de la cedula
     */
    private JTextField[] txtCedula;

    /**
     * Campo de texto de la edad
     */
    private JTextField[] txtEdad;

    /**
     * Casilla de chequeo para compartir
     */
    private JCheckBox chkParaCompartir;

    /**
     * Campo de texto de la imagen
     */
    private JTextField[] txtFoto;

    /**
     * Botón Aceptar
     */
    private JButton btnAceptar;

    /**
     * Botón Cancelar
     */
    private JButton btnCancelar;

    /**
     * Botón Examinar
     */
    private JButton[] btnExaminar;

    /**
     * Tabs para navegar entre la información de los diferentes grupos
     */
    private JTabbedPane tabs;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo
     * @param ventanaPrincipal Ventana principal de la aplicación
     * @param cantidadPersonas Catidad de personas en el grupo - cantidadPersonas > 0
     */
    public DialogoAgregarGrupo( InterfazZonaDeCamping ventanaPrincipal, int cantidadPersonas )
    {
        super( ventanaPrincipal, "Agregar Campista" ); 
        setLocationRelativeTo( ventanaPrincipal );
        
        principal = ventanaPrincipal;
        tamanioGrupo = cantidadPersonas;
        setLayout( new BorderLayout( ) );
        inicializarComponentes( );

        for( int i = 0; i < cantidadPersonas; i++ )
        {
            inicializarPanelIngreso( i );
        }

        add( tabs, BorderLayout.CENTER );

        inicializarPanelBotones( );
        add( panelBotones, BorderLayout.SOUTH );

        pack( );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Inicializa los componentes de los tabs
     */
    public void inicializarComponentes( )
    {
        txtNombre = new JTextField[tamanioGrupo];
        txtApellido = new JTextField[tamanioGrupo];
        txtCedula = new JTextField[tamanioGrupo];
        txtEdad = new JTextField[tamanioGrupo];
        txtFoto = new JTextField[tamanioGrupo];
        btnExaminar = new JButton[tamanioGrupo];
        tabs = new JTabbedPane( );
        panelIngreso = new JPanel[tamanioGrupo];
        panelFoto = new JPanel[tamanioGrupo];

        panelInfoGeneral = new JPanel( );
        panelInfoGeneral.setLayout( new GridLayout( 4, 3 ) );
        panelInfoGeneral.setBorder( new TitledBorder( "Datos " ) );

        panelInfoGeneral.add( new JLabel( ) );
       // panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( ) );

        panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( "Cantidad personas: " ) );
        panelInfoGeneral.add( new JLabel( tamanioGrupo + "" ) );
        //panelInfoGeneral.add( new JLabel( ) );
        
        panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( "Compartida" ) );
        chkParaCompartir = new JCheckBox( );
        panelInfoGeneral.add( chkParaCompartir );
        //panelInfoGeneral.add( new JLabel( ) );

        //panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( ) );
        panelInfoGeneral.add( new JLabel( ) );
        
        tabs.add( "Información General", panelInfoGeneral );
    }

    /**
     * Inicializa el panel donde se inicializa la información del campista dado por parámetro
     * @param posicion Número del panel a inicializar
     */
    public void inicializarPanelIngreso( int posicion )
    {
        panelIngreso[ posicion ] = new JPanel( );
        panelIngreso[ posicion ].setBorder( new TitledBorder( "Ingreso Datos" ) );
        panelIngreso[ posicion ].setLayout( new GridLayout( 6, 2 ) );

        panelIngreso[ posicion ].add( new JLabel( "Nombre:" ) );
        txtNombre[ posicion ] = new JTextField( );
        panelIngreso[ posicion ].add( txtNombre[ posicion ] );

        panelIngreso[ posicion ].add( new JLabel( "Apellido " ) );
        txtApellido[ posicion ] = new JTextField( );
        panelIngreso[ posicion ].add( txtApellido[ posicion ] );

        panelIngreso[ posicion ].add( new JLabel( "Cédula:" ) );
        txtCedula[ posicion ] = new JTextField( );
        panelIngreso[ posicion ].add( txtCedula[ posicion ] );

        panelIngreso[ posicion ].add( new JLabel( "Edad:" ) );
        txtEdad[ posicion ] = new JTextField( );
        panelIngreso[ posicion ].add( txtEdad[ posicion ] );

        panelIngreso[ posicion ].add( new JLabel( "Foto:" ) );
        panelFoto[ posicion ] = new JPanel( );
        panelFoto[ posicion ].setLayout( new GridLayout( ) );

        txtFoto[ posicion ] = new JTextField( "" );
        txtFoto[ posicion ].setEditable( false );
        panelFoto[ posicion ].add( txtFoto[ posicion ] );
        btnExaminar[ posicion ] = new JButton( "Examinar" );
        btnExaminar[ posicion ].setActionCommand( EXAMINAR + "_" + posicion );
        btnExaminar[ posicion ].addActionListener( this );
        panelFoto[ posicion ].add( btnExaminar[ posicion ] );
        panelIngreso[ posicion ].add( panelFoto[ posicion ] );

        panelIngreso[ posicion ].add( new JLabel( "" ) );
        panelIngreso[ posicion ].add( new JLabel( "" ) );

        tabs.add( "Campista " + ( posicion + 1 ), panelIngreso[ posicion ] );
    }

    /**
     * Inicializa el panel con los botones
     */
    public void inicializarPanelBotones( )
    {
        panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        panelBotones.add( btnAceptar );
        panelBotones.add( btnCancelar );
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {

        if( e.getActionCommand( ).equals( ACEPTAR ) )
        {
            try
            {

                boolean paraCompartir = chkParaCompartir.isSelected( );
                boolean vacio = false;
                Campista[] campistas = new Campista[tamanioGrupo];
                String[] nombre = new String[tamanioGrupo];
                String[] apellido = new String[tamanioGrupo];
                String[] cedula = new String[tamanioGrupo];
                int[] edad = new int[tamanioGrupo];
                String[] foto = new String[tamanioGrupo];
                for( int i = 0; i < tamanioGrupo && !vacio; i++ )
                {
                    nombre[ i ] = txtNombre[ i ].getText( );
                    apellido[ i ] = txtApellido[ i ].getText( );
                    cedula[ i ] = txtCedula[ i ].getText( );
                    String strEdad = txtEdad[ i ].getText( );
                    foto[ i ] = txtFoto[ i ].getText( );

                    if( nombre.equals( "" ) || apellido.equals( "" ) || foto.equals( "" ) || strEdad.equals( "" ))
                    {
                        System.out.println(i);
                        vacio = true;
                    }
                    else
                    {
                        edad[ i ] = Integer.parseInt( strEdad );
                    }
                }
                if( !vacio )
                {
                    principal.agregarCampistas( tamanioGrupo, paraCompartir, nombre, apellido, cedula, edad, foto );
                    setVisible( false );
                    dispose( );

                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe llenar todos los campos", "Datos incompletos", JOptionPane.ERROR_MESSAGE );
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( this, "La edad debe ser un valor numérico", "Datos incorrectos", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( e.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }
        else
        {
            for( int i = 0; i < tamanioGrupo; i++ )
            {
                if( e.getActionCommand( ).equals( EXAMINAR + "_" + i ) )
                {
                    JFileChooser fc = new JFileChooser( "./data/imagenes" );
                    fc.setDialogTitle( "Buscar imagen" );
                    fc.setMultiSelectionEnabled( false );
                    int resultado = fc.showOpenDialog( this );
                    if( resultado == JFileChooser.APPROVE_OPTION )
                    {
                        String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                        txtFoto[ i ].setText( imagen );

                    }
                }
            }
        }
    }
}