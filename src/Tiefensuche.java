import java.util.ArrayList;
import java.util.List;

public class Tiefensuche implements Nachfolger{
	
	private int count = 0;
	private String ergebnis = "";

	public String tiefensuche(int[][] knoten, int[][] ziel) {
		count ++;
		List<int[][]> neueKnoten;
		if(zielErreicht(knoten, ziel)){
			ergebnis = " \"Lösung gefunden\"";			
			return ergebnis;
		}else{
			neueKnoten = getNachfolger(knoten);
		}
		while(neueKnoten != null){
			System.out.println("");
			System.out.println("Ebene: "+ count);
			String ergebnis = tiefensuche(erster(neueKnoten), ziel);
			if(ergebnis == " \"Lösung gefunden\""){
				ergebnis = " \"Lösung gefunden\"";			
				return ergebnis;
			}		
			neueKnoten = rest(neueKnoten);
		}ergebnis = " \"Keine Lösung\"";					
		return ergebnis;		
	}

	private List<int[][]> rest(List<int[][]> knotenListe) {
		knotenListe.remove(0);
		List<int[][]> neueKnoten = new ArrayList<>();
		for(int i = 0; i < knotenListe.size(); i++){
			neueKnoten.add(knotenListe.get(i));
		}		
		return neueKnoten;
	}

	private int[][] erster(List<int[][]> knoten) {
		return knoten.get(0);
	}
	
}
