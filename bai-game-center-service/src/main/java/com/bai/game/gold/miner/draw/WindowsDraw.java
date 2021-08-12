package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

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
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		Map<String, Image> allBgImage = GoldMinerPicUtil.getAllBgImage();
		for (Entry<String, Image> entry : allBgImage.entrySet()) {
			List<Integer> imageInfo = GoldMinerPicUtil.getImageInfoByKey(entry.getKey());
			g.drawImage(entry.getValue(), imageInfo.get(0), imageInfo.get(1), imageInfo.get(2), imageInfo.get(3), null);
		}
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
