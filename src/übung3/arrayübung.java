package übung3;

public class arrayübung {
	 
	public static int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
	@SuppressWarnings("unused")
	public static int [][]aufteilen (int [] a){
		
		int[] geradeZahl = new int[a.length];
		int[] ungeradeZahl = new int[a.length];
		
		if( a == null ) {
			return new int [][] { new int [0], new int [0]};
		}
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 0) {
				geradeZahl[i] = a[i];
			}
			if(a[i] % 2 != 0) {
				ungeradeZahl[i] = a[i];
			}
		}
		
		 return new int[][] {geradeZahl, ungeradeZahl};
	}
		 
		
		/*int k = 0;
		int rows = 0, colms = 0;
		int result [][] = new int [rows][colms];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < colms; j++) {
				if( a[k] % 2 == 0) {
					result[i][0] = a[k];
					k++;
				}
				if(a[k] % 2 != 0) {
					result[0][j] = a[k];
					k++;
				}
			}
		
		}
		return result;*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] result = aufteilen(b);
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}


	

}
