package übung5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Keys {
	
	public static Map<Integer, String> slice (Map<Integer, String>m, int min, int max){
		
		Map<Integer, String> result = new HashMap<Integer, String>();
		for(Map.Entry<Integer, String > entry : m.entrySet()) {
			if(entry.getKey() >= min && entry.getKey() <= max) {
				result.put(entry.getKey() ,entry.getValue());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		int mini = 4;
		int maxi = 40;
		 Map<Integer, String> Map = new HashMap<Integer, String>();
		 Map.put(10 , " Zidan ");
	     Map.put(5 , " Berte ");
	     Map.put(6 , " Alex ");
	     Map.put(20 , " Catherine ");
	     Map.put(1 , " Denis ");
	     Map.put(7 , "  Emile ");
	     Map.put(8, " Yann ");
	     Map.put(99, " Nike ");
	     Map.put(50, " John ");
	     Map.put(2, " Mari ");
	     Map.put(9, " Fon ");
	     Map<Integer, String> treeMap = new TreeMap <Integer, String>(Map);
	     System.out.println(slice(treeMap, mini, maxi));
	}

}
