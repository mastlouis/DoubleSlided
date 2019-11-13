package starter.solver;

public class SolveState {

	String boardState;
	String movesToArriveHere;
	
	int blankSquareRow;
	int blankSquareCol;
	
	public SolveState(String boardState, String movesToArriveHere) {
		this.boardState = boardState;
		this.movesToArriveHere = movesToArriveHere; 
	}
	
	public void setBlankSquare(int row, int col) {
		this.blankSquareRow = row;
		this.blankSquareCol = col;
	}
	
	public String getBoardState() {
		return this.boardState;
	}
	
	public String getMovesToArriveHere() {
		return this.movesToArriveHere;
	}
	
	public int getBlankSquareRow() {
		return this.blankSquareRow;
	}
	
	public int getBlankSquareCol() {
		return this.blankSquareCol;
	}
}
