package com.project.bomberman.gui;

import com.project.bomberman.Game;
import com.project.bomberman.audio.Audio;
import com.project.bomberman.gui.menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

	public GamePanel _gamepane;
	private final InfoPanel _infopanel;

	private final Game _game;

	public Frame() {
		setJMenuBar(new Menu(this));

		JPanel _containerpane = new JPanel(new BorderLayout());
		_gamepane = new GamePanel(this);
		_infopanel = new InfoPanel(_gamepane.getGame());

		_containerpane.add(_infopanel, BorderLayout.PAGE_START);
		_containerpane.add(_gamepane, BorderLayout.PAGE_END);

		_game = _gamepane.getGame();

		add(_containerpane);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		Audio _audio = new Audio();
		_audio.playSound("res/sounds/audiopb.wav",100);
		_game.start();
	}
	
	/*
	|--------------------------------------------------------------------------
	| Game Related
	|--------------------------------------------------------------------------
	 */
	public void newGame() {
		_game.getBoard().newGame();
	}
	
	public void changeLevel(int i) {
		_game.getBoard().changeLevel(i);
	}
	
	public void pauseGame() {
		_game.getBoard().gamePause();
	}
	
	public void resumeGame() {
		_game.getBoard().gameResume();
	}
	
	public boolean isRunning() {
		return _game.isRunning();
	}
	
	public void setTime(int time) {
		_infopanel.setTime(time);
	}
	
	public void setLives(int lives) {
		_infopanel.setLives(lives);
	}
	
	public void setPoints(int points) {
		_infopanel.setPoints(points);
	}

	public void setCDShield(int cd){
		_infopanel.setCD(cd);
	}

	public boolean validCode(String str) {
		return _game.getBoard().getLevel().validCode(str) != -1;
	}
	
	public void changeLevelByCode(String str) {
		_game.getBoard().changeLevelByCode(str);
	}
	
}
