package Clase07;

public class Nodo<T> {

	T val;
	Nodo<T> sig;

	Nodo(T v, Nodo<T> n) {
		val = v;
		sig = n;
	}
}
