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
		//绘制新的画布 将所有图片绘制到新画布上
		Image image = this.createImage(1200, 800);
		Graphics graphics = image.getGraphics();
		//绘制背景图
		BgsDraw.paint(graphics, this);
		//绘制矿工
		GoldMinerDraw.paint(graphics, this);
		//绘制黑石头
		StoneDraw.paint(graphics, this);
		//绘制金子
		GoldDraw.paint(graphics, this);
		g.drawImage(image, 0, 0, this);
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
