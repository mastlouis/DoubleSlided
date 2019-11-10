package starter.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class tileTest {
	Tile tile;
	
	@Before
	public void setUp() throws Exception{
		this.tile = new Tile("1", "4", false);
	}

	@Test
	public void test() {
		assertFalse(this.tile.isFlipped());
		assertEquals("1", this.tile.getSymbolShown());
		
		this.tile.setFlip(true);
		
		assertTrue(this.tile.isFlipped());
		assertEquals("4", this.tile.getSymbolShown());
		
		assertFalse(this.tile.isBlank());
	}

}
