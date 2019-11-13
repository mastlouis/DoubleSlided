package starter;

//import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starter.boundary.App;
import starter.controller.ExitApplicationController;
import starter.entity.Model;
import starter.solver.ConfigurationGenerator;
import starter.solver.Solver;

public class Main {

	public static void main(String[] args) {
		ConfigurationGenerator cg = new ConfigurationGenerator();
		int[] x = {1,2,3, 4, 5, 6, 7, 8, 9};
		cg.generatePermutation(x);
//		Solver test = new Solver();
//		System.out.println(test.findSolution(Model.CONFIGURATION_789));
		
//		Model model = new Model("default");
//		App app = new App(model);
//		app.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e) {
//				new ExitApplicationController(app).process();
//			}
//		});
//		app.setVisible(true);
//		app.repaint();
	}
}
