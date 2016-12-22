package SYE;

import java.util.Random;

public class dado {
	
	private int cara;								//lado actual del dado
	private Random azar;	

	public dado(){
		cara = 0;
		azar = new Random();
	}
	
	public int getCara() {
		return cara;
	}

	public void cambiarCara(){
		cara = 1 + azar.nextInt(5); 				//cambia el lado del dado por uno al azar de 1 a 5
	}
}
