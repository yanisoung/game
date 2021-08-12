package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.util.List;
import java.util.Random;

import com.bai.game.gold.miner.GoldMinerPicUtil;

/**
 * 黑石头 处理类
 *
 * @author Bai
 * @date 2021/8/12 22:17
 */
public class StoneDraw {

	/**
	 * 随机刷新金子
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		List<String> allStone = GoldMinerPicUtil.getAllStoneKey();
		Random random = new Random();
		int stoneCount = 5;
		for (int i = 0; i < stoneCount; i++) {
			String key = allStone.get(random.nextInt(allStone.size() - 1));
			Image image = GoldMinerPicUtil.getStoneImageByKey(key);
			int x = 10 + (int)(Math.random() * (1200 - 10 + 1));
			int y = 210 + (int)(Math.random() * (790 - 210 + 1));
			g.drawImage(image, x, y, null);
		}
	}
}
