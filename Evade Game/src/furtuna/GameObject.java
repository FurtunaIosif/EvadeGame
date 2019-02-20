package furtuna;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	//all the game objects(enemies, players, etc.)
	protected int x;
	protected int y;
	protected ID id;
	protected float velX;
	protected float velY;//speed on x and y axis
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int Y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public float getVelX() {
		return velY;
	}
	public void setVelY(int velY) {
	    this.velY = velY;
		
	}
	public float getVelY() {
		return velY;
	}
}
