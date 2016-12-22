package Clase03;

import java.util.ArrayList;
import java.util.List;

public class Nivel {

	private int lim;
	private List<Integer> elems;

	Nivel(int niv) {
		lim = niv + 1;
		elems = new ArrayList<Integer>();
	}

	boolean lleno() {
		return elems.size() > lim;
	}

	boolean agregar(int x) {
		if (!lleno()) {
			return elems.add(x);
		}
		return false;
	}

	int obtener(int idx) {
		return elems.get(idx);
	}
}
