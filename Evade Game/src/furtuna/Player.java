package furtuna;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;
	
 public Player(int x, int y, ID id, Handler handler ) {
	 super(x,y,id);
	 this.handler = handler;
 }
 
 public Rectangle getBounds(){
	 return new Rectangle(x, y, 32, 32);
 }
 public void tick() {
	 x += velX;
	 y += velY;
	 
	 x = Game.clema( x, 0, Game.WIDTH - 39);
     y = Game.clema( y, 0, Game.HEIGHT - 66);
     
     handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
     collision();
 }
 
 private void collision() {
	 for(int i = 0; i < handler.object.size(); i++) {
		 GameObject tempObject = handler.object.get(i);
		 
		 if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy || tempObject.getID() == ID.HardEnemy) {
			 //collision code
			 if(getBounds().intersects(tempObject.getBounds())) {
				 //collision code 
				 HUD.HEALTH -= 2;
			 }
		 }
	 }
 }
 public void render(Graphics g) {
	 g.setColor(Color.white);
	 g.fillRect(x, y, 32, 32);
 }
 
 
}
