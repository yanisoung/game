package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.util.List;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.constant.GoldMinerConstant;

/**
 * 矿工处理类
 *
 * @author Bai
 * @date 2021/8/11 22:22
 */
public class GoldMinerDraw {

	/**
	 * 绘制矿工
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		List<Integer> imageInfo = GoldMinerPicUtil.getImageInfoByKey(GoldMinerConstant.MINER);
		g.drawImage(GoldMinerPicUtil.getMinerImageByKey(GoldMinerConstant.MINER), imageInfo.get(0), imageInfo.get(1),
			imageInfo.get(2), imageInfo.get(3), null);
	}
}
