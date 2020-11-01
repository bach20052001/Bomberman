package com.project.bomberman.level;


import com.project.bomberman.exceptions.LoadLevelException;

public interface ILevel {

    void loadLevel(String path) throws LoadLevelException;
}
