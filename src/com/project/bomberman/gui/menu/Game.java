package com.project.bomberman.gui.menu;

import com.project.bomberman.gui.CodeDialog;
import com.project.bomberman.gui.Frame;
import com.project.bomberman.gui.InfoDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game extends JMenu {

	public Frame frame;
	
	public Game(Frame frame) {
        super("Game");
        this.frame = frame;

        /**
         * New Game
         */

        JMenuItem newgame = new JMenuItem("New Game");
        newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        newgame.addActionListener(new MenuActionListener(frame));
        add(newgame);

        /**
         * Scores
         */
        JMenuItem scores = new JMenuItem("Top Scores");
        scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
        scores.addActionListener(new MenuActionListener(frame));
        add(scores);

        /**
         * Codes
         */
        JMenuItem codes = new JMenuItem("Codes");
        codes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        codes.addActionListener(new MenuActionListener(frame));
        add(codes);
    }

	private String ReadFileScore(){
		StringBuilder Scores = new StringBuilder();

		List<Integer> scores = new ArrayList<>();

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("Scores.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(fileInputStream);

		while (scanner.hasNextLine()) {
			scores.add(Integer.parseInt(scanner.nextLine()));
		}

		Collections.sort(scores);
		Collections.reverse(scores);

		for (int i=0;i<scores.size();i++){
			Scores.append("Top " + (i+1) + " : "  + scores.get(i) + "\n");
		}

		return Scores.toString();
	}
	class MenuActionListener implements ActionListener {
		public Frame _frame;
		public MenuActionListener(Frame frame) {
			_frame = frame;
		}
		
		  @Override
		public void actionPerformed(ActionEvent e) {
			  
			  if(e.getActionCommand().equals("New Game")) {
				  _frame.newGame();
			  }
			  
			  if(e.getActionCommand().equals("Top Scores")) {
				  new InfoDialog(_frame, "Top Scores", ReadFileScore(), JOptionPane.INFORMATION_MESSAGE);
			  }
			  
			  if(e.getActionCommand().equals("Codes")) {
				  new CodeDialog(_frame);
			  }
		  }
		}

}
