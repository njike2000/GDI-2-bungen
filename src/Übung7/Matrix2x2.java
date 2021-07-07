package Übung7;

class Matrix2x2 {
	
	private double mMatrix2x2[][];
	public static final Matrix2x2 Null = new Matrix2x2(0, 0, 0, 0);
	public static final Matrix2x2 EINHEIT = new Matrix2x2(1.0, 0.0, 0.0, 1.0);
	
	public Matrix2x2 (double a, double b, double c, double d) {
		this.mMatrix2x2 = new double[][] {{a,b},{c,d}};
	}
	
	public void set(int zeile, int spalte, double wert) {
		this.mMatrix2x2[zeile][spalte] = wert ; 
	}
	
	public double get(int zeile, int spalte) {
		return this.mMatrix2x2[zeile][spalte];
	}
	
	public void add(Matrix2x2 A) {
		
		
		for(int i = 0; i < mMatrix2x2.length; i++) {
			for(int j = 0; j < mMatrix2x2[0].length; j++) {
				this.mMatrix2x2[i][j] = mMatrix2x2[i][j] + A.get(i, j);
				System.out.println(this.mMatrix2x2[i][j]);
			}
		}
	}
	
	public void sub(Matrix2x2 A) {
		
		
		for(int i = 0; i < mMatrix2x2.length; i++) {
			for(int j = 0; j < mMatrix2x2[0].length; j++) {
				this.mMatrix2x2[i][j] = mMatrix2x2[i][j] - A.get(i, j);
				System.out.println(this.mMatrix2x2[i][j]);
			}
		}
	}
	
	public void mult(Matrix2x2 A) {
		
		double a = ((this.mMatrix2x2[0][0] * A.get(0, 0)) + (this.mMatrix2x2[0][1] * A.get(1, 0)));
		double b = ((this.mMatrix2x2[0][0] * A.get(0, 1)) + (this.mMatrix2x2[0][1] * A.get(1, 1)));
		double c = ((this.mMatrix2x2[1][0] * A.get(0, 0)) + (this.mMatrix2x2[1][1] * A.get(1, 0)));
		double d = ((this.mMatrix2x2[1][0] * A.get(0, 1)) + (this.mMatrix2x2[1][1] * A.get(1, 1)));
		
		Matrix2x2 e = new Matrix2x2(a,b,c,d);
	    this.mMatrix2x2 = e.mMatrix2x2;
		
		System.out.println(e);
	}
	
	public double determinante() {
		return (this.mMatrix2x2[0][0]*this.mMatrix2x2[1][1]) - (this.mMatrix2x2[1][0]*this.mMatrix2x2[0][1]);
	}
	
	public boolean istRegulaer() {
		double m = determinante();
		if(m == 0.0)
			return false;
		else
			return true;
	}
	
	public Matrix2x2 inverse() {
		double m = determinante();
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		try {
		if(this.istRegulaer()) {
			 a = ((1 / m) * this.mMatrix2x2[0][0]);
			 b = ((1 / m) * -this.mMatrix2x2[0][1]);
			 c = ((1 / m) * -this.mMatrix2x2[1][0]);
			 d = ((1 / m) * this.mMatrix2x2[1][1]);
			}
		}
		catch(ArithmeticException n) {
			System.out.println(" Inverse kann nicht berechnen werden,"
					+ " weil der Matrix nicht Regular ist ");
		}
		return new Matrix2x2(a,b,c,d);
	}
	
	public String toString() {
		String result ;
		result = "((" + this.get(0, 0) + "," + this.get(0, 1) + ")" + "," + 
		  "(" + this.get(1, 0) + "," + this.get(1, 1) + "))";
		return result;
	}
	
	public static Matrix2x2 add(Matrix2x2 A, Matrix2x2 B) {
	
		double a = (A.get(0, 0) + B.get(0, 0));
		double b = (A.get(0, 1) + B.get(0, 1));
		double c = (A.get(1, 0) + B.get(1, 0));
		double d = (A.get(1, 1) + B.get(1, 1));
			Matrix2x2 ans = new Matrix2x2(a,b,c,d);
		return ans;
	}
	
	public static Matrix2x2 sub(Matrix2x2 A, Matrix2x2 B) {
		
		double a = (A.get(0, 0) - B.get(0, 0));
		double b = (A.get(0, 1) - B.get(0, 1));
		double c = (A.get(1, 0) - B.get(1, 0));
		double d = (A.get(1, 1) - B.get(1, 1));
			Matrix2x2 ans = new Matrix2x2(a,b,c,d);
		return ans ;
	}
	
	public static Matrix2x2 mult(Matrix2x2 A, Matrix2x2 B) {
		Matrix2x2 ans = null;
		double a = ((A.get(0, 0) * B.get(0, 0)) + (A.get(0, 1) * B.get(1, 0)));
		double b = ((A.get(0, 0) * B.get(0, 1)) + (A.get(0, 1) * B.get(1, 1)));
		double c = ((A.get(1, 0) * B.get(0, 0)) + (A.get(1, 1) * B.get(1, 0)));
		double d = ((A.get(1, 0) * B.get(0, 1)) + (A.get(1, 1) * B.get(1, 1)));
			ans = new Matrix2x2(a,b,c,d);
		return ans;
		
	}
	
	public static class TestMatrin2x2 {

		public static void main (String [] args) {
			Matrix2x2 m1 = new Matrix2x2(2.0, 5.0, 1.0, 10.0);
			Matrix2x2 m2 = new Matrix2x2(4.0, 6.0, 1.0, 8.0);
			Matrix2x2 A = new Matrix2x2(1.0, 5.0, 3.0, 4.0);
			Matrix2x2 B = new Matrix2x2(5.0, 3.2, 2.0, 9.0);
			
			
			m1.add(m2);
			m1.sub(m2);
			m1.mult(m2);
			//System.out.println(m1.mult(m2)); 
			System.out.println(m2.determinante());
			System.out.println(m1.istRegulaer());
			m1.inverse();
			System.out.println(m2.inverse());
			System.out.println(A.toString());
			System.out.println(add(A, B));
			System.out.println(sub(A, B));
			Matrix2x2 C = mult(A, B);
			System.out.println(C);
		}
	}



}
