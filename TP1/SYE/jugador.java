package SYE;

public class jugador {
	
	private int posicion;				//Posicion del jugador en el tablero.
	private String nombre;				//Nombre del jugador.
	private String estado;				//Describe si el jugador cayo en una serpiente 
										//o escalera y su cambio de posicion en el tablero.

	
	jugador (String s){					//El constructor recibe el nombre del jugador y el tamanio del tablero.
		posicion = 0;
		nombre = "Jugador " + s;
		estado = "";
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int n) {
		posicion = n;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String s) {
		nombre = s;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String syE) {
		estado = syE;
	}
}
