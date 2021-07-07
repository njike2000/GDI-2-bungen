package übung6;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private int Matrikelnummer = 0;
	private String Vorname = null;
	private String Name = null;
	public List<Integer> Noten = new ArrayList<>();
	
	public Student(int Matrikelnummer , String Vorname ,String Name  ) {
		this.Matrikelnummer = Matrikelnummer;
		this.Vorname = Vorname;
		this.Name = Name;
	}


	public int getMatrikelnummer() {
		return Matrikelnummer;
	}

	public String getVorname() {
		return Vorname;
	}

	public String getName() {
		return Name;
	}

	public List<Integer> getNoten() {
		return Noten;
	}
	
	public void addNote(int note){
		Noten.add(note);
	}
	/**
	 * @return
	 */
	public double durchschrittNote() {
		int totalnote = 0;
		double average = 0.0;
		for(Integer e : Noten) {
			totalnote += e;
		}
		average = 1.0 *totalnote / Noten.size();
		return average;
		
	}
	public int compare (Student other) {
		double durschnittOtherStudent = other.durchschrittNote();
		double durschnittCurrentStudent = this.durchschrittNote();
		if(durschnittOtherStudent == durschnittCurrentStudent) {
			return 0;
		} else if(durschnittOtherStudent > durschnittCurrentStudent) {
			return -1;
		} else {
			return 1;
		}
	}

	
}
