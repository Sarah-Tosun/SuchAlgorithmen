import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/** 
 * Algorithmus: Heuristische Suche A* 8-Puzzle
 * Anzahl der falschen Plättchen
 * Autor: Sarah Tosun
 * */
public class HeuristischeSuche implements Hilfsfunktionen{
	
	private String ergebnis;
	private int[][] ziel;

	public String heuristischeSuche(HeuristikKnoten start, int[][] ziel) throws InterruptedException {
		this.ziel = ziel;
		List<HeuristikKnoten> knotenListe = new ArrayList<HeuristikKnoten>();
		knotenListe.add(start);
		knotenListe.get(0).bewertungBerechnen(start.getKnoten(), ziel, 0);
		int level = 0;
		System.out.println("Suche läuft, bitte warten");
		while(true){
			if(knotenListe.isEmpty()){
				ergebnis = " \"Keine Lösung\"";
				return ergebnis;				
			}
			HeuristikKnoten knoten = knotenListe.get(0);
			knotenListe = restHeuristik(knotenListe);
			if(zielErreichtHeuristik(knoten, ziel) == true){
				ergebnis = " \"Lösung gefunden\"";	
				return ergebnis;
			}
			level = knoten.getBewertung()[0];
			knotenListe = einsortieren(getNachfolger(knoten.getKnoten()), knotenListe, level, knoten);
		}	
	}

	private boolean zielErreichtHeuristik(HeuristikKnoten knoten, int[][] ziel2) throws InterruptedException {
		int count = 0;
		for(int i = 0; i < knoten.getKnoten().length; i++){
			for(int j = 0; j < knoten.getKnoten().length; j++){
				if(knoten.getKnoten()[i][j] == ziel[i][j]){
					count += 1;
				}				
			}
		}if(count == 9){
			printKnoten(knoten.getKnoten());
			System.out.print(" "+knoten.getBewertung()[0]);
			System.out.print(" "+knoten.getBewertung()[1]);
			System.out.print(" "+knoten.getBewertung()[2]);
			System.out.println("");
			printKnoten(knoten.getKnoten());
			System.out.print(" "+knoten.getBewertung()[0]);
			System.out.print(" "+knoten.getBewertung()[1]);
			System.out.print(" "+knoten.getBewertung()[2]);
			System.out.println("");
			while(knoten.getParent() != null){
				printKnoten(knoten.getParent().getKnoten());
				System.out.print(" "+knoten.getParent().getBewertung()[0]);
				System.out.print(" "+knoten.getParent().getBewertung()[1]);
				System.out.print(" "+knoten.getParent().getBewertung()[2]);
				knoten = knoten.getParent();
				System.out.println("");
			}
			return true;			
		}else{
//			Thread.sleep(100);
//			System.out.println("Suche läuft, bitte warten");
			return false;
		}
	}

	private List<HeuristikKnoten> restHeuristik(List<HeuristikKnoten> knotenListe) {		
		knotenListe.remove(0);
		return knotenListe;
	}

	private List<HeuristikKnoten> einsortieren(List<int[][]> nachfolger, List<HeuristikKnoten> knotenListe, int ebene, HeuristikKnoten parent) {
		HeuristikKnoten heuristikKnoten;
		for(int[][] knoten : nachfolger){
			heuristikKnoten = new HeuristikKnoten(knoten, parent);	
			heuristikKnoten.bewertungBerechnen(knoten, ziel, ebene+1);
			knotenListe.add(heuristikKnoten);
			if(zyklenchen(heuristikKnoten, heuristikKnoten.getBewertung()[0]) == true){
				knotenListe.remove(heuristikKnoten);
			}
		}
		Collections.sort(knotenListe);
		return knotenListe;
	}

	//Vgl aktueller Knoten mit Vorvorgänger, Zyklen der Länge 2 vermeiden
	private boolean zyklenchen(HeuristikKnoten heuristikKnoten, int ebene) {
		if(ebene > 1){ //erst auf Ebene 2 davor kein Parent
			if(Arrays.deepEquals(heuristikKnoten.getKnoten(), heuristikKnoten.getParent().getParent().getKnoten())){
				return true;
			}
		}		
		return false;
	}

}
