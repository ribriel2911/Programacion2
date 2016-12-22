package ejercicios.complejidad;

public class sumasParciales {

	public static int[][] sumasParciales(int[] arreglo){
		
		int i,j,l;
		int[][] s;
		
		l = arreglo.length;
		s = new int[l][l];
		
		for (i=0;i<l;i++){
			for (j=i;j<l;j++){
				s[i][j] = sumaDeXaY(arreglo,i,j);
			}
		}
		
		return s;
	}
	
	public static int sumaDeXaY(int[] arreglo,int x, int y){
		
		int i,sumado;
		
		sumado = 0;
		
		for(i=x;i<=y;i++){
			sumado+=arreglo[i];
		}
		
		return sumado;
	}
	
	public static void imprimirMatriz(int[][] matriz){
		int i,j;
		
		System.out.print("[ ");
		
		for (i=0;i<matriz.length;i++){
			
			System.out.print("[ ");
			
			for (j=0;j<matriz[i].length;j++){
				
				System.out.print(matriz[i][j]+", ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {

		int[] flashando = new int [6];
		flashando[0] = 7;
		flashando[1] = 20;
		flashando[2] = 3;
		flashando[3] = 13;
		flashando[4] = 29;
		flashando[5] = 12;
		
		imprimirMatriz(sumasParciales(flashando));

	}

}
