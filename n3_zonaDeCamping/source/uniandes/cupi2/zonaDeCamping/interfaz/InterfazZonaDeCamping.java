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

import java.awt.*;

import javax.swing.*;

import uniandes.cupi2.zonaDeCamping.mundo.Campista;
import uniandes.cupi2.zonaDeCamping.mundo.Carpa;
import uniandes.cupi2.zonaDeCamping.mundo.ZonaDeCamping;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazZonaDeCamping extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private ZonaDeCamping zonaDeCamping;

    /**
     * Carpa actualmente visualizada
     */
    private int carpaActual;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la información de la carpa actual
     */
    private PanelCarpa panelCarpa;

    /**
     * Panel con la información del campista actual
     */
    private PanelCampista panelCampista;

    /**
     * Panel con la información de la zona de camping
     */
    private PanelInformacion panelInformacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método constructor de la ventana. <br>
     * <b>post: </b> Se inicializan los paneles con la información del sistema
     */
    public InterfazZonaDeCamping( )
    {
        // Crea la clase principal
        zonaDeCamping = new ZonaDeCamping( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 580, 730 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        setTitle( "Zona de Camping" );
        // Creación de los paneles aquí

        JPanel auxPanelSuperior = new JPanel( );
        auxPanelSuperior.setLayout( new BorderLayout( ) );

        panelImagen = new PanelImagen( );
        auxPanelSuperior.add( panelImagen, BorderLayout.NORTH );

        panelInformacion = new PanelInformacion( this );
        auxPanelSuperior.add( panelInformacion, BorderLayout.SOUTH );

        add( auxPanelSuperior, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        JPanel auxPanelInformacion = new JPanel( );
        auxPanelInformacion.setLayout( new BorderLayout( ) );

        panelCarpa = new PanelCarpa( this );
        auxPanelInformacion.add( panelCarpa, BorderLayout.CENTER );

        panelCampista = new PanelCampista( );
        auxPanelInformacion.add( panelCampista, BorderLayout.EAST );

        add( auxPanelInformacion, BorderLayout.CENTER );

        carpaActual = 0;
        panelInformacion.actualizar( );
        panelCarpa.actualizar( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna la carpa actual
     * @return retorna la carpa actual
     */
    public Carpa darCarpaActual( )
    {
        return zonaDeCamping.darCarpa( carpaActual );
    }

    /**
     * Retorna la cantidad máxima de personas admitidas por grupo
     * @return Cantidad máxima de personas admitidas por grupo
     */
    public int darCantidadMaximaGrupo( )
    {
        return ZonaDeCamping.CANT_MAX_GRUPOS;
    }

    /**
     * Cambia el número de la carpa siguiente, asignándole el número anterior
     */
    public void siguenteCarpa( )
    {
        carpaActual++;
        eliminarDatosCampista( );
        if( carpaActual == ZonaDeCamping.CANT_CARPAS )
        {
            carpaActual = 0;
        }
        panelCarpa.reiniciarSeleccionLista( );
    }

    /**
     * Cambia el número de la carpa actual, asignándole el número anterior
     */
    public void anteriorCarpa( )
    {
        carpaActual--;
        eliminarDatosCampista( );
        if( carpaActual < 0 )
        {
            carpaActual = ZonaDeCamping.CANT_CARPAS - 1;
        }
    }

    /**
     * Muestra los datos del campista dado en el panel
     * @param campista Campista cuyos datos se desea visualizar
     */
    public void verDatosCampista( Campista campista )
    {
        panelCampista.actualizar( campista );
    }

    /**
     * Elimina los datos del campista actual de la interfaz
     */
    public void eliminarDatosCampista( )
    {
        panelCampista.borrarDatos( );
    }

    /**
     * Retorna la zona de camping
     * @return Zona de Camping
     */
    public ZonaDeCamping darZonaDeCamping( )
    {
        return zonaDeCamping;
    }

    /**
     * Agrega un nuevo campista
     * @param nNombre Nombre del campista a agregar - nNombre "= null && nNombre != ""
     * @param nApellido Apellido del campista a agregar - nApellido != null && nApellido != ""
     * @param nCedula Cedula del campista a agregar - nCedula != null && nCedula != 0
     * @param nEdad Edad del campista a agregar - nEdad > 0
     * @param nFoto Foto de campista a agregar - nFoto != null && nFoto != ""
     * @param paraCompartir True si se desea compartir la carpa, false de lo contrario
     */
    public void agregarCampista( String nNombre, String nApellido, String nCedula, int nEdad, String nFoto, boolean paraCompartir )
    {
        int posicion = zonaDeCamping.agregarCampista( nNombre, nApellido, nCedula, nEdad, nFoto, paraCompartir );
        if( posicion == -1 )
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el campista a ninguna carpa", "Agregar Campista", JOptionPane.WARNING_MESSAGE );
        }
        else if( posicion == -2 )
        {
            JOptionPane.showMessageDialog( this, "Ya existe un campista con la cédula " + nCedula, "Agregar Campista", JOptionPane.WARNING_MESSAGE );
        }
        else
        {
            carpaActual = posicion;
            Carpa carpa = zonaDeCamping.darCarpa( carpaActual );
            String zona = carpa.darZona( );
            int numero = carpa.darNumero( );
            String mensaje = "Se agregó al campista con cédula " + nCedula + " a la carpa no. " + numero + " en la zona " + zona;
            JOptionPane.showMessageDialog( this, mensaje, "Agregar Campista", JOptionPane.INFORMATION_MESSAGE );
            actualizar( );          

        }
    }

    /**
     * Agrega un grupo de campistas a la zona de camping
     * @param cantidad - Cantidad de personas a del grupo - cantidad >= 0 && cantidad < zonaCamping.darCantidadMaximaGrupo
     * @param paraCompartir - true si se desea compartir la carpa, false de lo contradio
     * @param nombre - Lista de nombres a agregar - nombre != null
     * @param apellido - Lista de apellidos a agregar - apellido != null
     * @param cedula - Lista de cédulas a agregar - cedula != null
     * @param edad - Lista de edades a agregar - edad != null
     * @param foto - Lista de rutas con las fotos a agregar - foto != null
     */
    public void agregarCampistas( int cantidad, boolean paraCompartir, String[] nombre, String[] apellido, String[] cedula, int[] edad, String[] foto )
    {
        int posicion = zonaDeCamping.puedeAgregarGrupo( cantidad, paraCompartir );
        if( posicion == -1 )
        {
            JOptionPane.showMessageDialog( this, "No se puede agregar al grupo de campistas" );
        }
        else
        {
            String noAgregados = "";
            for( int i = 0; i < cantidad; i++ )
            {
                boolean agrego = zonaDeCamping.agregarCampista( posicion, nombre[ i ], apellido[ i ], cedula[ i ], edad[ i ], foto[ i ], paraCompartir );
                if( !agrego )
                {
                    noAgregados += cedula + "\n";
                }
            }
            if( noAgregados.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Se agregó al grupo de campistas exitosamente", "Agregar Campista", JOptionPane.INFORMATION_MESSAGE );
                carpaActual = posicion;
                actualizar( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Las siguientes cédulas ya se encuentran en el sistema y los campistas no fueron agregados: \n" + noAgregados );
            }
        }
    }

    /**
     * Busca al campista con la cédula ingresada
     */
    public void buscarCampista( )
    {
        String cedula = JOptionPane.showInputDialog( this, "Ingrese la cédula del campista buscado" );

        Campista campista = zonaDeCamping.buscarCampista( cedula );
        if( cedula != null )
        {
            if( cedula.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar una cédula", "BuscarCampista", JOptionPane.WARNING_MESSAGE );
            }
            else if( campista == null )
            {
                String mensaje = "El campista con cédula " + cedula + " no se encuentra en la zona de camping";
                JOptionPane.showMessageDialog( this, mensaje, "Buscar campista", JOptionPane.WARNING_MESSAGE );
            }
            else
            {
                panelCampista.actualizar( campista );
            }
        }

    }

    /**
     * Busca la carpa ingresada por el usuario
     */
    public void buscarCarpa( )
    {
        String numeroCarpa = JOptionPane.showInputDialog( this, "Ingrese el número de la carpa buscada" );
        if( numeroCarpa != null )
        {
            if( numeroCarpa.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar el número de la carpa", "Buscar Carpa", JOptionPane.WARNING_MESSAGE );
            }
            else
            {
                try
                {
                    int numCarpa = Integer.parseInt( numeroCarpa );
                    int posicion = zonaDeCamping.buscarCarpa( numCarpa );
                    if( posicion == -1 )
                    {
                        JOptionPane.showMessageDialog( this, "No hay ninguna carpa con número " + numeroCarpa, "Buscar Carpa", JOptionPane.WARNING_MESSAGE );
                    }
                    else
                    {
                        carpaActual = posicion;
                        panelCarpa.actualizar( );
                    }
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico", "Buscar Carpa", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
    }

    /**
     * Elimina el campista con la cédula ingresada
     */
    public void eliminarCampista( )
    {
        String cedula = JOptionPane.showInputDialog( this, "Ingrese la cédula del campista que desea eliminar" );
        if( cedula != null )
        {
            if( cedula.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar una cédula", "Eliminar campista", JOptionPane.WARNING_MESSAGE );
            }
            else
            {
                boolean elimino = zonaDeCamping.eliminarCampista( cedula );
                if( elimino )
                {
                    String mensaje = "El campista con cédula " + cedula + " fue eliminado";
                    JOptionPane.showMessageDialog( this, mensaje, "Eliminar campista", JOptionPane.INFORMATION_MESSAGE );
                    actualizar( );
                }
                else
                {
                    String mensaje = "El campista con cédula" + cedula + "no se encuentra en la zona de camping";
                    JOptionPane.showMessageDialog( this, mensaje, "Buscar campista", JOptionPane.WARNING_MESSAGE );
                }
            }
        }
    }
    
    /**
     * Actualiza la información en los páneles
     */
    public void actualizar( )
    {
        eliminarDatosCampista( );
        panelInformacion.actualizar( );
        panelCarpa.actualizar( );
    }
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = zonaDeCamping.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = zonaDeCamping.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args -
     */
    public static void main( String[] args )
    {
        InterfazZonaDeCamping interfaz = new InterfazZonaDeCamping( );
        interfaz.setVisible( true );
    }

}
