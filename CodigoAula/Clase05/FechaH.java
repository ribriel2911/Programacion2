package Clase05;

public class FechaH {

	private int diasEC;

	public FechaH(int dia, int mes, int año) {
		// if !verificar(dia, mes, año)
		//    ERROR.

		diasEC = calcularDia(dia, mes, año);
	}

	public void sumarDias(int numDias) {
		diasEC += numDias;
	}
	
	static int calcularDia(int dia, int mes, int año){
		int ret = (año*365)+(mes*31)+dia;
		
		return ret;
	}
}
