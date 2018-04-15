import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/** 
 * Algorithmus: Iterative Deepening 8-Puzzle
 * Autor: Sarah Tosun
 * */
public class IterativeDeepening implements Hilfsfunktionen{
	
	private int count = 0;
	private String ergebnis = "";
	private int tiefenschranke;
	private String noResult = " \"Keine Lösung\"";
	private String result = " \"Lösung gefunden\"";
	
	public String iterativeDeepening(int[][] knoten1, int[][] ziel) throws InterruptedException {
		tiefenschranke = 0;
		ergebnis = noResult;
		Knoten knoten = new Knoten(knoten1, null, 0, 0);
		while(ergebnis == noResult){
			printTiefe(tiefenschranke);
			ergebnis = tiefenSucheB(knoten, ziel, 0, tiefenschranke);
			tiefenschranke++;
		}
		return ergebnis;
	}

	//TiefensucheB Tiefe erhoehen, Schranke feste Tiefe bis while Schleife, tiefe < schranke erreicht return
	public String tiefenSucheB(Knoten knoten, int[][] ziel, int tiefe, int schranke) throws InterruptedException {
		List<Knoten> neueKnoten;
		if(zielErreichtIterative(knoten, ziel) == true){	
			ergebnis = result;			
			return ergebnis;
		}
		count++;
		neueKnoten = nachfolgerKnoten(getNachfolger(knoten.getKnoten()), knoten, count, schranke);		
		while(!neueKnoten.isEmpty() && tiefe < schranke){	
			//Aufruf Rekursive
			ergebnis = tiefenSucheB(erster(neueKnoten), ziel, tiefe + 1, schranke);
			neueKnoten = rest(neueKnoten);	
			if(ergebnis == result){		
			return ergebnis;
			}
			//Für vollständige Ausgabe
//			System.out.print("Rest: ");
//			printKnoteAusListe(neueKnoten);
//			System.out.println(" ");
		}
		count--;
		return ergebnis;							
	}
	
	
	private boolean zielErreichtIterative(Knoten knoten, int[][] ziel) {
		int count = 0;
		for(int i = 0; i < knoten.getKnoten().length; i++){
			for(int j = 0; j < knoten.getKnoten().length; j++){
				if(knoten.getKnoten()[i][j] == ziel[i][j]){
					count += 1;
				}				
			}
		}if(count == 9){	
			System.out.println(" ");
			printKnoten(knoten.getKnoten());
			System.out.print(" Ebene: ["+knoten.getEbene()+"]");
			System.out.print(" Tiefe: ["+knoten.getTiefe()+"]");
			while(knoten.getParent() != null){
				System.out.println(" ");
				printKnoten(knoten.getParent().getKnoten());
				System.out.print(" Ebene ["+knoten.getParent().getEbene()+"]");
				knoten = knoten.getParent();
			}
			return true;		
		}else{	
//			Für vollständige Ausgabe
//			System.out.println(" ");
//			printKnoten(knoten.getKnoten());
//			System.out.print(" ["+knoten.getEbene()+"]");
			return false;
		}
	}
		

	private List<Knoten> nachfolgerKnoten(List<int[][]> nachfolger, Knoten parent, int ebene, int tiefe) {
		List<Knoten> knotenListe = new ArrayList<>();
		Knoten nachfolgerKnoten;
		//Nachfolger-Knoten erzeugen, Werte zuweisen und in einer Liste speichern
		for(int[][] knoten : nachfolger){
			nachfolgerKnoten = new Knoten(knoten, parent, ebene, tiefe);		
			knotenListe.add(nachfolgerKnoten);
		}
		return knotenListe;
	}

	private void printTiefe(int tiefenschranke2) {
		if(tiefenschranke2 == 0){
			System.out.println("Tiefe:" +0);
		}else{
			System.out.println(" ");
			System.out.println("---------------------------------------------");
			System.out.println("Tiefe:" +tiefenschranke2);
		}		
	}
	
	public void printKnoteAusListe(List<Knoten> neueKnoten) {
		if(neueKnoten == null){
			System.out.println("Kein Rest");
		}
		for(Knoten knoten : neueKnoten){
			System.out.print("Ebene: ["+knoten.getEbene()+"] ");
			printKnoten(knoten.getKnoten());
			System.out.print(" ");
		}	
	}
	
	//Liefert den Rest der Knoten, außer den ersten
	public List<Knoten> rest(List<Knoten> knotenListe) {
		knotenListe.remove(0);		
		return knotenListe;
	}
	
	//Liefert den ersten Knoten
	public Knoten erster(List<Knoten> knoten) {
		return knoten.get(0);
	}
	
}
