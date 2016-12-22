package Clase07;

public class UsoTupla {

	public static void main(String[] args) {
		Tupla<Integer, Integer> t1 = new Tupla<Integer, Integer>(7, 3);

		// Los enteros se pueden sumar.
		System.out.println(t1.fst() + t1.snd());

		Tupla<String, String> t2 =
		    new Tupla<String, String>("hola", "mundo");

		// Las cadenas se pueden concatenar.
		System.out.println(t2.fst() + " " + t2.snd());

		// Los enteros s� se pueden multiplicar, tambi�n.
		System.out.println(t1.fst() * t1.snd());

		// XXX No compila porque el operador * no est� definido para String.
		// System.out.println(t2.fst() * t2.snd());
	}
}
