package Clase11;

public class SumatoriaInt {

	/**
	 * Sumar los N primeros n�meros naturales, recursivamente.
	 *
	 * (TODO: A�n no verifica que N sea positivo.)
	 */
	public static int sumatoria(int n) {
		if (n == 0)
			return 0;// O bien: if (n == 1)
			         //             return 1;

		return n + sumatoria(n - 1);
	}

	/**
	 * Versi�n alternativa: sumar de menor a mayor.
	 *
	 * (Es m�s clara la versi�n anterior, pero esta idea de �sumar por
	 * la izquierda� ser� �til para SumatoriaList.)
	 */
	public static int sumatoria_izq(int n) {
		return sumatoria_rec(0, n);
	}

	private static int sumatoria_rec(int desde, int hasta) {
		if (desde > hasta)  // O bien: if (desde == hasta)
			return 0;       //             return desde;
		return desde + sumatoria_rec(desde + 1, hasta);
	}
}
