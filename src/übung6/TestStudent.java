package übung6;

public class TestStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student s1 = new Student(630,"Njike","Samuel");
		Student s2 = new Student(122,"Max","Elvis");
		
		
		//Datei von Objekten aufgeben
		System.out.println(s1.getMatrikelnummer());
		System.out.println(s1.getName());
		System.out.println(s1.getVorname());
		
		System.out.println(s2.getMatrikelnummer());
		System.out.println(s2.getName());
		System.out.println(s2.getVorname());
		
		//Noten von Objekten aufgeben
		System.out.println(s1.getNoten());
		System.out.println(s2.getNoten());
		
		//Notten speichern
		s1.addNote(20);
		s2.addNote(12);
		
		System.out.println(s1.getNoten());
		System.out.println(s2.getNoten());
		
		System.out.println(s1.compare(s2));
		
	}


}
