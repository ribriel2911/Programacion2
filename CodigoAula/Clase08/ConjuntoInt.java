package Clase08;

/**
 * TDA "Conjunto de enteros".
 *
 * El conjunto es no ordenado, y no admite duplicados.
 */
public interface ConjuntoInt {

	/**
	 * Agrega un elemento al conjunto.
	 *
	 * Devuelve true si el elemento no pertenec�a previamente al
	 * conjunto (esto es, se agreg�); falso si el elemento ya
	 * pertenec�a.
	 */
	public boolean agregar(int x);

	/**
	 * Devuelve true si el elemento pertenece al conjunto.
	 */
	public boolean pertenece(int x);

	/**
	 * Elimina un elemento del conjunto.
	 *
	 * Devuelve true si el elemento pertenec�a al conjunto, false en
	 * caso de no pertenecer.
	 */
	public boolean quitar(int x);

	/**
	 * Devuelve true si el conjunto est� vac�o.
	 */
	public boolean vacio();

	/**
	 * Devuelve el n�mero de elementos en el conjunto.
	 */
	public int len();
}
