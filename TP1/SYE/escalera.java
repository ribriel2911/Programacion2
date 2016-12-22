package SYE;

public class escalera {

	private int entrada;	//posicion de la base de la escalera
	private int salida;		//posicion del tope de la escalera

	escalera(int n, int m){
		entrada = n;
		salida = m;
	}
	
	
	public int getCom() {
		return entrada;
	}
	
	
	public void setCom(int n) {
		entrada = n;
	}
	
	
	public int getFin() {
		return salida;
	}
	
	
	public void setFin(int n) {
		salida = n;
	}
}
