package com.project.bomberman.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CodeDialog implements WindowListener, ActionListener {

    private final Frame _frame;
    private final JFrame _dialog;
    private final JTextField _code;
    private boolean _valid = false;

    public CodeDialog(Frame f) {
        _frame = f;

        _dialog = new JFrame("Enter a Valid Code");
        final JButton button = new JButton("Load!");
        button.addActionListener(this);

        JPanel pane = new JPanel(new BorderLayout());
		_code = new JTextField("code");

		pane.add(new JLabel("Code: "), BorderLayout.WEST);
		pane.add(_code, BorderLayout.CENTER);
		pane.add(button, BorderLayout.PAGE_END);

		_dialog.getContentPane().add(pane);
		_dialog.setLocationRelativeTo(f);
		_dialog.setSize(400, 100);
		_dialog.setVisible(true);
		_dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_dialog.addWindowListener(this);
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
        if (!_valid)
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String code = _code.getText();

		if(_frame.validCode(code)) {
			_frame.changeLevelByCode(code);
			_valid = true;
			_dialog.dispose();
		} else {
			JOptionPane.showMessageDialog(_frame,
				    "That code isnt correct!!!",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
