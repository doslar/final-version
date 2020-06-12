package main;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import input.KListener;
import input.MListener;
import states.State;
import states.State_Game;
import util.Assets;
import util.Constants;

public class Game implements Runnable {
	public static Game game;
	
	private Display display;
	private Thread mainThread;
	private boolean isRunning =false;
	
	private BufferStrategy bs;
	private Graphics2D g2;
	
	//States
	private State gameState;

	//Listener
	public static KListener keyListener;
	public static MListener mouseListener;
	
	
	public void init() {
		display= new Display(Constants.WINDOW_TITLE,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);

		game= this;
		new Assets();
		
		keyListener = new KListener();
		mouseListener= new MListener();
		
		display.addKeyListener(keyListener);
		display.addMouseListener(mouseListener);
		
		gameState = new State_Game();
		
		State.setState(gameState);
	}
	
	

	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int FPS = 0;
		
		while(isRunning) {
			now = System.nanoTime();
			delta += (now- lastTime) / timePerTick;
			timer += now-lastTime;
			lastTime = now;
			
			if(delta>=1) {
				update();
				render();
				FPS++;
				delta--;
			}
			
			if(timer>= 1000000000) {
				System.out.println("FPS :"+FPS);
				FPS = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		System.out.println(mouseListener.mousePressed);
		
		if(State.getState()!=null)
			gameState.getState().update();
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g2 = (Graphics2D) bs.getDrawGraphics();
		
		//Clear Screen;
		g2.clearRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		//Draw here
		
		if(State.getState()!=null)
			gameState.getState().render(g2);

		//End drawing
		
		bs.show();
		g2.dispose();
	}
	
	public synchronized void start() {
		if(isRunning)
			return;
		isRunning=true;
		mainThread = new Thread(this);
		mainThread.start();
		
	}
	
	public synchronized void stop() {
		if(!isRunning)
			return;
		isRunning=false;
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
