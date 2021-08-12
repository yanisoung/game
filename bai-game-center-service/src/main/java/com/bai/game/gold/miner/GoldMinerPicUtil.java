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
	 * 图片集合
	 */
	public static Map<String, Image> IMAGE_MAP = new HashMap<>();
	/**
	 * 图片宽度集合
	 */
	public static Map<String, List<Integer>> IMAGE_INFO_MAP = new HashMap<>();

	static {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		//背景 - 天空
		IMAGE_MAP.put(GoldMinerConstant.BG_SKY, defaultToolkit.getImage(PRE + GoldMinerConstant.BG_SKY));
		//背景 - 土地
		IMAGE_MAP.put(GoldMinerConstant.BG_LAND, defaultToolkit.getImage(PRE + GoldMinerConstant.BG_LAND));
		//小块 金子
		IMAGE_MAP.put(GoldMinerConstant.SMALLEST_GOLD, defaultToolkit.getImage(PRE + GoldMinerConstant.SMALLEST_GOLD));
		IMAGE_MAP.put(GoldMinerConstant.SMALL_GOLD, defaultToolkit.getImage(PRE + GoldMinerConstant.SMALL_GOLD));
		//中块 金子
		IMAGE_MAP.put(GoldMinerConstant.MIDDLE_GOLD, defaultToolkit.getImage(PRE + GoldMinerConstant.MIDDLE_GOLD));
		//大块 金子
		IMAGE_MAP.put(GoldMinerConstant.BIG_GOLD, defaultToolkit.getImage(PRE + GoldMinerConstant.BIG_GOLD));

		//小块 石头
		IMAGE_MAP.put(GoldMinerConstant.SMALL_STONE, defaultToolkit.getImage(PRE + GoldMinerConstant.SMALL_STONE));
		//中块 石头
		IMAGE_MAP.put(GoldMinerConstant.MIDDLE_STONE, defaultToolkit.getImage(PRE + GoldMinerConstant.MIDDLE_STONE));
		//大块 石头
		IMAGE_MAP.put(GoldMinerConstant.BIG_STONE, defaultToolkit.getImage(PRE + GoldMinerConstant.BIG_STONE));

		//矿工
		IMAGE_MAP.put(GoldMinerConstant.MINER, defaultToolkit.getImage(PRE + GoldMinerConstant.MINER));
		//失败的矿工
		IMAGE_MAP.put(GoldMinerConstant.FAIL_MINER, defaultToolkit.getImage(PRE + GoldMinerConstant.FAIL_MINER));
		//疯狂的矿工
		IMAGE_MAP.put(GoldMinerConstant.CRAZY_MINER, defaultToolkit.getImage(PRE + GoldMinerConstant.CRAZY_MINER));

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

	public static Image get (String key) {
		return IMAGE_MAP.get(key);
	}

	public static List<Image> getAllGold () {
		return Lists.newArrayList(IMAGE_MAP.get(GoldMinerConstant.SMALLEST_GOLD),
			IMAGE_MAP.get(GoldMinerConstant.SMALL_GOLD), IMAGE_MAP.get(GoldMinerConstant.MIDDLE_GOLD),
			IMAGE_MAP.get(GoldMinerConstant.BIG_GOLD));
	}

	public static List<Image> getAllStone () {
		return Lists.newArrayList(IMAGE_MAP.get(GoldMinerConstant.SMALL_STONE),
			IMAGE_MAP.get(GoldMinerConstant.MIDDLE_STONE), IMAGE_MAP.get(GoldMinerConstant.BIG_STONE));
	}
}
