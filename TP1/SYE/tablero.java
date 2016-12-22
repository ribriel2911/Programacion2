package SYE;

import java.util.ArrayList;

public class tablero {
	
	private int tamano;												//tamanio del tablero
	private ArrayList<serpiente> serpientes;						//sepientes en el tablero
	private ArrayList<escalera> escaleras;							//escaleras en el tablero
	private jugador[] jugadores;									//jugadores en el tablero
	private dado dado;												//dado del tablero
	
	public int getTamano() {
		return tamano;
	}

	public ArrayList<serpiente> getSerpientes() {
		return serpientes;
	}

	public ArrayList<escalera> getEscaleras() {
		return escaleras;
	}

	public jugador[] getJugadores() {
		return jugadores;
	}

	public dado getDado() {
		return dado;
	}

	public tablero(int tam,int jug){								//el constructor recibe el tamanio del tablero deseado
																	//y la cantidad de jugadores en el mismo
		tamano = tam;
		serpientes = new ArrayList<serpiente>();
		escaleras = new ArrayList<escalera>();
		jugadores = new jugador[jug];
		
		for (int i=0;i<jugadores.length;i++){						//crea los jugadores con el numero correspondiente a cada uno por defecto
			jugadores[i] = new jugador(""+i);
		}
		
		dado = new dado();
	}
	
	public boolean cambiarNombre(String nuevoNom, int jugador){		//cambia el nombre del jugador deseado
		
		String ant = jugadores[jugador].getNombre();
		jugadores[jugador].setNombre(nuevoNom);
		
		if(jugadores[jugador].getNombre().equals(ant)) return false;
		
		return true;
	}
	
	public boolean agregarSerpiente(int n, int m) {					//crea serpiente en el tablero
		
		if(n<0 || m<0 || n>tamano || m>tamano || m>=n){ 			//controla q el ingreso sea correcto
			return false;											//y que no se exceda el tablero
		}
		
		for(serpiente serpiente : serpientes){						//que no haya ninguna cola de serpiente
			if(serpiente.getCola()==n){								//en el mismo lugar
				return false;
			}
		}
		
		for(escalera escalera : escaleras){							//y que no haya una base de escalera
			if(escalera.getCom()==n){								//en el mismo lugar
				return false;
			}
		}
		
		return serpientes.add(new serpiente(n,m));					//si se cumple agrega la serpiente
	}
	
	
	public boolean agregarEscalera(int n, int m) {					//crea escalera en el tablero
		
		if(n<0 || m<0 || n>tamano || m>tamano || n>=m){				//controla q el ingreso sea correcto
			return false;											//y que no se exceda del tablero
		}
		
		for(serpiente serpiente : serpientes){						//controla que no haya una cola de serpiente
			if(serpiente.getCola()==n){								//en el mismo lugar
				return false;
			}
		}
		
		for(escalera escalera : escaleras){							//controla que no haya una base de escalera
			if(escalera.getCom()==n){								//en el mismo lugar
				return false;
			}
		}
		
		return escaleras.add(new escalera(n,m));					//si se cumple agrega la escalera
	}
	
	public boolean tirarDado(){
		dado.cambiarCara();
		return true;
	}
	
	
	public boolean moverJugador(int j, int p){
		
		if (p>=tamano){
			jugadores[j].setPosicion(tamano);
			return false;
		}
		jugadores[j].setPosicion(p);
		return true;
	}
	
	public boolean informar(int j,String estado){
		jugadores[j].setEstado(estado);
		return true;

	}
}
