package com.bai.game.gold.miner.draw;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.model.ObjectInfoModel;

/**
 * 店铺
 *
 * @author Bai
 * @date 2021/8/15 16:37
 */
public class ShopDraw extends BaseDraw {

	/**
	 * 绘制
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (Graphics g, ImageObserver imageObserver) {
		ObjectInfoModel potion = GoldMinerPicUtil.getShopDataByKey(GoldMinerConstant.POTION);
		//绘制药水
		g.drawImage(potion.getImage(), potion.getX(), potion.getY(), potion.getWidth(), potion.getHeight(),
			imageObserver);
		g.setFont(new Font("仿宋", Font.BOLD, 20));
		g.drawString(" X " + getPotion(), 340, 130);
		g.drawString("F键使用/购买", 270, 190);
	}

	/**
	 * 物品消耗&购买
	 */
	public static void consume () {
		Integer potion = getPotion();
		//激活购买功能
		if (potion < 1) {
			Integer goldCoin = getGoldCoin();
			if (goldCoin >= 3) {
				//减少金币
				changeGoldCoin(-3);
				//增加药水一个
				changePotion(1);
			}
		} else {
			//直接消耗1个
			changePotion(-1);
			//todo 执行药水效果
		}
	}

}
