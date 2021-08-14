package com.bai.game.gold.miner.draw;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ImageInfoModel;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author Bai
 * @date 2021/8/14 17:35
 */
public class BaseDraw {

	public static Map<String, List<ImageInfoModel>> IMAGE_INFO_MAP = new HashMap<>();

	public static List<ImageInfoModel> getImageInfoModel (String key) {
		return IMAGE_INFO_MAP.get(key);
	}

	public static List<ImageInfoModel> buildAllGoldOrStone (List<ImageInfoModel> orImages, Integer count) {
		List<ImageInfoModel> allImages = Lists.newArrayList();
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			ImageInfoModel out = new ImageInfoModel();
			BeanUtils.copyProperties(orImages.get(random.nextInt(orImages.size() - 1)), out);
			List<ImageInfoModel> all = Lists.newArrayList();
			IMAGE_INFO_MAP.values().forEach(all::addAll);
			buildXYInfo(all, out);
			allImages.add(out);
		}
		return allImages;
	}

	public static void buildXYInfo (List<ImageInfoModel> all, ImageInfoModel outModel) {
		Integer x = x();
		Integer y = y();
		for (ImageInfoModel infoModel : all) {
			if (null == infoModel.getX() || null == infoModel.getY()) {
				continue;
			}
			Rectangle rec = infoModel.getRec();
			Rectangle outRec = outModel.getRec(x, y);
			if (rec.intersects(outRec) || outRec.intersects(rec)) {
				buildXYInfo(all, outModel);
			}
		}
		//构建坐标等信息
		outModel.setX(x);
		outModel.setY(y);
	}

	public static Integer x () {
		return (int)(Math.random() * 700);
	}

	public static Integer y () {
		return (int)(Math.random() * 550 + 300);
	}

	/**
	 * 随机刷新金子or石头
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (String key, Integer count, Graphics g, ImageObserver imageObserver) {
		List<ImageInfoModel> allImages = getImageInfoModel(key);
		if (CollectionUtils.isEmpty(allImages)) {
			allImages = buildAllGoldOrStone(GoldMinerPicUtil.getByKey(key), count);
		}
		IMAGE_INFO_MAP.put(key, allImages);
		doPaint(g, imageObserver, allImages);
	}

	public static void doPaint (Graphics g, ImageObserver imageObserver, List<ImageInfoModel> allImages) {
		allImages.forEach(imageInfoModel -> {
			g.drawImage(imageInfoModel.getImage(), imageInfoModel.getX(), imageInfoModel.getY(),
				imageInfoModel.getWidth(), imageInfoModel.getHeight(), imageObserver);
		});
	}
}
