/**
 * HeuristikKnoten
 * @author Sarah
 *
 */
public class HeuristikKnoten implements Comparable<HeuristikKnoten> {
	
	@Override
	public int compareTo(HeuristikKnoten a) {
    	int eins = this.getBewertung()[2];
    	int zwei = a.getBewertung()[2];
    	int eins_ = this.getBewertung()[1];
    	int zwei_ = a.getBewertung()[1];
    	if(eins < zwei){
    		//aufsteigend
    		return -1;	  		
    	}else if(eins == zwei && eins_ == zwei_){
    		return 0;
    	}else{
    		//1 wäre absteigend
    		return 1;
    	}
    }
    
	private int[][] knoten = new int[3][3];
	private int[] bewertung = new int[3];
	private HeuristikKnoten parent;
	
	public HeuristikKnoten(){
	}

	public HeuristikKnoten(int[][] knoten, HeuristikKnoten parent){
		this.parent = parent;
		this.knoten = knoten;
		this.bewertung = new int[3];
	}
	
	public HeuristikKnoten getParent(){
		return parent;
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
		bewertung[0] = 0;
		int g = ebene;
		int h = 0;
		int f;

		for(int i = 0; i < knoten.length; i++){
			for(int j = 0; j < knoten.length; j++){
				if(knoten[i][j] != ziel[i][j]){
					h++;
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
