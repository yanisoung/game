package com.bai.game.gold.miner.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Map;
import java.util.Map.Entry;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ObjectInfoModel;

/**
 * 背景图片处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class BgDraw extends BaseDraw {

	/**
	 * 绘制背景图片
	 *
	 * @param g
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		//绘制背景图片
		paintBg(g, imageObserver);
		//绘制积分&金币等物品
		paintDataInfo(g, imageObserver);
		//商店
		ShopDraw.paint(g, imageObserver);
	}

	private static void paintDataInfo (Graphics g, ImageObserver imageObserver) {
		g.setColor(Color.black);
		g.setFont(new Font("仿宋", Font.BOLD, 40));
		g.drawString("积分:" + getIntegral(), 80, 100);
		g.drawString("金币:" + getGoldCoin(), 80, 160);
	}

	private static void paintBg (Graphics g, ImageObserver imageObserver) {
		Map<String, ObjectInfoModel> allBgImage = GoldMinerPicUtil.getAllBgImage();
		for (Entry<String, ObjectInfoModel> entry : allBgImage.entrySet()) {
			ObjectInfoModel objectInfoModel = entry.getValue();
			g.drawImage(objectInfoModel.getImage(), objectInfoModel.getX(), objectInfoModel.getY(),
				objectInfoModel.getWidth(), objectInfoModel.getHeight(), imageObserver);
		}
	}

}
