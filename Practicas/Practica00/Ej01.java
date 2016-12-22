package Practica00;

public class Ej01 {

	boolean mayor10(int[] lista){
		
		boolean ret = true;
		
		for(int i=0 ; i<lista.length ; i++){
			ret = ret && lista[i]>10;
		}
		
		return ret;
	}
}
