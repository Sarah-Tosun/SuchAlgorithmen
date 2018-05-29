import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String [] args) throws InterruptedException, IOException
	{	
//		String ergebnis;
//		List<int[][]> list = new ArrayList<>();
//		
//		int[][] startB = {{1,0,3}, {4,2,6}, {7,5,8}};
//		//Vorgabeknoten A*
//		int[][] startA = {{2,0,4}, {6,7,1}, {8,5,3}};
//		//für Tiefensuche
//		int[][] startT = {{1,2,0}, {4,5,3}, {7,8,6}};
//		list.add(startB);
//		
//		int[][] ziel = {{1,2,3}, {4,5,6}, {7,8,0}};
//		
//		double[][] menge1Test = {{0,1.8}, {2,0.6}};
//		double[][] menge2Test = {{-1.2,1.4}, {0.4,-1}};

//		double[][] menge1 = {{6,1,1}, {7,3,1}, {8,2,1}, {9,0,1}};
//		double[][] menge2 = {{8,4,1}, {8,6,1}, {9,2,1}, {9,5,1}};
		
		double[][] menge1 = {{6,1}, {7,3}, {8,2}, {9,0}};
		double[][] menge2 = {{8,4}, {8,6}, {9,2}, {9,5}};
		
//		System.out.println("Breitensuche");
//		Breitensuche breitenSuche = new Breitensuche();
//		ergebnis = breitenSuche.breitensuche(list, ziel);
//		System.out.println(ergebnis);
//		System.out.println("-----------------------------------------------------------------------------------");
//		
//		System.out.println("Tiefensuche");
//		Tiefensuche tiefenSuche = new Tiefensuche();
//		ergebnis = tiefenSuche.tiefensuche(startT, ziel);
//		System.out.println(ergebnis);
//		System.out.println("-----------------------------------------------------------------------------------");
//
//		System.out.println(" ");
//		System.out.println("Iterative Deepening");
//		IterativeDeepening iterativeDeepening = new IterativeDeepening();
//		ergebnis = iterativeDeepening.iterativeDeepening(startB, ziel);
//		System.out.println(ergebnis);
//		System.out.println("-----------------------------------------------------------------------------------");
//		
//		System.out.println(" ");
//		System.out.println("HeuristischeSuche");
//		HeuristikKnoten knoten = new HeuristikKnoten(startA, null);
//		HeuristischeSuche heuristischeSuche = new HeuristischeSuche();
//		ergebnis = heuristischeSuche.heuristischeSuche(knoten, ziel);
//		System.out.println(ergebnis);
//		
		
		Perzeptron perzeptron = new Perzeptron();
		perzeptron.perzeptronLernregel(menge1, menge2);
//		perzeptron.perzeptronLernregel(menge1Test, menge2Test);
		
//		FileReader fr = null;
//		StringBuffer sb = null;
//		try
//		{
//		   String fileName="app1_data.data";
//		   fr = new FileReader(fileName);
//		   sb = new StringBuffer();
//		   ArrayList<Double> lines = new ArrayList<Double>();
//		   int ch;
//		   while( (ch = fr.read()) != -1 )
//		      sb.append((char)ch);
//		      System.out.println(sb.toString());
//		}catch(FileNotFoundException ex){			
//		}finally{			
//		}
//		
//		String s = sb.toString();
//		System.out.println(s.charAt(0));
		double[] newPoint = {1,2};
		double[][] mengePos = {{6,5}, {1,1}, {3,7}, {11,1}};
		double[][] mengeNeg = {{-3,-2},{-12,-14},{-1,-2},{-9,-7}};

		KNearestNeighbour kNN = new KNearestNeighbour();
		kNN.kNearestNeighbour(mengePos,mengeNeg, newPoint);
//		
	}
	
}
