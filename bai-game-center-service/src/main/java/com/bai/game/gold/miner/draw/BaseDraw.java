package com.bai.game.gold.miner.draw;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import com.bai.game.gold.miner.GoldMinerPicUtil;
import com.bai.game.gold.miner.model.ObjectInfoModel;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author Bai
 * @date 2021/8/14 17:35
 */
public class BaseDraw {

	/**
	 * 物体实体
	 */
	public static Map<String, List<ObjectInfoModel>> IMAGE_INFO_MAP = new HashMap<>();

	/**
	 * 数据集合
	 */
	public static Map<String, Integer> DATA_INFO_MAP = new HashMap<>();

	/**
	 * 店铺集合
	 */
	public static Map<String, Integer> SHOP_INFO_MAP = new HashMap<>();

	static {
		//初始化积分
		DATA_INFO_MAP.put("integral", 0);
		//初始化金币
		DATA_INFO_MAP.put("goldCoin", 0);
		//初始化药水
		SHOP_INFO_MAP.put("potion", 0);
	}

	public static Integer getIntegral () {
		return DATA_INFO_MAP.get("integral");
	}

	public static Integer getGoldCoin () {
		return DATA_INFO_MAP.get("goldCoin");
	}

	public static Integer getPotion () {
		return SHOP_INFO_MAP.get("potion");
	}

	public static void changePotion (Integer addCount) {
		if (null == addCount) {
			return;
		}
		Integer potion = getPotion();
		if (Objects.equals(potion, 0) && addCount < 0) {
			return;
		}
		SHOP_INFO_MAP.put("potion", potion + addCount);
	}

	public static void changeIntegral (Integer addIntegral) {
		if (null == addIntegral) {
			return;
		}
		Integer integral = DATA_INFO_MAP.get("integral");
		if (Objects.equals(integral, 0) && addIntegral < 0) {
			return;
		}
		DATA_INFO_MAP.put("integral", integral + addIntegral);
	}

	public static void changeGoldCoin (Integer addGoldCoin) {
		if (null == addGoldCoin) {
			return;
		}
		DATA_INFO_MAP.put("goldCoin", DATA_INFO_MAP.get("goldCoin") + addGoldCoin);
	}

	public static List<ObjectInfoModel> getObjectInfoModel (String key) {
		return IMAGE_INFO_MAP.get(key);
	}

	public static List<ObjectInfoModel> buildAllGoldOrStone (List<ObjectInfoModel> orImages, Integer count) {
		List<ObjectInfoModel> allImages = Lists.newArrayList();
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			ObjectInfoModel out = new ObjectInfoModel();
			BeanUtils.copyProperties(orImages.get(random.nextInt(orImages.size() - 1)), out);
			List<ObjectInfoModel> all = Lists.newArrayList();
			IMAGE_INFO_MAP.values().forEach(all::addAll);
			buildXYInfo(all, out);
			allImages.add(out);
		}
		return allImages;
	}

	public static void buildXYInfo (List<ObjectInfoModel> all, ObjectInfoModel outModel) {
		Integer x = x();
		Integer y = y();
		for (ObjectInfoModel infoModel : all) {
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
		return 10 + (int)(Math.random() * (1200 - 10 + 1));
	}

	public static Integer y () {
		return 200 + (int)(Math.random() * (650 - 200 + 1));
	}

	/**
	 * 随机刷新金子or石头
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void paint (String key, Integer count, Graphics g, ImageObserver imageObserver) {
		List<ObjectInfoModel> allImages = getObjectInfoModel(key);
		if (CollectionUtils.isEmpty(allImages)) {
			allImages = buildAllGoldOrStone(GoldMinerPicUtil.getByKey(key), count);
		}
		IMAGE_INFO_MAP.put(key, allImages);
		doPaint(g, imageObserver, allImages);
	}

	public static void doPaint (Graphics g, ImageObserver imageObserver, List<ObjectInfoModel> allImages) {
		allImages.forEach(ObjectInfoModel -> {
			g.drawImage(ObjectInfoModel.getImage(), ObjectInfoModel.getX(), ObjectInfoModel.getY(),
				ObjectInfoModel.getWidth(), ObjectInfoModel.getHeight(), imageObserver);
		});
	}
}
