package MDV;

public class Molino {
	
	private boolean esGigante;
	
	public Molino(){
		this.esGigante=false;
		// si es false, es molino
		}
	
	public Molino(boolean esGigante){
		this.esGigante=esGigante;
		}
	
	public boolean esGigante() {
		return esGigante;
		}
	
	public void setGigante(boolean esGigante) {
		this.esGigante= esGigante;
		}
	
	@Override
	
	public String toString() {
		
		if(esGigante()){
			
			return"G";
			}
		else{
			return"M";
		}
	}

}
