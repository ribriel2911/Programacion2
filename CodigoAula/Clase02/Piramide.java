package Clase02;

public class Piramide {
	// TODO: Decidir c�mo representar el TAD internamente.

	// 1: private int[] elems;
	// 2: private List<Integer> elems;
	// 3: private int[][] elems;
	// 4: crear un TAD Nivel.

	public Piramide(int numNiveles) {
	}

	/**
	 * Agrega un entero a la pir�mide.
	 *
	 * Devuelve falso si la pir�mide estaba llena.
	 */
	boolean agregar(int x) {
		return false;
	}

	/**
	 * Elimina el �ltimo elemento de la pir�mide.
	 *
	 * No hace nada si la pir�mide estaba vac�a.
	 */
	void quitar() {
	}

	/**
	 * Devuelve el elemento en la posici�n indicada.
	 *
	 * Los niveles y los �ndices de cada nivel empiezan en 0.
	 */
	int obtener(int nvl, int idx) throws RuntimeException {
		throw new RuntimeException("mensaje descriptivo");
	}
}
