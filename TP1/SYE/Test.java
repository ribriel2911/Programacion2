package SYE;

public class Test {
	
	public static void main(String[] args) {
		
		juego sye;
		int i;
		
		sye = new juego(80,2);
		i = 0;
		
		sye.agregarSerpiente(20, 80);
		sye.agregarEscalera(6, 14);
		
		
		while (!sye.juegoTerminado()){
			
			System.out.println(sye.ver());
			sye.jugar();
			i++;
		}
		System.out.println(sye.ver());
		System.out.println("Ganador: "+sye.Ganador());
		if(i>=1000){
			System.out.println("Ganador por cansancio");
		}
	}

}
