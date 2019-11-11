package starter.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class App extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 410);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mnGame.add(mntmReset);
		
		JMenuItem mntmSeeSolvedPuzzle = new JMenuItem("See Solved Puzzle");
		mnGame.add(mntmSeeSolvedPuzzle);
		
		JMenu mnChangeConfiguration = new JMenu("Change Configuration");
		mnGame.add(mnChangeConfiguration);
		
		JMenuItem mntmConfiguration = new JMenuItem("Configuration 01");
		mnChangeConfiguration.add(mntmConfiguration);
		
		JMenuItem mntmConfiguration_1 = new JMenuItem("Configuration 234");
		mnChangeConfiguration.add(mntmConfiguration_1);
		
		JMenuItem mntmConfiguration_2 = new JMenuItem("Configuration 56");
		mnChangeConfiguration.add(mntmConfiguration_2);
		
		JMenuItem mntmConfiguration_3 = new JMenuItem("Configuration 789");
		mnChangeConfiguration.add(mntmConfiguration_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
