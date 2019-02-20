package furtuna;

import java.awt.Graphics;
import java.util.LinkedList;

import furtuna.Game.STATE;

public class Handler {
//maintain and render all your objects
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public int spd = 5;
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getID() != ID.Player)
			{
				object.clear();
				if(Game.gameState != Game.STATE.End)
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
		
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	public int getSpd() {
		return spd;
	}
}
