package Clase11;

public class ListaConSumatoria {

	private NodoInt prim;

	/**
	 * M�todo sumatoria() implementado iterativamente.
	 */
	public int sumatoria_iter() {
		int sum = 0;
		NodoInt nodo = prim;

		while (nodo != null) {
			sum += nodo.val;
			nodo = nodo.sig;
		}
		return sum;
	}

	/**
	 * M�todo sumatoria() implementado recursivamente.
	 *
	 * Delega a una funci�n recursiva EST�TICA.
	 */
	public int sumatoria() {
		return sumatoria_rec(this.prim);
	}

	/**
	 * Sumatoria recursiva para sumar desde un nodo.
	 */
	private static int sumatoria_rec(NodoInt nodo) {
		if (nodo == null)
			return 0;
		return nodo.val + sumatoria_rec(nodo.sig);

	}

	// Resto de m�todos de la lista...
}
