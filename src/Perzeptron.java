
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Perzeptron {

	public Perzeptron() {
		// TODO Auto-generated constructor stub
	}

	public void perzeptronLernregel(double[][] menge1, double[][] menge2) throws InterruptedException {
		// w beliebiger Vektor reeller Zahlen
		double[] w = {1,1};
		//alle x korrekt klassifiziert
		int count = 0;
		//Für Abbruch ArrayList mit den aktuellen Werten
		List mapPlus;
		List mapMinus;
		while(true){

			double vekortWXMenge1 = 0;
			double vekortWXMenge2 = 0;
			mapPlus = new ArrayList<>();
			mapMinus = new ArrayList<>();
			
			for(double[]x : menge1){				
				double vekortWX1 = (w[0]*x[0])+(w[1]*x[1]);
				// für abbruchsbedingung
				vekortWXMenge1 = vekortWX1;
				mapPlus.add(vekortWXMenge1);
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
				mapMinus.add(vekortWXMenge2);
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
			
			//Abbruchbedingung 
			int plus = 0;
			boolean allPlus = false;
			for(int i = 0; i < mapPlus.size();i++){
				if((double) mapPlus.get(i) > 0){
					plus++;
				}
				if(plus == mapPlus.size()){
					//alle sind nun Positiv (vekortWX1)
					allPlus = true;
				}
			}

			int minus = 0;
			boolean allMinus = false;
			for(int i = 0; i < mapMinus.size();i++){
				if((double)mapMinus.get(i) < 0){
					minus++;
				}
				if(minus == mapMinus.size()){
					//alle sind nun Negativ (vekortWX2)
					allMinus = true;
				}
			}			
			
			if(allPlus == true && allMinus == true){
				//Alle richtig klassifiziert
				break;
			}
			
			
//			Thread.sleep(100);
				
		}
		
	}

}
