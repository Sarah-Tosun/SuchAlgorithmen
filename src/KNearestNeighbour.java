import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KNearestNeighbour{

	public void kNearestNeighbour(double[][] mengePos, double[][] mengeNeg, double[] newPoint) {
		System.out.println("!!! START KNN-Algorithmus !!!");
		System.out.println("------------------------------------- ");

		System.out.println("Neuer Punkt: ["+newPoint[0]+", "+ newPoint[1]+"]");
		//Nur für schöne Originalpunkte Ausgabe
		System.out.print("Original Punkte[");
		printOriginalPunkte(mengePos);

		TreeMap<Integer, Double> sorted_map_Pos = getMap(mengePos, newPoint, "positiv");
		
		//Nur für schöne Originalpunkte Ausgabe		
		System.out.println("------------------------------------- ");
		System.out.print("Original Punkte[");
		printOriginalPunkte(mengeNeg);
		
		TreeMap<Integer, Double> sorted_map_Neg = getMap(mengeNeg, newPoint, "negativ");
		Double valuePos = sorted_map_Pos.firstEntry().getValue();
		Double valueNeg = sorted_map_Neg.firstEntry().getValue();
		
		
		if(valuePos < valueNeg && valuePos < valueNeg){
			System.out.println("+++++++++  Positiv, Index Punkte: "+ sorted_map_Pos.firstEntry().getKey());
		}else{
			System.out.println("---------  Negativ, Index Punkte: " + sorted_map_Pos.firstEntry().getKey());
		}
		System.out.println("ENDE_____________________________________________________");

	}
	
	private void printOriginalPunkte(double[][] menge) {
		for(int i = 0; i < menge.length; i++){
			for(int j = 0; j < 2; j++){
				System.out.print(" "+menge[i][j]+", ");
			}
		}
		System.out.print("]");
		System.out.println(" ");
		
	}

	public TreeMap<Integer, Double> getMap(double[][] menge, double[] newPoint, String string){
		List<Double> list = new ArrayList<>();
		HashMap<Integer, Double> list2 = new HashMap<Integer, Double>();
	    Comparator<Integer> valueComparator = new ValueComparator(list2);
	    TreeMap<Integer, Double> sorted_map = new TreeMap<Integer, Double>(valueComparator);

		// k nächster Nachbar
	    //Punkt x1 - neuerPunkt x1 für alle 
		for(int i = 0; i < menge.length; i++){
			for(int j = 0; j < 2; j++){
				double a = menge[i][j] - newPoint[j];
				list.add(a);
			}
		}
		System.out.println("Liste Abstand: "+string +" :"+list);
		int index = 0;
		//liste erster x Wert und zweiter Wert addieren = !Abstand! speichern
		for(int i = 0; i < list.size(); i=i+2){ //zwei, da einer übersprungen wird durch i+1
			double a = (double) list.get(i);
			double b = (double) list.get(i+1);
			double c = a + b;
			list2.put(index, c);
			index++;
		}
		double d = 0;
		//Abstandswerte mit Index speichern, Negativen negieren also zu Positiven für Vergleich
		for(int i = 0; i < list2.size(); i++){
			if(list2.get(i) < 0 ){
				d = list2.get(i) * -1; //positiv machen
				list2.remove(i); //leeren
				list2.put(i, d); //neu füllen
			}
		}
		System.out.println("Unsortiert:      " + list2);
	    sorted_map.putAll(list2); 	//TreeMap, ordnen nach Wert aufsteigend
	    System.out.println("Geordnete Liste: " + sorted_map);
		return sorted_map;
	}
 
}

class ValueComparator implements Comparator<Integer> {
	 Map<Integer, Double> base;

	 public ValueComparator(HashMap<Integer, Double> list2) {
	     this.base = list2;
	 }
	 // Kleinster Value aufsteigend geordnet
	 public int compare(Integer a, Integer b) {
	     if (base.get(a) <= base.get(b)) {
	         return -1; 
	     } else {
	         return 1;
	     } 
	 }

}
