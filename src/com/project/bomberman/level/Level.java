package com.project.bomberman.level;

import com.project.bomberman.Board;
import com.project.bomberman.exceptions.LoadLevelException;

public abstract class Level implements ILevel {

	protected int _width, _height, _level;
	protected String[] _lineTiles;
	protected Board _board;

	// code để chuyển màn khác
	private static String[] codes = { //TODO: change this code system to actualy load the code from each level.txt
		"JumpToLevel1",
		"JumpToLevel2",
		"JumpToLevel3",
		"JumpToLevel4",
		"JumpToLevel5",
		"JumpToLevel6",
		};

	public Level(String path, Board board) throws LoadLevelException {
		loadLevel(path);
		_board = board;
	}

	@Override
	public abstract void loadLevel(String path) throws LoadLevelException;
	
	public abstract void createEntities();

	/*
	|--------------------------------------------------------------------------
	| Codes
	|--------------------------------------------------------------------------
	 */

	// check code xem hợp lệ k ??
	public int validCode(String str) {
		for (int i = 0; i < codes.length; i++) {
			if (codes[i].equals(str)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getActualCode() {
		return codes[_level -1];
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public int getLevel() {
		return _level;
	}

}
