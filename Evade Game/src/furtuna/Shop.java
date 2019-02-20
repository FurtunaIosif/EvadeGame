package furtuna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{
	Handler handler;
	HUD hud;
	private int B1 = 1000;
	private int B2 = 1000;
	private int B3 = 1000;
    public Shop(Handler handler, HUD hud) {
    	this.handler = handler;
    	this.hud = hud;
    }
    public void setB1(int B1) {
		this.B1 = B1;
	}
    public int getB1() {
		return B1;
	}
    public void setB2(int B2) {
		this.B2 = B2;
	}
    public int getB2() {
		return B2;
	}
    public void setB3(int B3) {
		this.B3 = B3;
	}
    public int getB3() {
		return B3;
	}
    public void resetShop() {
    	B1 = 1000;
    	B2 = 1000;
    	B3 = 1000;
    	handler.spd = 5;
    }
    public void render(Graphics g) {
    	g.setColor(Color.white);
    	g.setFont(new Font("arial", 0, 48));
    	g.drawString("Shop", Game.WIDTH/2 - 70, 50);
    	
    	//b1
    	g.setFont(new Font("arial", 0, 12));
    	g.drawString("Upgrade Health", 110, 120);
    	g.drawString("Cost: " + B1, 110, 140);
    	g.drawRect(100, 100, 100, 80);
    	
    	
    	//b2
    	g.setFont(new Font("arial", 0, 12));
    	g.drawString("Upgrade Speed", 260, 120);
    	g.drawString("Cost: " + B2, 260, 140);
    	g.drawRect(250, 100, 100, 80);
    	
    	
    	//b3
    	g.setFont(new Font("arial", 0, 12));
    	g.drawString("Refill Health", 410, 120);
    	g.drawString("Cost: " + B3, 410, 140);
    	g.drawRect(400, 100, 100, 80);
    	
    	
    	g.drawString("Score: " + hud.getScore(), Game.WIDTH/2-50, 300);
    	g.drawString("Press space to go back", Game.WIDTH/2-50, 330);
    }
    
    public void mousePressed(MouseEvent e) {
    	int mx = e.getX();
    	int my = e.getY();
    	
    	//prima casuta
    	if(mx >= 100 && mx <= 200) {
    		if(my >= 100 && my <= 180) {
    			//ai selectat prima casuta
    			if(hud.getScore() >= B1) {
    				hud.setScore(hud.getScore() - B1);
    				B1 += 1000;
    				hud.bounds += 20;
    				hud.HEALTH = (100 + (hud.bounds/2));
    			}
    			
    		}
    	}
    	//casuta 2
    	if(mx >= 250 && mx <= 350) {
    		if(my >= 100 && my <= 180) {
    			//ai selectat a doua casuta
    			if(hud.getScore() >= B2) {
    				hud.setScore(hud.getScore() - B2);
    				B2 += 1000;
    				handler.spd++;
    			}
    		}
    	}
       	//casuta 3
    	if(mx >= 400 && mx <= 500) {
    		if(my >= 100 && my <= 180) {
    			//ai selectat a treia casuta
    			if(hud.getScore() >= B3) {
    				hud.setScore(hud.getScore() - B3);
    				hud.HEALTH = (100 + (hud.bounds/2));
    			}
    		}
    	}
    }
}
