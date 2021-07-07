package übung6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Kennzahl {
	
	public static <T> double Jaccard_koeff(Set<T> A, Set<T> B) {
		
		if(A.size() == 0 && B.size() == 0) {
			return 1.0;
		}
		int inter = 0;
		for(T i : A) {
			if(B.contains(i)) {
				inter++;
			}
		}
		A.addAll(B);
		int union = A.size();
		
		return 1.0 *inter / union;

	}
	public static <T> double cosinus(Set<T> A, Set<T> B) {
	  double dotProduct = 0.0;
	    double normA = 0.0;
	    double normB = 0.0;
	    Iterator<T> iteratorA = A.iterator();
	    Iterator<T> iteratorB = B.iterator();
	    while(iteratorA.hasNext()) {
	    	double valueA = (double)iteratorA.next();
	    	double valueB = (double)iteratorB.next();
	    	dotProduct += (valueA * valueB);
	    	normA += Math.pow(valueA, 2);
		    normB += Math.pow(valueB, 2);
	    }
	    return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
	}

	public static void main(String[] args) {
		Set<Double> C = new HashSet<Double>();
		Set<Double> D = new HashSet<Double>();
		C.add(1.2);
		C.add(5.0);
		C.add(8.9);
		D.add(1.2);
		D.add(5.0);
		D.add(4.9);
		double ans1 = Jaccard_koeff(C, D);
		System.out.println(ans1);
		Set<Double> E = new HashSet<Double>();
		Set<Double> F = new HashSet<Double>();
		E.add(1.2);
		E.add(5.0);
		E.add(8.9);
		F.add(1.2);
		F.add(5.0);
		F.add(4.9);
		double ans2 = cosinus(E, F);
		System.out.println(ans2);

	}

}
