package starter.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import starter.entity.Model;
import starter.entity.Tile;


public class PuzzlePanel extends JPanel {
	Model model;
	Rectangle[][] rectangles = null;
	Tile[][] tiles;
	
	/**
	 * Create the panel.
	 */
	public PuzzlePanel(Model model) {
		this.model = model;
		this.tiles = model.getTiles();
		this.rectangles = new Rectangle[tiles.length][tiles[1].length];
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[row].length; col++) {
				rectangles[row][col] = new Rectangle(50 + (120 * col), 50 + (120 * row), 100, 100);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		this.tiles = model.getTiles();
		this.rectangles = new Rectangle[tiles.length][tiles[1].length];
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[row].length; col++) {
				rectangles[row][col] = new Rectangle(50 + (120 * col), 50 + (120 * row), 100, 100);
			}
		}
		g.setFont(new Font("Georgia", Font.PLAIN, 18));
		//Draw the move counter
		g.drawString("Moves Made: " + this.model.getMoves() + "  " + this.model.getBoard().getPrintMessage(), 30, 30);
		g.setFont(new Font("Georgia", Font.PLAIN, 48));
		//Draw the rectangles and grid
		for(int row = 0; row < rectangles.length; row++) {
			for(int col = 0; col < rectangles[row].length; col++) {
				g.setColor(new Color(255, 255, 255));//Black for the outline
				g.drawRect(rectangles[row][col].x, rectangles[row][col].y, rectangles[row][col].width, rectangles[row][col].height);
				if(tiles[row][col].getType() == "blank") {
					g.setColor(new Color(253, 191, 45));
					g.fillRect(rectangles[row][col].x, rectangles[row][col].y, rectangles[row][col].width, rectangles[row][col].height);
				}
				else if(tiles[row][col].isFlipped()) {//If the tile is face down
					g.setColor(new Color(0, 0, 0)); //Fill rectangle black
					g.fillRect(rectangles[row][col].x, rectangles[row][col].y, rectangles[row][col].width, rectangles[row][col].height);
					g.setColor(new Color(255,255,255)); //Fill Text White
					g.drawString(tiles[row][col].getSymbolShown(), (int) rectangles[row][col].getCenterX() - 10, (int) rectangles[row][col].getCenterY());
				}
				else {//If the tile is face up
					g.setColor(new Color(166,166,166));//Fill rectangle gray
					g.fillRect(rectangles[row][col].x, rectangles[row][col].y, rectangles[row][col].width, rectangles[row][col].height);
					g.setColor(new Color(0,0,0)); //Fill Text Black
					g.drawString(tiles[row][col].getSymbolShown(), (int) rectangles[row][col].getCenterX() - 10, (int) rectangles[row][col].getCenterY());
				}
			}
		}
		
//		g.drawString("Hello", 100, 100);
//		g.drawLine(10, 10, 300, 50);
	}
	
	public Rectangle[][] getRectangles(){
		return this.rectangles;
	}
	
}