package übung2;

import java.util.Random;

public class char_Array {

	private int anzahlPalindrome = 0;
	public static char  charErzeugen() {
		Random r = new Random();
		char Menge = (char)('a' + r.nextInt(4));
		return Menge;
		
	}
	
	public void istPalindrome() {
		char [] arr = new char [10];
		char [] arrRev = new char [10];
		for(int i = 0; i < 10; i++) {
			arr[i] = charErzeugen();
		}
		for(int i = 0; i < 10; i++) {
			arrRev[i] = arr[9-i];
		}
		String arrString = new String(arr);
		String arrRevString = new String(arrRev);
		System.out.println(arrString);
		System.out.println(arrRevString);
		if(arrString == arrRevString) {
			this.anzahlPalindrome++;
		}
	}
	
	public char[] printChararray(char[] result) {
		System.out.println("Die Worte ist: ");
		for(int j = 0; j < 10; j++)
			System.out.print(result[j] + " ");
		return result;
		
	}
	
	public void palindrom() {
		 int i = 0;
		 while(i <= 100000) {
			 istPalindrome();
			 i++;
		 }
		 System.out.println(anzahlPalindrome);
	}
	
	public int getAnzahlPalindrome() {
		return anzahlPalindrome;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 new char_Array().palindrom();
		 
	}

}
