package MDV;

public class Test {
	
	public static void main(String[] args) {
		
		Mapa m2 = new Mapa(12);
		
		m2.setDistIJ(0,1);
		m2.setDistIJ(0,3);
		m2.setDistIJ(0,6);
		m2.setDistIJ(1,2);
		m2.setDistIJ(1,3);
		m2.setDistIJ(1,4);
		m2.setDistIJ(2,5);
		m2.setDistIJ(3,4);
		m2.setDistIJ(3,6);
		m2.setDistIJ(3,7);
		m2.setDistIJ(5,8);
		m2.setDistIJ(5,11);
		m2.setDistIJ(6,7);
		m2.setDistIJ(6,9);
		m2.setDistIJ(7,8);
		m2.setDistIJ(7,10);
		m2.setDistIJ(8,10);
		m2.setDistIJ(9,10);
		m2.setDistIJ(10,11);
		
		m2.setMolino(2, true);
		m2.setMolino(4, true);
		m2.setMolino(7, true);
		m2.setMolino(9, true);
		
		System.out.println(m2.solver());
		
	}

}
