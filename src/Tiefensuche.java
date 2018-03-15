import java.util.ArrayList;
import java.util.List;

public class Tiefensuche {
	private Breitensuche loesungFinden = new Breitensuche();
	public void tiefensuche(List<int[][]> knoten, int[][] ziel) {

		if(loesungFinden.findeLoesung(knoten, ziel)){
		}else{
			List<int[][]> neueKnoten = nachfolger(knoten);
			while(neueKnoten != null){
				tiefensuche(erster(neueKnoten), ziel);

			}
		}
		
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
