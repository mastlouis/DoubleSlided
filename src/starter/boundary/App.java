package starter.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.Sizes;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Button;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class App {

	private JFrame frmDoubleSlidedApp;
	private JTextField txtMovesMade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					App window = new App();
//					window.frmDoubleSlidedApp.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDoubleSlidedApp = new JFrame();
		frmDoubleSlidedApp.setTitle("Double Slided App");
		frmDoubleSlidedApp.setBounds(100, 100, 452, 424);
		frmDoubleSlidedApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmDoubleSlidedApp.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(667, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(224, Short.MAX_VALUE))
		);
		
		txtMovesMade = new JTextField();
		txtMovesMade.setText("Moves Made:");
		txtMovesMade.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("New button");
		
		JButton btnNewButton_7 = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JButton btnNewButton_9 = new JButton("New button");
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_3 = new JButton("New button");
		
		JButton btnNewButton_4 = new JButton("New button");
		
		JButton btnNewButton_10 = new JButton("New button");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtMovesMade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(263)
							.addComponent(btnNewButton_7))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(5)
							.addComponent(btnNewButton_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_11)))
					.addGap(31))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_10))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4)))
					.addGap(147))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_7)
						.addComponent(txtMovesMade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_9)
							.addComponent(btnNewButton_11)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_5)
							.addComponent(btnNewButton_4)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_10))
					.addGap(230))
		);
		panel.setLayout(gl_panel);
		frmDoubleSlidedApp.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frmDoubleSlidedApp.setJMenuBar(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mnGame.add(mntmReset);
	}
}
