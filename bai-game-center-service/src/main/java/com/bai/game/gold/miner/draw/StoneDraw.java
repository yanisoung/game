package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.List;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ImageInfoModel;
import org.apache.commons.collections.CollectionUtils;

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
		String key = "StoneDraw";
		List<ImageInfoModel> allImages = getImageInfoModel(key);
		if (CollectionUtils.isEmpty(allImages)) {
			allImages = buildAllGoldOrStone(GoldMinerPicUtil.getAllStone(), 5);
		}
		IMAGE_INFO_MAP.put(key, allImages);
		doPaint(g, imageObserver, allImages);
	}

}
