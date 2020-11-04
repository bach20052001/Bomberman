package com.project.bomberman.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    /**
     * Xử lý để nhận input từ bàn phím
     */
    private final boolean[] keys = new boolean[200]; //120 is enough to this game
    public boolean up, down, left, right, space ,add ,subtract ,backtick , R;

    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        space = keys[KeyEvent.VK_SPACE] || keys[KeyEvent.VK_X];
        add = keys[KeyEvent.VK_ADD];
        subtract = keys[KeyEvent.VK_SUBTRACT];
        backtick = keys[KeyEvent.VK_BACK_QUOTE];
        R = keys[KeyEvent.VK_R];
    }

    @Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
}
