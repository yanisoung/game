package com.bai.game.gold.miner;

import java.awt.*;

import javax.swing.*;

import com.bai.game.gold.miner.draw.BgsDraw;
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
		BgsDraw.paint(g, this);
		//绘制矿工
		GoldMinerDraw.paint(g, this);
		//绘制黑石头
		StoneDraw.paint(g, this);
		//绘制金子
		GoldDraw.paint(g, this);
	}

	public void start () {
		//绘制窗口
		WindowsDraw.paint(this);
	}

	public static void main (String[] args) {
		GoldMinerCenter goldMinerCenter = new GoldMinerCenter();
		goldMinerCenter.start();
	}
}
