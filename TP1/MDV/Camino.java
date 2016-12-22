package MDV;

import java.util.ArrayList;

public class Camino {
	
	ArrayList<Integer> molinos;
	
	public Camino(){
		molinos = new ArrayList<Integer>();
		}
	
	public void agregarMolino(int id){
		Integer molino = new Integer(id);
		molinos.add(molino);
		}
	// es importante evitar aliasing
	
	public Camino copiar(){
		Camino aux = new Camino();
		for(int i= 0;i<molinos.size();i++){
			aux.agregarMolino(molinos.get(i));
			}
		return aux;
		}
	
	// todavia no se explico equals en la materia
	
	public boolean igual(Camino c2){
		
		boolean ret = c2.molinos.size() == molinos.size() ;
		
		if(ret) {
			//pertenece
			for(int i= 0;i<molinos.size();i++){
				ret = ret && c2.molinos.contains(molinos.get(i));
				}
			}
		return ret;
		}
	@Override
	
	public String toString() {
		return "Camino [molinos="+ molinos+ "]";
		}
}
