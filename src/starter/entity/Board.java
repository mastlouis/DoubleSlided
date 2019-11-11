package starter.entity;
import java.util.LinkedList;

public class Board {
	Tile[][] tiles;
	int rows;
	int columns;
	String configuration;
	String[] symbols;
	String printMessage;
	//printMessage is a message that the GUI will display to the user
	
	public final static String SEPARATION = ",";
	public final static String FACEUP = "u";
	public final static String FACEDOWN = "d";
	public final static String NEWCOL = "*";
	public final static String NEWROW = "-";
	
	final static String DEFAULT_CONFIGURATION = "default"; 
	
	public final int COLLECTFRONT = 0;
	public final int COLLECTBACK = 1;
	public final int COLLECTFLIP = 2;
	
	public Board(String configuration) {
		this.configuration = configuration;
		
		if(configuration.equals("default")) {
			this.configuration = Model.CONFIGURATION_01;
		}
		this.tiles = this.decodeTiles(this.configuration);
		this.rows = tiles.length;
		this.columns = tiles[0].length;
		this.symbols = new String[] {"", "1", "2", "3", "4"};
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
	
	/**
	 * This method checks whether or not the board is in a winning configuration
	 * 
	 * @return true if the user has won, false otherwise
	 */
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
	
	/**
	 * This converts the grid of tiles into a string representation that can be
	 * parsed back into an array of tiles
	 * 
	 * @param tiles is the 2Darray of tiles to encode
	 * @return the string representation of the tiles
	 */
	public String encodeTiles(Tile[][] tiles) {
		String code = "";
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[row].length; col++) {
				code += tiles[row][col].front; //Add the front text
				code += SEPARATION; //SEPARATION is ,
				code += tiles[row][col].back; //Add the back text
				code += SEPARATION;
				if(tiles[row][col].isFlipped()) {
					code += FACEDOWN; //FACEDOWN is d
				}
				else {
					code += FACEUP; //FACEUP is u
				}
				code += NEWCOL; //NEWCOL is *
			}
			code += NEWROW; //NEWROW is -
		}
		return code;
	}
	
	public String getEncodedTiles() {
		return encodeTiles(this.tiles);
	}
	
	/**
	 * This converts a string representation of tiles into a 2D array of tiles
	 * 
	 * @param code is the string representation to convert
	 * @return the 2D array of tiles that corresponds to the string
	 */
	public Tile[][] decodeTiles(String code){
		int rowIndex = 0;
		int state = COLLECTFRONT;
		
		String frontOfTile = "";
		String backOfTile = "";
		boolean flipState = false;
		LinkedList<LinkedList<Tile>> tileRows = new LinkedList<LinkedList<Tile>>();
		tileRows.add(new LinkedList<Tile>()); //Create an empty first column of the first row
		
		//Iterate through each character and either write it to tile data 
		//or use it as a signal to manipulate the state of the linked lists
		for(int i = 0; i < code.length(); i++) {
			if(code.substring(i,i + 1).equals(SEPARATION)) {
				if(state == COLLECTFRONT) state = COLLECTBACK;
				else if(state == COLLECTBACK) state = COLLECTFLIP; 
				//Be very careful to keep this as an else if
				//Otherwise, the state will continue to fall through
			}
			else if(code.substring(i,i + 1).equals(NEWCOL)) {
				tileRows.get(rowIndex).add(new Tile(frontOfTile, backOfTile, flipState));
				frontOfTile = "";
				backOfTile = "";
				state = COLLECTFRONT;
			}
			else if(code.substring(i,i + 1).equals(NEWROW) && i < code.length() - 1) {
				//Add a new row if there is another row
				tileRows.add(new LinkedList<Tile>());
				rowIndex++;
			}
			//Since the character is not special, add it to the appropriate value
			else if(state == COLLECTFRONT) {
				frontOfTile += code.substring(i,i + 1);
			}
			else if(state == COLLECTBACK) {
				backOfTile += code.substring(i,i + 1);
			}
			else if(state == COLLECTFLIP) {
				if(code.substring(i,i + 1).equals(FACEUP)) flipState = false;
				else if(code.substring(i,i + 1).equals(FACEDOWN)) flipState = true;
			}
		}
		return listToArray(tileRows);
	}
	
	/**
	 * Converts a 2D linked list of tiles into a 2D array of tiles
	 * 
	 * @param lists is the 2D linked list
	 * @return a 2D array of tiles converted from a 2D linked list
	 */
	public Tile[][] listToArray(LinkedList<LinkedList<Tile>> lists){
		Tile[][] outputArray = new Tile[lists.size()][];
		for(int i = 0; i < outputArray.length; i++) {
			outputArray[i] = new Tile[lists.get(i).size()];
			for(int j = 0; j < outputArray[i].length; j++){
				outputArray[i][j] = lists.get(i).get(j);
			}
		}
		return outputArray;
	}
}
