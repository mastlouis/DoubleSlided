package starter.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {
	Model model;

	@Before
	public void setUp() throws Exception {
		this.model = new Model("default");
	}
	
	@Test
	public void test() {
		assertEquals(0, this.model.getMoves());
		this.model.incrementMoves();
		this.model.incrementMoves();
		assertEquals(2, this.model.getMoves());
	}

}
