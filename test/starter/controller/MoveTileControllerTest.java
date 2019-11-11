package starter.controller;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.Point;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import starter.boundary.App;
import starter.entity.Board;
import starter.entity.Model;

public class MoveTileControllerTest {
	Model model;
	App app;
	MoveTileController mtc;
	
	
	@Before
	public void setUp() throws Exception {
		this.model = new Model("default");
		this.app = new App(this.model);
		this.mtc = new MoveTileController(this.model, this.app);
	}

	@Test
	public void test() {
		assertEquals(Model.CONFIGURATION_01, this.model.getBoard().getEncodedTiles());
		mtc.mousePressed(new MouseEvent(new Button(), 0, 0, 0, 0, 0, 0, false)); 
		assertEquals(Model.CONFIGURATION_01, this.model.getBoard().getEncodedTiles());
		
		//test clicking a tile that can't move
		mtc.interactWithPoint(new Point(100, 100));// 0,0
		assertEquals(Model.CONFIGURATION_01, this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(225, 100)); // 0,1
		assertEquals("1,4,u*,,u*4,1,d*-1,4,d*3,2,u*4,1,u*-2,3,d*2,3,u*3,2,u*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(225, 225)); // 1,1
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*,,u*4,1,u*-2,3,d*2,3,u*3,2,u*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(225, 350)); // 2,1
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*4,1,u*-2,3,d*,,u*3,2,u*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(350, 350)); // 2,2
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*,,u*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(350, 225)); // 1,2
		assertEquals("1,4,u*3,2,d*4,1,d*-1,4,d*2,3,d*,,u*-2,3,d*3,2,d*4,1,d*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(350, 100)); // 0,2
		assertEquals("1,4,u*3,2,d*,,u*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(225, 100)); // 0,1
		assertEquals("1,4,u*,,u*3,2,u*-1,4,d*2,3,d*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.model.getBoard().getEncodedTiles());
		
		mtc.interactWithPoint(new Point(225, 225)); // 1,1
		assertEquals("1,4,u*2,3,u*3,2,u*-1,4,d*,,u*4,1,u*-2,3,d*3,2,d*4,1,d*-", this.model.getBoard().getEncodedTiles());
		assertTrue(this.model.getBoard().gameIsWon());
	}

}
