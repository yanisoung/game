package com.bai.game.gold.miner;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import com.bai.game.gold.miner.draw.BgDraw;
import com.bai.game.gold.miner.draw.GoldDraw;
import com.bai.game.gold.miner.draw.GrapnelDraw;
import com.bai.game.gold.miner.draw.LineDraw;
import com.bai.game.gold.miner.draw.MinerDraw;
import com.bai.game.gold.miner.draw.StoneDraw;
import com.bai.game.gold.miner.draw.WindowsDraw;
import com.bai.game.gold.miner.listener.KeyListener;
import com.bai.game.gold.miner.listener.MouseListener;

/**
 * 黄金矿工 - 处理类
 *
 * @author Bai
 * @date 2021/8/10 21:51
 */
public class GoldMinerCenter extends JFrame {

	/**
	 * 新画布
	 */
	private Image offScreenImage;

	@Override
	public void paint (Graphics g) {
		//绘制新的画布 将所有图片绘制到新画布上
		offScreenImage = this.createImage(1200, 800);
		Graphics graphics = offScreenImage.getGraphics();
		//绘制背景图
		BgDraw.paint(graphics, null);
		//绘制矿工
		MinerDraw.paint(graphics, null);
		//绘制线
		LineDraw.paint(graphics);
		//绘制钩子
		GrapnelDraw.paint(graphics);
		//绘制黑石头
		StoneDraw.paint(graphics, null);
		//绘制金子
		GoldDraw.paint(graphics, this);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void start () {
		//绘制窗口
		WindowsDraw.paint(this);
		//鼠标事件监听
		MouseListener.listener(this);
		//键盘事件
		KeyListener.listener(this);
	}

	public static void main (String[] args) {
		GoldMinerCenter goldMinerCenter = new GoldMinerCenter();
		goldMinerCenter.start();
	}

}
