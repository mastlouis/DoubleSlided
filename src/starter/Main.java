package starter;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starter.boundary.App;
import starter.controller.ExitApplicationController;
import starter.entity.Model;

public class Main {

	public static void main(String[] args) {
		Model model = new Model("test");
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
