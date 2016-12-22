package Ej2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class RedSocial<T> implements Iterable<T> {
	
	private HashMap<T,HashSet<T>> miembros;						
	private int Trelaciones;									
	private int Tmiembros;										
	
	RedSocial(){												//Constructor
		miembros = new HashMap<T, HashSet<T>>();		
		Trelaciones = 0;
		Tmiembros = 0;
	}
	
	protected boolean incRelaciones(){							//incrementador de relaciones
		Trelaciones = Trelaciones + 1;
		return true;
	}
	
	public int totalPersonas(){
		return Tmiembros;
	}
	
	public int totalRelaciones(){
		return Trelaciones;
	}

	public int numRelaciones(T p){								//numero de relaciones de una persona
		
		if(p==null || !miembros.containsKey(p)) return 0;
		
		int ret = miembros.get(p).size();
		
		return ret;
	}

	protected void verificarMiembro(T p){						//verifica que un miembro este en el diccionario
		if(!miembros.containsKey(p) && p!=null){				//si no es nulo y no esta lo inicializa y lo agrega
			miembros.put(p,new HashSet<T>());
			Tmiembros++;
		}
	}

	public boolean agregarRelacion(T p1, T p2){
		
		if(p1==null||p2==null) return false;					//verifica que ninguno sea nulo
		
		if (p1.equals(p2)) return false;						//verifica que no sean la misma persona
		
		verificarMiembro(p1);									//verifica que este la primer persona
		
		if (miembros.get(p1).contains(p2)) return false;		//verifica si ya estan relacionados y si lo estan
																//retorna falso al intentar relacionarlos	
		
		verificarMiembro(p2);									//verifica que este la segunda persona
		
		miembros.get(p1).add(p2);								//agrega la relacion y retorna verdadero

		return true;								
		
	}

	public Iterable<T> obtenerRelaciones(T p){
		
		if(p==null || !miembros.containsKey(p)) return new HashSet<T>();	//si el parametro es nulo o no esta en la red 
																			//retorna un iterable vacio;
		
		return miembros.get(p);
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = miembros.keySet().iterator();
		return it;
	}
	
	public String toString(){
		
		StringBuilder strB = new StringBuilder();
		String enter = "\n\n";									//salto de linea
		
		
		strB.append("Numero de miembros en la Red: ").append(totalPersonas()).append(enter)
		.append("Numero de relaciones en la Red: ").append(totalRelaciones()).append(enter);
		
		for (T miembro : this){
			
			for(T relacionado : obtenerRelaciones(miembro)){	
				
				strB.append(miembro.toString()).append(" esta relacionado con ")
				.append(relacionado.toString()).append(enter);		
			}
		}	
		
		return strB.toString();
	}

}
