package unibague.cupi2.alquilerChivasRumberas.mundo;

public class Empresa {

	//--------------------------------------------------------------------------
	//Constantes
	//--------------------------------------------------------------------------
		
		public static final String PEQUENIA = "Pequenia";
		public static final String MEDIANA = "Mediana";
		public static final String GRANDE = "Grande";
		public static final String NOMBRE_CHIVA_RUMBERA_1 = "La Rumbera";
		public static final String NOMBRE_CHIVA_RUMBERA_2 = "La Fiestera";
		public static final String NOMBRE_CHIVA_RUMBERA_3 = "La Guapachosa";
		public static final String NOMBRE_CHIVA_RUMBERA_4 = "La Alegre";
		
	//--------------------------------------------------------------------------
	//Atributos
	//--------------------------------------------------------------------------
		
		private ChivaRumbera chivaRumbera1;
		private ChivaRumbera chivaRumbera2;
		private ChivaRumbera chivaRumbera3;
		private ChivaRumbera chivaRumbera4;
	//--------------------------------------------------------------------------
    //Constructor
	//--------------------------------------------------------------------------
		public Empresa()
		{
			chivaRumbera1 = new ChivaRumbera(NOMBRE_CHIVA_RUMBERA_1, PEQUENIA, 100000.0);
			chivaRumbera2 = new ChivaRumbera(NOMBRE_CHIVA_RUMBERA_2, MEDIANA, 150000.0);
			chivaRumbera3 = new ChivaRumbera(NOMBRE_CHIVA_RUMBERA_3, GRANDE, 230000.0);
			chivaRumbera4 = new ChivaRumbera(NOMBRE_CHIVA_RUMBERA_4, PEQUENIA, 100000.0);
		}
		
	//--------------------------------------------------------------------------
	//Metodos
	//--------------------------------------------------------------------------
		
		public ChivaRumbera darChivaRumbera1() {
			return chivaRumbera1;
		}

		public ChivaRumbera darChivaRumbera2() {
			return chivaRumbera2;
		}

		public ChivaRumbera darChivaRumbera3() {
			return chivaRumbera3;
		}

		public ChivaRumbera darChivaRumbera4() {
			return chivaRumbera4;
		}
	
		public void devolverChivaRumbera(String pNombre)
		{
			ChivaRumbera chiva = darChivaRumbera(pNombre);
			chiva.devolverChivaRumbera();
		}
		
		public ChivaRumbera darChivaRumbera(String pNombre)
		{
			ChivaRumbera chiva = null;
			
			if(chivaRumbera1.darNombre().equals(pNombre))
			{
				chiva = chivaRumbera1;
			}
			else if (chivaRumbera2.darNombre().equals(pNombre))
			{
				chiva = chivaRumbera2;
			}
			else if (chivaRumbera3.darNombre().equals(pNombre))
			{
				chiva = chivaRumbera3;
			}
			else if (chivaRumbera4.darNombre().equals(pNombre))
			{
				chiva = chivaRumbera4;
			}
			return chiva;
		}
		
		public double alquilarChivaRumbera(String pNombre, int pHoras)
		{
			ChivaRumbera chiva = darChivaRumbera(pNombre);
			double valorAlquiler = chiva.alquilarChivaRumbera(pHoras);
			return valorAlquiler;
		}
		
		
		public ChivaRumbera darChivaRumberaMasAlquilada()
		{
			ChivaRumbera chiva = chivaRumbera1;
			int cantidad = chivaRumbera1.darVecesAlquilado();
			
			if(chivaRumbera2.darVecesAlquilado() > cantidad)
			{
				chiva = chivaRumbera2;
				cantidad = chivaRumbera2.darVecesAlquilado();
			}
			if(chivaRumbera3.darVecesAlquilado() > cantidad)
			{
				chiva = chivaRumbera3;
				cantidad = chivaRumbera3.darVecesAlquilado();
			}
			if(chivaRumbera4.darVecesAlquilado() > cantidad)
			{
				chiva = chivaRumbera4;
				cantidad = chivaRumbera4.darVecesAlquilado();
			}
			
			return chiva;
		}
		
		public ChivaRumbera darChivaRumberaMenosAlquilada()
		{
			ChivaRumbera chiva = chivaRumbera1;
			int cantidad = chivaRumbera1.darVecesAlquilado();
			
			if(chivaRumbera2.darVecesAlquilado() < cantidad)
			{
				chiva = chivaRumbera2;
				cantidad = chivaRumbera2.darVecesAlquilado();
			}
			if(chivaRumbera3.darVecesAlquilado() < cantidad)
			{
				chiva = chivaRumbera3;
				cantidad = chivaRumbera3.darVecesAlquilado();
			}
			if(chivaRumbera4.darVecesAlquilado() < cantidad)
			{
				chiva = chivaRumbera4;
				cantidad = chivaRumbera4.darVecesAlquilado();
			}
			
			return chiva;
		}
		
		public double darTotalRecaudado() 
		{
			return chivaRumbera1.darDineroRecaudado() + chivaRumbera2.darDineroRecaudado() +
				   chivaRumbera3.darDineroRecaudado() + chivaRumbera4.darDineroRecaudado();
		}
	
		public boolean verificarDisponibilidad(String pNombre) 
		{
			ChivaRumbera chiva = darChivaRumbera(pNombre);
			boolean disponibilidad = chiva.darDisponibilidad();
			return disponibilidad;
		}
		
		public void reiniciar()
		{
			chivaRumbera1.reiniciar();
			chivaRumbera2.reiniciar();
			chivaRumbera3.reiniciar();
			chivaRumbera4.reiniciar();
			
		}
		
		public String metodo1() 
		{
			return "Respuesta 1";
		}
		
		public String metodo2() 
		{
			return "Respuesta 2";
		}
		
		public String metodo3() 
		{
			return "Respuesta 3";
		}
		
		public String metodo4() 
		{
			return "Respuesta 5";
		}
		
		
		
		
}
