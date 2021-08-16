package com.bai.game.gold.miner.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 按钮组件处理
 *
 * @author Bai
 * @date 2021/8/16 21:35
 */
public class ButtonDraw {

	public static void paint (JFrame jFrame) {
		//todo 调试按钮 白
		JPanel jp = new JPanel();
		//重置按钮
		JButton reset = new JButton("重置当前关卡");
		reset.setBackground(Color.YELLOW);
		Dimension preferredSize = new Dimension();
		reset.setPreferredSize(preferredSize);
		reset.setVerticalAlignment(SwingConstants.BOTTOM);
		reset.setEnabled(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 160;
		int height = 60;
		reset.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
		jp.add(reset);
		jFrame.add(jp);
		jFrame.setVisible(true);
	}
}
