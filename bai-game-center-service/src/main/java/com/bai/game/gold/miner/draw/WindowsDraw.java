package com.bai.game.gold.miner.draw;

import javax.swing.*;

/**
 * 背景窗口处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class WindowsDraw {

	/**
	 * 绘制窗口
	 */
	public static void paint (JFrame jFrame) {
		//创建标题名
		jFrame.setTitle("黄金矿工");
		// 窗口默认是不可见的
		jFrame.setVisible(true);
		jFrame.setSize(1200, 800);
		jFrame.setLocation(500, 100);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
