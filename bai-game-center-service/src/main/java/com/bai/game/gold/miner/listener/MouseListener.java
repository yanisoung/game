package com.bai.game.gold.miner.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.bai.game.gold.miner.draw.LineDraw;

/**
 * 鼠标监听事件
 *
 * @author Bai
 * @date 2021/8/14 22:47
 */
public class MouseListener {

	public static void listener (JFrame jFrame) {
		jFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				super.mouseClicked(e);
				if (e.getButton() == 1) {
					LineDraw.status = 1;
				}
			}
		});
	}
}
