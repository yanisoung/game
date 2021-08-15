package com.bai.game.gold.miner.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.List;

import com.bai.game.gold.miner.model.ImageInfoModel;
import org.apache.commons.collections.CollectionUtils;

/**
 * 绘制线
 *
 * @author Bai
 * @date 2021/8/14 22:10
 */
public class LineDraw extends BaseDraw {
	/**
	 * 启动坐标
	 */
	private static Integer x = 600;
	private static Integer y = 170;

	/**
	 * 终点坐标
	 */
	private static Integer endX = 1200;
	private static Integer endY = 800;

	/**
	 * 线长
	 */
	private static Double startLength = 100.0;

	/**
	 * 线长
	 */
	private static Double length = startLength;

	private static Double n = 0.0;

	/**
	 * 线段摇摆的方向
	 */
	private static Integer dir = 1;

	/**
	 * 线段状态：
	 * 0 初始化
	 * 1 伸长
	 * 2 收回
	 * 3 抓取
	 */
	public static Integer status = 0;

	/**
	 * 绘制摇摆的线
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		//判断当前的线与金子的交集
		goldCheck();
		//筛选不同状态执行不同动作
		switchStatus(g);
	}

	private static void switchStatus (Graphics g) {
		switch (status) {
		case 0:
			//改变当前摇摆方向
			if (n < 0.1) {
				dir = 1;
			} else if (n > 0.9) {
				dir = -1;
			}
			n = n + 0.005 * dir;
			drawLine(g);
			break;
		case 1:
			//一直绘制线段直到终点后返回
			if (length < 630) {
				length += 10;
				drawLine(g);
			} else {
				status = 2;
			}
			break;
		case 2:
			//一直回收，直到初始化的线长度
			if (length > startLength) {
				length -= 10;
				drawLine(g);
			} else {
				status = 0;
			}
			break;
		case 3:
			if (length > startLength) {
				length -= 10;
				drawLine(g);
				//移动金子
				moveGold(endX - 40, endY);
			} else {
				//移除金子
				delGold();
				status = 0;
			}
			break;
		default:
			break;
		}
	}

	private static void drawLine (Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		endX = (int)(x + length * Math.cos(n * Math.PI));
		endY = (int)(y + length * Math.sin(n * Math.PI));
		//设置为黑色
		g.setColor(Color.BLACK);
		//设置线宽为5.0
		Stroke stroke = new BasicStroke(5.0f);
		g2.setStroke(stroke);
		g2.drawLine(x, y, endX, endY);
	}

	private static void goldCheck () {
		List<ImageInfoModel> allGold = GoldDraw.getAllGold();
		if (CollectionUtils.isEmpty(allGold)) {
			return;
		}
		for (ImageInfoModel imageInfoModel : allGold) {
			if (null == imageInfoModel.getX() || null == imageInfoModel.getY()) {
				continue;
			}
			if (endX > imageInfoModel.getX() && endX < imageInfoModel.getX() + imageInfoModel.getWidth()
				&& endY > imageInfoModel.getY() && endY < imageInfoModel.getY() + imageInfoModel.getHeight()) {
				//设置当前符合条件的
				imageInfoModel.setMove(true);
				status = 3;
			}
		}
	}

	private static void delGold () {
		List<ImageInfoModel> allGold = GoldDraw.getAllGold();
		if (CollectionUtils.isEmpty(allGold)) {
			return;
		}
		allGold.removeIf(gold -> null != gold.getMove() && gold.getMove());
	}

	private static void moveGold (Integer goldX, Integer goldY) {
		List<ImageInfoModel> allGold = GoldDraw.getAllGold();
		if (CollectionUtils.isEmpty(allGold)) {
			return;
		}
		allGold.forEach(gold -> {
			if (null != gold.getMove() && gold.getMove()) {
				gold.setX(goldX);
				gold.setY(goldY);
			}
		});
	}
}
