package starter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;

import starter.boundary.App;
import starter.entity.Model;

public class ResetController implements ActionListener/*, ItemListener*/{
	Model model;
	App app;
	JMenuItem mntm;
	
	public ResetController(Model model, App app) {
		this.model = model;
		this.app = app;
	}

//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("Reset button pressed: Item state changed");
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Reest button pressed: Action perfomed");
		// TODO Auto-generated method stub
		model.resetGame();
		app.repaint();
	}

}
