package übung1;

import java.util.Scanner;

public class PerfekZahlen {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int summe = 0;
		int  zahl = 0 ;
		System.out.println("Geben Sie eine ganz Zahl");
		zahl =sc.nextInt();
		for(int i = 1; i < zahl; i++) {
			if(zahl % i == 0) {
				summe += i;
			}
		}
		if(summe == zahl )
			System.out.println("Die " + zahl + " ist ein Perfekt Zahl");
		else
			System.out.println("Die " + zahl + " ist Leider Keine Perfekt Zahl");
			
		sc.close();
	}

}
