import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KNN {
	
	public void KNNAlg(double[][] point, double[] newPoint, int k) {
		
		List<Points> pointList = new ArrayList<>();
		List<Result> resultList = new ArrayList<>();
		
		//Punkte einlesen in Liste speichern mit Indexstelle
		for(int i = 0; i < point.length; i++){
			pointList.add(new Points(point[i], i));
		}
		
		for(Points koordinate : pointList){
			double dist = 0.0;
			for(int j = 0; j < koordinate.point.length; j++){
				dist += Math.pow(koordinate.point[j]-newPoint[j], 2);
			}
			double distance = Math.sqrt(dist);
			distance = Math.round(100.0 * distance) / 100.0;
			resultList.add(new Result(distance, koordinate.index, koordinate.point));
		}
		
		Collections.sort(resultList, new DistComparator());
		
		//k Schleife
		for(int j = 0; j <= k; j++){
			System.out.print(resultList.get(j).dist+", "+ resultList.get(j).index+"  [");		
			for(int i = 0; i < resultList.get(j).point.length; i++){
				System.out.print(resultList.get(j).point[i]+", ");
			}
			System.out.print("]");
		}
	}
	
	public class Points{
		double[] point;
		int index;
		 
		Points(double[] point_, int index_){
			this.point = point_;
			this.index = index_;
		}	 
	}
	
	public class Result{
		double dist;
		int index;
		double[] point;
		 
		Result(double dist_, int index_, double[] point_){
			this.dist = dist_;
			this.index = index_;
			this.point = point_;
		}	 
	}
	
	class DistComparator implements Comparator<Result> {

		 // Kleinster Value aufsteigend geordnet
		 public int compare(Result a, Result b) {
			 if (a.dist < b.dist){
				 return -1;				 
			 }else if (a.dist >= b.dist){
				 return 1;
			 }else{
				 return 0;
			 }

		 }
	} 


}
