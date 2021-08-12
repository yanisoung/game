package com.bai.game.gold.miner;

import java.awt.*;

import javax.swing.*;

import com.bai.game.gold.miner.draw.GoldDraw;
import com.bai.game.gold.miner.draw.GoldMinerDraw;
import com.bai.game.gold.miner.draw.StoneDraw;
import com.bai.game.gold.miner.draw.WindowsDraw;

/**
 * 黄金矿工 - 处理类
 *
 * @author Bai
 * @date 2021/8/10 21:51
 */
public class GoldMinerCenter extends JFrame {

	@Override
	public void paint (Graphics g) {
		super.paintComponents(g);
		//绘制背景图
		WindowsDraw.paint(g);
		//绘制矿工
		GoldMinerDraw.paint(g);
		//绘制金子
		GoldDraw.paint(g);
		//绘制黑石头
		StoneDraw.paint(g);
	}

	public static void start () {
		GoldMinerCenter goldMinerCenter = new GoldMinerCenter();
		//初始化窗口
		WindowsDraw.drawWindows(goldMinerCenter);
	}

	public static void main (String[] args) {
		start();
	}
}
