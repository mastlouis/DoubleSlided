package starter.entity;

public class Board {
	Tile[][] tiles;
	int rows;
	int columns;
	String configuration;
	String[] symbols;
	String printMessage;
	
	final static String SEPARATION = ",";
	final static String FACEUP = "u";
	final static String FACEDOWN = "d";
	final static String NEWCOL = "*";
	final static String NEWROW = "-";
	
	public Board(String configuration) {
		this.configuration = configuration;
		
//		if(configuration.equals("default")) {
			this.rows = 3;
			this.columns = 3;
			this.tiles = new Tile[][] {
	            {new Tile("1", "4", false), new Tile("4", "1", false), new Tile("", "", false)},
	            {new Tile("1", "4", true), new Tile("3", "2", false), new Tile("4","1", false)},
	            {new Tile("2", "3", true), new Tile("2", "3", false), new Tile("3", "2", false)}
			};
			this.symbols = new String[] {"", "1", "2", "3", "4"};
//		}
		this.printMessage = "";
	}
	
	public boolean isValidMove(int row, int column) {
		if(row > 0 
				&& tiles[row-1][column].isBlank()) {return true;}//Top
		if(column > 0 
				&& tiles[row][column - 1].isBlank()) {return true;}//Left
		if(this.columns - 1> column 
				&& tiles[row][column + 1].isBlank()) {return true;}//Right
		if(this.rows - 1 > row 
				&& tiles[row + 1][column].isBlank()) {return true;}//Bottom
		return false;
	}
	
	public void swapWithBlank(int row, int col) {
		int blankRow = -1;
		int blankCol = -1;
		if(row > 0 && tiles[row-1][col].isBlank()) {blankRow = row-1; blankCol = col;}//Top
		if(col > 0 && tiles[row][col - 1].isBlank()) {blankRow = row; blankCol = col - 1;}//Left
		if(this.columns - 1> col && tiles[row][col + 1].isBlank()) {blankRow = row; blankCol = col+1;}//Right
		if(this.rows - 1 > row && tiles[row + 1][col].isBlank()) {blankRow = row+1; blankCol = col;}//Bottom
		
		Tile temp = this.tiles[blankRow][blankCol];
		this.tiles[blankRow][blankCol] = this.tiles[row][col];
		this.tiles[row][col] = temp;
		
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
					if(tiles[r][c].getSymbolShown().equals(this.symbols[symbolIndex])) {
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
		victory = victory && this.tiles[0][0].getSymbolShown().equals("1");
		victory = victory && !this.tiles[0][0].isFlipped();
		
		victory = victory && this.tiles[0][1].getSymbolShown().equals("2");
		victory = victory && !this.tiles[0][1].isFlipped();
		
		victory = victory && this.tiles[0][2].getSymbolShown().equals("3");
		victory = victory && !this.tiles[0][2].isFlipped();
		
		victory = victory && this.tiles[1][2].getSymbolShown().equals("4");
		victory = victory && !this.tiles[1][2].isFlipped();
		
		
		victory = victory && this.tiles[2][2].getSymbolShown().equals("1");
		victory = victory && this.tiles[2][2].isFlipped();
		
		victory = victory && this.tiles[2][1].getSymbolShown().equals("2");
		victory = victory && this.tiles[2][1].isFlipped();
		
		victory = victory && this.tiles[2][0].getSymbolShown().equals("3");
		victory = victory && this.tiles[2][0].isFlipped();
		
		victory = victory && this.tiles[1][0].getSymbolShown().equals("4");
		victory = victory && this.tiles[1][0].isFlipped();
		
		return victory;
	}
	
	public Tile[][] getTiles(){
		return this.tiles;
	}
	public void setPrintMessage(String printMessage) {
		this.printMessage = printMessage;
	}
	
	public String getPrintMessage() {
		return this.printMessage;
	}
	
	public String encodeTiles(Tile[][] tiles) {
		String code = "";
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[row].length; col++) {
				code += tiles[row][col].front;
				code += SEPARATION; //SEPARATION is ,
				code += tiles[row][col].back;
				code += SEPARATION;
				if(tiles[row][col].isFlipped()) {
					code += FACEDOWN; //FACEDOWN is d
				}
				else {
					code += FACEUP; //FACEUP is u
				}
				code += NEWCOL;
			}
			code += NEWROW;
		}
		return code;
	}
}
