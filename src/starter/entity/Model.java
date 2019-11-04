package starter.entity;

public class Model {

	int moveCounter;
	Board board;
	String configuration;
	
	public Model(String configuration) {
		moveCounter = 0;
		this.board = new Board(configuration);
		this.configuration = configuration;
	}
	public void resetGame() {
		moveCounter = 0;
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
