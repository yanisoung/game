package com.bai.game.gold.miner.draw;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;

import com.bai.game.gold.miner.model.ObjectInfoModel;

import static com.bai.game.gold.miner.constant.DataInfoConstant.STONE_DRAW;

/**
 * 黑石头 处理类
 *
 * @author Bai
 * @date 2021/8/12 22:17
 */
public class StoneDraw extends BaseDraw {

	/**
	 * 随机刷新石头
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		paint(STONE_DRAW, getStoneCount(), g, imageObserver);
	}

	public static List<ObjectInfoModel> getAllStone () {
		return getObjectInfoModel(STONE_DRAW);
	}
}
