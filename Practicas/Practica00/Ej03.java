package Practica00;

public class Ej03 {
	
	boolean mayor10_par(int[][] matriz){
		
		//Controla que todas las filas cumplan la condicion
		boolean retM = true;
		//Controla que todas las columnas cumplan la condicion
		boolean retP = true;
		
		for(int i=0;i<matriz.length;i++){
			
			//Controla que por lo menos un n de la fila sea mayor a 10
			boolean retX = false;
			
			for(int j=0;j<matriz[i].length;i++){
				
				retX = retX || matriz[i][j]>10;
				
				//Solo en la primer iteracion de i;
				if(i==0){
					
					//Controla que por lo menos un n de la columna sea par
					boolean retY = false;
					
					for(int k=0;k<matriz.length;k++){
						
						retY = retY || (matriz[k][j]%2==0);
					}
					
					retP = retP && retY;
				}
			}
			
			retM = retM && retX;
		}
		
		return (retM && retP);
	}
	
	boolean mayor10_parCuadrada(int[][] matrizCuadrada){
		
		//Controla que todas las filas cumplan la condicion
		boolean retM = true;
		//Controla que todas las columnas cumplan la condicion
		boolean retP = true;
		
		for(int i=0;i<matrizCuadrada.length;i++){
			
			//Controla que por lo menos un n de la fila sea mayor a 10
			boolean retX = false;
			//Controla que por lo menos un n de la columna sea par
			boolean retY = false;
			
			for(int j=0;j<matrizCuadrada.length;i++){
				
				retX = retX || matrizCuadrada[i][j]>10;
				retY = retY || (matrizCuadrada[j][i]%2==0);
			}
			
			retM = retM && retX;
			retM = retM && retX;
		}
		
		return (retM && retP);
	}

}
