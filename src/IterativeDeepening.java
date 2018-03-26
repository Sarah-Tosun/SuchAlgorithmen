import java.util.ArrayList;
import java.util.List;

public class IterativeDeepening implements Nachfolger{
	
	private int count = 0;
	private String ergebnis = "";
	private int tiefenschranke;
	
	public String iterativeDeepening(int[][] knoten, int[][] ziel) {
		tiefenschranke = 0;
		ergebnis = " \"Keine L�sung\"";
		while(ergebnis == " \"Keine L�sung\""){
			ergebnis = tiefenSucheB(knoten, ziel, 0, tiefenschranke);
			tiefenschranke += 1;
			if(ergebnis == " \"L�sung gefunden\""){
				ergebnis = " \"L�sung gefunden\"";			
				return ergebnis;
			}
		}
		return ergebnis;
	}
	
	public String tiefenSucheB(int[][] knoten, int[][] ziel, int tiefe, int schranke) {
		List<int[][]> neueKnoten;
		if(schranke > 0){
			count++;
			if(zielErreicht(knoten, ziel)){
				ergebnis = " \"L�sung gefunden\"";			
				return ergebnis;
			}else{
				neueKnoten = getNachfolger(knoten);
			}
		}else{
			neueKnoten = getNachfolger(knoten);
		}
		while(neueKnoten != null && tiefe < schranke){
			System.out.println("");
			System.out.println("Ebene: "+ count);
			ergebnis = tiefenSucheB(erster(neueKnoten), ziel, tiefe++, schranke);				
			if(ergebnis == " \"L�sung gefunden\""){
				ergebnis = " \"L�sung gefunden\"";			
				return ergebnis;
			}		
			neueKnoten = rest(neueKnoten);
		}ergebnis = " \"Keine L�sung\"";					
		return ergebnis;							
	}

	private List<int[][]> rest(List<int[][]> knotenListe) {
		List<int[][]> neueKnoten = new ArrayList<>();
		for(int i = 1; i < knotenListe.size(); i++){
			neueKnoten.add(knotenListe.get(i));
		}		
		return neueKnoten;
	}

	private int[][] erster(List<int[][]> knoten) {
		return knoten.get(0);
	}

}
