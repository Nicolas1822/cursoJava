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

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Dialogo de creación de un campista
 */
@SuppressWarnings("serial")
public class DialogoAgregarCampista extends JDialog implements ActionListener
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

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de ingreso de la información
     */
    public JPanel panelIngreso;

    /**
     * Panel de ingreso de la imagen
     */
    public JPanel panelFoto;

    /**
     * Campo de texto del nombre
     */
    private JTextField txtNombre;

    /**
     * Campo de texto del apellido
     */
    private JTextField txtApellido;

    /**
     * Campo de texto de la cedula
     */
    private JTextField txtCedula;

    /**
     * Campo de texto de la edad
     */
    private JTextField txtEdad;

    /**
     * Casilla de chequeo para compartir
     */
    private JCheckBox chkParaCompartir;

    /**
     * Campo de texto de la imagen
     */
    private JTextField txtFoto;

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
    private JButton btnExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo
     * @param ventanaPrincipal Ventana principal de la aplicación
     */
    public DialogoAgregarCampista( InterfazZonaDeCamping ventanaPrincipal )
    {
        super( ventanaPrincipal, "Agregar Campista" );
        setLocationRelativeTo( ventanaPrincipal );
        principal = ventanaPrincipal;

        panelIngreso = new JPanel( );
        panelIngreso.setBorder( new TitledBorder( "Ingreso Datos" ) );
        panelIngreso.setLayout( new GridLayout( 8, 2 ) );

        panelIngreso.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelIngreso.add( txtNombre );

        panelIngreso.add( new JLabel( "Apellido " ) );
        txtApellido = new JTextField( );
        panelIngreso.add( txtApellido );

        panelIngreso.add( new JLabel( "Cédula:" ) );
        txtCedula = new JTextField( );
        panelIngreso.add( txtCedula );

        panelIngreso.add( new JLabel( "Edad:" ) );
        txtEdad = new JTextField( );
        panelIngreso.add( txtEdad );

        panelIngreso.add( new JLabel( "Compartida:" ) );
        chkParaCompartir = new JCheckBox( );
        panelIngreso.add( chkParaCompartir );

        panelIngreso.add( new JLabel( "Foto:" ) );
        panelFoto = new JPanel( );
        panelFoto.setLayout( new GridLayout( ) );

        txtFoto = new JTextField( "" );
        txtFoto.setEditable( false );
        panelFoto.add( txtFoto );
        btnExaminar = new JButton( "Examinar" );
        btnExaminar.setActionCommand( EXAMINAR );
        btnExaminar.addActionListener( this );
        panelFoto.add( btnExaminar );
        panelIngreso.add( panelFoto );

        panelIngreso.add( new JLabel( "" ) );
        panelIngreso.add( new JLabel( "" ) );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelIngreso.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelIngreso.add( btnCancelar );

        add( panelIngreso );

        pack( );
        setLocationRelativeTo( null );
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
        if( e.getActionCommand( ).equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String apellido = txtApellido.getText( );
            String cedula = txtCedula.getText( );
            String strEdad = txtEdad.getText( );
            boolean paraCompartir = chkParaCompartir.isSelected( );
            String foto = txtFoto.getText( );
            if( !nombre.equals( "" ) && !apellido.equals( "" ) && !foto.equals( "" ) )
            {
                try
                {
                    int edad = Integer.parseInt( strEdad );
                    principal.agregarCampista( nombre, apellido, cedula, edad, foto, paraCompartir );
                    setVisible( false );
                    dispose( );
                }
                catch( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog( this, "La edad debe ser un valor numérico", "Datos incorrectos", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos", "Datos incompletos", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( e.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }
        else if( e.getActionCommand( ).equals( EXAMINAR ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Buscar imagen" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtFoto.setText( imagen );
            }
        }
    }
}