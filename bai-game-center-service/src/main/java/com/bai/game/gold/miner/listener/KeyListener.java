package com.bai.game.gold.miner.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

import javax.swing.JFrame;

import com.bai.game.gold.miner.draw.LineDraw;
import com.bai.game.gold.miner.draw.ShopDraw;

/**
 * 键盘监听
 *
 * @author Bai
 * @date 2021/8/15 9:35
 */
public class KeyListener {

	public static void listener (JFrame jFrame) {
		jFrame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed (KeyEvent e) {
				super.keyPressed(e);
				int keyCode = e.getKeyCode();
				if (Objects.equals(keyCode, KeyEvent.VK_S) || Objects.equals(keyCode, KeyEvent.VK_DOWN)) {
					//修改线的状态
					LineDraw.changeStatus();
				}
				if (Objects.equals(keyCode, KeyEvent.VK_F)) {
					//用品消耗&购买
					ShopDraw.consume();
				}
			}
		});
	}
}
