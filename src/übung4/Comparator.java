package übung4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Comparator {
	
	/*public static int[] findDuplikate(int[] a) {
		List<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < a.length - 1; i++) {
		for (int j = i + 1; j < a.length; j++) {
		// Ist a[i] ein Duplikat?
		if (a[i] == a[j] && tmp.contains(a[i]) == true)
		tmp.remove(a[i]);
		}
		}
		return toArray(tmp);
		} */
	public static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,25,11,0,3,1,9,6,8,9,7,4,3,5,5));
	
	public static <N> ArrayList <N> removeDuplicate(ArrayList <N> list){
		 //Creat aNew List
		ArrayList<N>  newList = new ArrayList<N>();
		for(N element: list) {
			if(!newList.contains(element)) {
				
				newList.add(element);
			}
		}
		return newList;
	}
	
	public static <N> void kriterium() {
		//Creat a new List
		List<Integer> nummer = removeDuplicate(list);
		nummer.sort(null);
		System.out.println("1. Kriterium " + nummer);
		java.util.Comparator<Object> c = Collections.reverseOrder(); 
		Collections.sort(nummer, c);
		System.out.println("2. Kriterium " + nummer);
		for(int b = 0; b < nummer.size(); b++) {
			if(b % 2 == 0) {
				System.out.println("Die gerade Zahlen Sind : " + b);
			}
			else if(b % 2 != 0) {
				System.out.println("Die ungerade Zahlen Sind : " + b);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer>  newList = new ArrayList<>();
		System.out.println("List with Duplicates: " + list);
		newList = removeDuplicate(list);
		System.out.println("List without Duplicates: " + newList);
		kriterium();
	}

}
