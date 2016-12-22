package Libre;

public class Nodo<x> {
	
	public x elem;
	public Nodo<x> izq;
	public Nodo<x> der;
	
	Nodo (x e){
		this.elem = e;
		this.izq = null;
		this.der = null;
	}

}
