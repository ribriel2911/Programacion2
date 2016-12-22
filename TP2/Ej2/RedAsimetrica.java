package Ej2;

public class RedAsimetrica <T> extends RedSocial<T>{

	@Override
	public boolean agregarRelacion(T p1, T p2){
		
		boolean ret = super.agregarRelacion(p1, p2);			//asigna relacion de p1 a p2
		
		if(ret) incRelaciones();								//si se logro relacionarlos incluyo la relacion
		
		return ret;
		
	}
	
	public RedAsimetrica<T> inversa(){
		
		RedAsimetrica<T> ret = new RedAsimetrica<T>();			//creo una red a retornar
		
		for(T miembro : this){
			
			for(T relacionado : obtenerRelaciones(miembro)){	//obtengo las relaciones de cada uno de sus miembros
				
				ret.agregarRelacion(relacionado, miembro);		//agrego la relacion inversa a la nueva red
			}
		}
		
		return  ret;
	}
}
