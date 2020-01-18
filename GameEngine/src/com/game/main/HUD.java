package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float HEALTH = 100;
	public static float HEALTHPL2 = 100;
	
	private float greenVal = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick () {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenVal = Game.clamp(greenVal, 0, 255);
		
		greenVal = HEALTH * 2;
		
		score ++;
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color (75, (int)greenVal, 0));
		g.fillRect(15, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	
		g.drawString("Score: " + score, 10, 64);
		g.drawString("Level: " + level, 10, 80);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore () {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	public void setlevel (int level) {
		this.level = level;
	}
}
