
import java.util.ArrayList;
import java.util.List;

/**
 * Perzeptron, linearer Klassifizierer
 * aus einem zB Zweidimensinalen Raum einen Dreidimensionalen machen 
 * einfach mit 1 erweitern, also auf die nächste Ebene/auf den nächsten Raum
 * anheben/erweitern um linear klassifizieren zu können!
 * 
 * @author Sarah
 *
 */

public class Perzeptron {

	public void perzeptronLernregel(double[][] menge1, double[][] menge2) throws InterruptedException {
		// w beliebiger Vektor reeller Zahlen
		double[] weight = {1,1,1};
		//alle x korrekt klassifiziert
		int count = 1;
		//Für Abbruch ArrayList mit den aktuellen Werten
		List<Double> mapPlus;
		List<Double> mapMinus;
		
		while(true){
			mapPlus = new ArrayList<>();
			mapMinus = new ArrayList<>();
			for(double[] x : menge1){	
				double wert = 0;
				wert = getVektorWert(weight, x);

				// für Abbruchsbedingung
				mapPlus.add(wert);
				if(wert <= 0){		
					//Klassifizieren und Ausgabe der Gewichte
					klassifizierePerzeptron(weight, x, count, "+");
					count++;
				}
			}			
			
			for(double[]x : menge2){	
				double wert = 0;
				wert = getVektorWert(weight, x);

				// für abbruchsbedingung
				mapMinus.add(wert);
				if(wert > 0){
					//Klassifizieren und Ausgabe der Gewichte
					klassifizierePerzeptron(weight, x, count, "-");
					count++;
				}
			}
//			count++;
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
				System.out.println("ENDE__________________________________________");
				System.out.println("");
				break;
			}				
//			Thread.sleep(100);				
		}		
	}	
	
	//Gewichtsvektor erste Stelle mit Punkt erster Stelle multiplizieren, ebenso alle Stellen
	//und diese dann addieren und zurückgeben
	private double getVektorWert(double[] weight, double[] x) {
		double wert = 0;
		//Auf weight.length-1 setzten für Mehrdimensionen
		for(int i = 0; i < weight.length-1;i++){
			wert = wert + (weight[i]*x[i]);
		}
//		Wegen Mehrdimensionen, auskommentieren bei Zweidimensionalem
		wert = wert + (weight[weight.length-1]*1);
		return wert;
	}


	private void klassifizierePerzeptron(double[] weight, double[] x, int count, String addition_subtraktion) {
		//Perzeptron klassifizieren, addieren
		String plus = "+";
		//Auf weight.length-1 setzten für Mehrdimensionen
		for(int i = 0; i < weight.length-1; i++){
			if(addition_subtraktion == plus){
				weight[i] = weight[i] + x[i];
			}else{
				weight[i] = weight[i] - x[i];
			}
			weight[i] = Math.round(100.0 * weight[i]) / 100.0;
		}
		// Wegen Mehrdimensionen, sonst auskommentieren bei Zweidimensional
		if(addition_subtraktion == plus){
			weight[weight.length-1] = weight[weight.length-1]+1;
		}else{
			weight[weight.length-1] = weight[weight.length-1]-1;
		}			
		weight[weight.length-1] = Math.round(100.0 * weight[weight.length-1]) / 100.0;
		
		//Ausgabe der Gewichte
		System.out.print("Step "+count+ " w + :  ");
		for(int j = 0; j < weight.length; j++){
			System.out.print(weight[j] +", ");
		}
		System.out.println(" ");
	}
}
