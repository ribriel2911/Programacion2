package Practica00;

public class Ej04 {
	
	boolean mayorX_Y(int[][] matriz){
		
		//Controla que todas las filas cumplan la condicion;
		boolean retF = true;
		
		int columnaMenor = 0;
		
		for(int i=0;i<matriz.length;i++){
			
			int sumaFila = 0;
			
			for(int j=0;j<matriz[i].length;i++){
				
				sumaFila += matriz[i][j];
				
				//Solo en la primer iteracion de i
				if(i==0){
					
					//Busca la suma de la columna de menor valor
					int sumaColumna = 0;
					
					for(int k=0;k<matriz.length;k++){
						
						sumaColumna += matriz[k][j];
					}
					
					//Solo en la primer iteracion de j
					if (j==0){
						
						//Guarda el valor de la suma de la primer columna
						columnaMenor = sumaColumna;
					}
					else{
						
						//Si la suma de la nueva columna es menor a las anteriores reemplaza al valor
						if (sumaColumna<columnaMenor){
							columnaMenor = sumaColumna;
						}
					}
				}
			}
			
			retF = retF && (sumaFila>columnaMenor);
		}
		
		return retF;		
		
	}

}
