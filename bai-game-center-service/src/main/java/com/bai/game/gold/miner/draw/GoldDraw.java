package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;

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
		paint("GoldDraw", 10, g, imageObserver);
	}

}
