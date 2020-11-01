package com.project.bomberman.entities.tile;

import com.project.bomberman.Board;
import com.project.bomberman.entities.Entity;
import com.project.bomberman.entities.mob.Player;
import com.project.bomberman.graphics.Sprite;

public class PortalTile extends Tile {

	protected Board _board;


	public PortalTile(int x, int y, Board board, Sprite sprite) {
		super(x, y, sprite);
		_board = board;
	}

	/**
	 * Xử lý va chạm với người chơi để qua màn
	 */
	@Override
	public boolean collide(Entity e) {
		if(e instanceof Player ) {
            if (!_board.detectNoEnemies())
                return false;

            if (e.getXTile() == getX() && e.getYTile() == getY()) {
                if (_board.detectNoEnemies())
                    _board.nextLevel();
            }

            return true;
        }
		return false;
	}
}
