package Practica00;

public class Ej02 {
	
	boolean estaOrdenado(int[] arreglo,int i){
		
		boolean ret = true;
		
		for(int j=0;j<i;j++){
			
			ret = ret && arreglo[j]<arreglo[i];
		}
		
		return ret;
	}
	
	boolean oredenado(int[] arreglo){
		
		boolean ret = true;
		
		int n = arreglo.length;
		
		for (int k=0;k<n;k++){
			
			ret = ret && estaOrdenado(arreglo,k);
		}
		
		return ret;
	}
}
