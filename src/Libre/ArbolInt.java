package Libre;

public class ArbolInt {

	Nodo<Integer> copa;
	
	void agregar(int n){
		
		if (copa==null){
			Nodo<Integer> nodo = new Nodo<Integer>(n);
			copa = nodo;
		}
		else{
			Nodo<Integer> nodo = copa;
			boolean flag = false;
			boolean Esta = false;
			while (!flag && !Esta){
				if(n>nodo.elem){
					if (nodo.der!=null){
					nodo = nodo.der;
					}
					else{
						nodo.der = new Nodo<Integer>(n);
						flag = true;
					}
				}
				else{
					if (n<nodo.elem){
						if(nodo.izq!=null){
						nodo = nodo.izq;
						}
						else{
							nodo.izq = new Nodo<Integer>(n);
							flag = true;
						}
					}
					else{
						Esta = true;
					}
				}
			}
		}
	}
	
	void imprimir(){
		
		Nodo<Integer> nodo = copa;
		while (nodo!=null){
			System.out.println(nodo.elem);
			nodo = nodo.izq;
		}
		
		nodo = copa.der;
		while (nodo!=null){
			System.out.println(nodo.elem);
			nodo = nodo.der;
		}
	}
	
	public static void main(String[] args) {
		ArbolInt arbol = new ArbolInt();
		
		arbol.agregar(5);
		arbol.agregar(10);
		arbol.agregar(1);
		arbol.agregar(7);
		
		arbol.imprimir();

	}

}
