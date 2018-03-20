import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String [] args)
	{	
		List<int[][]> list = new ArrayList<>();
//		int[][] start = {{2,5,0}, {1,4,8}, {7,3,6}};
		int[][] start = {{1,0,3}, {4,2,5}, {7,8,6}};
		list.add(start);
		int[][] ziel = {{1,2,3}, {4,5,6}, {7,8,0}};
		
		Breitensuche breitenSuche = new Breitensuche();
		breitenSuche.breitensuche(list, ziel);
		
//		Tiefensuche tiefenSuche = new Tiefensuche();
//		tiefenSuche.tiefensuche(list, ziel);
		
//		IterativeDeepening iterativeDeepening = new IterativeDeepening();
//		iterativeDeepening.iterativeDeepening(list, ziel);
	}
	
}
