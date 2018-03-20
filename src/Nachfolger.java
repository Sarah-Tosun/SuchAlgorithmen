import java.util.ArrayList;
import java.util.List;

public interface Nachfolger {
	
	public default boolean findeLoesung(List<int[][]> list, int[][] ziel) {
		int count = 0;
		for(int a = 0; a < list.size(); a++){
			for(int i = 0; i < list.get(a).length; i++){
				for(int j = 0; j < list.get(a)[i].length; j++){
					if(list.get(a)[i][j] == ziel[i][j]){
						count += 1;
					}				
				}
			}if(count == 9){
				System.out.println("");
				System.out.print("L�sung: ");
				for(int i1 = 0; i1 < list.get(a).length; i1++){
					for(int j = 0; j < list.get(a)[i1].length; j++){
						System.out.print(list.get(a)[i1][j]);
					}
				}System.out.print(" An der Stelle: ");
				System.out.println(a);
				return true;							
			}else{			
				System.out.println("");
				System.out.println("Noch keine L�sung gefunden");
				for(int i1 = 0; i1 < list.get(a).length; i1++){
					for(int j = 0; j < list.get(a)[i1].length; j++){
						System.out.print(list.get(a)[i1][j]);
					}
				}
			}
			count = 0;			
		}return false;							
	}
		
	public default List<int[][]> getNachfolger(List<int[][]> knoten, int stelle) {
		List<int[][]> neueKnoten = null;
		for(int index = stelle; index < knoten.size(); index++){			
			for(int i = 0; i < knoten.get(index).length; i++){
				for(int j = 0; j < knoten.get(index).length; j++){
					if(knoten.get(index)[i][j] == 0){
						neueKnoten = verschieben(knoten.get(index), i, j);
						System.out.println("neu");
						knoten.addAll(neueKnoten);
						return knoten;
					}
				}
			}
		}return knoten;			
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

}
