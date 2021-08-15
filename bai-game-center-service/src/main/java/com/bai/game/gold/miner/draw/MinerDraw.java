package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.model.ObjectInfoModel;

/**
 * 矿工处理类
 *
 * @author Bai
 * @date 2021/8/11 22:22
 */
public class MinerDraw {

	/**
	 * 绘制矿工
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		ObjectInfoModel objectInfoModel = GoldMinerPicUtil.getMinerImageByKey(GoldMinerConstant.MINER);
		g.drawImage(objectInfoModel.getImage(), objectInfoModel.getX(), objectInfoModel.getY(), objectInfoModel.getWidth(),
			objectInfoModel.getHeight(), imageObserver);
	}
}
