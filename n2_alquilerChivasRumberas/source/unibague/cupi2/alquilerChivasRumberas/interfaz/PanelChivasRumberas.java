/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelChivasRumberas.java 2012-09-24 18:00:00Z andres.arciniegas $
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
import javax.swing.JPanel;

import unibague.cupi2.alquilerChivasRumberas.mundo.ChivaRumbera;

/**
 * Panel que contiene la información de las cuatro chivas rumberas 
 */
public class PanelChivasRumberas extends JPanel 
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
     * La ventana principal
     */
    private InterfazAlquilerChivasRumberas principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información de la chiva rumbera 1
     */
    private PanelChivaRumbera panelChivaRumbera1;
    
    /**
     * Panel con la información de la chiva rumbera 2
     */
    private PanelChivaRumbera panelChivaRumbera2;
    
    /**
     * Panel con la información de la chiva rumbera 3
     */
    private PanelChivaRumbera panelChivaRumbera3;
    
    /**
     * Panel con la información de la chiva rumbera 4
     */
    private PanelChivaRumbera panelChivaRumbera4;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel, se encarga de inicializar todos los datos
     * @param pPrincipal Una referencia de la ventana principal de la aplicación
     * @param chivaRumbera1 Chiva rumbera 1 de la empresa
     * @param chivaRumbera2 Chiva rumbera 2 de la empresa
     * @param chivaRumbera3 Chiva rumbera 3 de la empresa
     * @param chivaRumbera4 Chiva rumbera 4 de la empresa
     */
    public PanelChivasRumberas( InterfazAlquilerChivasRumberas pPrincipal, ChivaRumbera chivaRumbera1, 
    							ChivaRumbera chivaRumbera2, ChivaRumbera chivaRumbera3, ChivaRumbera chivaRumbera4 )
    {
        principal = pPrincipal;

        setLayout( new GridLayout( 2, 2 ) );

        panelChivaRumbera1 = new PanelChivaRumbera( principal, chivaRumbera1.darNombre( ) );
        panelChivaRumbera2 = new PanelChivaRumbera( principal, chivaRumbera2.darNombre( ) );
        panelChivaRumbera3 = new PanelChivaRumbera( principal, chivaRumbera3.darNombre( ) );
        panelChivaRumbera4 = new PanelChivaRumbera( principal, chivaRumbera4.darNombre( ) );

        panelChivaRumbera1.ingresarDatos( chivaRumbera1 );
        panelChivaRumbera2.ingresarDatos( chivaRumbera2 );
        panelChivaRumbera3.ingresarDatos( chivaRumbera3 );
        panelChivaRumbera4.ingresarDatos( chivaRumbera4 );

        add( panelChivaRumbera1 );
        add( panelChivaRumbera2 );
        add( panelChivaRumbera3 );
        add( panelChivaRumbera4 );

    }


    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza los paneles de los dulces
     * @param chivaRumbera1 Chiva rumbera 1 de la empresa
     * @param chivaRumbera2 Chiva rumbera 2 de la empresa
     * @param chivaRumbera3 Chiva rumbera 3 de la empresa
     * @param chivaRumbera4 Chiva rumbera 4 de la empresa
     */
    public void actualizar( ChivaRumbera chivaRumbera1, ChivaRumbera chivaRumbera2, 
    						ChivaRumbera chivaRumbera3, ChivaRumbera chivaRumbera4 )
    {
            panelChivaRumbera1.ingresarDatos( chivaRumbera1 );
            panelChivaRumbera2.ingresarDatos( chivaRumbera2 );
            panelChivaRumbera3.ingresarDatos( chivaRumbera3 );
            panelChivaRumbera4.ingresarDatos( chivaRumbera4 );
    }

}
