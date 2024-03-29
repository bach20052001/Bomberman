package com.project.bomberman.entities.tile.destroyable;


import com.project.bomberman.entities.Entity;
import com.project.bomberman.entities.bomb.DirectionalExplosion;
import com.project.bomberman.entities.mob.enemy.Kondoria;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;
import com.project.bomberman.level.Coordinates;

public class BrickTile extends DestroyableTile {
	
	public BrickTile(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	
	@Override
	public void update() {
		super.update();
	}
	
	@Override
	public void render(Screen screen) {
		int x = Coordinates.tileToPixel(_x);
		int y = Coordinates.tileToPixel(_y);
		
		if(_destroyed) {
			_sprite = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2);
			
			screen.renderEntityWithBelowSprite(x, y, this, _belowSprite);
		}
		else
			screen.renderEntity( x, y, this);
	}

	/**
	 * Xử lý va chạm với boom
	 * @param e
	 * @return
	 */
	@Override
	public boolean collide(Entity e) {

        if (e instanceof DirectionalExplosion)
            destroy();

        return e instanceof Kondoria;
    }
	
	
}
