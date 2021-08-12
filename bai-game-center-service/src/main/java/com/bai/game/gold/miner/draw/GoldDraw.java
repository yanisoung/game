package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.util.List;
import java.util.Random;

import com.bai.game.gold.miner.GoldMinerPicUtil;

/**
 * 金子 处理类
 *
 * @author Bai
 * @date 2021/8/11 22:16
 */
public class GoldDraw {

	/**
	 * 随机刷新金子
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		List<Image> allGold = GoldMinerPicUtil.getAllGold();
		//todo 解决 图片重叠 &gif图片展示失败 白
		Random random = new Random();
		int goldCount = 10;
		for (int i = 0; i < goldCount; i++) {
			Image image = allGold.get(random.nextInt(allGold.size() - 1));
			int x = 10 + (int)(Math.random() * (1200 - 10 + 1));
			int y = 210 + (int)(Math.random() * (790 - 210 + 1));
			g.drawImage(image, x, y, null);
		}

	}
}
