package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * 黑石头 处理类
 *
 * @author Bai
 * @date 2021/8/12 22:17
 */
public class StoneDraw extends BaseDraw {

	/**
	 * 随机刷新金子
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		paint("StoneDraw", 5, g, imageObserver);
	}

}
