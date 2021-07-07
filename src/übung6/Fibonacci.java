package übung6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.BarChartUtil;

public class Fibonacci {
	
	private static final int N = 10;
	private static int counter = 0;
	
	public static void fiboLaucher (int n , int []h) {
		for(int i = 1; i <= n; i++) {
			counter = 0;
			fiboRekursiv(i, h);
			h[i-1] = counter;
		}
	}
	
	public static BigInteger fiboRekursiv (int n , int []h) {
		//BigInteger f = BigInteger.ONE;
		counter++; 
		if(n == 0 || n == 1) {
			return BigInteger.ONE;
		}
		else 
			return fiboRekursiv(n-2, h).add(fiboRekursiv(n-1, h));
	}
	
	private static List<Integer> toList(int[] h) {
		List<Integer> ret = new ArrayList<>(h.length);
		for (int e : h) 
			ret.add(e); // Hier wird e automatisch vom Compiler in ein
	// Integer-Obj.
	// umgewandelt
	return ret;
	}
	
	private static void haeufigkeitAusgeben(String[] s, int[] h) {
		BarChartUtil.show("Häufigkeit", "n", "Häufigkeit", Arrays.asList(s), toList(h));
	}
	
	public static void main(String[] args){
		int[] h = new int[10];
		fiboLaucher(N, h);
		for(int i = 0; i < h.length; i++) {
			System.out.println(h[i]);
			}
		String[] label = new String[h.length];
		//for (int i = 0; i < label.length; i++) {
			//label[i] = "" + i;
		//}
		haeufigkeitAusgeben(label, h);
		}
	

}
