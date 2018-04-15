import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String [] args) throws InterruptedException
	{	
		String ergebnis;
		List<int[][]> list = new ArrayList<>();
		
		int[][] startB = {{1,0,3}, {4,2,6}, {7,5,8}};
		//Vorgabeknoten A*
		int[][] startA = {{2,0,4}, {6,7,1}, {8,5,3}};
		//für Tiefensuche
		int[][] startT = {{1,2,0}, {4,5,3}, {7,8,6}};
		list.add(startB);
		
		int[][] ziel = {{1,2,3}, {4,5,6}, {7,8,0}};
		
		System.out.println("Breitensuche");
		Breitensuche breitenSuche = new Breitensuche();
		ergebnis = breitenSuche.breitensuche(list, ziel);
		System.out.println(ergebnis);
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Tiefensuche");
		Tiefensuche tiefenSuche = new Tiefensuche();
		ergebnis = tiefenSuche.tiefensuche(startT, ziel);
		System.out.println(ergebnis);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println(" ");
		System.out.println("Iterative Deepening");
		IterativeDeepening iterativeDeepening = new IterativeDeepening();
		ergebnis = iterativeDeepening.iterativeDeepening(startB, ziel);
		System.out.println(ergebnis);
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println(" ");
		System.out.println("HeuristischeSuche");
		HeuristikKnoten knoten = new HeuristikKnoten(startA, null);
		HeuristischeSuche heuristischeSuche = new HeuristischeSuche();
		ergebnis = heuristischeSuche.heuristischeSuche(knoten, ziel);
		System.out.println(ergebnis);
	}
	
}
