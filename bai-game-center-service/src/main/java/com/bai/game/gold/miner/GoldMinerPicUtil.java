package com.bai.game.gold.miner;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bai.game.gold.miner.constant.GoldMinerConstant;
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
	public static Map<String, Image> BG_IMAGE_MAP = new HashMap<>();

	/**
	 * 金子集合
	 */
	public static Map<String, Image> GOLD_IMAGE_MAP = new HashMap<>();

	/**
	 * 石头集合
	 */
	public static Map<String, Image> STONE_IMAGE_MAP = new HashMap<>();

	/**
	 * 矿工集合
	 */
	public static Map<String, Image> MINER_IMAGE_MAP = new HashMap<>();

	/**
	 * 图片宽度集合
	 */
	public static Map<String, List<Integer>> IMAGE_INFO_MAP = new HashMap<>();

	static {
		//背景 - 天空
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_SKY,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.BG_SKY));
		//背景 - 土地
		BG_IMAGE_MAP.put(GoldMinerConstant.BG_LAND,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.BG_LAND));
		//小块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALLEST_GOLD,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.SMALLEST_GOLD));
		GOLD_IMAGE_MAP.put(GoldMinerConstant.SMALL_GOLD,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.SMALL_GOLD));
		//中块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_GOLD,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.MIDDLE_GOLD));
		//大块 金子
		GOLD_IMAGE_MAP.put(GoldMinerConstant.BIG_GOLD,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.BIG_GOLD));

		//小块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.SMALL_STONE,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.SMALL_STONE));
		//中块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.MIDDLE_STONE,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.MIDDLE_STONE));
		//大块 石头
		STONE_IMAGE_MAP.put(GoldMinerConstant.BIG_STONE,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.BIG_STONE));

		//矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.MINER,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.MINER));
		//失败的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.FAIL_MINER,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.FAIL_MINER));
		//疯狂的矿工
		MINER_IMAGE_MAP.put(GoldMinerConstant.CRAZY_MINER,
			Toolkit.getDefaultToolkit().getImage(PRE + GoldMinerConstant.CRAZY_MINER));

		//背景 - 天空
		IMAGE_INFO_MAP.put(GoldMinerConstant.BG_SKY, Lists.newArrayList(0, 10, 1200, 200));
		//背景 - 土地
		IMAGE_INFO_MAP.put(GoldMinerConstant.BG_LAND, Lists.newArrayList(0, 0, 1200, 800));
		//矿工
		IMAGE_INFO_MAP.put(GoldMinerConstant.MINER, Lists.newArrayList(530, 60, 140, 150));
		//小块 金子
		IMAGE_INFO_MAP.put(GoldMinerConstant.SMALLEST_GOLD, Lists.newArrayList(35, 35));
		IMAGE_INFO_MAP.put(GoldMinerConstant.SMALL_GOLD, Lists.newArrayList(71, 71));
		//中块 金子
		IMAGE_INFO_MAP.put(GoldMinerConstant.MIDDLE_GOLD, Lists.newArrayList(140, 140));
		//大块 金子
		IMAGE_INFO_MAP.put(GoldMinerConstant.BIG_GOLD, Lists.newArrayList(174, 174));

		//小块 石头
		IMAGE_INFO_MAP.put(GoldMinerConstant.SMALL_STONE, Lists.newArrayList(70, 70));
		//中块 石头
		IMAGE_INFO_MAP.put(GoldMinerConstant.MIDDLE_STONE, Lists.newArrayList(140, 140));
		//大块 石头
		IMAGE_INFO_MAP.put(GoldMinerConstant.BIG_STONE, Lists.newArrayList(174, 174));

	}

	public static List<Integer> getImageInfoByKey (String key) {
		return IMAGE_INFO_MAP.get(key);
	}

	public static Map<String, Image> getAllBgImage () {
		return BG_IMAGE_MAP;
	}

	public static List<String> getAllGoldKey () {
		return Lists.newArrayList(GOLD_IMAGE_MAP.keySet());
	}

	public static Image getGoldByKey (String key) {
		return GOLD_IMAGE_MAP.get(key);
	}

	public static List<String> getAllStoneKey () {
		return Lists.newArrayList(STONE_IMAGE_MAP.keySet());
	}

	public static Image getStoneImageByKey (String key) {
		return STONE_IMAGE_MAP.get(key);
	}

	public static Image getMinerImageByKey (String key) {
		return MINER_IMAGE_MAP.get(key);
	}
}
