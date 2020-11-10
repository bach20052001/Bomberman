package com.project.bomberman.gui;

import com.project.bomberman.Game;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

	private final JLabel timeLabel;
	private final JLabel pointsLabel;
	private final JLabel livesLabel;
	private final JLabel cdLabel;
	private final JLabel imgLabel = new JLabel(new ImageIcon("res/textures/shield2.png"));

	public InfoPanel(Game game) {
		setLayout(new GridLayout());

		timeLabel = new JLabel("Time: " + game.getBoard().getTime());
		timeLabel.setForeground(Color.white);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		pointsLabel = new JLabel("Points: " + game.getBoard().getPoints());
		pointsLabel.setForeground(Color.white);
		pointsLabel.setHorizontalAlignment(JLabel.CENTER);
		
		livesLabel = new JLabel("Lives: " + game.getBoard().getLives());
		livesLabel.setForeground(Color.white);
		livesLabel.setHorizontalAlignment(JLabel.CENTER);

		cdLabel = new JLabel("CD Shield: " + game.getBoard().get_cdShield());
		cdLabel.setForeground(Color.white);
		cdLabel.setHorizontalAlignment(JLabel.LEFT);

		imgLabel.setHorizontalAlignment(JLabel.RIGHT);


		add(timeLabel);
		add(pointsLabel);
		add(livesLabel);
		add(imgLabel);
		add(cdLabel);

		
		setBackground(Color.black);
		setPreferredSize(new Dimension(0, 40));
	}
	
	public void setTime(int t) {
		timeLabel.setText("Time: " + t);
	}

	public void setLives(int t) {
		livesLabel.setText("Lives: " + t);
		
	}

	public void setPoints(int t) {
		pointsLabel.setText("Points: " + t);		
	}

	public void setCD(int t){
		cdLabel.setText("CD Shield: " + t);
	}
}
