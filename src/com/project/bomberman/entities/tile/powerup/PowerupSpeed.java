package com.project.bomberman.entities.tile.powerup;

import com.project.bomberman.Game;
import com.project.bomberman.entities.Entity;
import com.project.bomberman.entities.mob.Player;
import com.project.bomberman.graphics.Sprite;

public class PowerupSpeed extends Powerup {

	public PowerupSpeed(int x, int y, int level, Sprite sprite) {
		super(x, y, level, sprite);
	}

	/**
	 * Xử lý va chạm với người chơi khi nhặt vật phẩm
	 */
	@Override
	public boolean collide(Entity e) {
		
		if(e instanceof Player) {
			((Player) e).addPowerup(this);
			remove();
			return true;
		}
		return false;
	}
	
	@Override
	public void setValues() {
		_active = true;
		Game.addPlayerSpeed(0.1);
	}
}
