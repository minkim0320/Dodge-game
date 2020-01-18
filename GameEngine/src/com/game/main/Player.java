package com.game.main;
import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	
	public Player (int x, int y, ID id, Handler handler) {
		super (x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,32,32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 44);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		handler.addObject(new Trail (x,y, ID.Trail, Color.white, 32,32,0.04f, handler));
		
		collision();
		
	}
	
	private void collision () {
		for (int i = 0; i < handler.object.size(); i ++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID() == ID.BasicObstacle || tempObject.getID() == ID.FastObstacle || tempObject.getID() == ID.SmartObstacle) { // temp object is basic obstacle
				if (getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 2;
				}
			}
			
		}
	}
	
	public void render (Graphics g) {
		if (id == ID.Player)
			g.setColor(Color.white);
		else {
			g.setColor(Color.red);
		}
		
		g.fillRect ((int)x,(int)y,32,32);
	}
	
	
	
}
