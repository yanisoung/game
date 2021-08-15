package com.bai.game.gold.miner.draw;

import java.awt.Graphics;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.constant.GoldMinerConstant;

/**
 * 抓钩
 *
 * @author Bai
 * @date 2021/8/15 13:55
 */
public class GrapnelDraw {

	public static void paint (Graphics g) {
		g.drawImage(GoldMinerPicUtil.getMinerImageByKey(GoldMinerConstant.GRANPEL).getImage(), LineDraw.endX - 34,
			LineDraw.endY, null);
	}

}
