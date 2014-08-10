package catcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

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
		
		// runs the game loop
		content.runGame();
		
	}
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;

	// for the game loop
    public final static long FPS = 60; // frames per second
    private final static long TPS = 1000000000; // ticks per second
    private final static long TPF = TPS/FPS; // ticks per frame
    
    private GameState state = new StateCatcherGame();
    
	private Main() {
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
	}
	
	private void runGame() {
        
        long startTime = System.nanoTime();
        long counter = 0;
        boolean gameOver = false;
        long frames;
        
        while (gameOver == false) { // game loop
            
            // update loop
            while (counter > 0) {
                // updating code goes here
            	update();
                // we have updated once, decrement counter
                counter--;
            }
            // drawing code goes here
            draw();
            
            // update the counter and start time
            frames = (System.nanoTime() - startTime)/TPF;
            counter += frames;
            startTime += frames*TPF;
        }
        
	}
	
	private void update() {
		state.update();
	}
	
	private void draw() {
		
		Graphics2D g = (Graphics2D)this.getGraphics();
		
		BufferedImage img = new BufferedImage(GAME_WIDTH, GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = (Graphics2D)img.getGraphics();
		
		state.draw(g2);
		
		g2.dispose();
		
		g.drawImage(img, 0, 0, null);
		
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
