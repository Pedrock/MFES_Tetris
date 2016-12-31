package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.overture.codegen.runtime.VDMSeq;

import vdmtetris.GameGrid;
import vdmtetris.Tetris;
import vdmtetris.quotes.GameOverQuote;

@SuppressWarnings("serial")
public class TetrisGUI extends JPanel implements KeyListener, ComponentListener {
	
	private static HashMap<String, Color> colorMap = new HashMap<String, Color>();
	static {
		colorMap.put("<Blue>", Color.BLUE);
		colorMap.put("<Cyan>", Color.CYAN);
		colorMap.put("<Green>", Color.GREEN);
		colorMap.put("<Orange>", Color.ORANGE);
		colorMap.put("<Purple>", Color.PINK);
		colorMap.put("<Red>", Color.RED);
		colorMap.put("<Yellow>", Color.YELLOW);
	}
	private static final int DEFAULT_SQUARE_SIZE = 30;
	private int SQUARE_SIZE = 30;
	private static final int TOP_MARGIN = 50;
	private static final int LEFT_MARGIN = 30;
	private static final int WIDTH = GameGrid.WIDTH.intValue();
	private static final int VISIBLE_HEIGHT = GameGrid.VISIBLE_HEIGHT.intValue();
	
	private static int PANEL_WIDTH_SQUARES = WIDTH + 4;
	private static int PANEL_HEIGHT_SQUARES = VISIBLE_HEIGHT + 1;
	
	private static Tetris tetris;
	
	private boolean pressingDown = false;
	
	Thread gameKeepingThread = new Thread() {
		@Override public void run() {
			while (true) {
				int delay = tetris.getTickDelay().intValue();
				if (pressingDown) delay /= 6;
				try {
					Thread.sleep(delay);
					if (SwingUtilities.getRoot(TetrisGUI.this).hasFocus()) {
						tetris.tick();
						repaint();
					}
				}
				catch (InterruptedException ex) {
					repaint();
				}
			}
		}
	};
	
	public TetrisGUI() {
		this.addComponentListener(this);
		
		tetris = new Tetris();
		tetris.begin();
		repaint();
		
		gameKeepingThread.start();
	}
	
	private void drawSquare(Graphics g, int x, int y, String colorName, boolean faint) {
		Color color = colorMap.get(colorName);
		if (color != null)
		{
			if (y >= VISIBLE_HEIGHT) return;
			if (faint) color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() / 4);
			g.setColor(color);
			g.fillRect(LEFT_MARGIN + SQUARE_SIZE*x, 
					   TOP_MARGIN + SQUARE_SIZE*(VISIBLE_HEIGHT - 1 - y), 
					   (SQUARE_SIZE-1), 
					   (SQUARE_SIZE-1));
		}
	}
	
	private void drawGridLines(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		int maxX = LEFT_MARGIN + WIDTH*SQUARE_SIZE - 1;
		for (int y = 0; y <= VISIBLE_HEIGHT; y++)
		{
			int lineY = TOP_MARGIN + SQUARE_SIZE*y - 1;
			g.drawLine(LEFT_MARGIN, lineY, maxX, lineY);
		}
		int maxY = TOP_MARGIN + VISIBLE_HEIGHT*SQUARE_SIZE - 1;
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
				drawSquare(g, x, y, line.get(x).toString(), false);
			}
		}
	}
	
	private void drawTetramino(Graphics g, int tetraminoY, boolean faint) {
		VDMSeq matrix = tetris.tetramino.getCurrentMatrix();
		int height = matrix.size();
		int offsetX = tetris.tetramino.x.intValue() - 1;
		int offsetY = tetraminoY - 1;
	
		for (int y = 0; y < height; y++) {
			VDMSeq line = (VDMSeq)matrix.get(y);
			int width = line.size();
			for (int x = 0; x < width; x++) {
				drawSquare(g, offsetX + x, offsetY - y, line.get(x).toString(), faint);
			}
		}
	}
	
	private void drawTetramino(Graphics g) {
		if (tetris.tetramino == null) return;
		drawTetramino(g, tetris.tetramino.y.intValue(), false);
	}
	
	private void drawGhostPiece(Graphics g) {
		if (tetris.tetramino == null) return;
		drawTetramino(g, tetris.getGhostPieceHeight().intValue(), true);
	}
	
	private void drawNextTetramino(Graphics g) {
		
		int offsetX = LEFT_MARGIN + (WIDTH + 1)*SQUARE_SIZE;
		int offsetY = TOP_MARGIN;
		
		int squareSize = SQUARE_SIZE / 2;
		
		g.setColor(Color.DARK_GRAY);
		g.drawRect(offsetX, offsetY, squareSize*4, squareSize*4);
		
		if (tetris.nextTetramino == null) return;
	
		VDMSeq matrix = tetris.nextTetramino.getCurrentMatrix();
		int height = matrix.size();
		
		if (height < 4) {
			offsetY += (4 - height)*squareSize/2;
			offsetX += (4 - height)*squareSize/2;
		}
		
		for (int y = 0; y < height; y++) {
			VDMSeq line = (VDMSeq)matrix.get(y);
			int width = ((VDMSeq)matrix.get(y)).size();
			for (int x = 0; x < width; x++) {
				Color color = colorMap.get(line.get(x).toString());
				if (color != null)
				{
					g.setColor(color);
					g.fillRect(offsetX + squareSize*x, 
							   offsetY + squareSize*y, 
							   (squareSize-1), 
							   (squareSize-1));
				}
			}
		}
	}
	
	@Override 
	public void paintComponent(Graphics g)
	{
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		drawGridLines(g);
		
		drawGameGrid(g);
		
		// Display the score
		g.setColor(Color.WHITE);
		g.drawString("Level: "+tetris.level + "    Score: "+tetris.score, 200, SQUARE_SIZE);
		
		if (tetris.gameState instanceof GameOverQuote) {
			g.setColor(Color.RED);
			g.drawString("GAME OVER", 50, SQUARE_SIZE);
		}
		
		drawNextTetramino(g);
		drawGhostPiece(g);
		drawTetramino(g);
	}
	
	public boolean processKeyPress(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_X:
				tetris.rotateRight();
				return true;
			case KeyEvent.VK_Z:
				tetris.rotateLeft();
				return true;
			case KeyEvent.VK_LEFT:
				tetris.moveLeft();
				return true;
			case KeyEvent.VK_RIGHT:
				tetris.moveRight();
				return true;
			case KeyEvent.VK_SPACE:
				tetris.hardDrop();
				return true;
			case KeyEvent.VK_DOWN:
				if (!pressingDown) {
					gameKeepingThread.interrupt();
					tetris.tick();
				}
				pressingDown = true;
				return false;
			case KeyEvent.VK_R:
				showRestartDialog();
				return false;
			case KeyEvent.VK_P:
				showPausedDialog();
				return false;
			default:
				return false;
		}
	}
	
	private void showRestartDialog() {
		int dialogResult = JOptionPane.showConfirmDialog(this, 
				"Do you want to restart?", "Restart?", JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			tetris.begin();
			gameKeepingThread.interrupt();
		}
	}
	
	private void showPausedDialog() {
		JOptionPane.showConfirmDialog(this, "Paused. Resume game?", "Paused", JOptionPane.DEFAULT_OPTION);
		gameKeepingThread.interrupt();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2*LEFT_MARGIN+PANEL_WIDTH_SQUARES*DEFAULT_SQUARE_SIZE, 
					  2*TOP_MARGIN+DEFAULT_SQUARE_SIZE*PANEL_HEIGHT_SQUARES);
		final TetrisGUI panel = new TetrisGUI();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) { } 
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (processKeyPress(e)) repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				pressingDown = false;
				gameKeepingThread.interrupt();
				break;
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {
		SQUARE_SIZE = Math.min(
				(this.getWidth() - LEFT_MARGIN) / PANEL_WIDTH_SQUARES, 
				(this.getHeight() - TOP_MARGIN) / PANEL_HEIGHT_SQUARES);
	}

	@Override
	public void componentShown(ComponentEvent e) {}
	
	
}
