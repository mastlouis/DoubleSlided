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
		
		this.board.swapWithBlank(0, 1);
		assertTrue(this.board.isValidMove(1, 1));
		this.board.swapWithBlank(1, 1);
		assertTrue(this.board.isValidMove(2, 1));
		this.board.swapWithBlank(2, 1);
		assertTrue(this.board.isValidMove(2, 2));
		this.board.swapWithBlank(2, 2);
		assertTrue(this.board.isValidMove(1, 2));
		this.board.swapWithBlank(1, 2);
		assertTrue(this.board.isValidMove(0, 2));
		this.board.swapWithBlank(0, 2);
		assertTrue(this.board.isValidMove(0, 1));
		this.board.swapWithBlank(0, 1);
		assertTrue(this.board.isValidMove(1, 1));
		this.board.swapWithBlank(1, 1);
		
		assertFalse(this.board.gameIsLost());
//		assertTrue(this.board.gameIsWon());
		
	}

}
