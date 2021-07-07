package übung5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlternatingList {

	public static List<Integer> toAlternatingList(int[] a){
		
		List<Integer> AList = new ArrayList<Integer>();
		List<Integer> ilist = new ArrayList<Integer>();
		
		//Unsere list anfang ausfühlen
		for (int i = 0; i < a.length; i++) {
			ilist.add(a[i]);
		}
		int lengvongl =0;
		int lengvonungerade = 0;
		
		
		for (int i = 0; i < a.length; i++) {
			if(a[i]%2==0) {
				lengvongl++;
			}
			else {
				lengvonungerade++;
			}
		}
		
		if(lengvongl == a.length) {
			for(int x: a) {
				AList.add(x);
			}
		}
		else if(lengvonungerade == a.length){ //Wenn die length von a == unsere variable d.h es gibt nur ungerade element in unsereliste
			for(int y: a) {
				AList.add(y); //wir fühlen die ganze liste mit element wie vorgegeben
			}
		}
		else {
			
			//wir ------
			List<Integer> gerade = new ArrayList<Integer>();
			List<Integer> ungerade = new ArrayList<Integer>();
			
			//Wir fühlen die Arrays
			for(int x: a) {
				if (x % 2 == 0) {
					gerade.add(x);
				}
			}
			System.out.println(gerade);
			
			for(int x: a) {
				if (x % 2 != 0) {
					ungerade.add(x);
				}
			}
			System.out.println(ungerade);
			
			for (int i = 0; i < ilist.size(); i++) {
				
				if(i % 2 == 0) {
					AList.add(gerade.get(i));
					gerade.remove(i);
				}else {
					AList.add(ungerade.get(i));
					ungerade.remove(i);
				}
				
			}
		}
		
		return AList;
	}
	
	
	public static List<Integer> listAuf(int size){
		List<Integer> myList = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			myList.add(i);
		}
		
		return myList;
	}

	public static List<Integer> triBull(int[] a){
		
		int size = a.length;
		boolean inverse;
		
		do {
			inverse = false;
			
			for (int i = 0; i < size-1; i++) {
				if (a[i]> a[i+1]) {
					swap(a,i,i+1);
					inverse = true;
				}
			}
			
		} while (inverse);
		
		List<Integer> List = new LinkedList<Integer>();
		for (int i = 0; i < a.length-1; i++) {
			List.add(a[i]);
		}
		
		
		return List;
	}
	
	public static void swap(int[] a,int i,int j) {
		int memory = a[i];
		a[i] = a[j];
		a[j] = memory;
	}

	public static void main(String[] args) {
		
		int[] a = new int[] {1,3,6,98,25,32,4,9};
		int[] a1 = new int[] {2,4,8,12,16};
		
		System.out.println(toAlternatingList(a));
		listAuf(5);
		System.out.println(triBull(a1));

	}

}