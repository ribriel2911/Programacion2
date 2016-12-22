package Clase04;

import java.util.LinkedList;

public class PilaLL {

	private LinkedList<Integer> elems;

	public PilaLL() {
		elems = new LinkedList<Integer>();
	}

	public void apilar(int x) {
		elems.addFirst(x);
	}

	public boolean vacia() {
		return elems.isEmpty();
	}

	public Integer tope() {
		return elems.peekFirst();
	}

	public Integer desapilar() {
		return elems.pollFirst();
	}
}
