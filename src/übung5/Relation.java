package übung5;

import java.util.HashMap;
import java.util.Map;

public class Relation {

	public static void main(String[] args) {
		Map<String,String>a=new HashMap<>();
		Map<String,String>b=new HashMap<>();
		a.put("X", "Y");
		b.put("Y", "Z");
		Map<String,String> result = komposition(a,b);
		
	for(Map.Entry<String, String>e: result.entrySet()) {
		System.out.println(e.getKey()+ " -> " +e.getValue());
	}
	
	

	}
	
	public static Map<String, String> komposition ( Map<String, String> a, Map<String, String> b ){
		
		Map<String,String> ergebnis= new HashMap<>();
		String c = null;
		String d = null;
		String f = null;
		String g = null;
		
		for(Map.Entry<String, String> e : a.entrySet()) {
			c = e.getKey();
			d = e.getValue();
		}
		
		for(Map.Entry<String, String> e : b.entrySet()) {
		f = e.getKey();
		g = e.getValue();
			}
		if(d.equals(f)) {
			ergebnis.put(c, g);
		}
		return ergebnis;
	}

}
