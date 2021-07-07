package übung3;

public class Matrix {
	
	public static void matrixAusfüllen() {
		
		int n = 4,m = 4;
		int [][] matrix = new int [n][m];
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		matrixAusfüllen();
	}

}
