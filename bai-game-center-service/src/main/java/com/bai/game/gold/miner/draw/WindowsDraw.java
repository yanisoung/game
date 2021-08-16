package com.bai.game.gold.miner.draw;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		//获取屏幕尺寸
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 1200;
		int height = 800;
		jFrame.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
