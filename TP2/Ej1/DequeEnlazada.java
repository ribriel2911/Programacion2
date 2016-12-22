package Ej1;

import java.util.Collection;
import java.util.Deque;
import java.util.NoSuchElementException;


public class DequeEnlazada<T> extends DequeBase<T> implements Deque<T> {
	
	public Nodo<T> primero;
	public Nodo<T> ultimo;
	
	private boolean agregarDequeVacio(T e){
		if (isEmpty()){
			primero = new Nodo<T>(e);
			ultimo = primero;
			return true;
		}
		return false;
	}
	
	private void borrarNodo(Nodo<T> n){
		
		Nodo<T> aux;
		
		if(n.ant==null){
			
			if(n.sig!=null){
				
				n = n.sig;
				primero = n;
				primero.ant = null;
			}
			
			else{
				primero = null;
				ultimo = null;
			}
		}
		
		else{
			
			if(n.sig!=null){
			
				aux = n.ant;
				aux.sig = n.sig;
				n = n.sig;
				n.ant = aux;
			}
			
			else{
				
				n = n.ant;
				n.sig = null;
				ultimo = n;
			}
		}
	}
	
	@Override
	public void addFirst(T e) {
		if (! agregarDequeVacio(e)){
			
			Nodo<T> nuevo = new Nodo<T>(e);
			nuevo.sig = primero;
			primero.ant = nuevo;
			
			primero = nuevo;
		}
	}

	@Override
	public void addLast(T e) {
		if (! agregarDequeVacio(e)){
			Nodo<T> nuevo = new Nodo<T>(e);
			ultimo.sig = nuevo;
			nuevo.ant = ultimo;
			
			ultimo = nuevo;
		}
	}

	@Override
	public T getFirst() {
	
		if(isEmpty()){
		
			throw new NoSuchElementException("Deque vacio!!!");
		}
		
		return primero.elem;
	}

	@Override
	public T getLast() {
		return ultimo.elem;
	}

	// Sugerencia: para las cuatro primitivas de borrado, usar una misma función
	// auxiliar:
	//
	//      private T borrarNodo(Nodo<T> nodo);

	@Override
	public T removeFirst() {
		
		if(isEmpty()){
			
			throw new NoSuchElementException("Deque vacio!!!");
		}
		
		Nodo<T> ret = primero;
		
		borrarNodo(primero);
		
		return ret.elem;
	}
	
	@Override
	public T removeLast() {
		
		Nodo<T> ret = ultimo;
		
		borrarNodo(ultimo);
		
		return ret.elem;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		
		Nodo<T> actual;
		
		actual = primero;
		
		while (actual!= null){
			
			if(actual.elem.equals(o)){
				
				borrarNodo(actual);	
				return true;				
			}			
			
			actual = actual.sig;
		}
		
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {

		Nodo<T> actual;
		
		actual = ultimo;
		
		while (actual!= null){
			
			if(actual.elem.equals(o)){
				
				borrarNodo(actual);
				return true;				
			}					
			
			actual = actual.ant;
		}
		
		return false;
	}

	@Override
	public int size() {
		
		Nodo<T> actual = primero;
		int cont = 0;
		
		while(actual!=null){
			cont++;
			actual = actual.sig;
		}
		return cont;
	}	
	
	//
	// Métodos de Collection.
	//

	@Override
	public boolean isEmpty() {
		if (primero!=null) return false;
		return true;
	}

	@Override
	public void clear() {
		
		primero = null;
		ultimo = null;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		for(T elem : c){
			
			addLast(elem);
		}
		
		return !c.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		Nodo<T> actual = primero;
		
		while(actual!=null){
			if (actual.elem.equals(o)) return true;
			
			actual = actual.sig;
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		for (Object elem : c){
			
			if(!contains(elem)) return false;
		}
		
		return true;
	}
}
