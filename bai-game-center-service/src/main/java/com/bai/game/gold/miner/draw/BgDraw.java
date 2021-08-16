package com.bai.game.gold.miner.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadPoolExecutor;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ObjectInfoModel;
import com.bai.game.thred.ThreadPoolExecutorUtil;

/**
 * 背景图片处理类
 *
 * @author Bai
 * @date 2021/8/10 21:19
 */
public class BgDraw extends BaseDraw {

	private static ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorUtil.getPool("BgDraw");

	/**
	 * 绘制背景图片
	 *
	 * @param g
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		//绘制背景图片
		paintBg(g, imageObserver);
		//绘制积分&金币等物品
		paintDataInfo(g);
	}

	private static void paintBg (Graphics g, ImageObserver imageObserver) {
		Map<String, ObjectInfoModel> allBgImage = GoldMinerPicUtil.getAllBgImage();
		for (Entry<String, ObjectInfoModel> entry : allBgImage.entrySet()) {
			ObjectInfoModel objectInfoModel = entry.getValue();
			g.drawImage(objectInfoModel.getImage(), objectInfoModel.getX(), objectInfoModel.getY(),
				objectInfoModel.getWidth(), objectInfoModel.getHeight(), imageObserver);
		}
	}

	private static void paintDataInfo (Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("仿宋", Font.BOLD, 40));
		g.drawString("积分:" + getIntegral(), 250, 100);
		g.drawString("金币:" + getGoldCoin(), 250, 160);
		g.drawString("倒计时:" + getTime(), 750, 120);
		//异步减少倒计时
		asynChangeTime();
		g.setFont(new Font("仿宋", Font.BOLD, 30));
		g.drawString("Level:" + getLevel(), 40, 80);

		g.setFont(new Font("仿宋", Font.BOLD, 20));
		g.drawString("过关积分:" + getLevelIntegral(), 40, 120);
	}

	private static void asynChangeTime () {
		threadPoolExecutor.execute(new Runnable() {
			@Override
			public void run () {
				changeItem(-1, 1000);
			}
		});
	}

}
