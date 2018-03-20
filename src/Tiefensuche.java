import java.util.ArrayList;
import java.util.List;

public class Tiefensuche implements Nachfolger{;

	public boolean tiefensuche(List<int[][]> knoten, int[][] ziel) {

		if(findeLoesung(knoten, ziel)){
			return true;
		}else{
			List<int[][]> neueKnoten = nachfolger(knoten);
			while(neueKnoten != null){
				boolean ergebnis = tiefensuche(erster(neueKnoten), ziel);
				if(ergebnis == true){
					System.out.println("Lösung");
				}else{
					System.out.println("Noch keine Lösung");
				}			
				neueKnoten = rest(neueKnoten);
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
						neueKnoten = verschieben(knoten.get(0), i, j);
						System.out.print("neu");
						return neueKnoten;
					}
				}
			}return neueKnoten;	
		}

}
