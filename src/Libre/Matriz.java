package Libre;

public class Matriz {
	
	int[][] copiaMatriz(int[][] m){
		
		int i,j;
		int[][] ret;
		
		ret = new int[m.length][m[0].length];
		
		for(i=0;i<m.length;i++){
			
			for(j=0;j<m[0].length;j++){
				
				ret[i][j] = m[i][j];
			}
		}
		
		return ret;
	}

	boolean estaVacia(int[][] m){
		
		int i,j;
		
		for(i=0;i<m.length;i++){
			
			for(j=0;j<m[0].length;j++){
				
				if(m[i][j]!=0) return false;
			}
		}
	
		return true;
	}
}
