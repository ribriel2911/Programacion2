package Clase05;

public class FechaL {

	private int d, m, a;

	public FechaL(int dia, int mes, int a�o) {
		// if !verificar(dia, mes, a�o)
		//    ERROR.

		d = dia;
		m = mes;
		a = a�o;
	}

	public void avanzarDias(int numDias) {
	}

	public void avanzarMes(int numMeses) {
	}

	@Override
	public String toString() {
		return d + "/" + m + "/" + a;
	}

}
