package furtuna;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{


	private static final long serialVersionUID = -3168287451882255481L;
	
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(height, width));
		frame.setMaximumSize(new Dimension(height, width));
		frame.setMinimumSize(new Dimension(height, width));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}


}
