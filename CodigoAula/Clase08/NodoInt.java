package Clase08;

public class NodoInt {

	int val;
	NodoInt sig;

	NodoInt(int i) {
		val = i;
	}

	NodoInt(int i, NodoInt n) {
		val = i;
		sig = n;
	}
}
