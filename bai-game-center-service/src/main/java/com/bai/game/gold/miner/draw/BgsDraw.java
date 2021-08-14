package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;

import com.bai.game.gold.miner.GoldMinerPicUtil;

/**
 * 背景图片处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class BgsDraw {

	/**
	 * 绘制背景图片
	 *
	 * @param g
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		Map<String, Image> allBgImage = GoldMinerPicUtil.getAllBgImage();
		for (Entry<String, Image> entry : allBgImage.entrySet()) {
			List<Integer> imageInfo = GoldMinerPicUtil.getImageInfoByKey(entry.getKey());
			g.drawImage(entry.getValue(), imageInfo.get(0), imageInfo.get(1), imageInfo.get(2), imageInfo.get(3),
				imageObserver);
		}
	}


}
