package com.bai.game.gold.miner.draw;

import java.awt.*;

import javax.swing.*;

import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.GoldMinerPicUtil;

/**
 * 背景窗口处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class WindowsDraw {

	/**
	 * 绘制背景图片
	 * @param g
	 */
	public static void paint (Graphics g) {
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.BG_LAND), 0, 0, 1200, 800, null);
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.BG_SKY), 0, 10, 1200, 200, null);
	}

	/**
	 * 绘制窗口
	 */
	public static void drawWindows (JFrame jFrame) {
		//创建标题名
		jFrame.setTitle("黄金矿工");
		// 窗口默认是不可见的
		jFrame.setVisible(true);
		jFrame.setSize(1200, 800);
		jFrame.setLocation(1200, 300);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
