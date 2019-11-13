package starter.solver;

public class ConfigurationGenerator {
	
	
	public void generatePermutation(int[] arrayOfTiles) {
		int[] counter = new int[arrayOfTiles.length];
		for(int i = 0; i < counter.length; i++) {
			counter[i] = 0;
		}
		
		System.out.println(printer(arrayOfTiles));
		int i = 1;//Was originally zero
		while(i < arrayOfTiles.length) {
			if(counter[i] < i) {
				if(i%2 == 0) {
					int temp = arrayOfTiles[i];
					arrayOfTiles[i] = arrayOfTiles[0];
					arrayOfTiles[0] = temp;
				}
				else {
					int temp = arrayOfTiles[counter[i]];
					arrayOfTiles[counter[i]] = arrayOfTiles[i];
					arrayOfTiles[i] = temp;
				}
				System.out.println(printer(arrayOfTiles));
				counter[i]++;
				i = 0;
			}
			else {
				counter[i] = 0;
				i++;
			}
		}
	}
	
	public String printer(int[] array) {
		String forPrinting = "[";
		for(int i:array) {
			forPrinting = forPrinting + i + ", ";
		}
		forPrinting += "]";
		
		return forPrinting;
	}
}
