package starter;

//import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starter.boundary.App;
import starter.controller.ExitApplicationController;
import starter.entity.Model;

public class Main {

	public static void main(String[] args) {
		
//		Model model = new Model("1,4,u*2,3,u*3,2,u*-1,4,d*,,u*4,1,u*-2,3,d*3,2,u*4,1,u*-");
		Model model = new Model("default");
		App app = new App(model);
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				new ExitApplicationController(app).process();
			}
		});
		app.setVisible(true);
		app.repaint();
	}
}
