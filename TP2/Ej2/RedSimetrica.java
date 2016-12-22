package Ej2;

public class RedSimetrica<T> extends RedSocial<T>{
	
	@Override
	
	public boolean agregarRelacion(T p1, T p2){
		
		boolean ret,ret1,ret2;
		
		ret1 = super.agregarRelacion(p1,p2);				//asigna relacion de p1 a p2
		ret2 = super.agregarRelacion(p2,p1);				//asigna relacion de p2 a p1
		
		ret = ret1||ret2;									//considero que si se cumplio en por lo menos uno de los sentidos
															//quiere decir que ya se encuntra relacionado en ambos
			
		if (ret) incRelaciones();							//e incluyo la relacion
										
											
		return ret;
	}
}
