package starter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import starter.boundary.App;
import starter.entity.Model;

public class Config234Controller implements ActionListener{
	Model model;
	App app;
	JMenuItem mntm;
	
	public Config234Controller(Model model, App app) {
		this.model = model;
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.resetGameTo(Model.CONFIGURATION_234);
		app.repaint();
	}

}