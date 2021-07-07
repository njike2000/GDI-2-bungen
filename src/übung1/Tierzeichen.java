package übung1;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tierzeichen {
	public static Scanner sc = new Scanner(System.in);

	public static String [] Tierzeichen = {"Tiger","Hase","Drache","Schlange","Pfeld","Ziege","Affe","Hahn","Hund","Schwein","Ratte","BÜffel" };

	public static int JahreEinlesen(int jahren) {
		int rest = 0;
		while(true) {
			try {
				
				if(!(jahren >= 0) ) {
					System.out.println(" Geben Sie bitte ein Zahl, die >= 0 ist");
					
				}
				else {
					rest = jahren % 12;
				}
				break;
			}
			catch(InputMismatchException x){
				String k = sc.nextLine();
				System.out.println("Ihre Eingabe " + k +" ist nicht gultig");
			}
		}
		
		return rest;
	}
	
	public static String ChinesicheZeichen(int n){
		String Tieren = null;
		  int m = n ;
		
		for(int i = 0; i < 12; i++) {
			
			if(i == m) {
				Tieren = Tierzeichen[i];
				
			}
		}
		return Tieren;
	}
	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Geben Sie bitte ein Jahr ein ");
			int Jahre	 = sc.nextInt();
		
		Jahre = JahreEinlesen(Jahre);
		ChinesicheZeichen(Jahre);
		System.out.println(JahreEinlesen(Jahre));
		System.out.println("Die Tierzeichen von dem eingegebenen Jahr ist : " + ChinesicheZeichen(Jahre));
		
		
			
		
	}

}
