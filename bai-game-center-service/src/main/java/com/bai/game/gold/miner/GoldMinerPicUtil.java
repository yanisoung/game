package com.bai.game.gold.miner;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bai
 * @date 2021/8/11 20:47
 */
public class GoldMinerPicUtil {

	private static final String PRE = "bai-game-center-service/src/main/resources/goldminer/";

	public static Map<String, Image> IMAGE_MAP = new HashMap<>();

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
	}

	public static Image get (String key) {
		return IMAGE_MAP.get(key);
	}
}
