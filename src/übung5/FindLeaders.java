package übung5;

import java.util.ArrayList;
import java.util.List;

public class FindLeaders {
	
	private static int [] b = {1, 7, 4, 5, 2, 6, 4, 2};
	
	public static List <Integer> findLeaders(int [] a){
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				if(a[i] < a[j]) {
					break;
				}
				if(j == a.length-1) {
					list.add(a[i]);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		List<Integer> ilist = findLeaders(b);
		System.out.println(ilist);

	}

}
