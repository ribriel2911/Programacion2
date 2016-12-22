package SYE;

public class serpiente {
	
	private	int cola;		//posicion de la cola de la serpiente
	private int cabeza;		//posicion de la cabeza de la serpiente
	
	public serpiente(int n,int m){
		cola = n;
		cabeza = m;
	}

	public int getCola() {
		return cola;
	}

	public void setCola(int comienzo) {
		cola = comienzo;
	}
 
	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int fin) {
		this.cabeza = fin;
	}
}