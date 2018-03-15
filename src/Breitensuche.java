import java.util.ArrayList;
import java.util.List;

public class Breitensuche {
	private static int count = 0;
	void breitensuche( List<int[][]> list, int[][] ziel) {

		if(findeLoesung(list, ziel)){
	
		}else{
			List<int[][]> neueListe = findeMoeglichkeiten(list, count);
			System.out.println("");
			for(int a = 0; a < neueListe.size(); a++){
				for(int b = 0; b < neueListe.get(a).length; b++){
					for(int c = 0; c < neueListe.get(a)[b].length; c++){
						System.out.print(neueListe.get(a)[b][c]);							
					}						
				}System.out.print(" ");					
			}
			count += 1;
			breitensuche(neueListe, ziel);
		}			
	}	

private static boolean findeLoesung(List<int[][]> list, int[][] ziel) {
	int count = 0;
	for(int a = 0; a < list.size(); a++){
		for(int i = 0; i < list.get(a).length; i++){
			for(int j = 0; j < list.get(a)[i].length; j++){
				if(list.get(a)[i][j] == ziel[i][j]){
					count += 1;
				}				
			}if(count == 9){
				System.out.println("");
				System.out.print("Lösung: ");
				for(int i1 = 0; i1 < list.get(a).length; i1++){
					for(int j = 0; j < list.get(a)[i1].length; j++){
						System.out.print(list.get(a)[i1][j]);
					}
				}System.out.print(" An der Stelle: ");
				System.out.println(a);
				return true;							
			}
		}count = 0;			
	}return false;							
}

private static List<int[][]> findeMoeglichkeiten(List<int[][]> list, int stelle) {
	List<int[][]> neueListe = null;
	for(int index = stelle; index < list.size(); index++){			
		for(int i = 0; i < list.get(index).length; i++){
			for(int j = 0; j < list.get(index).length; j++){
				if(list.get(index)[i][j] == 0){
					neueListe = verschieben(list.get(index), i, j);
					System.out.print("neu");
					list.addAll(neueListe);
					return list;
				}
			}
		}
	}return list;			
}

private static List<int[][]> verschieben(int[][] ks, int i, int j) {
	
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
