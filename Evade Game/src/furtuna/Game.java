package furtuna;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	

	private static final long serialVersionUID = 5640041051236175798L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 9*9;
	
	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
    public int diff = 0;
    
	
    private Random r;	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	public enum STATE {
		Menu,
		Select,
		Help,
		Shop,
		Game,
		End
	}; 
	
	public static STATE gameState = STATE.Menu;
	
	public Game() {
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		new Window(WIDTH, HEIGHT, "Evade Game",this);
		
		spawner = new Spawn(handler, hud, this);
		r = new Random();
		
		if(gameState == STATE.Game)
		{   
			//handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, handler));
			//handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			
		}else {
			for(int i = 0; i < 20; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle, handler));
			}
		}

	
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//GAME LOOP STARTS HERE
	public void run() {
		this.requestFocus(); //poti controla player-ul fara a tine click-ul apasat pe ecran
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	//GAME LOOP ENDS HERE
	private void tick(){	
		
		if(gameState == STATE.Game)
		{   
			if(!paused)
			{
				hud.tick();
				spawner.tick();
				handler.tick();
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;
					handler.spd = 5;
					shop.setB1(1000);
					shop.setB2(1000);
					shop.setB3(1000);
					hud.setBounds(0);
					gameState = STATE.End;
					handler.clearEnemys();
					for(int i = 0; i < 20; i++) {
						handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle, handler));
					}
				}
			}
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}

	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		

		
		if(paused) {
			g.setColor(Color.white);
			g.drawString("PAUSED", 15, 110);
		}
		
		if(gameState == STATE.Game)
		{
			hud.render(g);
			handler.render(g);
		}else if(gameState == STATE.Shop){
			shop.render(g);
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
			menu.render(g);
			handler.render(g);
		}
      
		
		g.dispose();
		bs.show();
	}
//exemplu var ia valoarea coordonatei x, max valoarea latimii ferestrei, var nu va puatea trece peste max si astfel obiectul nu va iesii din frame
		public static int clema(int var, int min, int max) {
			if(var >= max)
				return var = max;
			else if(var <= min)
				return var = min;
			else return var;
		}

public static void main(String args[]) {
	new Game();
}
}
