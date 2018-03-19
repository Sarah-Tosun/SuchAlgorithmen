import java.util.ArrayList;
import java.util.List;

public class IterativeDeepening {
	private Breitensuche loesungFinden = new Breitensuche();
	int tiefenschranke = 0;
	public void iterativeDeepening(List<int[][]> knoten, int[][] ziel) {
		boolean ergebnis = false;
		while(ergebnis == false){
			ergebnis = tiefenSucheB(knoten, ziel, 0, tiefenschranke);
			tiefenschranke += 1;
			if(ergebnis == true){
				ergebnis = true;
			}
		}
	}
	
	public boolean tiefenSucheB(List<int[][]> knoten, int[][] ziel, int tiefe, int schranke) {
		if(loesungFinden.findeLoesung(knoten, ziel)){
			return true;
		}else{
			List<int[][]> neueKnoten = nachfolger(knoten);
			boolean ergebnis;
			while(neueKnoten != null && tiefe < schranke){
				ergebnis = tiefenSucheB(erster(neueKnoten), ziel, tiefe+1, schranke);				
				neueKnoten = rest(neueKnoten);
				return ergebnis;
			}
		}
		return false;
	}

	private List<int[][]> rest(List<int[][]> knotenListe) {
		List<int[][]> neueKnoten = new ArrayList<>();
		for(int i = 1; i < knotenListe.size(); i++){
			neueKnoten.add(knotenListe.get(i));
		}		
		return neueKnoten;
	}

	private List<int[][]> erster(List<int[][]> knoten) {
		List<int[][]> newKnoten = new ArrayList<>();
		newKnoten.add(knoten.get(0));
		return newKnoten;
	}

	private List<int[][]> nachfolger(List<int[][]> knoten) {
		List<int[][]> neueKnoten = null;		
			for(int i = 0; i < knoten.get(0).length; i++){
				for(int j = 0; j < knoten.get(0).length; j++){
					if(knoten.get(0)[i][j] == 0){
						neueKnoten = loesungFinden.verschieben(knoten.get(0), i, j);
						System.out.print("neu");
						return neueKnoten;
					}
				}
			}return neueKnoten;	
		}

}
