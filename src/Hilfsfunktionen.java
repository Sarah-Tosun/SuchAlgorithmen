import java.util.ArrayList;
import java.util.List;

/** 
 * Interface Nachfolger f�r 8-Puzzle Suche
 * Nachfolger zur�ckgeben
 * Knoten auf Zielknoten pr�fen
 * Ausgabe von Knoten
 * Autor: Sarah Tosun
 * */
public interface Hilfsfunktionen {
	
	//Liefert Nachfolger, ruft nullVerschieben(...) auf
	public default List<int[][]> getNachfolger(int[][] knoten) {
		List<int[][]> neueKnoten = null;			
			for(int i = 0; i < knoten.length; i++){
				for(int j = 0; j < knoten.length; j++){
					if(knoten[i][j] == 0){
						neueKnoten = nullVerschieben(knoten, i, j);
						System.out.print(" ");
						return neueKnoten;
					}
				}
			}
		return neueKnoten;			
	}

	// Wo befindet sich die Null
	// Kopien des Knotens, Null verschieben
	default List<int[][]> nullVerschieben(int[][] ks, int i, int j) {		
		int[][] neuerKnoten1 = new int[3][3];
		int[][] neuerKnoten2 = new int[3][3];
		int[][] neuerKnoten3 = new int[3][3];
		int[][] neuerKnoten4 = new int[3][3];
		for (int i1=0; i1<ks.length; i1++){
			neuerKnoten1[i1] = ks[i1].clone();
			neuerKnoten2[i1] = ks[i1].clone();
			neuerKnoten3[i1] = ks[i1].clone();
			neuerKnoten4[i1] = ks[i1].clone();
		} 
		List<int[][]> list = new ArrayList<>();
	    int tmp;
		if(i < 2){
	    	tmp = neuerKnoten1[i][j];
	    	neuerKnoten1[i][j] = neuerKnoten1[i+1][j];
	    	neuerKnoten1[i+1][j] = tmp;
	    	list.add(neuerKnoten1);
	    }
		if(i > 0){
	    	tmp = neuerKnoten2[i][j];
	    	neuerKnoten2[i][j] = neuerKnoten2[i-1][j];
	    	neuerKnoten2[i-1][j] = tmp;
	    	list.add(neuerKnoten2);
	    }
		if(j < 2){
		    tmp = neuerKnoten3[i][j];
		    neuerKnoten3[i][j] = neuerKnoten3[i][j+1];
		    neuerKnoten3[i][j+1] = tmp;
	    	list.add(neuerKnoten3);
		}
		if(j > 0){
		    tmp = neuerKnoten4[i][j];
		    neuerKnoten4[i][j] = neuerKnoten4[i][j-1];
		    neuerKnoten4[i][j-1] = tmp;
	    	list.add(neuerKnoten4);
		}
	return list;		
	}	
	
	// Pr�fen ob der aktuelle Knoten gleich dem Zielknoten ist
	public default boolean zielErreicht(int[][] knoten, int[][] ziel) throws InterruptedException {
		int count = 0;
			for(int i = 0; i < knoten.length; i++){
				for(int j = 0; j < knoten.length; j++){
					if(knoten[i][j] == ziel[i][j]){
						count += 1;
					}				
				}
			}if(count == 9){
				printKnoten(knoten);
				System.out.print(" ");
				return true;							
			}else{	
				Thread.sleep(100);
				printKnoten(knoten);
				return false;
			}							
	}
	
	// Ausgabe Knoten
	public default void printKnoten(int[][] knoten){
		for(int i1 = 0; i1 < knoten.length; i1++){
			for(int j = 0; j < knoten.length; j++){
				System.out.print(knoten[i1][j]);
			}
		}
	}

	public default void printKnoteAusListeTiefe(List<int[][]> neueKnoten) {
		for(int[][] knoten : neueKnoten){
			printKnoten(knoten);
			System.out.print(" ");
		}		
	}
	
	public default List<int[][]> restTiefe(List<int[][]> knotenListe) {
		knotenListe.remove(0);		
		return knotenListe;
	}
	
	public default int[][] ersterTiefe(List<int[][]> knoten) {
		return knoten.get(0);
	}
	
//	public default int getEbene(){
//		int ebene = 0;
//		return ebene++;
//	}

}
