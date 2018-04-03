import java.util.List;
/** 
 * Algorithmus: Iterative Deepening 8-Puzzle
 * Autor: Sarah Tosun
 * */
public class IterativeDeepening implements Hilfsfunktionen{
	
	private int count;
	private String ergebnis = "";
	private int tiefenschranke;
	
	public String iterativeDeepening(int[][] knoten, int[][] ziel) {
		tiefenschranke = 0;
		ergebnis = " \"Keine Lösung\"";
		while(ergebnis == " \"Keine Lösung\""){
			if(ergebnis == " \"Lösung gefunden\""){
				ergebnis = " \"Lösung gefunden\"";			
				return ergebnis;
			}else if(tiefenschranke == 0){
				System.out.println("Tiefe:" +0);
			}else{
				System.out.println(" ");
				System.out.println("---------------------------------------------");
				System.out.println("Tiefe:" +tiefenschranke);
			}
			ergebnis = tiefenSucheB(knoten, ziel, 0, tiefenschranke);
			tiefenschranke += 1;
			count = 0;
		}
		return ergebnis;
	}
	
	public String tiefenSucheB(int[][] knoten, int[][] ziel, int tiefe, int schranke) {
		List<int[][]> neueKnoten;
		count++;
		if(zielErreicht(knoten, ziel)){
			ergebnis = " \"Lösung gefunden\"";			
			return ergebnis;
		}neueKnoten = getNachfolger(knoten);
		while(!neueKnoten.isEmpty() && tiefe < schranke){
			System.out.println(" ");
			System.out.println("Ebene: "+ count);
			ergebnis = tiefenSucheB(erster(neueKnoten), ziel, tiefe + 1, schranke);				
			if(ergebnis == " \"Lösung gefunden\""){
				ergebnis = " \"Lösung gefunden\"";			
				return ergebnis;
			}
			neueKnoten = rest(neueKnoten);	
			System.out.print("Rest: ");
			printKnoteAusListe(neueKnoten);
		}
		count-= 1;
		ergebnis = " \"Keine Lösung\"";
		return ergebnis;							
	}

}
