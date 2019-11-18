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
		ConfigurationGenerator cg = new ConfigurationGenerator(9);
		ConfigurationGenerator parallel = new ConfigurationGenerator(8);
//		for(int i = 0; i < 6; i++)
//			System.out.println(parallel.printer(parallel.nextPermutation()));
//		for(int i = 0; i < 0x100; i++)
//			System.out.println(cg.getNextBoardState());
		
		Solver test = new Solver();
//		System.out.println(test.findSolution(Model.CONFIGURATION_789));
		for(int i = 0; i < 0x100; i++) {
			String configuration = cg.getNextBoardState();
			System.out.println(configuration);
			System.out.println(test.findSolution(configuration));
		}
		
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
