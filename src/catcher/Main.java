package catcher;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame win = new JFrame("Catch the Bunnies!");
		Main content = new Main();
		
		win.setResizable(false);
		win.setContentPane(content);
		win.setLocation(100, 100);
		win.pack();
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// runs the game loop
		content.runGame();
		
	}
	
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 480;
	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 240;

	// for the game loop
    public final static long FPS = 60; // frames per second
    private final static long TPS = 1000000000; // ticks per second
    private final static long TPF = TPS/FPS; // ticks per frame
    
    private GameState state = new StateCatcherGame();
    
	// back buffer
	private BufferedImage backbuffer = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    
	private Main() {
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
	}
	
	private void runGame() {
        
        long startTime = System.nanoTime();
        long counter = 0;
        boolean gameOver = false;
        long frames;
        
        long currentGameFrame = 0;
        
        while (gameOver == false) { // game loop
            
            // update loop
            while (counter > 0) {
                // updating code goes here
            	update(currentGameFrame);
                // we have updated once, decrement counter
                counter--;
                currentGameFrame++;
            }
            // drawing code goes here
            draw();
            
            // update the counter and start time
            frames = (System.nanoTime() - startTime)/TPF;
            counter += frames;
            startTime += frames*TPF;
        }
        
	}
	
	private void update(long gameFrame) {
		state.update(gameFrame);
	}
	
	private void draw() {
		
		Graphics2D g = (Graphics2D)this.getGraphics();
		
		Graphics2D g2 = (Graphics2D)backbuffer.getGraphics();
		
		state.draw(g2);
		
		g2.dispose();
		
		g.drawImage(backbuffer, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
		
		g.dispose();
		
	}
	
	@Override
	public void paint(Graphics graphics) {

//		Graphics2D g = (Graphics2D)graphics;
//		
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
//		
	}

}
