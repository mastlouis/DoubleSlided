package starter.entity;

public class Model {

	int moveCounter;
	Board board;
	String configuration;
	
	public final static String CONFIGURATION_01 =  "1,4,u*4,1,u*,,u*-1,4,d*3,2,u*4,1,u*-2,3,d*2,3,u*3,2,u*-";
	public final static String CONFIGURATION_234 = "1,4,u*4,1,u*2,3,d*-2,3,u*1,4,u*3,2,d*-3,2,u*4,1,u*,,u*-";
	public final static String CONFIGURATION_56 =  "1,4,u*1,4,d*3,2,u*-2,3,u*4,1,d*4,1,u*-,,u*2,3,u*3,2,u*-";
	public final static String CONFIGURATION_789 = "1,4,u*3,2,d*,,u*-3,2,d*2,3,d*4,1,u*-1,4,u*2,3,u*4,1,d*-";
	
	public final static String VICTORY_CONFIGURATION = "1,4,u*2,3,u*3,2,u*-1,4,d*,,u*4,1,u*-2,3,d*3,2,d*4,1,d*-";
	//Some initial board states may leave the blank tile upside-down
	public final static String VICTORY_CONFIGURATION_1 = "1,4,u*2,3,u*3,2,u*-1,4,d*,,d*4,1,u*-2,3,d*3,2,d*4,1,d*-";
	
	public Model(String configuration) {
		moveCounter = 0;
		this.board = new Board(configuration);
		this.configuration = configuration;
	}
	public void resetGame() {
		this.moveCounter = 0;
		this.board = new Board(this.configuration);
	}
	public void resetGameTo(String configuration) {
		this.moveCounter = 0;
		this.configuration = configuration;
		this.board = new Board(this.configuration);
	}
	public void incrementMoves() {
		this.moveCounter++;
	}
	public Tile[][] getTiles(){
		return this.board.getTiles();
	}
	public Board getBoard() {
		return this.board;
	}
	public int getMoves() {
		return this.moveCounter;
	}
}
