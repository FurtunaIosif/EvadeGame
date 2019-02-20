package furtuna;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
    private Handler handler;
    
    Random r = new Random();
    
    
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	private Color col;
	
	int dir = 0;
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(7 - -7) + - 7);
		velX = (r.nextInt(7 - -7) + - 7);
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	 public Rectangle getBounds(){
		 return new Rectangle(x, y, 16, 16);
	 }

	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16, 16, 0.1f, handler));
	}


	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(col);
		g.fillRect(x, y, 16, 16);
	}

}
