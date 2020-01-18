package com.game.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();

	private int scoreKeep = 0;

	public Spawn (Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}

	public void tick() {
		scoreKeep++;

		if (scoreKeep >= 200) {
			scoreKeep = 0;
			hud.setlevel(hud.getLevel()+ 1);
			if (game.diff == 0) {
				if (hud.getLevel() == 2) {
					handler.addObject(new BasicObstacle (r.nextInt(Game.WIDTH- 50), r.nextInt(Game.HEIGHT - 50), ID.BasicObstacle, handler));
				} else if (hud.getLevel() == 3) {
					handler.addObject(new BasicObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicObstacle, handler));
				} else if (hud.getLevel() == 4) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 5) {
					handler.addObject(new SmartObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartObstacle, handler));
				} else if (hud.getLevel() == 6) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 7) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 10) {
					handler.clearObstacles();
					handler.addObject(new BossObstacle ((Game.WIDTH)/2-48, -120, ID.BossObstacle, handler));
				} 
			} else if (game.diff == 1) {
				if (hud.getLevel() == 2) {
					handler.addObject(new HardObstacle (r.nextInt(Game.WIDTH- 50), r.nextInt(Game.HEIGHT - 50), ID.BasicObstacle, handler));
				} else if (hud.getLevel() == 3) {
					handler.addObject(new HardObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicObstacle, handler));
				} else if (hud.getLevel() == 4) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 5) {
					handler.addObject(new SmartObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartObstacle, handler));
				} else if (hud.getLevel() == 6) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 7) {
					handler.addObject(new FastObstacle (r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastObstacle, handler));
				} else if (hud.getLevel() == 10) {
					handler.clearObstacles();
					handler.addObject(new BossObstacle ((Game.WIDTH)/2-48, -120, ID.BossObstacle, handler));
				}
			}



		}
	}

}
