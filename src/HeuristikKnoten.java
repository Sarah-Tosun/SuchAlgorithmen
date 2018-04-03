
public class HeuristikKnoten implements Comparable<HeuristikKnoten> {
	
	@Override
	public int compareTo(HeuristikKnoten a) {
    	int eins = this.getBewertung()[2];
    	int zwei = a.getBewertung()[2];
    	return eins < zwei ? -1: eins == zwei ? 0: 1 ;
    }
    
	private int[][] knoten;
	private int[] bewertung = new int[3];

	public HeuristikKnoten(int[][] knoten){
		this.knoten = knoten;
		this.bewertung = new int[3];
	}
	
	public int[] getBewertung(){
		return bewertung;
	}
	
	public void setEbene(int ebene){
		this.bewertung[0] = ebene;
	}
	
	public int[][] getKnoten(){
		return knoten;
	}

	public int[] bewertungBerechnen(int[][] knoten2, int[][] ziel, int ebene) {
		int g = ebene;
		int h = 0;
		int f;

		for(int i = 0; i < knoten.length; i++){
			for(int j = 0; j < knoten.length; j++){
				if(knoten[i][j] != ziel[i][j]){
					h++;
					if(knoten[i][j] == 0){
						h--;
					}
				}
			}
		}
		bewertung[0] = g;
		bewertung[1] = h;
		f = g + h;
		bewertung[2] = f;
		return bewertung;
	}
}
