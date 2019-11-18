package starter.solver;

import java.util.LinkedList;

import starter.entity.Board;
import starter.entity.Model;
import starter.entity.Tile;

public class Solver {
	SolveStateQueue theQueue;
	Model model;
	
	public Solver() {
		this.theQueue = new SolveStateQueue();
		this.model = new Model("default");
	}
	
	public String findSolution(String configuration) {
		SolveStateQueue theQueue = new SolveStateQueue();
		Model dummyModel = new Model(configuration);
		int blankRow = dummyModel.getBoard().getRowOfBlank();
		int blankCol = dummyModel.getBoard().getColOfBlank();
		LinkedList<String> reachedStates = new LinkedList<String>();
		
		theQueue.append(new SolveState(configuration, "", blankRow, blankCol));
		
		while(theQueue.hasNext()) {
			SolveState currentState = theQueue.next();
			blankRow = currentState.getBlankSquareRow();
			blankCol = currentState.getBlankSquareCol();
			
			//If there is a tile to move DOWN into the blank space
			if(
					blankRow > 0 
					&& (//Short circuit order matters
							currentState.getMovesToArriveHere().length() == 0 //Either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("U") //Or you have not just moved up
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().getTiles()[blankRow-1][blankCol].toggleFlip();
				dummyModel.getBoard().swapWithBlank(blankRow - 1, blankCol);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "D";
				}
				//If the new state is not a game over or a reached state
				if(!dummyModel.getBoard().gameIsLost() && !reachedStates.contains(dummyModel.getBoard().getEncodedTiles())) {
					//Add this state to the known states
					reachedStates.add(dummyModel.getBoard().getEncodedTiles());
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "D", blankRow - 1, blankCol));
				}
			}
			
			//If there is a tile to move RIGHT into the blank space
			if(
					blankCol > 0 
					&& (//Short circuit order matters
							currentState.getMovesToArriveHere().length() == 0 //either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("L") //Or you didn't just move right
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().getTiles()[blankRow][blankCol-1].toggleFlip();
				dummyModel.getBoard().swapWithBlank(blankRow, blankCol - 1);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "R";
				}
				//If the new state is not a game over or a reached state
				if(!dummyModel.getBoard().gameIsLost() && !reachedStates.contains(dummyModel.getBoard().getEncodedTiles())) {
					//Add this state to the known states
					reachedStates.add(dummyModel.getBoard().getEncodedTiles());
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "R", blankRow, blankCol - 1));
				}
				
			}
			
			//If there is a tile to move LEFT into the blank space
			if(
					blankCol < dummyModel.getBoard().getTiles()[blankRow].length - 1 
					&& (//Short circuit order matters
							currentState.getMovesToArriveHere().length() == 0 //either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("R") //Or you didn't just move left
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().getTiles()[blankRow][blankCol+1].toggleFlip();
				dummyModel.getBoard().swapWithBlank(blankRow, blankCol + 1);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "L";
				}
				//If the new state is not a game over or a reached state
				if(!dummyModel.getBoard().gameIsLost() && !reachedStates.contains(dummyModel.getBoard().getEncodedTiles())) {
					//Add this state to the known states
					reachedStates.add(dummyModel.getBoard().getEncodedTiles());
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "L", blankRow, blankCol + 1));
				}
			}
			
			//If there is a tile to move UP into the blank space
			if(
					blankRow < dummyModel.getBoard().getTiles().length - 1 
					&& (//Short circuit order matters
							currentState.getMovesToArriveHere().length() == 0 //Either there have been no moves
							|| !currentState.getMovesToArriveHere().endsWith("D") //Or you didn't just move down
					)
			) {
				dummyModel.resetGameTo(currentState.getBoardState());
				dummyModel.getBoard().getTiles()[blankRow+1][blankCol].toggleFlip();
				dummyModel.getBoard().swapWithBlank(blankRow + 1, blankCol);
				if(dummyModel.getBoard().gameIsWon()) {
					return currentState.getMovesToArriveHere() + "U";
				}
				//If the new state is not a game over or a reached state
				if(!dummyModel.getBoard().gameIsLost() && !reachedStates.contains(dummyModel.getBoard().getEncodedTiles())) {
					//Add this state to the known states
					reachedStates.add(dummyModel.getBoard().getEncodedTiles());
					theQueue.append(new SolveState(dummyModel.getBoard().getEncodedTiles(), currentState.getMovesToArriveHere() + "U", blankRow+1, blankCol));
				}
			}
		}
		
		return "no solution";
	}
}
