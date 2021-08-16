package com.bai.game.gold.miner.draw;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * 关卡处理类
 *
 * @author Bai
 * @date 2021/8/16 21:37
 */
public class LevelDraw extends BaseDraw {

	public static void next (Graphics g, ImageObserver imageObserver) {
		//校验当前是否摇摆状态
		if (!LineDraw.checkWaitStatus()) {
			return;
		}
		Integer integral = getIntegral();
		//开启下一级
		if (integral.compareTo(getLevelIntegral()) >= 0) {
			try {
				Thread.sleep(1000);
				reLevelInfo(g, imageObserver);
			} catch (InterruptedException e) {
			}
		}
	}
}
