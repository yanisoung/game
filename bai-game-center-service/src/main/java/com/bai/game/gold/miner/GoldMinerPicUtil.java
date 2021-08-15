package com.bai.game.gold.miner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.model.ImageInfoModel;
import com.google.common.collect.Lists;

/**
 * @author Bai
 * @date 2021/8/11 20:47
 */
public class GoldMinerPicUtil {

	private static final String PRE = "bai-game-center-service/src/main/resources/goldminer/";

	/**
	 * 背景集合
	 */
	public static Map<String, ImageInfoModel> BG_IMAGE_MAP = new HashMap<>();

	/**
	 * 金子集合
	 */
	public static Map<String, ImageInfoModel> GOLD_IMAGE_MAP = new HashMap<>();

	/**
	 * 石头集合
	 */
	public static Map<String, ImageInfoModel> STONE_IMAGE_MAP = new HashMap<>();

	/**
	 * 矿工集合
	 */
	public static Map<String, ImageInfoModel> MINER_IMAGE_MAP = new HashMap<>();

	static {
		//背景 - 天空
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_SKY,
			ImageInfoModel.build(GoldMinerConstant.BG_SKY, PRE + GoldMinerConstant.BG_SKY, 1200, 200, 0, 10));

		//背景 - 土地
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_LAND,
			ImageInfoModel.build(GoldMinerConstant.BG_LAND, PRE + GoldMinerConstant.BG_LAND, 1200, 800, 0, 0));

		//小块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALLEST_GOLD,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.SMALLEST_GOLD, PRE + GoldMinerConstant.BG_LAND, 35, 35));

		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALL_GOLD,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.SMALL_GOLD, PRE + GoldMinerConstant.SMALL_GOLD, 71, 71));

		//中块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_GOLD,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.MIDDLE_GOLD, PRE + GoldMinerConstant.MIDDLE_GOLD, 80, 80));

		//大块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.BIG_GOLD,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.BIG_GOLD, PRE + GoldMinerConstant.BIG_GOLD, 114, 114));

		//小块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.SMALL_STONE,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.SMALL_STONE, PRE + GoldMinerConstant.SMALL_STONE, 70, 70));

		//中块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_STONE,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.MIDDLE_STONE, PRE + GoldMinerConstant.MIDDLE_STONE, 80,
				80));

		//大块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.BIG_STONE,
			ImageInfoModel.buildImageInfo(GoldMinerConstant.BIG_STONE, PRE + GoldMinerConstant.BIG_STONE, 114, 114));

		//矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.MINER,
			ImageInfoModel.build(GoldMinerConstant.MINER, PRE + GoldMinerConstant.MINER, 140, 150, 530, 60));

		//失败的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.FAIL_MINER,
			ImageInfoModel.build(GoldMinerConstant.FAIL_MINER, PRE + GoldMinerConstant.FAIL_MINER, 140, 150, 530, 60));

		//疯狂的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.CRAZY_MINER,
			ImageInfoModel.build(GoldMinerConstant.CRAZY_MINER, PRE + GoldMinerConstant.CRAZY_MINER, 140, 150, 530,
				60));

		//钩子
		MINER_IMAGE_MAP.put(GoldMinerConstant.GRANPEL,
			ImageInfoModel.build(GoldMinerConstant.GRANPEL, PRE + GoldMinerConstant.GRANPEL, 140, 150, 530, 60));

	}

	public static Map<String, ImageInfoModel> getAllBgImage () {
		return BG_IMAGE_MAP;
	}

	public static List<ImageInfoModel> getAllGold () {
		return Lists.newArrayList(GOLD_IMAGE_MAP.values());
	}

	public static ImageInfoModel getGoldByKey (String key) {
		return GOLD_IMAGE_MAP.get(key);
	}

	public static List<ImageInfoModel> getAllStone () {
		return Lists.newArrayList(STONE_IMAGE_MAP.values());
	}

	public static ImageInfoModel getStoneImageByKey (String key) {
		return STONE_IMAGE_MAP.get(key);
	}

	public static ImageInfoModel getMinerImageByKey (String key) {
		return MINER_IMAGE_MAP.get(key);
	}

	public static List<ImageInfoModel> getByKey (String key) {
		switch (key) {
		case "StoneDraw":
			return Lists.newArrayList(STONE_IMAGE_MAP.values());
		case "GoldDraw":
			return Lists.newArrayList(GOLD_IMAGE_MAP.values());
		default:
			return null;
		}
	}
}
