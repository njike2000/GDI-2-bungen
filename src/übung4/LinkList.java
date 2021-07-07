package übung4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkList {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		int n = 0;
		int [] m = {1,2,3,4,5,6,7,8,9};
		List<Integer> ilist = new ArrayList<>(n);
		
		 ilist.size();
		 for(int i : m) {
		 ilist.add(i);
		 }
		System.out.println(ilist);
		int getObj = ilist.get(5);
		System.out.println(getObj);
		ilist.remove(5);
		
		System.out.println(ilist.size());
		
		System.out.println(ilist);

	}

}
