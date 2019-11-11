package starter.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	
	@Before
	public void setUp() throws Exception {
		this.board = new Board("default");
	}

	@Test
	public void test() {
		assertEquals(Model.CONFIGURATION_01, this.board.getEncodedTiles());
		assertFalse(this.board.isValidMove(0, 0));
		assertTrue(this.board.isValidMove(0, 1));
		assertFalse(this.board.isValidMove(0, 2));
		
		assertFalse(this.board.isValidMove(1, 0));
		assertFalse(this.board.isValidMove(1, 1));
		assertTrue(this.board.isValidMove(1, 2));
		
		assertFalse(this.board.isValidMove(2, 0));
		assertFalse(this.board.isValidMove(2, 1));
		assertFalse(this.board.isValidMove(2, 2));
		
		assertFalse(this.board.gameIsLost());
		assertFalse(this.board.gameIsWon());
		
		//Test the game all the way through the fastest solution
		assertEquals(Model.CONFIGURATION_01, this.board.getEncodedTiles());
		this.board.getTiles()[0][1].toggleFlip();
		this.board.swapWithBlank(0, 1);
		assertTrue(this.board.isValidMove(1, 1));
		assertEquals("1,4,u*,,u*4,1,d*-1,4,d*3,2,u*4,1,u*-2,3,d*2,3,u*3,2,u*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[1][1].toggleFlip();
		this.board.swapWithBlank(1, 1);
		assertTrue(this.board.isValidMove(2, 1));
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*,,u*4,1,u*-2,3,d*2,3,u*3,2,u*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[2][1].toggleFlip();
		this.board.swapWithBlank(2, 1);
		assertTrue(this.board.isValidMove(2, 2));
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*4,1,u*-2,3,d*,,u*3,2,u*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[2][2].toggleFlip();
		this.board.swapWithBlank(2, 2);
		assertTrue(this.board.isValidMove(1, 2));
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*,,u*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[1][2].toggleFlip();
		this.board.swapWithBlank(1, 2);
		assertTrue(this.board.isValidMove(0, 2));
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*,,u*-2,3,d*3,2,d*4,1,d*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[0][2].toggleFlip();
		this.board.swapWithBlank(0, 2);
		assertTrue(this.board.isValidMove(0, 1));
		assertEquals("1,4,u*3,2,d*,,u*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[0][1].toggleFlip();
		this.board.swapWithBlank(0, 1);
		assertTrue(this.board.isValidMove(1, 1));
		assertEquals("1,4,u*,,u*3,2,u*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.board.getEncodedTiles());
		
		this.board.getTiles()[1][1].toggleFlip();
		this.board.swapWithBlank(1, 1);
		assertEquals("1,4,u*2,3,u*3,2,u*-1,4,d*,,u*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.board.getEncodedTiles());
		
		assertFalse(this.board.gameIsLost());
		System.out.println(this.board.getEncodedTiles());
		System.out.println(Model.VICTORY_CONFIGURATION);
		assertTrue(this.board.gameIsWon());
		
	}
	
	@Test
	public void testBoardToString() {
		this.board = new Board(Model.CONFIGURATION_01);
		assertEquals("1,4,u*4,1,u*,,u*-1,4,d*3,2,u*4,1,u*-2,3,d*2,3,u*3,2,u*-", this.board.getEncodedTiles());
	}

}
