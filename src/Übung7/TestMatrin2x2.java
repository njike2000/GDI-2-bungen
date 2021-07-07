package Übung7;

public class TestMatrin2x2 {

	public static void main (String [] args) {
		Matrix2x2 m1 = new Matrix2x2(2.0, 5.0, 1.0, 10.0);
		Matrix2x2 m2 = new Matrix2x2(4.0, 6.0, 1.0, 8.0);
		Matrix2x2 A = new Matrix2x2(1.0, 5.0, 3.0, 4.0);
		Matrix2x2 B = new Matrix2x2(5.0, 3.2, 2.0, 9.0);
		
		
		m1.add(m2);
		m1.sub(m2);
		m1.mult(m2);
		//System.out.println(m1); 
		System.out.println(m1.determinante());
		System.out.println(m1.istRegulaer());
		m1.inverse();
		//System.out.println(m1.inverse());
		System.out.println(m1.toString());
		
		Matrix2x2 K = Matrix2x2.add(A, B);
		Matrix2x2 L = Matrix2x2.sub(A, B);
		Matrix2x2 C = Matrix2x2.mult(A, B);
		System.out.println(K);
		System.out.println(L);
		System.out.println(C);
	}
}
