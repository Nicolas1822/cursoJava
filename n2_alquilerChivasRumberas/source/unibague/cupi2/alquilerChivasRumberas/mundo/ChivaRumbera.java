package unibague.cupi2.alquilerChivasRumberas.mundo;

public class ChivaRumbera {

	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------
	
	private String nombre;
	private String tamanio;
	private double precioHora;
	private boolean disponible;
	private int vecesAlquilado;
	private double dineroRecaudado;
	
	
	//--------------------------------------------------------------------------
	//Constructor
	//--------------------------------------------------------------------------
	
	public ChivaRumbera (String pNombre, String pTamanio, double pPrecio)
	{
		this.nombre = pNombre;
		this.tamanio = pTamanio;
		this.precioHora = pPrecio;
		disponible = true;
		vecesAlquilado = 0;
		dineroRecaudado =  0.0;
	}
	
	//--------------------------------------------------------------------------
	//Metodos
	//--------------------------------------------------------------------------
	
	public String darNombre() {
		return nombre;
	}
	public String darTamanio() {
		return tamanio;
	}
	public double darPrecioHora() {
		return precioHora;
	}
	public boolean darDisponibilidad() {
		return disponible;
	}
	public int darVecesAlquilado() {
		return vecesAlquilado;
	}
	public double darDineroRecaudado() {
		return dineroRecaudado;
	}
	
	public double alquilarChivaRumbera( int pHoras)
	{
		vecesAlquilado++;
		disponible = false;
		
		double porcentajeDescuento = darDescuento(pHoras);
		double valorAlquiler = (precioHora * pHoras) - (precioHora * pHoras * porcentajeDescuento);
		
		dineroRecaudado += valorAlquiler;
		
		return valorAlquiler;
	}
	
	public void devolverChivaRumbera()
	{
		disponible =true;
	}
	
	public void reiniciar() {
		disponible = true;
		vecesAlquilado = 0;
		dineroRecaudado = 0.0;
	}
	
	public double darDescuento (int pHoras)
	{
		double porcentaje = 0.0;
		
		if(pHoras <= 2)
		{
			porcentaje = 0.0;
		}
		else if (pHoras >= 3 && pHoras <= 6)
		{
			porcentaje = 0.05;
		}
		else if (pHoras >= 7 && pHoras <= 12)
		{
			porcentaje = 0.08;
		}
		else if (pHoras >= 13 && pHoras <= 24)
		{
			porcentaje = 0.10;
		}
		else 
		{
			porcentaje = 0.15;
		}
		
		return porcentaje;
	}
}
