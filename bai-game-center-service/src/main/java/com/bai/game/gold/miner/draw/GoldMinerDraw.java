package com.bai.game.gold.miner.draw;

import java.awt.*;

import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.GoldMinerPicUtil;

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
		g.drawImage(GoldMinerPicUtil.get(GoldMinerConstant.MINER), 530, 60, 140, 150, null);
	}
}
