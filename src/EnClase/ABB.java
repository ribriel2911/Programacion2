package EnClase;

public class ABB extends AB{
	
	boolean es_ABB(){
		
		return AB.es_ABB_exponencial(raiz) && AB.es_ABB(raiz,null,null);
	}
}
