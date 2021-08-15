package com.bai.game.gold.miner.draw;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;

import com.bai.game.gold.miner.model.ObjectInfoModel;

/**
 * 金子 处理类
 *
 * @author Bai
 * @date 2021/8/11 22:16
 */
public class GoldDraw extends BaseDraw {

	/**
	 * 随机刷新金子
	 *
	 * @param g
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		String key = "GoldDraw";
		paint(key, 10, g, imageObserver);
	}

	public static List<ObjectInfoModel> getAllGold () {
		String key = "GoldDraw";
		return getObjectInfoModel(key);
	}

}
