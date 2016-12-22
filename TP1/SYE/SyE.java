package SYE;

public interface SyE {
	
public  String Ganador();//Informa el nombre del jugador que va ganando

public boolean juegoTerminado();/*	Informa cuando un jugador alcanzo el final del tablero
									o cuando se supero el limite de jugadas
								*/

public boolean cambiarNombre(String s, int n); //cambia el nombre del jugador deseado

public boolean agregarSerpiente(int i, int j); //crea serpiente en el tablero

public boolean agregarEscalera(int i, int j);	//crea escalera en el tablero

public void jugar();	/*	tira los dados y controla el movimiento de los jugadores
							y su iteraccion con el tablero, las serpientes y escaleras
						*/	
						
public String ver();	//muestra la ultima jugada ejecutada

}

