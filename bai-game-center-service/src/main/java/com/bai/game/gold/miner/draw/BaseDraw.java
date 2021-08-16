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
import com.bai.game.gold.miner.constant.DataInfoConstant;
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
	public volatile static Map<String, List<ObjectInfoModel>> IMAGE_INFO_MAP = new HashMap<>();

	/**
	 * 数据集合
	 */
	public volatile static Map<String, Integer> DATA_INFO_MAP = new HashMap<>();

	/**
	 * 店铺集合
	 */
	public volatile static Map<String, Integer> SHOP_INFO_MAP = new HashMap<>();

	static {
		init();
	}

	public static void init () {
		//初始化当前级别
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL, 1);
		//初始化倒计时
		DATA_INFO_MAP.put(DataInfoConstant.TIME, 120);
		//初始化过关的积分
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_INTEGRAL, 10);
		//初始化 刷新金子的个数
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_GOLD_CNT, 10);
		//初始化 刷新石头的个数
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_STONE_CNT, 5);
		//初始化积分
		DATA_INFO_MAP.put(DataInfoConstant.INTEGRAL, 0);
		//初始化金币
		DATA_INFO_MAP.put(DataInfoConstant.GOLD_COIN, 0);

		//初始化药水
		SHOP_INFO_MAP.put(DataInfoConstant.POTION, 3);
	}

	/**
	 * 重置级别
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void reLevelInfo (Graphics g, ImageObserver imageObserver) {
		//初始化当前级别
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL, getLevel() + 1);
		//初始化倒计时
		DATA_INFO_MAP.put(DataInfoConstant.TIME, 120);
		//初始化过关的积分
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_INTEGRAL, getLevelIntegral() + 2);
		//初始化 刷新金子的个数
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_GOLD_CNT, getGoldCoin() + 1);
		//初始化 刷新石头的个数
		DATA_INFO_MAP.put(DataInfoConstant.LEVEL_STONE_CNT, getStoneCount() + 1);
		//初始化积分
		DATA_INFO_MAP.put(DataInfoConstant.INTEGRAL, 0);
		//重置 金子 & 石头
		rePaint(DataInfoConstant.GOLD_DRAW, getGoldCount(), g, imageObserver);
		rePaint(DataInfoConstant.STONE_DRAW, getStoneCount(), g, imageObserver);
	}

	public static Integer getLevelIntegral () {
		return DATA_INFO_MAP.get(DataInfoConstant.LEVEL_INTEGRAL);
	}

	public static Integer getIntegral () {
		return DATA_INFO_MAP.get(DataInfoConstant.INTEGRAL);
	}

	public static Integer getLevel () {
		return DATA_INFO_MAP.get(DataInfoConstant.LEVEL);
	}

	public static Integer getGoldCoin () {
		return DATA_INFO_MAP.get(DataInfoConstant.GOLD_COIN);
	}

	public static Integer getPotion () {
		return SHOP_INFO_MAP.get(DataInfoConstant.POTION);
	}

	public static synchronized void changeItem (Integer addTime) {
		if (null == addTime) {
			return;
		}
		if (getTime() < 1 && addTime < 1) {
			return;
		}
		DATA_INFO_MAP.put(DataInfoConstant.TIME, getTime() + addTime);
	}

	public static synchronized void changeItem (Integer addTime, Integer time) {
		if (null == addTime) {
			return;
		}
		if (getTime() < 1 && addTime < 1) {
			return;
		}
		if (null != time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				//
			}
		}
		DATA_INFO_MAP.put(DataInfoConstant.TIME, getTime() + addTime);
	}

	public static void changePotion (Integer addCount) {
		if (null == addCount) {
			return;
		}
		Integer potion = getPotion();
		if (Objects.equals(potion, 0) && addCount < 0) {
			return;
		}
		SHOP_INFO_MAP.put(DataInfoConstant.POTION, potion + addCount);
	}

	public static void changeIntegral (Integer addIntegral) {
		if (null == addIntegral) {
			return;
		}
		Integer integral = DATA_INFO_MAP.get(DataInfoConstant.INTEGRAL);
		if (Objects.equals(integral, 0) && addIntegral < 0) {
			return;
		}
		DATA_INFO_MAP.put(DataInfoConstant.INTEGRAL, integral + addIntegral);
	}

	public static void changeGoldCoin (Integer addGoldCoin) {
		if (null == addGoldCoin) {
			return;
		}
		DATA_INFO_MAP.put(DataInfoConstant.GOLD_COIN, DATA_INFO_MAP.get(DataInfoConstant.GOLD_COIN) + addGoldCoin);
	}

	public static Integer getTime () {
		return DATA_INFO_MAP.get(DataInfoConstant.TIME);
	}

	public static Integer getStoneCount () {
		return DATA_INFO_MAP.get(DataInfoConstant.LEVEL_STONE_CNT);
	}

	public static Integer getGoldCount () {
		return DATA_INFO_MAP.get(DataInfoConstant.LEVEL_GOLD_CNT);
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

	/**
	 * 随机刷新金子or石头
	 *
	 * @param g
	 * @param imageObserver
	 */
	public static void rePaint (String key, Integer count, Graphics g, ImageObserver imageObserver) {
		//重置为空
		IMAGE_INFO_MAP.put(key, Lists.newArrayList());
		List<ObjectInfoModel> allImages = buildAllGoldOrStone(GoldMinerPicUtil.getByKey(key), count);
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
