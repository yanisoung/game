package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.bai.game.gold.miner.model.ImageInfoModel;
import com.google.common.collect.Lists;

/**
 * @author Bai
 * @date 2021/8/14 17:35
 */
public class BaseDraw {

	public static Map<String, List<ImageInfoModel>> IMAGE_INFO_MAP = new HashMap<>();

	public static List<ImageInfoModel> getImageInfoModel (String key) {
		return IMAGE_INFO_MAP.get(key);
	}

	public static List<ImageInfoModel> buildAllGoldOrStone (List<ImageInfoModel> orImages) {
		List<ImageInfoModel> allImages = Lists.newArrayList();
		Random random = new Random();
		int goldCount = 10;
		for (int i = 0; i < goldCount; i++) {
			ImageInfoModel imageInfoModel = orImages.get(random.nextInt(orImages.size() - 1));
			int x = 10 + (int)(Math.random() * (1100 - 10 + 1));
			int y = 210 + (int)(Math.random() * (650 - 200 + 1));
			allImages.add(buildImageInfo(imageInfoModel, x, y));
		}
		return allImages;
	}

	public static ImageInfoModel buildImageInfo (ImageInfoModel imageInfoModel, Integer x, Integer y) {
		//构建坐标等信息
		imageInfoModel.setX(x);
		imageInfoModel.setY(y);
		return imageInfoModel;
	}

	public static void doPaint (Graphics g, ImageObserver imageObserver, List<ImageInfoModel> allImages) {
		allImages.forEach(imageInfoModel -> {
			g.drawImage(imageInfoModel.getImage(), imageInfoModel.getX(), imageInfoModel.getY(),
				imageInfoModel.getWidth(), imageInfoModel.getHeight(), imageObserver);
		});
	}
}
