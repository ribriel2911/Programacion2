package EnClase;

import Libre.Nodo;

public class AB<x> {

	Nodo<x> raiz;
	
	int cantNodos(){
		
		return cantNodos(raiz);
	}
	
	int cantNodos(Nodo<x> nod){
		
		if (nod==null) return 0;
		
		return 1+cantNodos(nod.izq)+cantNodos(nod.der);
	}
	
	int altura(){
		return altura(raiz);
	}
	
	int altura(Nodo<x> nod){
		
		if(nod==null) return 0;
		
		return 1 + Math.max(altura(nod.izq), altura(nod.der));
	}
	
	boolean esBalanceado(){
		
		return esBalanceado(raiz);
	}
	
	boolean esBalanceado(Nodo<x> nod){
		
		if(nod==null) return true;
		
		if(((altura(nod.izq)-altura(nod.der))>1)||((altura(nod.izq)-altura(nod.der))<-1)) return false;
		
		return esBalanceado(nod.izq) && esBalanceado(nod.der);
	}
	
	int cantHojas(){
		
		return cantHojas(raiz);
	}
	
	int cantHojas(Nodo<x> nod){
		
		if(nod==null) return 0;
		
		if((nod.izq==null) && (nod.der==null)) return 1;
		
		return cantHojas(nod.izq)+cantHojas(nod.der);
	}
	
	int cantNodos_Nivel(int niv){
		
		return cantNodos_Nivel(raiz, niv);
	}
	
	int cantNodos_Nivel(Nodo<x> nod,int niv){
		
		if(nod==null) return 0;
		
		if(niv==0) return 1;
		
		return cantNodos_Nivel(nod.izq,niv-1) + cantNodos_Nivel(nod.der,niv-1);
	}
	
	Nodo<Integer> eliminar(int x, Nodo<Integer> p){
		
		if(p==null) return null;
		
		if(x==p.elem){
			
			if(p.izq==null) return p.der;
			
			if(p.der==null) return p.izq;
			
			int cambio = (Integer) p.izq.elem; //linea fatidica
			p.elem = cambio;
			p.izq = eliminar(cambio,p.izq);
		}
		
		else if(x<p.elem) p.izq = eliminar(x,p.izq);
		
		else if(x>p.elem) p.der = eliminar(x,p.der);
		
		return p;
	}
	
	static boolean sonMenores(int val, Nodo<Integer> nod){
		
		if(nod==null) return true;
		
		if(nod.elem>val) return false;
		
		return sonMenores(val,nod.izq) && sonMenores(val,nod.der);
	}
	
	static boolean sonMayores(int val, Nodo<Integer> nod){
		
		if(nod==null) return true;
		
		if(nod.elem<val) return false;
		
		return sonMayores(val,nod.izq) && sonMayores(val,nod.der);
	}
	
	static boolean es_ABB_exponencial(Nodo<Integer> nod){
		
		if(nod==null) return true;
		
		if(!sonMenores(nod.elem,nod.izq)) return false;
		
		if(!sonMayores(nod.elem,nod.der)) return false;
		
		return es_ABB_exponencial(nod.izq) && es_ABB_exponencial(nod.der);
	}
	
	static boolean es_ABB(Nodo<Integer> nod, Integer menor, Integer mayor){
		
		if(nod==null) return true;
		
		if((menor!=null) && (nod.elem<menor)) return false;
		
		if((mayor!=null) && (nod.elem>mayor)) return false;
		
		return es_ABB(nod.izq,menor,nod.elem) && es_ABB(nod.der,nod.elem,mayor);
	}
}
