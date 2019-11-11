package starter.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import starter.boundary.App;
import starter.boundary.PuzzlePanel;
import starter.entity.Model;
import starter.entity.Tile;

public class MoveTileController extends MouseAdapter{
	App app;
	Model model;
	Rectangle[][] rectangles;
	Tile[][] tiles;
	
	public MoveTileController(Model model, App app) {
		this.model = model;
		this.app = app;
	}
	
	@Override
	public void mousePressed(MouseEvent me) {
		Point p = me.getPoint();
		rectangles = app.getPanel().getRectangles();
		tiles = model.getBoard().getTiles();
		for(int row = 0; row < rectangles.length; row++) {
			for(int col = 0; col < rectangles[row].length; col++){
				//If the user successfully presesd on a rectangle and can make a move
				if(!model.getBoard().gameIsLost() 
						&& !model.getBoard().gameIsWon()
						&& rectangles[row][col].contains(p) 
						&& model.getBoard().isValidMove(row, col)) {
					tiles[row][col].setFlip(!tiles[row][col].isFlipped()); //Flip the tile
					this.model.getBoard().swapWithBlank(row, col); //Swap its place
					model.incrementMoves();
					break;
				}
			}
		}
		//After the move is made, if any, check if the user has won
		if(model.getBoard().gameIsLost()) {
			model.getBoard().setPrintMessage("Four tiles display the same number. Let the tears flow.");
		}
		if(model.getBoard().gameIsWon() && this.model.getMoves() > 0) {
			//Check that the player has actually won and not just started in the victory state
			model.getBoard().setPrintMessage("You did the thing!! Nice work!!");
		}
		app.repaint();
		
	}
}
