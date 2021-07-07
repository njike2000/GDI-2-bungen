package übung5;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SymmetrischeDifferenz {
	
	
	public static <T> Set <T> symmDiff(Set<T> A, Set <T> B){
		
		Set<T> C = new HashSet<>();
		for(T e: A) {
			if(!B.contains(e)) {
				C.add(e);
			}
		}
		for(T e: B) {
			if(!A.contains(e)) {
				C.add(e);
		}
	}
		return C;
	}

	public static void main(String[] args) {
		  
		int[] a = {1,2,3,4};
		int [] b = {3,4,5,6};
		Set<Integer> set1 = new HashSet<Integer>();
		for(int i : a)
			set1.add(i);
		Set<Integer> set2 = new HashSet<Integer>();
		for(int j : b)
		set2.add(j);
				//System.out.println(symmDiff(set1, set2));
			
			System.out.println(symmDiff(set1, set2));
		
	}

}
