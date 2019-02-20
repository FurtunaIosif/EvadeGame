package furtuna;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import furtuna.Game.STATE;
public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();

	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
	if(game.gameState == STATE.Menu) {
		if(mouseOver(mx, my, 210, 150, 200, 64)) {
			//game.gameState = STATE.Game;
			game.gameState = STATE.Select;
			return;
		}

	if(mouseOver(mx, my, 210, 250, 200, 64)) {
		game.gameState = STATE.Help;
	}
	
	if(mouseOver(mx, my, 210, 350, 200, 64)) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	if(mouseOver(mx, my, 210, 450, 200, 64)) {
		System.exit(1);
	}
	}
	
	
if(game.gameState == STATE.Select) {
	if(mouseOver(mx, my, 210, 150, 200, 64)) {
		game.gameState = STATE.Game;
		game.diff = 0;
		
	}

if(mouseOver(mx, my, 210, 250, 200, 64)) {
	game.gameState = STATE.Game;
	game.diff = 1;
}

	
if(mouseOver(mx, my, 210, 350, 200, 64)) {
	game.gameState = STATE.Menu;
    return;
}
}
	
	if(game.gameState == STATE.Help) {
		if(mouseOver(mx, my, 210, 350, 200, 64))
			game.gameState = STATE.Menu;
		    return;
	 }
	//Aici trb
	if(game.gameState == STATE.End) {
	   if(mouseOver(mx, my, 210, 350, 200, 64))
			game.gameState = STATE.Menu;
	   
	       

	 
	   if(mouseOver(mx, my, 210, 250, 200, 64)){
		   EventQueue.invokeLater(new Runnable() {
		    	public void run() {
		    		try {
		    			  Login frame = new Login(hud);
		    			  frame.Save();
					      frame.setVisible(true);
					      frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 

	}
	   if(mouseOver(mx, my, 210, 350, 200, 64)) {
			game.gameState = STATE.Menu;
	        hud.setLevel(0);
            hud.setScore(0);
	}
	}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx,int my,int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Evade Game", 180, 70);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);
		
		
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);

		g.drawRect(210, 350, 200, 64);
		g.drawString("Ranking", 250, 390);
		
		g.drawRect(210, 450, 200, 64);
		g.drawString("Quit", 270, 490);
	}else if(game.gameState == STATE.Help) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Help", 240, 70);
		
		g.setFont(fnt3);
		g.drawString("Use W,A,S,D keys to evade the enemies!",120,200);
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Back", 270, 390);
		

	}else if(game.gameState == STATE.End) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		Font fnt3 = new Font("arial",1,20);
				
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 185, 70);
		
		g.setFont(fnt3);
		g.drawString("You lost with a score of:" + hud.getScore(),175,200);
		g.setFont(fnt2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again", 245, 390);
		g.setFont(fnt2);
		g.drawRect(210, 250, 200, 64);
		g.drawString("Save Score", 233, 290);
	}else if(game.gameState == STATE.Select) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("SELECT DIFICULTY", 100, 70);
		
		g.setFont(fnt2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Normal", 270, 190);
		
		
		
		g.drawRect(210, 250, 200, 64);
		g.drawString("Hard", 270, 290);

		g.drawRect(210, 350, 200, 64);
		g.drawString("Back", 270, 390);
	}
		
}
}
