package SYE;

public class juego implements SyE {
	
	private tablero tablero;											//tamanio del tablero
	private int iterador;												//cuenta iteraciones
	private boolean juegoTerminado;
	
	public juego(int dimension, int cantidadJugadores){					//el constructor recibe el tamanio del tablero deseado
		
		tablero = new tablero(dimension,cantidadJugadores);
		iterador = 0;
		juegoTerminado = false;
	}
	
	@Override
	
	public boolean cambiarNombre(String nuevoNom, int jugador){			//cambia el nombre del jugador deseado
		
		return tablero.cambiarNombre(nuevoNom, jugador);
	}

	@Override
	
	public boolean agregarSerpiente(int n, int m) {						//crea serpiente en el juego
		
		return tablero.agregarSerpiente(n, m);							/* devuelve true o false dependiendo si logro
		 																   o no agregar la serpiente;
		 																*/
	}
	
	@Override
	
	public boolean agregarEscalera(int n, int m) {						//crea escalera en el juego

		return tablero.agregarEscalera(n, m);							// devuelve true o false dependiendo si logro o no agregar la escalera;
	}

	@Override
	
	public String Ganador() {											//Informa el nombre del jugador que va ganando
		
		jugador Ganador,J;
		int i,l;
		boolean empatador;
		
		Ganador = tablero.getJugadores()[0];							//guarda el primer jugador
		l = tablero.getJugadores().length;								
		empatador = false;
		
		for (i=1;i<l;i++){												//recorre los jugadores
			
			J = tablero.getJugadores()[i];
			
			if(J.getPosicion()==Ganador.getPosicion()) empatador = true;	//si alguno iguala la posicion del jugador guardado activa el empatador

			if(J.getPosicion()>Ganador.getPosicion()){						//si alguno supera la posicion del jugador guardado
				Ganador = tablero.getJugadores()[i];						//guarda el jugador actual
				empatador = false;											//y desactiva el empatador
			}
		}
		if(empatador) return "EMPATE";									//si resulto en un empate devuelve EMPATE
		return Ganador.getNombre();										//sino devuelve el nombre del jugador guardado
	}
	
	@Override
	
		public boolean juegoTerminado(){								/*	Informa cuando un jugador alcanzo el final del tablero
																			o cuando se supero el limite de jugadas
		 																*/

		return juegoTerminado;
	}
	
	@Override

	public void jugar() {
		
		iterador++;														//incrementa el cuentaIteraciones
		
		int i,l,p,d;
		jugador J;
		
		l = tablero.getJugadores().length;
		
		for(i=0;i<l;i++){												//recorre los jugadores
			tablero.tirarDado();										//tira el dado por cada uno		
			J = tablero.getJugadores()[i];
			d = tablero.getDado().getCara();
			
			tablero.informar(i, J.getNombre()+" tiro un "+d);
			
			p = tablero.getJugadores()[i].getPosicion();
			
			if(!tablero.moverJugador(i,p+d )){							//actualiza su posicion y si esa es el final del tablero 
				juegoTerminado = true;									//termina el juego
			}
			
			tablero.informar(i,J.getEstado()+", avanza hasta "+J.getPosicion());
		}
		
		for( serpiente serpiente : tablero.getSerpientes()){			//recorre las serpientes

			for(i=0;i<l;i++){											//recorre los jugadores
				J = tablero.getJugadores()[i]; 
										
				if(J.getPosicion()==serpiente.getCola()){						//si el jugador cayo en la cola de alguna serpiente
					if(!tablero.moverJugador(i,serpiente.getCabeza())){			//actualiza su posicion y si esa es el final del tablero 
						juegoTerminado = true;									//termina el juego
					}
					
					tablero.informar(i,J.getEstado()+
									", a caido en una serpiente y cae hasta "+
									serpiente.getCabeza());
				}
			}
		}
		
		for(escalera escalera: tablero.getEscaleras()){					//recorre las escaleras
			
			for(i=0;i<l;i++){											//recorre los jugadores
				J = tablero.getJugadores()[i]; 	
				
				if(J.getPosicion()==escalera.getCom()){					//si el jugador cayo en la base de alguna escalera
					if(!tablero.moverJugador(i,escalera.getFin())){			//actualiza su posicion y si esa es el final del tablero 
						juegoTerminado = true;									//termina el juego
					}
					tablero.informar(i,J.getEstado()+
									", a subido por una escalera y sube hasta "+
									escalera.getFin());
				}
			}
		}
		
		if(iterador>=1000) juegoTerminado = true;
	}
	
	@Override
	
	public String ver() {												//muestra la ultima jugada ejecutada
		
		String ret;
		int i,l;
		
		ret = "";
		l = tablero.getJugadores().length;
		
		for(i=0;i<l;i++){
			jugador J = tablero.getJugadores()[i]; 
			ret += J.getEstado()+"\n";								//agrega su cambio de estado al retorno con un salto de linea al final
		}
		return ret;
	}
}
