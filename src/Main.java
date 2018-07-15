import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		//Perzeptron Zweidimensional
//		double[][] menge1Test = {{0,1.8}, {2,0.6}};
//		double[][] menge2Test = {{-1.2,1.4}, {0.4,-1}};

		//Perzeptron Dreidimensional
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
//		perzeptron.perzeptronLernregel(menge1, menge2);
//		perzeptron.perzeptronLernregel(menge1Test, menge2Test);
		
		
		//KNN File einlesen mit Daten
		FileReader fr = null;
		StringBuffer sb = null;
		try
		{
			//app1_data.data oder
			//app1_test.test
		   String fileName="app1_data.data";
		   fr = new FileReader(fileName);
		   sb = new StringBuffer();
		   int ch;
		   while( (ch = fr.read()) != -1 )
		      sb.append((char)ch);
//		      System.out.println(sb.toString());
		}catch(FileNotFoundException ex){			
		}finally{			
		}
		
		String s = sb.toString();
		String[] zeile = s.split("\\n");
		String[] ziffer = null;
		
		double[][] menge = new double[zeile.length][16];
		for( int i = 0; i < zeile.length; i++ ){
			ziffer = new String[16];
			ziffer = zeile[i].split(",");
			for(int j = 0; j < ziffer.length; j++){
				menge[i][j] = Double.parseDouble(ziffer[j]);
			}		
		}

		//Testdata
//		double[] newPoint = {30.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 37.5, 38.3, 17800.0, 0.0, 0};
		double[] newPoint = {12.0, 2.0, 0, 1.0, 1.0, 0, 0, 0, 1.0, 1.0, 0, 36.3, 36.8, 22000.0, 0, 0};		

		//k nächste Nachbarn
		int k = 3;
		KNN kNNbeta = new KNN();
		kNNbeta.KNNAlg(menge, newPoint, k);

		
//		
	}
	
}
