package starter.solver;

import starter.entity.Board;

public class ConfigurationGenerator {
	int[] counters;
	int[] elements;
	int stackPointerSimulator;
	int flipStates;
	
	public ConfigurationGenerator(int size){
		this.elements = new int[size];
		this.counters = new int[this.elements.length];
		for(int i = 0; i < this.elements.length; i++) {
			this.elements[i] = i;
			this.counters[i] = 0;
		}
		this.stackPointerSimulator = 0;
		//Will be incremented before use
		this.flipStates = -1;
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
	
	public int[] nextPermutation() {
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
	
	private int[] nextValidPermutation() {
		this.nextPermutation();
		//Use partial ordering to remove redundant permutations
		while(
				this.elements[1] > this.elements[2]
				|| this.elements[3] > this.elements[4]
				|| this.elements[5] > this.elements[6]
				|| this.elements[7] > this.elements[8]
		) {
			this.nextPermutation();
		}
		return this.elements;
	}
	
	private int[] nextValidBoardState() {
		if(this.flipStates >= 0xFF) {
			//Will not be incremented before use
			this.flipStates = 0;
			return this.nextValidPermutation();
		}
		this.flipStates++;
		return this.elements;
	}
	
	public String getNextBoardState() {
		String configuration = "";
		
		int[] permutation = this.nextValidPermutation();
		
		//For each of the nine spaces on the board
		for(int boardPositionNumber = 0; boardPositionNumber < 9; boardPositionNumber++) {
			//Go through the permutation array to find which tile comes next
			for(int tileIDNumber = 0; tileIDNumber < 9; tileIDNumber++) {
				//When you have found the right tile to add to the configuration
				if(permutation[tileIDNumber] == boardPositionNumber) {
					//Add that tile's symbols
					if(tileIDNumber == 0) configuration+= ",,u";
					else if(tileIDNumber == 1 || tileIDNumber == 2) configuration += "1,4,";
					else if(tileIDNumber == 3 || tileIDNumber == 4) configuration += "2,3,";
					else if(tileIDNumber == 5 || tileIDNumber == 6) configuration += "3,2,";
					else if(tileIDNumber == 7 || tileIDNumber == 8) configuration += "4,1,";
					//Add the flip state, then the end of tile symbol
					if(tileIDNumber != 0) {
						boolean flip;
						//If the front of the tile is a 1 or 3, flip it if it's on an odd square
						if(tileIDNumber == 1 || tileIDNumber == 2 || tileIDNumber == 5 || tileIDNumber == 6) 
							flip = boardPositionNumber % 2 == 1;
						else
							flip = boardPositionNumber % 2 == 0;
						if(flip) {configuration += "d";}
						else {configuration+= "u";}
					}
					configuration += Board.NEWCOL;
					break;
				}
			}
			//If this is the end of the row, add a row separator
			if(boardPositionNumber % 3 == 2) configuration += Board.NEWROW;
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
