package übung2;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double Gewicht = 0.0;
		double hoehe = 0.0;
		double BMI = 0.0;
		while (true) {
			
			System.out.println("--------Wilkomme bei der Boby Mass Index (BMI)--------");
			try {
				System.out.println("Wenn Sie ihre Gewicht in Pfund und Ihre hoehe in Inch geben wollen, tipppen Sie: 1");
				System.out.println("Wenn Sie ihre Gewicht in Kg und Ihre hoehe in Meter geben wollen, tipppen Sie: 2");
				System.out.println("Wenn Sie das Programm beenden möchten, tipppen Sie: 3");
				int Option = sc.nextInt();
				
				switch(Option) {
				
				case 1 :
					
					System.out.println("Geben Sie bitte Ihre Gewicht in Pfund");
					Gewicht = sc.nextDouble();
					System.out.println("Geben Sie bitte Ihre Hoehe in Inch");
					hoehe = sc.nextDouble();
					 
					BMI = ((Gewicht)/(hoehe*hoehe))*703;
					System.out.println("Ihre Boby Mass Index Ist: " + BMI);
					break;
				case 2:
					
					System.out.println("Geben Sie bitte Ihre Gewicht in Kg");
					Gewicht = sc.nextDouble();
					System.out.println("Geben Sie bitte Ihre Hoehe in Meter");
					hoehe = sc.nextDouble();
					 
					BMI = ((Gewicht)/(hoehe*hoehe));
					System.out.println("Ihre Boby Mass Index Ist: " + BMI);
					break;
				case 3:
					System.out.println("Programmende");
					System.exit(0);
					break;
				default:
					throw new IllegalArgumentException("Sie müssen entweder 1 oder 2 eingeben");
				}
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Sie müssen entweder 1 oder 2 eingeben");
			}
			catch(Exception e) {
				e.printStackTrace(System.out); 
			}
		}
		
	}

}
