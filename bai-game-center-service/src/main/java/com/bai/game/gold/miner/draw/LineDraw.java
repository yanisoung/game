package com.bai.game.gold.miner.draw;

import java.awt.*;

/**
 * 绘制线
 *
 * @author Bai
 * @date 2021/8/14 22:10
 */
public class LineDraw {
	/**
	 * 启动坐标
	 */
	private static int x = 600;
	private static int y = 170;

	/**
	 * 终点坐标
	 */
	private static int endX = 1200;
	private static int endY = 800;
	/**
	 * 线长
	 */
	private static Double length = 100.0;

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
	 */
	public static Integer status = 0;

	/**
	 * 绘制摇摆的线
	 *
	 * @param g
	 */
	public static void paint (Graphics g) {
		switch (status) {
		case 0:
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
			if (length > 100) {
				length -= 10;
				drawLine(g);
			} else {
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
}
