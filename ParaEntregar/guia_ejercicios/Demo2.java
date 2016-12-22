package guia_ejercicios;

public class Demo2 {
		/**
		 * Devuelve verdadero si todos los elementos están en el conjunto.
		 */
	
		public static boolean pertenecenTodos(int[] elems, int[] conjunto) {
			
			//recorre el arreglo de elementos
			for (int i = 0; i<elems.length ; i++ ){
				//si alguno no esta en el conjunto devuelve false
				if(!estaN(elems[i],conjunto)){
					return false;
				}
			}
			//si estan todos los elementos en el conjunto devuelve verdadero
			return true;
		}
		
		//devuelve verdadero o falso si un numero esta en un arreglo;
		public static boolean estaN(int n,int[] arregloN){
			
			for (int i = 0; i<arregloN.length ; i++ ){
				if (arregloN[i]==n){
					return true;
				}
			}
			
			return false;
		}

		/**
		 * Devuelve el índice del pico en un arreglo unimodal.
		 *
		 * Nomenclatura: un arreglo unimodal de N elementos es estrictamente
		 * creciente hasta una determinada posición P, y estrictamente
		 * decreciente a partir de ella. Se cumple que 0 < P < N-1.
		 *
		 * Se garantiza que el arreglo pasado como parámetro tiene forma de
		 * pico y, por tanto, al menos 3 elementos.
		 */
		public static int indicePico(int[] arreglo) {
			// Ejemplos:
			//     [2, 4, 6, 19, 15, 8, -2] → se devuelve 3
			//     [10, 20, 30, 40, 50, 15] → se devuelve 4
			//     [50, 100, 75]            → se devuelve 1
			
			//guarda el primer numero del arreglo
			int nAnt = arreglo[0];
			//recorre el arreglo
			for (int i = 1; i<arreglo.length ; i++){
				//si el numero es menor al anterior se considera al anterior pico del arreglo y retorna el indice de este
				if(arreglo[i]<nAnt){
					return (i-1);
				}
				//si no es el pico remplaza el valor del anterior
				nAnt = arreglo[i];
			}
			
			return -1;	//ya esta aclarado que el arreglo tiene forma de pico creciente y un minimo
						//de 3 elementos, pero aun asi en caso de un error de ingreso devuelve -1
		}
}