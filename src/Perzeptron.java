
public class Perzeptron {

	public Perzeptron() {
		// TODO Auto-generated constructor stub
	}

	public void perzeptronLernregel(double[][] menge1, double[][] menge2) throws InterruptedException {
		// w beliebiger Vektor reeller Zahlen
		double[] w = {1,1};
		//alle x korrekt klassifiziert
		int count = 0;
		boolean abbruch = false;
		while(true){

			double vekortWXMenge1 = 0;
			double vekortWXMenge2 = 0;

			for(double[]x : menge1){				
				double vekortWX1 = (w[0]*x[0])+(w[1]*x[1]);
				// für abbruchsbedingung
				vekortWXMenge1 = vekortWX1;
				if(vekortWX1 <= 0){
					//Perzeptron klassifizieren, addieren
					w[0] = w[0]+x[0];
					//runden
					w[0] = Math.round(100.0 * w[0]) / 100.0;
					
					w[1] = w[1]+x[1];
					w[1] = Math.round(100.0 * w[1]) / 100.0;
					count++;
					System.out.println("Step"+count+ "w+: "+ w[0] +", "+ w[1]);

				}

			}
			
			
			for(double[]x : menge2){				
				double vekortWX2 = (w[0]*x[0])+(w[1]*x[1]);
				// für abbruchsbedingung
				vekortWXMenge2 = vekortWX2;
				if(vekortWX2 > 0){
					//Perzeptron klassifizieren, abziehen
					w[0] = w[0]-x[0];
					w[0] = Math.round(100.0 * w[0]) / 100.0;
					
					w[1] = w[1]-x[1];
					w[1] = Math.round(100.0 * w[1]) / 100.0;
					count++;
					System.out.println("Step"+count+ "w+: "+ w[0] +", "+ w[1]);
				}
			}
//			if((vekortWXMenge1 > 0) && (vekortWXMenge2 <= 0)){
//				abbruch = true;
//			}
			
			if(count == 444){
				break;
			}
			
//			Thread.sleep(100);
				
		}
		
	}

}
