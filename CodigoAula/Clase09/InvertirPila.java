package Clase09;

import java.util.LinkedList;
import java.util.Queue;

import Clase04.PilaEnlazada;
import Clase04.PilaInt;

public class InvertirPila {
	/**
	 * Invierte la pila �p�. No devuelve nada, la modifica.
	 *
	 * Usa una cola para �darle la vuelta�. Ver versi�n incorrecta
	 * abajo.
	 */
	public static void invertirPila(PilaInt p) {
		Queue<Integer> cola = new LinkedList<Integer>();  // Se podr�a usar nuestra ColaInt tambi�n.

		while (!p.vacia())
			cola.add(p.desapilar());

		while (!cola.isEmpty())
			p.apilar(cola.remove());
	}

	/*** VERSI�N INCORRECTA ***/

	public static void invertirPila_INCORRECTA(PilaInt p) {
		PilaInt p2 = new PilaEnlazada();

		while (!p.vacia())
			p2.apilar(p.desapilar());

		// �p2� es la inversa de �p�, s�; pero la siguiente
		// asignaci�n NO tiene efecto fuera de la funci�n.
		p = p2;  // XXX no funciona.
	}

	public static void main(String args[]) {
		PilaInt pila = new PilaEnlazada();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);

		invertirPila_INCORRECTA(pila);
		System.out.println(pila.tope());
	}
}
