package übung3;

import java.util.Arrays;

public class ArrayÜbung1 {
	
	public static int [] toArrayInSpiralOrder (int [][] a) {
		
		int [] b = new int [a.length * a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				b[(i + j * a.length) ] = a[i][j];
			}
		}
		return b;
	 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] c = {{1,2,3,4},{5,6,7,8}};
		int [] result = toArrayInSpiralOrder(c);
		for(int i = 0; i < result.length; i++) {
			
			Arrays.sort(result);
				System.out.print((result[i]) + " ");
		}
	}
	
	

}
