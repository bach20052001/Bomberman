package com.project.bomberman.entities;

import com.project.bomberman.graphics.IRender;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;
import com.project.bomberman.level.Coordinates;

public abstract class Entity implements IRender {

	protected double _x, _y;
	protected boolean _removed = false;
	protected Sprite _sprite;
	
	@Override
	public abstract void update();
	
	@Override
	public abstract void render(Screen screen);
	
	public void remove() {
		_removed = true;
	}
	
	public boolean isRemoved() {
		return _removed;
	}
	
	public Sprite getSprite() {
		return _sprite;
	}
	
	public abstract boolean collide(Entity e);
	
	public double getX() {
		return _x;
	}
	
	public double getY() {
		return _y;
	}
	
	public int getXTile() {
		return Coordinates.pixelToTile(_x + _sprite.SIZE / 2f); //plus half block for precision
	}
	
	public int getYTile() {
		return Coordinates.pixelToTile(_y - _sprite.SIZE / 2f); //plus half block
	}
}
