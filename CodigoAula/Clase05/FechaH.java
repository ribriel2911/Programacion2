package Clase05;

public class FechaH {

	private int diasEC;

	public FechaH(int dia, int mes, int a�o) {
		// if !verificar(dia, mes, a�o)
		//    ERROR.

		diasEC = calcularDia(dia, mes, a�o);
	}

	public void sumarDias(int numDias) {
		diasEC += numDias;
	}
	
	static int calcularDia(int dia, int mes, int a�o){
		int ret = (a�o*365)+(mes*31)+dia;
		
		return ret;
	}
}
