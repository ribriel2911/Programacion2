package ejercicios.cola;

public class ColaInt {

	//Creo clase Nodo con constructor
	public class Nodo{
		
		int elem;
		Nodo sig;
		
		Nodo(int elemento,Nodo siguiente){
			this.elem = elemento;
			this.sig = siguiente;
		}
	}

	Nodo prim;
	Nodo ulti;

	//Considero que encolar agrega un nuevo elemento al final de la cola
	public void encolar(int x){
		
		//Crea un nodo nuevo con el nuevo elemento
		Nodo nodoX = new Nodo(x,null);
		
		//Si la cola esta vacia señala al primero y al ultimo como el nuevo elemento
		if  (vacia()){
				prim = nodoX;
				ulti = prim;
		}
		//Sino señala al ultimo como el nuevo elemento
		else{	
			ulti.sig = nodoX;
			ulti = ulti.sig;
		}
	}

	//Considero que desencolar retira el primer elemento de la cola y lo retorna
	public Integer desencolar(){
			
		//Guarda el valor del primer elemento de la cola
		Integer desencolado = primero();
			
		//Si la cola no esta vacia reasigna al siguiente como primero de la cola
		if (!vacia()){
			prim = prim.sig;
		}
		
		return desencolado;
	}

	//Considero que vacia devuelve verdadero o falso si la cola esta vacia
	public boolean vacia(){
			
		return (prim==null);
	}

	//Considero que primero retorna el primer elemento de la cola sin reemplazarlo
	public Integer primero(){
			
		Integer primero = null;
			
		//Si la cola no esta vacia, guarda el valor del primer elemento;
		if (!vacia()){
			primero = prim.elem;
		}
			
		return primero;
	}
}
