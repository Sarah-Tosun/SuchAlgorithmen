import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeuristischeSuche implements Hilfsfunktionen{
	
	private String ergebnis;
	private int[][] ziel;

	public String heuristischeSuche(HeuristikKnoten start, int[][] ziel) {
		this.ziel = ziel;
		List<HeuristikKnoten> knotenListe = new ArrayList<HeuristikKnoten>();
		knotenListe.add(start);
		knotenListe.get(0).bewertungBerechnen(start.getKnoten(), ziel, 0);
		int level = 0;
		while(true){
			if(knotenListe.isEmpty()){
				ergebnis = " \"Keine Lösung\"";
				return ergebnis;				
			}
			HeuristikKnoten knoten = knotenListe.get(0);
			knotenListe = restHeuristik(knotenListe);
			if(zielErreichtHeuristik(knoten, ziel)){
				ergebnis = " \"Lösung gefunden\"";			
				return ergebnis;
			}
			System.out.println(" ");

			level = level+1;
			knotenListe = einsortieren(getNachfolger(knoten.getKnoten()), knotenListe, level);
		}	
	}

	private boolean zielErreichtHeuristik(HeuristikKnoten knoten, int[][] ziel2) {
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
			return true;							
		}else{	
			printKnoten(knoten.getKnoten());
			System.out.print(" "+knoten.getBewertung()[0]);
			System.out.print(" "+knoten.getBewertung()[1]);
			System.out.print(" "+knoten.getBewertung()[2]);
			return false;
		}
	}

	private List<HeuristikKnoten> restHeuristik(List<HeuristikKnoten> knotenListe) {
		List<HeuristikKnoten> neueKnoten = new ArrayList<>();
		for(int i = 1; i < knotenListe.size(); i++){
			neueKnoten.add(knotenListe.get(i));
		}		
		return neueKnoten;
	}

	private List<HeuristikKnoten> einsortieren(List<int[][]> nachfolger, List<HeuristikKnoten> knotenListe, int ebene) {
		List<HeuristikKnoten> heuristikKnotenListe = new ArrayList<>();
		HeuristikKnoten heuristikKnoten;
		int count = 0;

		for(int[][] knoten : nachfolger){
			heuristikKnoten = new HeuristikKnoten(nachfolger.get(count));
			heuristikKnoten.bewertungBerechnen(knoten, ziel, ebene);
			heuristikKnotenListe.add(heuristikKnoten);
			count++;
		}

		for(HeuristikKnoten knoten : heuristikKnotenListe){		
			knotenListe.add(knoten);
		}
		Collections.sort(knotenListe);
		return knotenListe;
	}

}
