package com.project.bomberman.level;


import com.project.bomberman.exceptions.LoadLevelException;

public interface ILevel {

	public void loadLevel(String path) throws LoadLevelException;
}
