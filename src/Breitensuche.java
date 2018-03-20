import java.util.List;

public class Breitensuche implements Nachfolger{
	private static int count = 0;
	void breitensuche( List<int[][]> list, int[][] ziel) {

		if(findeLoesung(list, ziel)){
			System.out.println("Lösung gefunden");
		}else{
			List<int[][]> knoten = getNachfolger(list, count);
			System.out.println("");
			printKnoten(knoten);
			count += 1;
			breitensuche(knoten, ziel);
		}			
	}	

private void printKnoten(List<int[][]> knoten) {
	for(int a = 0; a < knoten.size(); a++){
		for(int b = 0; b < knoten.get(a).length; b++){
			for(int c = 0; c < knoten.get(a)[b].length; c++){
				System.out.print(knoten.get(a)[b][c]);							
			}						
		}System.out.print(" ");					
	}		
}

}
