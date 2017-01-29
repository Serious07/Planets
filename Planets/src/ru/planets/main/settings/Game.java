package ru.planets.main.settings;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import ru.planets.main.scenes.Help_scene;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 9150544329153300964L;
	
	boolean running;
	public static int gameState = Settings.GAME_STATE_HELP;
	
	// Screens
	Help_scene help_screen = new Help_scene();
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT));

		JFrame frame = new JFrame(Settings.TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //выход из приложения по нажатию клавиши ESC
		frame.setLayout(new BorderLayout());
		frame.add(game, BorderLayout.CENTER); //добавляем холст на наш фрейм
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		game.start();
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double ticks = Settings.TICKS_IN_SECOND;
		double ns = 1000000000 / ticks;    
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
		    delta += (now - lastTime) / ns;
		    lastTime = now;
		    if(delta >= 1){
		    	update(delta);
		    	render();
		        delta--;
		    }
		    
		    // Wait 1 ms before next cycle
		    try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void update(double delta){
		switch(gameState){
			case Settings.GAME_STATE_HELP:
				help_screen.Update(delta);
			break;
		}
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy(); 
		if (bs == null) {
			createBufferStrategy(2); //создаем BufferStrategy для нашего холста
			requestFocus();
			return;
		}
			
		Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
		g.setColor(Color.black); //выбрать цвет
		g.fillRect(0, 0, getWidth(), getHeight()); //заполнить прямоугольник 
		
		switch(gameState){
			case Settings.GAME_STATE_HELP:
				help_screen.Render(g);
			break;
		}
		
		g.dispose();
		bs.show(); //показать
	}
}