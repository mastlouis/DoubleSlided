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
//		ConfigurationGenerator parallel = new ConfigurationGenerator(8);
		
//		Model model = new Model(Model.CONFIGURATION_01);
//		System.out.println(model.getBoard().isSolvable());
//		model.resetGameTo(Model.CONFIGURATION_234);
//		System.out.println(model.getBoard().isSolvable());
//		model.resetGameTo(Model.CONFIGURATION_56);
//		System.out.println(model.getBoard().isSolvable());
//		model.resetGameTo(Model.CONFIGURATION_789);
//		System.out.println(model.getBoard().isSolvable());
		
//		for(int i = 0; i < 6; i++)
//			System.out.println(parallel.printer(parallel.nextPermutation()));
//		for(int i = 0; i < 0x100; i++)
//			System.out.println(cg.getNextBoardState());
		
		Solver test = new Solver();
//		System.out.println(test.findSolution(Model.CONFIGURATION_789));
		while(!cg.hasResumed())
			cg.getNextBoardState();
		do {
			String configuration = cg.getNextBoardState();
			System.out.println(configuration);
			String solution = test.findSolution(configuration);
			System.out.println(solution + " length: " + solution.length());
		} while(!cg.hasRepeated());
		
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
