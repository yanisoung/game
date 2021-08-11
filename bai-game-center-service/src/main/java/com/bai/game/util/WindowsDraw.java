package com.bai.game.util;

import java.awt.*;

import javax.swing.*;

import com.bai.game.gold.miner.GoldMinerConstant;
import com.bai.game.gold.miner.GoldMinerPicUtil;

/**
 * 画图util
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class WindowsDraw extends JFrame {

	@Override
	public void paint (Graphics g) {
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.BG_LAND), 0, 0, 1200, 800, null);
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.BG_SKY), 0, 10, 1200, 200, null);
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.MINER), 530, 60, 140, 150, null);
	}

	/**
	 * 绘制窗口
	 *
	 * @param sceneWidth
	 * @param sceneHeight
	 * @param time
	 */
	public static void drawWindows (String windowName, Integer x, Integer y, Integer sceneWidth, Integer sceneHeight,
		Long time) {
		//创建标题名
		WindowsDraw window = new WindowsDraw();
		window.setTitle(windowName);
		// 窗口默认是不可见的
		window.setVisible(true);
		window.setSize(sceneWidth, sceneHeight);
		window.setLocation(x, y);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		if (null != time) {
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				//todo
			}
		}
	}

	public static void main (String[] args) {
		drawWindows("黄金矿工", 800, 300, 1200, 800, 1000L);
	}
}
