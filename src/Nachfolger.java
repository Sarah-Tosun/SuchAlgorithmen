import java.util.ArrayList;
import java.util.List;

public interface Nachfolger {
	
	public default List<int[][]> getNachfolger(int[][] knoten) {
		List<int[][]> neueKnoten = null;			
			for(int i = 0; i < knoten.length; i++){
				for(int j = 0; j < knoten.length; j++){
					if(knoten[i][j] == 0){
						neueKnoten = verschieben(knoten, i, j);
						System.out.print(" ");
//						neueKnoten.add(knoten);
						return neueKnoten;
					}
				}
			}
		return neueKnoten;			
	}


	default List<int[][]> verschieben(int[][] ks, int i, int j) {
		
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
	
	public default boolean zielErreicht(int[][] knoten, int[][] ziel) {
		int count = 0;
			for(int i = 0; i < knoten.length; i++){
				for(int j = 0; j < knoten.length; j++){
					if(knoten[i][j] == ziel[i][j]){
						count += 1;
					}				
				}
			}if(count == 9){
				printKnoten(knoten);
				return true;							
			}else{	
				printKnoten(knoten);
				System.out.print("");
				return false;
			}							
	}
	
	public static void printKnoten(int[][] knoten){
		for(int i1 = 0; i1 < knoten.length; i1++){
			for(int j = 0; j < knoten.length; j++){
				System.out.print(knoten[i1][j]);
			}
		}
	}


}
