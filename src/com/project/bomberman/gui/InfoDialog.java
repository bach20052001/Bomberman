package com.project.bomberman.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InfoDialog implements WindowListener {

	private final Frame _frame;

	public InfoDialog(Frame f, String title, String message, int option) {
		_frame = f;

		final JFrame dialog = new JFrame(title);
		final JButton button = new JButton("Ok");
		button.addActionListener(e -> dialog.dispose());

		JButton[] buttons = {button};
		JOptionPane optionPane = new JOptionPane(
				message,
				option,
				JOptionPane.YES_NO_OPTION, null, buttons, button);
		dialog.getContentPane().add(optionPane);
		dialog.setSize(500, 300);
		dialog.setLocationRelativeTo(f);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        dialog.addWindowListener(this);
	  }

	@Override
	public void windowOpened(WindowEvent e) {
		_frame.pauseGame();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		_frame.resumeGame();
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
