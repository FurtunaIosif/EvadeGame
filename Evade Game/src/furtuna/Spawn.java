package furtuna;

import java.util.Random;

public class Spawn {
	
   private Handler handler;
   private HUD hud;
   private Game game;
   private Random r = new Random();
   private int scoreKeep = 0;
   public Spawn(Handler handler, HUD hud,Game game) {
	   
	   this.handler = handler;
	   this.hud = hud;
	   this.game = game;
   }
   
   public void tick() {
	   scoreKeep ++;
	   if(scoreKeep >= 50) {
		   scoreKeep = 0;
		   hud.setLevel(hud.getLevel() + 1);
		   if(game.diff == 0)
		   {   
			   if(hud.getLevel() == 1) {
				   handler.clearEnemys();
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			   }else if(hud.getLevel() == 5) {
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			   }else if(hud.getLevel() == 10) {
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			   }else if(hud.getLevel() == 15) {
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			   }else if(hud.getLevel() == 20) {
				   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			   }else if(hud.getLevel() == 25) {
				   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler)); 
		       }else if(hud.getLevel() == 30) {
		    	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 35) {
	        	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 40) {
	        	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 45) {
	        	   handler.clearEnemys();
		       handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120,ID.EnemyBoss, handler));
	           }else if(hud.getLevel() == 70) {
	        	   handler.clearEnemys();
	        	   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler));
	        	   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler));
	        	   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler));
	           }else if(hud.getLevel() == 90) {
	        	   handler.clearEnemys();
		       handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120,ID.EnemyBoss, handler));
		       handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
		       handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
		       handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
	           }else if(hud.getLevel() == 130) {
	        	   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler));
	        	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }
		   }else if(game.diff == 1)
		   {
			   if(hud.getLevel() == 1) {
				   handler.clearEnemys();
				   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   }else if(hud.getLevel() == 5) {
				   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   }else if(hud.getLevel() == 10) {
				   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   }else if(hud.getLevel() == 15) {
				   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   }else if(hud.getLevel() == 20) {
				   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			   }else if(hud.getLevel() == 25) {
				   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler)); 
		       }else if(hud.getLevel() == 30) {
		    	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 35) {
	        	   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 40) {
	        	   handler.clearEnemys();
		       handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120,ID.EnemyBoss, handler));
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
	           }else if(hud.getLevel() == 70) {
	        	   handler.clearEnemys();
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
	           }else if(hud.getLevel() == 100) {
	        	   handler.clearEnemys();
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
		       handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
		       handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 130) {
		       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
		       handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
	           }else if(hud.getLevel() == 150) {
			   handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.SmartEnemy, handler));
		       }
	           else if(hud.getLevel() == 200) {
	        	   handler.clearEnemys();
			       handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120,ID.EnemyBoss, handler));
			       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			       handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.HardEnemy, handler));
			   }else if(hud.getLevel() == 250) {
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
				   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			   }
		   
           }
}
	   }
   }

