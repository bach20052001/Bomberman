package com.project.bomberman.gui.menu;

import com.project.bomberman.Game;
import com.project.bomberman.gui.Frame;
import com.project.bomberman.gui.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Help extends JMenu {

	public Help(Frame frame)  {
		super("Help");
		
		/*
		 * How to play
		 */
		JMenuItem instructions = new JMenuItem("How to play");
		instructions.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		instructions.addActionListener(new MenuActionListener(frame));
		add(instructions);
		
		/*
		 * Credits
		 */
//		JMenuItem about = new JMenuItem("About");
//		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
//		about.addActionListener(new MenuActionListener(frame));
//		add(about);
		
	}
	
	class MenuActionListener implements ActionListener {
		public Frame _frame;
		public MenuActionListener(Frame frame) {
			_frame = frame;
		}
		
		  @Override
		public void actionPerformed(ActionEvent e) {
			  
			  if(e.getActionCommand().equals("How to play")) {
				  new InfoDialog(_frame, "How to Play", "Movement: W, A, S, D or UP, DOWN, RIGHT, LEFT\nPut Bombs: SPACE, X\nShield: R", JOptionPane.QUESTION_MESSAGE);
			  }
				  
			  if(e.getActionCommand().equals("About")) {
				  new InfoDialog(_frame, "About", "Version: " + Game.VERSION + "\n"
						  + "Author : Nguyen Dinh Bach + Dinh Thi Thanh Huyen \n", JOptionPane.INFORMATION_MESSAGE);
			  }
		  }
	}
}
