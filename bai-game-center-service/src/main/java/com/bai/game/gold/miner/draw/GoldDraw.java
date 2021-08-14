package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;
import java.util.Random;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ImageInfoModel;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

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
		String key = "GoldDraw";
		List<ImageInfoModel> allImages = getImageInfoModel(key);
		if (CollectionUtils.isEmpty(allImages)) {
			allImages = buildAllGoldOrStone(GoldMinerPicUtil.getAllGold(), 10);
			IMAGE_INFO_MAP.put(key, allImages);
		}
		doPaint(g, imageObserver, allImages);
	}

}
