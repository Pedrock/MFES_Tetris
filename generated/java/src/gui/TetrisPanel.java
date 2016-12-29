package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ColorModel;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.overture.codegen.runtime.VDMSeq;

import tetris.GameGrid;
import tetris.Tetramino;
import tetris.Tetris;

public class TetrisPanel extends JPanel {
	
	private static HashMap<String, Color> colorMap = new HashMap<String, Color>();
	static {
		colorMap.put("<Blue>", Color.BLUE);
		colorMap.put("<Cyan>", Color.CYAN);
		colorMap.put("<Green>", Color.GREEN);
		colorMap.put("<Orange>", Color.ORANGE);
		colorMap.put("<Purple>", Color.PINK); // TODO - Mudar
		colorMap.put("<Red>", Color.RED);
		colorMap.put("<Yellow>", Color.YELLOW);
	}
	private static final int SQUARE_SIZE = 30;
	private static final int TOP_MARGIN = 50;
	private static final int LEFT_MARGIN = 30;
	private static final int WIDTH = GameGrid.WIDTH.intValue();
	private static final int HEIGHT = GameGrid.HEIGHT.intValue();
	
	private static Tetris tetris;
	
	public TetrisPanel() {
		tetris = new Tetris();
		tetris.begin();
		repaint();
		
		new Thread() {
			@Override public void run() {
				while (true) {
					try {
						Thread.sleep(400);
						tetris.tick();
						repaint();
					} catch ( InterruptedException e ) {}
				}
			}
		}.start();
	}
	
	private void drawSquare(Graphics g, int x, int y, String colorName) {
		Color color = colorMap.get(colorName);
		if (color != null)
		{
			g.setColor(color);
			g.fillRect(LEFT_MARGIN + SQUARE_SIZE*x, 
					   TOP_MARGIN + SQUARE_SIZE*(HEIGHT - 1 - y), 
					   (SQUARE_SIZE-1), 
					   (SQUARE_SIZE-1));
		}
	}
	
	private void drawGridLines(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		int maxX = LEFT_MARGIN + WIDTH*SQUARE_SIZE - 1;
		for (int y = 0; y <= HEIGHT; y++)
		{
			int lineY = TOP_MARGIN + SQUARE_SIZE*y - 1;
			g.drawLine(LEFT_MARGIN, lineY, maxX, lineY);
		}
		int maxY = TOP_MARGIN + HEIGHT*SQUARE_SIZE - 1;
		for (int x = 0; x <= WIDTH; x++) {
			int lineX = LEFT_MARGIN + SQUARE_SIZE*x - 1;
			g.drawLine(lineX, TOP_MARGIN, lineX, maxY);
		}
	}
	
	private void drawGameGrid(Graphics g) {
		VDMSeq grid = tetris.gameGrid.grid;
		int height = grid.size();
		int width = ((VDMSeq)grid.get(0)).size();
	
		for (int y = 0; y < height; y++)
		{
			VDMSeq line = ((VDMSeq)grid.get(y));
			for (int x = 0; x < width; x++) {
				drawSquare(g, x, y, line.get(x).toString());
			}
		}
	}
	
	private void drawTetramino(Graphics g) {
		VDMSeq matrix = tetris.tetramino.getCurrentMatrix();
		int height = matrix.size();
		int offsetX = tetris.tetramino.x.intValue() - 1;
		int offsetY = tetris.tetramino.y.intValue() - 1;
	
		for (int y = 0; y < height; y++) {
			VDMSeq line = (VDMSeq)matrix.get(y);
			int width = line.size();
			for (int x = 0; x < width; x++) {
				drawSquare(g, offsetX + x, offsetY - y, line.get(x).toString());
			}
		}
	}
	
	@Override 
	public void paintComponent(Graphics g)
	{
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LEFT_MARGIN + SQUARE_SIZE*(WIDTH+2), TOP_MARGIN + SQUARE_SIZE*(HEIGHT+1));
		
		drawGridLines(g);
		
		drawGameGrid(g);
		
		// Display the score
		g.setColor(Color.WHITE);
		g.drawString("0", 200, SQUARE_SIZE);
		
		drawTetramino(g);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(LEFT_MARGIN+(WIDTH+2)*SQUARE_SIZE, TOP_MARGIN+SQUARE_SIZE*(HEIGHT+2));
		final TetrisPanel panel = new TetrisPanel();
		frame.add(panel);
		frame.setVisible(true);
		
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					tetris.rotateLeft();
					frame.repaint();
					break;
				case KeyEvent.VK_DOWN:
					tetris.rotateRight();
					frame.repaint();
					break;
				case KeyEvent.VK_LEFT:
					tetris.moveLeft();
					frame.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					tetris.moveRight();
					frame.repaint();
					break;
				case KeyEvent.VK_SPACE:
					// TODO
					break;
				} 
			}
			
			public void keyReleased(KeyEvent e) {
			}
		});
	}
}
