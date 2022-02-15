/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazAlquilerChivasRumberas.java 2012-09-10 18:00:00Z andres.arciniegas $
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

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import unibague.cupi2.alquilerChivasRumberas.mundo.Empresa;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazAlquilerChivasRumberas extends JFrame 
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Panel con los dulces
     */
    private PanelChivasRumberas panelChivas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor principal de la aplicación
     */
    public InterfazAlquilerChivasRumberas( )
    {
        setTitle( "Alquiler de Chivas Unibague" );
        // Crea la clase principal
        empresa = new Empresa( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 880, 620 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Creación de los paneles aquí
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        // Centrar la ventana
        setLocationRelativeTo( null );

        panelChivas = new PanelChivasRumberas( this, empresa.darChivaRumbera1( ), empresa.darChivaRumbera2( ), empresa.darChivaRumbera3( ), empresa.darChivaRumbera4( ) );
        add( panelChivas, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Requerimientos funcionales
    // -----------------------------------------------------------------
       
    /**
     * Alquila una chiva rumbera dado su nombre
     * @param nombreChiva Nombre de la chiva a alquilar
     */
    public void alquilarChivaRumbera( String nombreChiva )
    {
    	String sHoras = JOptionPane.showInputDialog( "Cantidad de horas a alquilar la chiva " + nombreChiva );
    	try
    	{
	    	if( sHoras != null )
	    	{
	    		int horas = Integer.parseInt( sHoras );
		    	if( horas > 0)
		    	{
		    		double valor = empresa.alquilarChivaRumbera( nombreChiva, horas );
		    		
		    		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		            df.applyPattern( "$ ###,###.##" );
		            
		    		JOptionPane.showMessageDialog( this, "Valor del alquiler: " + df.format( valor ) , "Alquilar Chiva Rumbera", JOptionPane.INFORMATION_MESSAGE );
		    		actualizar();
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog( this, "La cantidad debe ser mayor a 0", "Problema", JOptionPane.WARNING_MESSAGE );
		    	}
	    	}
    	}
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Es necesario ingresar un número", "Problema", JOptionPane.WARNING_MESSAGE );
        }
    }
    
    /**
     * Actualiza el panel ChivaRumbera con la información recién obtenida
     * @param nombre La chiva rumbera que se acaba de Actualizar
     */
    private void actualizar(  )
    {
        panelChivas.actualizar( empresa.darChivaRumbera1( ), empresa.darChivaRumbera2( ), empresa.darChivaRumbera3( ), empresa.darChivaRumbera4( ) );
    }


    /**
     * Devuelve una chiva rumbera que estaba alquilada dado su nombre
     * @param nombreChiva Nombre de la chiva a alquilar
     */
    public void devolverChivaRumbera( String nombreChiva )
    {
    	empresa.devolverChivaRumbera(nombreChiva);
    	JOptionPane.showMessageDialog( this, "Chiva devuelta satisfactoriamente" , "Devolver Chiva Rumbera", JOptionPane.INFORMATION_MESSAGE );
    	actualizar( );
    }
    
    
    /**
     * Determina cual es la chiva rumbera más alquilada y la muestra en pantalla
     */
	public void calcularChivaMasAlquilada()
	{
		JOptionPane.showMessageDialog(this, "La chiva rumbera más alquilada es: " + empresa.darChivaRumberaMasAlquilada().darNombre() + 
				" y ha sido alquilada " + empresa.darChivaRumberaMasAlquilada().darVecesAlquilado() + " veces.", "Chiva rumbera más alquilada", 
				JOptionPane.INFORMATION_MESSAGE  );
	}
	
	
    /**
     * Determina cual es la chiva rumbera menos alquilada y la muestra en pantalla
     */
	public void calcularChivaMenosAlquilada()
	{
		JOptionPane.showMessageDialog(this, "La chiva rumbera menos alquilada es: " + empresa.darChivaRumberaMenosAlquilada().darNombre() + 
				" y ha sido alquilada " + empresa.darChivaRumberaMenosAlquilada().darVecesAlquilado() + " veces.", "Chiva rumbera menos alquilada", 
				JOptionPane.INFORMATION_MESSAGE  );
	}
	

    /**
     * Calcula el valor total recaudado por alquiler de todas las chivas rumberas
     */
	public void calcularTotalRecaudado()
	{
		double valor = empresa.darTotalRecaudado();
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );

		JOptionPane.showMessageDialog( this, "El total recaudado es: " + df.format( valor ), "Total Recaudado", JOptionPane.INFORMATION_MESSAGE );
	}
	

    /**
     * Reinicia los datos de todas las chivas rumberas
     */
	public void reiniciar()
	{
		empresa.darChivaRumbera1().reiniciar();
		empresa.darChivaRumbera2().reiniciar();
		empresa.darChivaRumbera3().reiniciar();
		empresa.darChivaRumbera4().reiniciar();
		panelChivas.actualizar(empresa.darChivaRumbera1(), empresa.darChivaRumbera2(), empresa.darChivaRumbera3(), empresa.darChivaRumbera4());

		JOptionPane.showMessageDialog( this, "Las Chivas Rumberas han sido reiniciadas", "Total Recaudado", JOptionPane.INFORMATION_MESSAGE );
	}
	
	
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresa.metodo1( );
    	JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresa.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 3
     */
    public void reqFuncOpcion3( )
    {
        String resultado = empresa.metodo3( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 4
     */
    public void reqFuncOpcion4( )
    {
        String resultado = empresa.metodo4( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        try
        {
	        InterfazAlquilerChivasRumberas interfaz = new InterfazAlquilerChivasRumberas( );
	        interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }

}
