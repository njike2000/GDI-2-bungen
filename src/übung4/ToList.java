package übung4;

import java.util.ArrayList;
import java.util.List;

public class ToList {
	
	public static List<Integer> toList(boolean[] a){
		
		List<Integer> ilist = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if(a[i] != false) {
				ilist.add(i);
			}
		}
		return ilist;
	}
	

	public static void main (String [] args) {
		boolean[] b = {true, false, true, false, false, true };
		System.out.println(toList(b));
	}

}
