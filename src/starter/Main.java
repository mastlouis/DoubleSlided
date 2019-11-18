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
		ConfigurationGenerator cg = new ConfigurationGenerator(3);
		int[] x = {0,1,2};
		cg.generatePermutation(x);
		System.out.println("As above, so below");
		for(int i = 0; i < 6; i++)
			System.out.println(cg.printer(cg.nextPerumtation()));
		
		
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
