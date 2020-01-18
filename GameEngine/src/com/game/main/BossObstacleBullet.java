package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class BossObstacleBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public BossObstacleBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velY = 5;
		velX = (r.nextInt(5 - -5) + -5);
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x, (int)y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		/*if (y <= 0 || y> Game.HEIGHT - 32)
			velY *= -1;
		if (x <= 0 || x > Game.WIDTH - 16)
			velX *= -1;
		*/
		
		if (y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject (new Trail (x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
