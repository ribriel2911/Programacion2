package MDV;

public class Mapa {
	private Molino [] molinos;
	
	private int[][] distancias;	// distanciade i a j
	
	private int n;
	
	public Mapa(int tamano){
		n= tamano;
		molinos= new Molino [n];
		distancias= new int[n][n];
		for(int i=0; i<n; i++){
			molinos[i] = new Molino();//generamos todos molinos x defecto
			for(int j=0; j<n; j++){
				distancias[i][j] = 0;//distancias default en 0
				}
			}
		}
	
	public int tamano(){
		return n;
		}
	
	public void setMolino(Integer id, boolean esGigante){
		molinos[id].setGigante(esGigante);
		}
	
	public void setDistIJ(int i, int j){
		distancias[i][j] = 1;
		distancias[j][i] = 1;//simetrica
		}
	
	// distanciasnominales
	
	public int getDistIJ(int i, int j){
		return distancias[i][j];
		}
	
	Camino solver(){
		
		Camino cInicial = new Camino();
		Caminos solucionesi = new Caminos();
		Caminos solucionesf = new Caminos();
		
		Camino ret=null;
		
		int cantMolinos=0;
		
		for(int i=0; i< molinos.length; i++){
			if(!molinos[i].esGigante()){
				cantMolinos++;
				}
			}
		
		cInicial.molinos.add(0);		// asumimos que 0 es el molinoinicial
		solucionesi.caminos.add(cInicial);
		solucionesf = obtenerCaminos(solucionesi);
		
		//imprimir esto para debug
		//System.out.println(solucionesf);
		
		int cantGigantes = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		//obtener la mejor solucion factible dentro de soluciones
		for(Camino c:  solucionesf.caminos){
			cantGigantes=factible(c,cantMolinos );
			if(cantGigantes > -1){
				System.out.println("factible. Gigantes: "+ cantGigantes + "->"+ c);
				
				if(cantGigantes < min){
					ret = c;
					min = cantGigantes;
				}
			}
		}
		return ret;
	}
	
	private int factible(Camino c, int cantMolinos){
		
		int gigantesEnC=0;
		int molinosEnC=0;
		
		for(int i=0; i< c.molinos.size();i++){
			if(molinos[c.molinos.get(i)].esGigante()){
				gigantesEnC++;
			}
			else{
				molinosEnC++;
			}
		}
		
		if(molinosEnC == cantMolinos){
			return gigantesEnC;
		}
		
		else{
			return-1;// no esfactible
		}
	}
		//   toma los caminos de in, los aumenta y agrega caminos nuevos
	
	//verifica si un molino esta en un camino;
	static boolean estaEnCamino(Camino cam,int elem){
		int i,l;
		
		l = cam.molinos.size();
		
		for (i=0;i<l;i++){
			if(cam.molinos.get(i)==elem){
				return true;
			}
		}
		
		return false;
	}

	//devuelve la cantidad de caminos que tengo disponibles;
	static int cantCaminos(int[][] matriz,Camino cam){
		
		int i,l,f,cont;
		
		cont = 0;
		f = cam.molinos.get(cam.molinos.size()-1);
		l = matriz[f].length;
		
		for(i=0;i<l;i++){
			if ((matriz[f][i]==1)&&(!estaEnCamino(cam,i))){
				cont++;
			}
		}
		
		return cont;
	}
	
	//Devuelve un arreglo de molinos disponibles;
	static int[] caminosDisp(int[][] matriz,Camino cam){
		
		int i,l,v,f;
		int[] caminos;
		
		caminos = new int[cantCaminos(matriz,cam)];
		f = cam.molinos.get(cam.molinos.size()-1);
		l = matriz[f].length;
		v=0;
		
		for(i=0;i<l;i++){
			if ((matriz[f][i]==1)&&(!estaEnCamino(cam,i))){
				caminos[v] = i;
				v++;
			}
		}
		
		return caminos;
	}

	//   toma los caminos de in, los aumenta y agrega caminos nuevos
	Caminos obtenerCaminos(Caminos in){
		
		//Creacion de variables a usar;
		int i,j,lRec,lRem,caminosVistados;
		int[] caminosArecorrer;
		Caminos recorriendo,removidos,ret;
		Camino nuevo,copia;
		
		//Inicializacion de caminos;
		recorriendo = new Caminos();
		removidos = new Caminos();
		ret = new Caminos();
		
		//guardo una copia del primer molino ingresado para empezar a recorrerlo;
		copia = in.caminos.get(0).copiar();
		recorriendo.caminos.add(copia);
		
		//mientras haya caminos por recorrer;
		while(recorriendo.caminos.size()>0){
			//guardo la longitud de los caminos a recorrer en esta iteracion;
			lRec = recorriendo.caminos.size();
			//empiezo a recorrer;
			for(i=0;i<lRec;i++){
				//reviso cuantos molinos posibles tengo para moverme;
				caminosVistados = cantCaminos(distancias,recorriendo.caminos.get(i));
				//si hay almenos uno;
				if(caminosVistados>=1){
					//guardo el indice de los molinos que tengo disponibles;
					caminosArecorrer = caminosDisp(distancias,recorriendo.caminos.get(i));
					//guardo una copia del camino q estoy recorriendo sin agregarle ningun molino nuevo;
					copia = recorriendo.caminos.get(i).copiar();
					//agrego el primer molino disponible al camino q estoy recorriendo;
					recorriendo.caminos.get(i).agregarMolino(caminosArecorrer[0]);
					//si hay mas molinos disponibles;
					for(j=1;j<caminosVistados;j++){
						//copia la copia que habia guardado;
						nuevo = copia.copiar();
						//le asigno el siguiente molino disponoble;
						nuevo.agregarMolino(caminosArecorrer[j]);
						//y lo agrego a los que voy a recorrer en la siguiente iteracion;
						recorriendo.caminos.add(nuevo);
					}
				}
				
				else{
					//si no hay mas molinos disponibles lo agrego a los caminos a borrar para la siguiente iteracion;
					removidos.caminos.add(recorriendo.caminos.get(i));
				}
			}
			
			//guardo la longitud de los caminos a remover;
			lRem = removidos.caminos.size();
			//los recorro;
			for(i=0;i<lRem;i++){
				//guardo los caminos finalizados en los caminos a retornar;
				ret.caminos.add(removidos.caminos.get(i));
				//los remuevo de los que voy a recorrer en la siguiente iteracion;
				recorriendo.caminos.remove(removidos.caminos.get(i));
			}
			//re inicializo los caminos a remover;
			removidos = new Caminos();
		}
		//retorno los caminos finalizados;
		return ret;
	}
}
