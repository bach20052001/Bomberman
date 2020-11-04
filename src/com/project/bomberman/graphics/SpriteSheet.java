package com.project.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {


	//Load texture từ textures/classic.png

	public static SpriteSheet tiles = new SpriteSheet("/textures/classic4.bmp", 256);
    public final int SIZE;
    private final String _path;
    public int[] _pixels;

    public SpriteSheet(String path, int size) {
        _path = path;
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        load();
	}
	
	private void load() {
		try {
			URL a = SpriteSheet.class.getResource(_path);
			BufferedImage image = ImageIO.read(a);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, _pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			//TODO: what should this do? stop the program? yes i think
			System.exit(0);
		}
	}
}
