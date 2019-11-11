package starter.boundary;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

import starter.entity.Model;
import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;

public class PuzzlePanelTest {
	
	Model model;
	App app;
	
	@Before
	public void setUp() throws Exception {
		this.model = new Model("default");
		this.app = new App(this.model);
	}

	@Test
	public void test() {
//		app.getPanel().paintComponent(
//				new SunGraphics2D( //new CGLSurfaceData$CGLOffScreenSurfaceData()
//						new SurfaceData(), Color.BLACK, Color.WHITE, new Font("Lucida Grande", Font.PLAIN, 13)
//				)
//		);
		
	}

}
