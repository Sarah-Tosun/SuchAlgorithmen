import java.util.List;
/** 
 * Algorithmus: Tiefensuche 8-Puzzle
 * Autor: Sarah Tosun
 * */
public class Tiefensuche implements Hilfsfunktionen{
	
	private int count = 0;
	private String ergebnis = "";

	public String tiefensuche(int[][] knoten, int[][] ziel) {
		count ++;
		List<int[][]> neueKnoten;
		if(zielErreicht(knoten, ziel)){
			ergebnis = " \"L�sung gefunden\"";			
			return ergebnis;
		}else{
			neueKnoten = getNachfolger(knoten);	
			System.out.println(" ");
			printKnoteAusListe(neueKnoten);
		}
		while(neueKnoten != null){
			System.out.println("");
			System.out.println("Ebene: "+ count);
			String ergebnis = tiefensuche(erster(neueKnoten), ziel);
			if(ergebnis == " \"L�sung gefunden\""){
				ergebnis = " \"L�sung gefunden\"";			
				return ergebnis;
			}		
			neueKnoten = rest(neueKnoten);
		}ergebnis = " \"Keine L�sung\"";					
		return ergebnis;		
	}
	
}
