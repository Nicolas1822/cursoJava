package uniandes.cupi2.zonaDeCamping.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.zonaDeCamping.mundo.Campista;
import uniandes.cupi2.zonaDeCamping.mundo.Carpa;

/**
 * Panel con la información de la carpa actual
 */
public class PanelCarpa extends JPanel implements ListSelectionListener, ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Anterior
     */
    private final static String ANTERIOR = "Anterior";

    /**
     * Comando Siguiente
     */
    private final static String SIGUIENTE = "Siguiente";

    /**
     * Comando Buscar
     */
    private final static String BUSCAR = "Buscar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazZonaDeCamping principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel con la información de la carpa
     */
    private JPanel panelInformacion;

    /**
     * Panel con los elementos de navegavión
     */
    private JPanel panelNavegacion;

    /**
     * Panel que contiene la lista de campistas
     */
    private JScrollPane panelListaCampistas;

    /**
     * Etiqueta para número de la carpa
     */
    private JLabel lblNumero;

    /**
     * Etiqueta para la zona
     */
    private JLabel lblZona;

    /**
     * Etiqueta para la capacidad
     */
    private JLabel lblCapacidad;

    /**
     * Etiqueta para el cupo restante
     */
    private JLabel lblRestante;

    /**
     * Etiqueta para la cantidad de campistas
     */
    private JLabel lblCantidadCampistas;

    /**
     * Campo de texto para número de la carpa
     */
    private JTextField txtNumero;

    /**
     * Campo de texto para la zona
     */
    private JTextField txtZona;

    /**
     * Campo de texto para la capacidad
     */
    private JTextField txtCapacidad;

    /**
     * Campo de texto para el cupo restante
     */
    private JTextField txtRestante;

    /**
     * Campo de texto para la cantidad de campistas
     */
    private JTextField txtCantidadCampistas;

    /**
     * Botón Anterior
     */
    private JButton btnAnterior;

    /**
     * Botón Siguiente
     */
    private JButton btnSiguiente;

    /**
     * Botón Buscar
     */
    private JButton btnBuscar;

    /**
     * Lista de campistas
     */
    private JList listaCampistas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal de la aplicación - ventana != null
     */
    public PanelCarpa( InterfazZonaDeCamping ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Información Carpa" ) );
        setLayout( new BorderLayout( ) );
        inicializarPanelInformacion( );
        add( panelInformacion, BorderLayout.NORTH );
        inicializarPanelListaCampistas( );
        add( panelListaCampistas, BorderLayout.CENTER );
        inicializarPanelNavegacion( );
        add( panelNavegacion, BorderLayout.SOUTH );
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel de información
     */
    public void inicializarPanelInformacion( )
    {
        panelInformacion = new JPanel( );
        panelInformacion.setLayout( new GridLayout( 7, 2 ) );

        lblNumero = new JLabel( "Número:" );
        lblZona = new JLabel( "Zona:" );
        lblCapacidad = new JLabel( "Capacidad:" );
        lblRestante = new JLabel( "Cupo Restante:" );
        lblCantidadCampistas = new JLabel( "Cantidad Campistas:" );
        txtNumero = new JTextField( );
        txtNumero.setEditable( false );
        txtZona = new JTextField( );
        txtZona.setEditable( false );
        txtCapacidad = new JTextField( );
        txtCapacidad.setEditable( false );
        txtRestante = new JTextField( );
        txtRestante.setEditable( false );
        txtCantidadCampistas = new JTextField( );
        txtCantidadCampistas.setEditable( false );

        panelInformacion.add( new JLabel( ) );
        panelInformacion.add( new JLabel( ) );

        panelInformacion.add( lblNumero );
        panelInformacion.add( txtNumero );
        panelInformacion.add( lblZona );
        panelInformacion.add( txtZona );
        panelInformacion.add( lblCapacidad );
        panelInformacion.add( txtCapacidad );
        panelInformacion.add( lblRestante );
        panelInformacion.add( txtRestante );
        panelInformacion.add( lblCantidadCampistas );
        panelInformacion.add( txtCantidadCampistas );
        panelInformacion.add( new JLabel( "Campistas:" ) );
    }

    /**
     * Inicializa el panel con la lista de campistas
     */
    public void inicializarPanelListaCampistas( )
    {
        panelListaCampistas = new JScrollPane( );
        listaCampistas = new JList( );
        listaCampistas.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaCampistas.addListSelectionListener( this );
        listaCampistas.setSelectedIndex( 0 );
        panelListaCampistas.setViewportView( listaCampistas );
        panelListaCampistas.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        panelListaCampistas.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
    }

    /**
     * Inicializa el panel de navegación
     */
    public void inicializarPanelNavegacion( )
    {
        panelNavegacion = new JPanel( );
        panelNavegacion.setBorder( new TitledBorder( "Selección Carpa" ) );
        panelNavegacion.setLayout( new GridLayout( 1, 3 ) );

        // Botón Anterior
        btnAnterior = new JButton( "<<" );
        btnAnterior.setActionCommand( ANTERIOR );
        btnAnterior.addActionListener( this );
        panelNavegacion.add( btnAnterior );

        // Botón Siguiente
        btnSiguiente = new JButton( ">>" );
        btnSiguiente.setActionCommand( SIGUIENTE );
        btnSiguiente.addActionListener( this );
        panelNavegacion.add( btnSiguiente );

        // Botón Buscar
        btnBuscar = new JButton( "Buscar" );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        panelNavegacion.add( btnBuscar );
    }

    /**
     * Actualiza la información con la carpa que entra por parámetro
     */
    public void actualizar(  )
    {
        Carpa carpa = principal.darCarpaActual( );
        int numeroCarpa = carpa.darNumero( );
        int capacidad = carpa.darCapacidad( );
        String zona = carpa.darZona( );
        boolean compartida = carpa.esCompartida( );
        int cantidadCampistas = carpa.darCantidadCampistas( );
        int cantidadRestante = carpa.darCuposRestantes( );
        txtNumero.setText( "" + numeroCarpa );
        txtCapacidad.setText( "" + capacidad );
        txtZona.setText( zona );
        txtCantidadCampistas.setText( "" + cantidadCampistas );
        if( compartida )
        {
            txtRestante.setText( "" + cantidadRestante );
        }
        else
        {
            txtRestante.setText( "Carpa no compartida" );
        }
        listaCampistas.setListData( carpa.darCampistas( ).toArray( ) );
        if( listaCampistas.getSelectedIndex( ) == -1 )
        {
            listaCampistas.setSelectedIndex( 0 );
        }
    }
    
    /**
     * Cambia la selección de la lista a 0
     */
    public void reiniciarSeleccionLista( )
    {
        listaCampistas.setSelectedIndex( 0 );
    }

    /**
     * Maneja los eventos de selección de la lista
     * @param arg0 - Evento de selección
     */
    public void valueChanged( ListSelectionEvent arg0 )
    {
        if( listaCampistas.getSelectedValue( ) != null )
        {
            Campista campista = ( Campista )listaCampistas.getSelectedValue( );
            principal.verDatosCampista( campista );
        }

    }

    /**
     * Manejo de los eventos de los botones
     * @param e - Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if(e.getActionCommand( ).equals( ANTERIOR ) )
        {
            principal.anteriorCarpa( );
            actualizar( );
            listaCampistas.setSelectedIndex( 0 );
        }
        else if( e.getActionCommand( ).equals( SIGUIENTE ) )
        {
            principal.siguenteCarpa( );
            actualizar( );
            listaCampistas.setSelectedIndex( 0 );
        }
        else if( e.getActionCommand( ).equals( BUSCAR ))
        {
            principal.buscarCarpa( );
        }

    }
}
