package starter;

//import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starter.boundary.App;
import starter.controller.ExitApplicationController;
import starter.entity.Model;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model(Model.CONFIGURATION_789);
//		Model model = new Model("default");
		String code = model.getBoard().encodeTiles(model.getTiles());
		System.out.println(code);
		System.out.println(model.getBoard().encodeTiles(model.getBoard().decodeTiles(code)));
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
