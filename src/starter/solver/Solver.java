package starter.solver;

import starter.entity.Board;
import starter.entity.Model;
import starter.entity.Tile;

public class Solver {
	SolveStateQueue theQueue;
	Model model;
	
	public Solver() {
		theQueue = new SolveStateQueue();
		this.model = new Model("default");
	}
	
	public String findSolution(String configuration) {
		Model dummyModel = new Model(configuration);
		model.resetGameTo(configuration);
		Tile[][] tiles = model.getBoard().decodeTiles(configuration);
		int blankRow = model.getBoard().getRowOfBlank();
		int blankCol = model.getBoard().getColOfBlank();
		SolveStateQueue theQueue = new SolveStateQueue();
		
		theQueue.append(new SolveState(configuration, ""));
		
		while(theQueue.hasNext()) {
			SolveState currentState = theQueue.next();
			blankRow = currentState.getBlankSquareRow();
			blankCol = currentState.getBlankSquareCol();
			
			//If there is a tile to move DOWN into the blank space
			if(
					blankRow > 0 
					&& (
							currentState.getMovesToArriveHere().length() == 0 //Either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("U") //Or you have not just moved up
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().swapWithBlank(blankRow - 1, blankCol);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "D";
				}
				if(!dummyModel.getBoard().gameIsLost()) {
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "D"));
				}
			}
			
			//If there is a tile to move LEFT into the blank space
			if(
					blankCol > 0 
					&& (
							currentState.getMovesToArriveHere().length() == 0 //either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("R") //Or you didn't just move right
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().swapWithBlank(blankRow, blankCol - 1);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "L";
				}
				if(!dummyModel.getBoard().gameIsLost()) {
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "L"));
				}
				
			}
			
			//If there is a tile to move RIGHT into the blank space
			if(
					blankCol < dummyModel.getBoard().getTiles()[blankRow].length - 1 
					&& (
							currentState.getMovesToArriveHere().length() == 0 //either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("L") //Or you didn't just move left
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().swapWithBlank(blankRow, blankCol + 1);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "R";
				}
				if(!dummyModel.getBoard().gameIsLost()) {
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "R"));
				}
			}
			
			//If there is a tile to move UP into the blank space
			if(
					blankRow < dummyModel.getBoard().getTiles().length - 1 
					&& (
							currentState.getMovesToArriveHere().length() == 0 //Either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("D") //Or you didn't just move down
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().swapWithBlank(blankRow + 1, blankCol);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "U";
				}
				if(!dummyModel.getBoard().gameIsLost()) {
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "U"));
				}
			}
		}
		
		return "no solution";
	}
}
