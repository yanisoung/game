package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Map;
import java.util.Map.Entry;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ImageInfoModel;

/**
 * 背景图片处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class BgDraw {

	/**
	 * 绘制背景图片
	 *
	 * @param g
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		Map<String, ImageInfoModel> allBgImage = GoldMinerPicUtil.getAllBgImage();
		for (Entry<String, ImageInfoModel> entry : allBgImage.entrySet()) {
			ImageInfoModel imageInfoModel = entry.getValue();
			g.drawImage(imageInfoModel.getImage(), imageInfoModel.getX(), imageInfoModel.getY(),
				imageInfoModel.getWidth(), imageInfoModel.getHeight(), imageObserver);
		}
	}

}
