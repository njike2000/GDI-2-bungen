package übung2;

public class LottoZahlen {

	private int[][] zahlArray = new int[10000][6];
	private int anzZahl = 0;
	
	public void Lottozahlen() {
		int [] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = (int)(Math.floor(Math.random() * 49 +1));
			System.out.print(arr[i] + " ");
		}
		
		zahlArray[this.anzZahl++] = arr;
	}
	
	public boolean arrayEqual(int[] a, int[] b) {
		for(int i = 0; i < 6; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	public void printlottozahlen() {
		
		for(int i = 0; i < 10000; i++) {
			Lottozahlen();
			int hauefigkeit = 0;
			for(int j = 0; j < 10000; j++) {
				if(arrayEqual(zahlArray[i], zahlArray[j])) {
					hauefigkeit++;
				}
			}
			System.out.println(" : " + hauefigkeit);
		}
			
	}
	
	public static void main(String[] args) {
		new LottoZahlen().printlottozahlen();
	
	}

}
