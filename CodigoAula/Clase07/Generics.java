package Clase07;

import java.util.ArrayList;

public class Generics {

	public static void aceptaListInteger(ArrayList<Integer> l) {
	}

	public static void Main(String args[]) {
		ArrayList<String> ls = new ArrayList<String>();
		ArrayList<Integer> li = new ArrayList<Integer>();

		// Funciona porque a�adimos elementos del tipo correcto.
		ls.add("hola");
		li.add(7);

		// XXX No compilar�a por ser del tipo incorrecto.
		// ls.add(7);
		// li.add("hola");

		// Lo mismo ocurre al pasar la lista en s�:

		// Funciona.
		aceptaListInteger(li);

		// XXX No compila.
		// aceptaListInteger(ls);
	}
}
