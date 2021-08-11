package com.bai.game.util;

/**
 * 文件加载工具类
 *
 * @author Bai
 * @date 2021/8/10 22:02
 */
public class FileLoadUtil {

	public static String loadFileUrl (String fileName) {
		return ClassLoader.getSystemResource(fileName).getPath();
	}

	public static void main (String[] args) {
		String s = FileLoadUtil.loadFileUrl("bai-game-center-service/src/main/resources/goldminer/bgSky.jpg");
		System.out.println(s);
	}
}
