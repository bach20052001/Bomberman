package com.project.bomberman.entities.bomb;

import com.project.bomberman.Board;
import com.project.bomberman.entities.Entity;
import com.project.bomberman.entities.mob.Mob;
import com.project.bomberman.graphics.Screen;

public class DirectionalExplosion extends Entity {

	protected Board _board;
	protected int _direction;
	private final int _radius;
	protected int xOrigin, yOrigin;
	protected Explosion[] _explosions;

	public DirectionalExplosion(int x, int y, int direction, int radius, Board board) {
		xOrigin = x;
		yOrigin = y;
		_x = x;
		_y = y;
		_direction = direction;
		_radius = radius;
		_board = board;
		
		_explosions = new Explosion[ calculatePermitedDistance() ];
		createExplosions();
		}
	
	private void createExplosions() {
		boolean last;

		int x = (int) _x;
		int y = (int) _y;
		for (int i = 0; i < _explosions.length; i++) {
			last = i == _explosions.length - 1;

			switch (_direction) {
				case 0:
					y--;
					break;
				case 1:
					x++;
					break;
				case 2:
					y++;
					break;
				case 3:
					x--;
					break;
			}
			_explosions[i] = new Explosion(x, y, _direction, last, _board);
		}
	}
	
	private int calculatePermitedDistance() {
		int radius = 0;
		int x = (int)_x;
		int y = (int)_y;
		while(radius < _radius) {
			if (_direction == 0) y--;
			if (_direction == 1) x++;
			if (_direction == 2) y++;
			if (_direction == 3) x--;

			Entity a = _board.getEntity(x, y, null);

			if (a instanceof Mob) ++radius; //explosion has to be below the mob

			if (!a.collide(this)) //cannot pass thru
				break;

			++radius;
		}
		return radius;
	}
	
	public Explosion explosionAt(int x, int y) {
		for (Explosion explosion : _explosions) {
			if (explosion.getX() == x && explosion.getY() == y)
				return explosion;
		}
		return null;
	}

	@Override
	public void update() {}
	
	@Override
	public void render(Screen screen) {

		for (Explosion explosion : _explosions) {
			explosion.render(screen);
		}
	}

	@Override
	public boolean collide(Entity e) {
		return true;
	}
}
