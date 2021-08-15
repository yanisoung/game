package com.bai.game.gold.miner.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import lombok.Data;

/**
 * 物体信息
 *
 * @author Bai
 * @date 2021/8/14 16:46
 */
@Data
public class ObjectInfoModel {

	/**
	 * 图片唯一标识
	 */
	private String key;

	/**
	 * x坐标
	 */
	private Integer x;

	/**
	 * y坐标
	 */
	private Integer y;

	/**
	 * 图片宽度
	 */
	private Integer width;

	/**
	 * 图片高度
	 */
	private Integer height;

	/**
	 * 图片
	 */
	private Image image;

	/**
	 * 金币
	 */
	private Integer goldCoin;

	/**
	 * 积分
	 */
	private Integer integral;

	/**
	 * 是否移动
	 */
	private Boolean move;

	public static ObjectInfoModel build (String key, String imagePath, Integer width, Integer height, Integer x,
		Integer y) {
		ObjectInfoModel imageInfoModel = new ObjectInfoModel();
		imageInfoModel.setKey(key);
		imageInfoModel.setX(x);
		imageInfoModel.setY(y);
		imageInfoModel.setWidth(width);
		imageInfoModel.setHeight(height);
		imageInfoModel.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		imageInfoModel.setMove(false);
		return imageInfoModel;
	}

	public static ObjectInfoModel buildObjectInfo (String key, String imagePath, Integer width, Integer height,
		Integer goldCoin, Integer integral) {
		ObjectInfoModel imageInfoModel = new ObjectInfoModel();
		imageInfoModel.setKey(key);
		imageInfoModel.setWidth(width);
		imageInfoModel.setHeight(height);
		imageInfoModel.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		imageInfoModel.setMove(false);
		imageInfoModel.setGoldCoin(goldCoin);
		imageInfoModel.setIntegral(integral);
		return imageInfoModel;
	}

	/**
	 * 获取当前所有坐标可构建成的矩形
	 *
	 * @return
	 */
	public Rectangle getRec () {
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getRec (Integer x, Integer y) {
		return new Rectangle(x, y, width, height);
	}

}
