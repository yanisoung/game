package com.bai.game.gold.miner.model;

import java.awt.*;

import lombok.Data;

/**
 * 图片信息
 *
 * @author Bai
 * @date 2021/8/14 16:46
 */
@Data
public class ImageInfoModel {

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

	public static ImageInfoModel build (String key, String imagePath, Integer width, Integer height, Integer x,
		Integer y) {
		ImageInfoModel imageInfoModel = new ImageInfoModel();
		imageInfoModel.setKey(key);
		imageInfoModel.setX(x);
		imageInfoModel.setY(y);
		imageInfoModel.setWidth(width);
		imageInfoModel.setHeight(height);
		imageInfoModel.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		return imageInfoModel;
	}

	public static ImageInfoModel buildXyInfo (String key, String imagePath, Integer x, Integer y) {
		ImageInfoModel imageInfoModel = new ImageInfoModel();
		imageInfoModel.setKey(key);
		imageInfoModel.setX(x);
		imageInfoModel.setY(y);
		imageInfoModel.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		return imageInfoModel;
	}

	public static ImageInfoModel buildImageInfo (String key, String imagePath, Integer width, Integer height) {
		ImageInfoModel imageInfoModel = new ImageInfoModel();
		imageInfoModel.setKey(key);
		imageInfoModel.setWidth(width);
		imageInfoModel.setHeight(height);
		imageInfoModel.setImage(Toolkit.getDefaultToolkit().getImage(imagePath));
		return imageInfoModel;
	}

}
