package com.bai.game.gold.miner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bai.game.gold.miner.constant.GoldMinerConstant;
import com.bai.game.gold.miner.model.ObjectInfoModel;
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
	public static Map<String, ObjectInfoModel> BG_IMAGE_MAP = new HashMap<>();

	/**
	 * 商店物品集合
	 */
	public static Map<String, ObjectInfoModel> SHO_DATA_MAP = new HashMap<>();

	/**
	 * 金子集合
	 */
	public static Map<String, ObjectInfoModel> GOLD_IMAGE_MAP = new HashMap<>();

	/**
	 * 石头集合
	 */
	public static Map<String, ObjectInfoModel> STONE_IMAGE_MAP = new HashMap<>();

	/**
	 * 矿工集合
	 */
	public static Map<String, ObjectInfoModel> MINER_IMAGE_MAP = new HashMap<>();

	static {
		//背景 - 天空
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_SKY,
			ObjectInfoModel.build(GoldMinerConstant.BG_SKY, PRE + GoldMinerConstant.BG_SKY, 1200, 200, 0, 10));

		//背景 - 土地
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_LAND,
			ObjectInfoModel.build(GoldMinerConstant.BG_LAND, PRE + GoldMinerConstant.BG_LAND, 1200, 800, 0, 0));

		//小块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALLEST_GOLD,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.SMALLEST_GOLD, PRE + GoldMinerConstant.BG_LAND, 35, 35, 2,
				1));

		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALL_GOLD,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.SMALL_GOLD, PRE + GoldMinerConstant.SMALL_GOLD, 71, 71, 3,
				2));

		//中块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_GOLD,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.MIDDLE_GOLD, PRE + GoldMinerConstant.MIDDLE_GOLD, 80, 80,
				4, 3));

		//大块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.BIG_GOLD,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.BIG_GOLD, PRE + GoldMinerConstant.BIG_GOLD, 114, 114, 5,
				4));

		//小块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.SMALL_STONE,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.SMALL_STONE, PRE + GoldMinerConstant.SMALL_STONE, 70, 70,
				0, -1));

		//中块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_STONE,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.MIDDLE_STONE, PRE + GoldMinerConstant.MIDDLE_STONE, 80,
				80, 0, -1));

		//大块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.BIG_STONE,
			ObjectInfoModel.buildObjectInfo(GoldMinerConstant.BIG_STONE, PRE + GoldMinerConstant.BIG_STONE, 114, 114, 0,
				-1));

		//矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.MINER,
			ObjectInfoModel.build(GoldMinerConstant.MINER, PRE + GoldMinerConstant.MINER, 140, 150, 530, 60));

		//失败的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.FAIL_MINER,
			ObjectInfoModel.build(GoldMinerConstant.FAIL_MINER, PRE + GoldMinerConstant.FAIL_MINER, 140, 150, 530, 60));

		//疯狂的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.CRAZY_MINER,
			ObjectInfoModel.build(GoldMinerConstant.CRAZY_MINER, PRE + GoldMinerConstant.CRAZY_MINER, 140, 150, 530,
				60));

		//钩子
		MINER_IMAGE_MAP.put(GoldMinerConstant.GRANPEL,
			ObjectInfoModel.build(GoldMinerConstant.GRANPEL, PRE + GoldMinerConstant.GRANPEL, 71, 49, 530, 60));

		//药水
		SHO_DATA_MAP.put(GoldMinerConstant.POTION,
			ObjectInfoModel.build(GoldMinerConstant.POTION, PRE + GoldMinerConstant.POTION, 65, 78, 260, 80));

	}

	public static Map<String, ObjectInfoModel> getAllBgImage () {
		return BG_IMAGE_MAP;
	}

	public static List<ObjectInfoModel> getAllGold () {
		return Lists.newArrayList(GOLD_IMAGE_MAP.values());
	}

	public static ObjectInfoModel getGoldByKey (String key) {
		return GOLD_IMAGE_MAP.get(key);
	}

	public static List<ObjectInfoModel> getAllStone () {
		return Lists.newArrayList(STONE_IMAGE_MAP.values());
	}

	public static ObjectInfoModel getStoneImageByKey (String key) {
		return STONE_IMAGE_MAP.get(key);
	}

	public static ObjectInfoModel getShopDataByKey (String key) {
		return SHO_DATA_MAP.get(key);
	}

	public static ObjectInfoModel getMinerImageByKey (String key) {
		return MINER_IMAGE_MAP.get(key);
	}

	public static List<ObjectInfoModel> getByKey (String key) {
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
