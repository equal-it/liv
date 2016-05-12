package playground;

public class TestHttpAbfrageDatakick {
	public static void main(String[] args) {
		try {
			
			// ean für test api					 	000000000000
			// ean für test Ferrero Nutella 		4008400401928
			// ean für test Ferrero Kuesschen 		4008400154121 
			// ean für test Coca Cola Regular 		5449000000996
			// ean für test Heinz Tomato Ketchup 	013000001335
			
			playground.HttpAbfrageDatakick.sendGet("013000001335");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
