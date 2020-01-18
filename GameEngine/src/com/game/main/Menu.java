package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Game.STATE;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;

	public Menu (Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	public void mousePressed (MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (game.gameState == STATE.Menu) {
			//play button
			if (mouseOver (mx, my, 250, 100, 300, 64)) {
				game.gameState = STATE.Select;
				return;
				
			}


			//help button
			if (mouseOver (mx,my,250,200,300,64)) {
				game.gameState = STATE.Help;
			}



			//quit button
			if (mouseOver (mx,my,250,300,300,64)) {
				System.exit(1);
			}
		}
		
		if (game.gameState == STATE.Select) {
			//normal button
			if (mouseOver (mx, my, 250, 100, 300, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player (Game.WIDTH/ 2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearObstacles();
				handler.addObject(new BasicObstacle (r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicObstacle, handler));

				game.diff = 0;
				
			}

			//hard button
			if (mouseOver (mx,my,250,200,300,64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player (Game.WIDTH/ 2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearObstacles();
				handler.addObject(new HardObstacle (r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicObstacle, handler));

				game.diff = 1;
			}

			//back button
			if (mouseOver (mx,my,250,300,300,64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}


		//back button for help
		if (game.gameState == STATE.Help) {
			if (mouseOver (mx,my,250,300,300,64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}

		//end button
		if (game.gameState == STATE.End) {
			if (mouseOver (mx,my,250,300,300,64)) {
				game.gameState = STATE.Menu;
				
				hud.setlevel(1);
				hud.setScore(0);
				
				
			}
		}

	}

	public void mouseReleased (MouseEvent e) {

	}

	private boolean mouseOver (int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {
			Font fnt = new Font ("arial", 1, 50);
			Font fnt2 = new Font ("arial", 1, 30);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("GAME", 325, 75);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(250, 100, 300, 64);
			g.drawString ("Play", 350, 140);

			g.drawRect(250, 200, 300, 64);
			g.drawString ("Help", 350, 240);

			g.drawRect(250, 300, 300, 64);
			g.drawString ("Quit", 350, 340);

		} else if (game.gameState == STATE.Help) {
			Font fnt = new Font ("arial", 1, 50);
			Font fnt2 = new Font ("arial", 1, 30);
			Font fnt3 = new Font ("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);

			g.drawString("Help", 350, 140);

			g.setFont(fnt3);
			g.drawString("Use WASD keys to move player \n and dodge obstacles", 50, 250);

			g.setFont(fnt2);
			g.drawRect(250, 300, 300, 64);
			g.drawString ("Back", 350, 340);

		} else if (game.gameState == STATE.End) {
			Font fnt = new Font ("arial", 1, 50);
			Font fnt2 = new Font ("arial", 1, 30);
			Font fnt3 = new Font ("arial", 1, 20);

			g.setFont(fnt);
			g.setColor(Color.white);

			g.drawString("Game Over", 270, 140);

			g.setFont(fnt3);
			g.drawString("Your score: " + hud.getScore(), 300, 250);

			g.setFont(fnt2);
			g.drawRect(250, 300, 300, 64);
			g.drawString ("Try Again", 320, 340);

		} else if (game.gameState == STATE.Select) {
			Font fnt = new Font ("arial", 1, 50);
			Font fnt2 = new Font ("arial", 1, 30);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select Difficulty", 200, 75);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(250, 100, 300, 64);
			g.drawString ("Normal", 350, 140);

			g.drawRect(250, 200, 300, 64);
			g.drawString ("Hard", 350, 240);

			g.drawRect(250, 300, 300, 64);
			g.drawString ("Back", 350, 340);

		}

	}
}
