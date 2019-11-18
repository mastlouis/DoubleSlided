package starter.solver;

public class ConfigurationGenerator {
	int[] counters;
	int[] elements;
	int stackPointerSimulator;
	
	public ConfigurationGenerator(int size){
		this.elements = new int[size];
		this.counters = new int[this.elements.length];
		for(int i = 0; i < this.elements.length; i++) {
			this.elements[i] = i;
			this.counters[i] = 0;
		}
		this.stackPointerSimulator = 0;
	}
	
	/**
	 * Adapted from Heap's Algorithm (non-recursive)
	 * 
	 * https://en.wikipedia.org/wiki/Heap%27s_algorithm#cite_note-3
	 * 
	 * @param arrayOfTiles
	 */
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
	
	public int[] nextPerumtation() {
		while(this.counters[stackPointerSimulator] >= stackPointerSimulator) {
			counters[stackPointerSimulator] = 0;
			stackPointerSimulator = (stackPointerSimulator+1)%counters.length;
		}
		
		if(stackPointerSimulator % 2 == 0) {
			int temp = this.elements[stackPointerSimulator];
			this.elements[stackPointerSimulator] = this.elements[0];
			this.elements[0] = temp;
		}
		else {
			int temp = this.elements[counters[stackPointerSimulator]];
			this.elements[counters[stackPointerSimulator]] = this.elements[stackPointerSimulator];
			this.elements[stackPointerSimulator] = temp;
		}
		
		counters[stackPointerSimulator]++;
		stackPointerSimulator = 0;
		return this.elements;
	}
	
	public String nextBoardState() {
		String configuration = "";
		
		int[] permutation = this.nextPerumtation();
		boolean isValidPermutation = false;
		while(!isValidPermutation) {
			isValidPermutation = true;
			if(permutation[1] > permutation[2]) isValidPermutation = false;
			else if(permutation[3] > permutation[4]) isValidPermutation = false;
			else if(permutation[5] > permutation[6]) isValidPermutation = false;
			else if(permutation[7] > permutation[8]) isValidPermutation = false;
		}
		
		
		return configuration;
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
