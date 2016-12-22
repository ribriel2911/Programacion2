package Ej1;

public class Nodo<x>{

	public x elem;
	public Nodo<x> sig;
	public Nodo<x> ant;
	
	Nodo (x e){
		this.elem = e;
		this.sig = null;
		this.ant = null;
	}


}
