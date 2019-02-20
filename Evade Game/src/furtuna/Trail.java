package furtuna;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
    public float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    
    private int width, heigth;

    
	public Trail(int x, int y, ID id, Color color,int width, int heigth, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.heigth = heigth;
		this.life = life;
	}


	public void tick() {
		if(alpha > life) {
			alpha -= (life - 0.0001f);
		}else handler.removeObject(this);
		
	}


	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, width, heigth);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}


	public Rectangle getBounds() {

		return null;
	}

}
