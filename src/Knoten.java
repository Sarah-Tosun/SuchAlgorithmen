
public class Knoten {
	
	private int[][] knoten;
	private Knoten parent;
	private int ebene;
	private int tiefe;

	public Knoten(){
	}
	
	public Knoten(int[][] knoten, Knoten parent, int ebene, int tiefe){
		this.knoten = knoten;
		this.parent = parent;
		this.ebene = ebene;
		this.tiefe = tiefe;
	}
	
	public Knoten getParent(){
		return parent;
	}
	
	public int[][] getKnoten(){
		return knoten;
	}
	
	public int getEbene(){
		return ebene;
	}
	
	public int getTiefe(){
		return tiefe;
	}
	
	public void setKnoten(int[][] knoten){
		this.knoten = knoten;
	}
	
	public void setEbene(int ebene){
		this.ebene = ebene;
	}
	
	public void setTiefe(int tiefe){
		this.tiefe = tiefe;
	}
	
	
	
	
	

}
