package catcher;

import java.awt.Color;
import java.awt.Graphics2D;
public class StateCatcherGame implements GameState {

//	private BufferedImage imgBunny;
	
	public StateCatcherGame() {
//		imgBunny = getImg("Bunny");
	}
	
	@Override
	public String getName() {
		return "CatcherGame";
	}

	@Override
	public void update(long gameFrame) {
		
		// spawn bunnies here
		if (gameFrame % 60 == 0) {
			new Bunny();
		}
		
		ObjectManager.updateObjects();
		LogicManager.runLogic();
		
	}

	@Override
	public void draw(Graphics2D g) {

		// draw background
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		
		// draw objects
		ObjectManager.drawObjects(g);
		
	}

}
