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
package uniandes.cupi2.zonaDeCamping.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.zonaDeCamping.mundo.Carpa;
import uniandes.cupi2.zonaDeCamping.mundo.ZonaDeCamping;

/**
 * Panel de información Adicional
 */
public class PanelInformacion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Comando Agregar Campista
     */
    private static final String AGREGAR_CAMPISTA = "Agregar Campista";

    /**
     * Comando Agregar Grupo Campistas
     */
    private static final String AGREGAR_GRUPO = "Agregar Grupo";

    /**
     * Comando Eliminar Campista
     */
    private static final String ELIMINAR_CAMPISTA = "Eliminar Campista";

    /**
     * Comando Buscar Campista
     */
    private static final String BUSCAR_CAMPISTA = "Buscar Campista";
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazZonaDeCamping principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información de la zona de camping
     */
    private JPanel panelInfo;

    /**
     * Pantel con los botones
     */
    private JPanel panelBotones;

    /**
     * Etiqueta para la cantidad de carpas
     */
    private JLabel lblCantidadCarpas;

    /**
     * Etiqueta para la cantidad de carpas en la zona norte
     */
    private JLabel lblCarpasZonaNorte;

    /**
     * Etiqueta para la cantidad de carpas en la zona este
     */
    private JLabel lblCarpasZonaEste;

    /**
     * Etiqueta para la cantidad de carpas en la zona oeste
     */
    private JLabel lblCarpasZonaOeste;

    /**
     * Etiqueta para la cantidad de carpas en la zona sur
     */
    private JLabel lblCarpasZonaSur;

    /**
     * Etiqueta para el porcentaje de ocupación de la zona de camping
     */
    private JLabel lblPorcentajeOcupacion;

    /**
     * Campo de texto con la cantidad de carpas
     */
    private JTextField txtCantidadCarpas;

    /**
     * Campo de texto con la cantidad de carpas de la zona norte
     */
    private JTextField txtCarpasZonaNorte;

    /**
     * Campo de texto con la cantidad de carpas de la zona este
     */
    private JTextField txtCarpasZonaEste;

    /**
     * Campo de texto con la cantidad de carpas de la zona oeste
     */
    private JTextField txtCarpasZonaOeste;

    /**
     * Campo de texto con la cantidad de carpas de la zona sur
     */
    private JTextField txtCarpasZonaSur;

    /**
     * Campo de texto con el porcentaje de ocupación de la zona de camping
     */
    private JTextField txtPorcentajeOcupacion;

    /**
     * Botón Agregar
     */
    private JButton btnAgregar;

    /**
     * Botón AgregarGrupo
     */
    private JButton btnAgregarGrupo;

    /**
     * Botón Eliminar
     */
    private JButton btnEliminar;

    /**
     * Botón Buscar
     */
    private JButton btnBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal de la aplicación - ventana != null
     */
    public PanelInformacion( InterfazZonaDeCamping ventana )
    {
        principal = ventana;
        setBorder( new TitledBorder( "Información Zona Camping" ) );
        setLayout( new BorderLayout( ) );

        inicializarPanelInfo( );
        add( panelInfo, BorderLayout.CENTER );

        inicializarPanelBotones( );
        add( panelBotones, BorderLayout.EAST );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel de información
     */
    public void inicializarPanelInfo( )
    {
        panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 8, 3 ) );

        panelInfo.add( new JLabel( ) );
        panelInfo.add( new JLabel( ) );
        panelInfo.add( new JLabel( ) );
        lblCantidadCarpas = new JLabel( "Cantidad Carpas:" );
        panelInfo.add( lblCantidadCarpas );
        txtCantidadCarpas = new JTextField( );
        txtCantidadCarpas.setEditable( false );
        panelInfo.add( txtCantidadCarpas );

        panelInfo.add( new JLabel( ) );
        lblCarpasZonaNorte = new JLabel( "Campistas Zona Norte: " );
        panelInfo.add( lblCarpasZonaNorte );
        txtCarpasZonaNorte = new JTextField( );
        txtCarpasZonaNorte.setEditable( false );
        panelInfo.add( txtCarpasZonaNorte );

        panelInfo.add( new JLabel( ) );
        lblCarpasZonaEste = new JLabel( "Campistas Zona Este: " );
        panelInfo.add( lblCarpasZonaEste );
        txtCarpasZonaEste = new JTextField( );
        txtCarpasZonaEste.setEditable( false );
        panelInfo.add( txtCarpasZonaEste );
        panelInfo.add( new JLabel( ) );

        lblCarpasZonaOeste = new JLabel( "Campistas Zona Oeste: " );
        panelInfo.add( lblCarpasZonaOeste );
        txtCarpasZonaOeste = new JTextField( );
        txtCarpasZonaOeste.setEditable( false );
        panelInfo.add( txtCarpasZonaOeste );

        panelInfo.add( new JLabel( ) );
        lblCarpasZonaSur = new JLabel( "Campistas Zona Sur: " );
        panelInfo.add( lblCarpasZonaSur );
        txtCarpasZonaSur = new JTextField( );
        txtCarpasZonaSur.setEditable( false );
        panelInfo.add( txtCarpasZonaSur );

        panelInfo.add( new JLabel( ) );
        lblPorcentajeOcupacion = new JLabel( "PorcentajeOcupación: " );
        panelInfo.add( lblPorcentajeOcupacion );
        txtPorcentajeOcupacion = new JTextField( );
        txtPorcentajeOcupacion.setEditable( false );
        panelInfo.add( txtPorcentajeOcupacion );

        panelInfo.add( new JLabel( ) );
        panelInfo.add( new JLabel( ) );
        panelInfo.add( new JLabel( ) );
    }

    /**
     * Inicializa el panel botones
     */
    public void inicializarPanelBotones( )
    {
        panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 6, 1 ) );

        btnAgregar = new JButton( "Agregar Campista" );
        btnAgregar.setActionCommand( AGREGAR_CAMPISTA );
        btnAgregar.addActionListener( this );

        btnAgregarGrupo = new JButton( "Agregar Grupo" );
        btnAgregarGrupo.setActionCommand( AGREGAR_GRUPO );
        btnAgregarGrupo.addActionListener( this );

        btnEliminar = new JButton( "Eliminar Campista" );
        btnEliminar.setActionCommand( ELIMINAR_CAMPISTA );
        btnEliminar.addActionListener( this );

        btnBuscar = new JButton( "Buscar Campista" );
        btnBuscar.setActionCommand( BUSCAR_CAMPISTA );
        btnBuscar.addActionListener( this );

        panelBotones.add( new JLabel( ) );
        panelBotones.add( btnAgregar );
        panelBotones.add( btnAgregarGrupo );
        panelBotones.add( btnEliminar );
        panelBotones.add( btnBuscar );
        panelBotones.add( new JLabel( ) );
    }

    /**
     * Actualiza el panel con la información de la zona de camping dada por parámetro
     */
    public void actualizar( )
    {
        ZonaDeCamping zonaDeCamping = principal.darZonaDeCamping( );
        txtCantidadCarpas.setText( "" + zonaDeCamping.CANT_CARPAS );
        txtCarpasZonaNorte.setText( "" + zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_NORTE ) );
        txtCarpasZonaEste.setText( "" + zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_ESTE ) );
        txtCarpasZonaOeste.setText( "" + zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_OESTE ) );
        txtCarpasZonaSur.setText( "" + zonaDeCamping.darCantidadCampistasPorZona( Carpa.ZONA_SUR ) );
        txtPorcentajeOcupacion.setText(( Math.floor( zonaDeCamping.calcularPorcentajeOcupacionCarpas( ) * 100 + 0.5 ) / 100 ) + "%" );
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( AGREGAR_CAMPISTA ) )
        {
            DialogoAgregarCampista dialogo = new DialogoAgregarCampista( principal );
            dialogo.setVisible( true );
        }
        else if( e.getActionCommand( ).equals( BUSCAR_CAMPISTA ) )
        {
            principal.buscarCampista( );
        }
        else if( e.getActionCommand( ).equals( ELIMINAR_CAMPISTA ) )
        {
            principal.eliminarCampista( );
        }
        else if( e.getActionCommand( ).equals( AGREGAR_GRUPO ) )
        {
            try
            {
                String cantPersonas = JOptionPane.showInputDialog( this, "Ingrese la cantidad de personas en el grupo" );
                if( cantPersonas!= null )
                {
                    if( cantPersonas.equals( "" ) )
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar una cantidad", "Agregar grupo", JOptionPane.WARNING_MESSAGE );
                    }
                    else
                    {
                        int cantidadPersonas = Integer.parseInt( cantPersonas );
                        if( cantidadPersonas > principal.darCantidadMaximaGrupo( ) )
                        {
                            JOptionPane.showMessageDialog( this, "La cantidad máxima de personas permitidas en un grupo es: " + principal.darCantidadMaximaGrupo( ), "Cantidad no permitida", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            DialogoAgregarGrupo dialogo = new DialogoAgregarGrupo( principal, cantidadPersonas );
                            dialogo.setVisible( true );
                        }
                    }
                }
            }
            catch( NumberFormatException ex )
            {
                JOptionPane.showMessageDialog( principal, "Debe ingresar un valor  numérico", "Valor incorrecto", JOptionPane.ERROR_MESSAGE );
            }
        }

    }
}
