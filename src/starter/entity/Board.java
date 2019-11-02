package starter.entity;

public class Board {
	Location[][] locations;
	int rows;
	int columns;
	String configuration;
	String[] symbols;
	
	public Board(String configuration) {
		this.configuration = configuration;
		
//		if(configuration.equals("default")) {
			this.rows = 3;
			this.columns = 3;
			this.locations = new Location[][] {
	            {new Location(0,0, "1", "4", false), new Location(0,1, "4", "1", false), new Location(0,2, "", "", false)},
	            {new Location(1,0, "1", "4", true), new Location(1, 1, "3", "2", false), new Location(1,2,"4","1", false)},
	            {new Location(2,0, "2", "3", true), new Location(2,1,"2", "3", false), new Location(1,2,"3", "2", false)}
			};
			this.symbols = new String[] {"", "1", "2", "3", "4"};
//		}
	}
	
	public boolean isValidMove(int row, int column) {
		if(row > 0 
				&& locations[row-1][column].isBlank()) {return true;}//Top
		if(column > 0 
				&& locations[row][column - 1].isBlank()) {return true;}//Left
		if(this.columns - 1> column 
				&& locations[row][column + 1].isBlank()) {return true;}//Right
		if(this.rows - 1 > row 
				&& locations[row + 1][column].isBlank()) {return true;}//Bottom
		return false;
	}
	
	public boolean gameIsLost() {
		//Make an array of integers to count the number or times each symbol appears
		int[] frequency = new int[this.symbols.length];
		for(int i = 0; i < frequency.length; i++) {
			frequency[i] = 0;
		}
		
		for(int r = 0; r < this.rows; r++) {
			for(int c = 0; c < this.columns; c++) {
				//For every cell in the grid, find which symbol 
				for(int symbolIndex = 0; symbolIndex < this.symbols.length; symbolIndex++) {
					if(locations[r][c].getSymbolShown().equals(this.symbols[symbolIndex])) {
						frequency[symbolIndex]++;
					}
				}
			}
		}
		
		//Check that no symbol appears four or more times
		for(int i = 0; i < frequency.length; i++) {
			if(frequency[i] >= 4) {return true;}
		}
		
		return false;
	}
	
	public boolean gameIsWon() {
		//This could possibly be extended with a string that represents the victory configuration
		boolean victory = true;
		victory = victory && this.locations[0][0].getSymbolShown().equals("1");
		victory = victory && !this.locations[0][0].isFlipped();
		
		victory = victory && this.locations[0][1].getSymbolShown().equals("2");
		victory = victory && !this.locations[0][1].isFlipped();
		
		victory = victory && this.locations[0][2].getSymbolShown().equals("3");
		victory = victory && !this.locations[0][2].isFlipped();
		
		victory = victory && this.locations[1][2].getSymbolShown().equals("4");
		victory = victory && !this.locations[1][2].isFlipped();
		
		
		victory = victory && this.locations[2][2].getSymbolShown().equals("1");
		victory = victory && this.locations[2][2].isFlipped();
		
		victory = victory && this.locations[2][1].getSymbolShown().equals("2");
		victory = victory && this.locations[2][1].isFlipped();
		
		victory = victory && this.locations[2][0].getSymbolShown().equals("3");
		victory = victory && this.locations[2][0].isFlipped();
		
		victory = victory && this.locations[1][0].getSymbolShown().equals("4");
		victory = victory && this.locations[1][0].isFlipped();
		
		return victory;
	}
}
