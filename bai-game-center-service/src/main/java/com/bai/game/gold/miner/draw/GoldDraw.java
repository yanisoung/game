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

	public static void paint (Graphics g) {
		List<Image> allGold = GoldMinerPicUtil.getAllGold();
		Random random = new Random();
		//todo 解决 图片重叠 & 金子随机到上方的问题 白
		for (int i = 0; i < 10; i++) {
			g.drawImage(allGold.get(random.nextInt(allGold.size())), random.nextInt(1200), random.nextInt(600), null);
		}

	}
}
