package übung1;

import java.util.Scanner;

public class WahrheitsTabelle {

	public static void main(String [] args) {
		
		Scanner sc = new Scanner (System.in);
		
		while(true) {
			System.out.println("------------- Wilkommen------------");
			try {
				System.out.println("Geben Sie bitte"+" "+"*"+" "+"fuer die UND-Verknuefung"+" "+" + "+" "+"fuer die ODER-Verknuepfung"+" "+" ~ "+" "+"fuer die Negation" + " "+"ein");
				String s = sc.next();
				if(!s.equals("*") && !s.equals("+") && !s.equals("~") )
					throw new IllegalArgumentException("falsche Eingabe");
						
				if(s.equals( "*")) 
					System.out.println("Die Wahrheitstabelle der UND-Verknuepfung ist:"+"\n"+0+" "+0+" "+0+"\n"+0+""+1+" "+0+"\n"+1+""+0+" "+0+"\n"+1+""+1+" "+1);
		 		else if (s.equals ( "+"))
					System.out.println("Die Wahrheitstabelle der ODER-Verknuepfung ist:"+"\n"+0+" + "+0+" "+0+"\n"+0+" + "+1+" "+1+"\n"+1+" + "+0+" "+1+"\n"+1+" + "+1+" "+1);
				
				else if (s.equals ("~"))
					System.out.println("Die Wahrheitstabelle der Negation ist :"+"\n"+0+" "+" "+1+"\n"+1+" "+" "+0);
				
				break;}
			catch(IllegalArgumentException ex) {
				
				System.out.println("Ihre  Eingabe hat bei uns keine entsprechende Wahrheitstabelle");
			}
	
		}
		sc.close();
	}
	
}
