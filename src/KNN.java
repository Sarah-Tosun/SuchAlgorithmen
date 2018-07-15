import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * K-NearestNeighbour Algorithmus
 * Klassifiziert neuen Punkt zur Klasse mit den k nächsten Nachbarn
 * 
 * @author Sarah
 *
 */
public class KNN {
	
	public void KNNAlg(double[][] point, double[] newPoint, int k) {
		
		List<Points> pointList = new ArrayList<>();
		List<Result> resultList = new ArrayList<>();
		
		//Punkte einlesen in Liste speichern mit Indexstelle
		for(int i = 0; i < point.length; i++){
			pointList.add(new Points(point[i], i));
		}
		//Distanz aller Stellen aufaddieren, eponieren und die Wurzel ziehen
		for(Points koordinate : pointList){
			double dist = 0.0;
			for(int j = 0; j < koordinate.point.length; j++){
				dist += Math.pow(koordinate.point[j]-newPoint[j], 2);
			}
			double distance = Math.sqrt(dist);
			distance = Math.round(100.0 * distance) / 100.0;
			resultList.add(new Result(distance, koordinate.index, koordinate.point));
		}
		//Punkte sortieren nach Distanz
		Collections.sort(resultList, new DistComparator());
		
		double distanceNull = 0;
		double distanceEins = 0;
		int countNull = 0;
		int countEins = 0;
		
		//Soviele Results ausgeben wie hoch der Wert k ist
		for(int j = 0; j < k; j++){
			System.out.print(resultList.get(j).dist+", "+ resultList.get(j).index+"  [");		
			for(int i = 0; i < resultList.get(j).point.length; i++){
				System.out.print(resultList.get(j).point[i]+", ");
				//An letzter Stelle prüfen in welcher Klasse sich die nähsten Punkte 
				//befinden
				if(i == resultList.get(j).point.length-1){
					if(resultList.get(j).point[i] == 0){
						distanceNull += resultList.get(j).dist;
						countNull++;
					}else{
						distanceEins += resultList.get(j).dist;
						countEins++;
					}
						
				}
			}
			System.out.print("]");
			System.out.println(" ");
						
		}
		//Klassenbestimmung, bei gleicher Klassenanzahl entscheidet die 
		//kleinere Gesamtdistanz
		System.out.println(" ");
		if(countNull < countEins || distanceNull > distanceEins){
			System.out.printf("Klasse:  '1':   ("+countEins+" Punkte dieser Klasse)");
		}else{
			System.out.printf("Klasse:  '0':   ("+countNull+" Punkte dieser Klasse)");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("ENDE__________________________________________");
		System.out.println("");
				
	}
	
	private void print(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public class Points{
		double[] point;
		int index;
		 
		Points(double[] point_, int index_){
			this.point = point_;
			this.index = index_;
		}	 
	}
	
	public class Result{
		double dist;
		int index;
		double[] point;
		 
		Result(double dist_, int index_, double[] point_){
			this.dist = dist_;
			this.index = index_;
			this.point = point_;
		}	 
	}
	
	class DistComparator implements Comparator<Result> {

		 // Kleinster Value aufsteigend geordnet nach Distanz
		 public int compare(Result a, Result b) {
			 if (a.dist < b.dist){
				 return -1;				 
			 }else if (a.dist >= b.dist){
				 return 1;
			 }else{
				 return 0;
			 }

		 }
	} 


}
