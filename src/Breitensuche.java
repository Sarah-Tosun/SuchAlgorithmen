import java.util.ArrayList;
import java.util.List;

public class Breitensuche implements Nachfolger{
	
	private int count = 0;
	private String ergebnis = "";
	
	public String breitensuche(List<int[][]> knotenListe, int[][] ziel) {
		List<int[][]> neueKnoten = new ArrayList<>();

		count ++;
		
		for(int[][] knoten : knotenListe){
			if(zielErreicht(knoten, ziel)){
				ergebnis = " \"L�sung gefunden\"";			
				return ergebnis;
			}else{
				neueKnoten = Append(neueKnoten, getNachfolger(knoten));
			}
		}
		if(neueKnoten != null){
			System.out.println("");
			System.out.println("Ebene: "+ count);
			breitensuche(neueKnoten, ziel);
		}else{
			ergebnis = " \"Keine L�sung\"";	
			return ergebnis;	
		}
		return ergebnis;			
	}
	
	private List<int[][]> Append(List<int[][]> neueKnoten2, List<int[][]> nachfolger) {
		for(int[][] knoten : nachfolger){
			neueKnoten2.add(knoten);
		}return neueKnoten2;
	}
	

}
