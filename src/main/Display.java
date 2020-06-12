package main;

import java.awt.Canvas;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Display extends JFrame{
	private Canvas canvas;
	private String title;

	
	public Display(String title, int width, int height) {
		
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		add(canvas);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
}
