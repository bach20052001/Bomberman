package com.project.bomberman.level;

import com.project.bomberman.Board;
import com.project.bomberman.Game;
import com.project.bomberman.entities.LayeredEntity;
import com.project.bomberman.entities.mob.Player;
import com.project.bomberman.entities.mob.enemy.*;
import com.project.bomberman.entities.tile.GrassTile;
import com.project.bomberman.entities.tile.PortalTile;
import com.project.bomberman.entities.tile.WallTile;
import com.project.bomberman.entities.tile.destroyable.BrickTile;
import com.project.bomberman.entities.tile.powerup.PowerupBombs;
import com.project.bomberman.entities.tile.powerup.PowerupFlames;
import com.project.bomberman.entities.tile.powerup.PowerupSpeed;
import com.project.bomberman.exceptions.LoadLevelException;
import com.project.bomberman.graphics.Screen;
import com.project.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevel extends Level {
	
	public FileLevel(String path, Board board) throws LoadLevelException {
		super(path, board);
	}

	/**
	 * Đọc các thực thể của từng level từ levels/....txt
	 */

	@Override
	public void loadLevel(String path) throws LoadLevelException {
		try {
			URL absPath = FileLevel.class.getResource("/" + path);
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(absPath.openStream()));

			String data = in.readLine();
			StringTokenizer tokens = new StringTokenizer(data);
			
			_level = Integer.parseInt(tokens.nextToken());
			_height = Integer.parseInt(tokens.nextToken());
			_width = Integer.parseInt(tokens.nextToken());

			_lineTiles = new String[_height];
			
			for(int i = 0; i < _height; ++i) {
				_lineTiles[i] = in.readLine().substring(0, _width);
 			}
			
			in.close();
		} catch (IOException e) {
			throw new LoadLevelException("Error loading level " + path, e);
		}
	}
	
	@Override
	public void createEntities() {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				addLevelEntity( _lineTiles[y].charAt(x), x, y );
			}
		}
	}


	//Tạo map từ file txt
	public void addLevelEntity(char c, int x, int y) {
		int pos = x + y * getWidth();
		
		switch(c) { // TODO: minimize this method
			case 'w':
				_board.addEntitie(pos, new WallTile(x, y, Sprite.wallAround));
				break;

			case '#':
				_board.addEntitie(pos, new WallTile(x, y, Sprite.wall));
				break;

			case 'b':
				LayeredEntity layer = new LayeredEntity(x, y,
						new GrassTile(x, y, Sprite.grass),
						new BrickTile(x, y, Sprite.brick));

				if (!_board.isPowerupUsed(x, y, _level)) {
					layer.addBeforeTop(new PowerupBombs(x, y, _level, Sprite.powerup_bombs));
				}

				_board.addEntitie(pos, layer);
				break;
			case 's':
				layer = new LayeredEntity(x, y,
						new GrassTile(x, y, Sprite.grass),
						new BrickTile(x, y, Sprite.brick));

				if (!_board.isPowerupUsed(x, y, _level)) {
					layer.addBeforeTop(new PowerupSpeed(x, y, _level, Sprite.powerup_speed));
				}

				_board.addEntitie(pos, layer);
				break;
			case 'f':
				layer = new LayeredEntity(x, y,
						new GrassTile(x, y, Sprite.grass),
						new BrickTile(x, y, Sprite.brick));

				if (!_board.isPowerupUsed(x, y, _level)) {
					layer.addBeforeTop(new PowerupFlames(x, y, _level, Sprite.powerup_flames));
				}

				_board.addEntitie(pos, layer);
				break;
			case '*':
				_board.addEntitie(pos, new LayeredEntity(x, y,
						new GrassTile(x, y, Sprite.grass),
						new BrickTile(x, y, Sprite.brick)));
				break;
			case 'x':
				_board.addEntitie(pos, new LayeredEntity(x, y,
						new GrassTile(x, y, Sprite.grass),
						new PortalTile(x, y, _board, Sprite.portal),
						new BrickTile(x, y, Sprite.brick)));
				break;
			case 'p':
				_board.addMob(new Player(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				Screen.setOffset(0, 0);

				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass));
				break;
			//Enemies
			case '1':
				_board.addMob(new Balloom(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass));
				break;
			case '2':
				_board.addMob( new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass) );
				break;
			case '3':
				_board.addMob( new Doll(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass) );
				break;
			case '4':
				_board.addMob( new Minvo(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass) );
				break;
			case '5':
				_board.addMob( new Kondoria(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass) );
				break;
			default: 
				_board.addEntitie(pos, new GrassTile(x, y, Sprite.grass) );
				break;
			}
	}
	
}
