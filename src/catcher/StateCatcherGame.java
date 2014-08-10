package catcher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static catcher.ResourceManager.*;
public class StateCatcherGame implements GameState {

	private BufferedImage imgBunny;
	
	public StateCatcherGame() {
		imgBunny = getImg("Bunny");
	}
	
	@Override
	public String getName() {
		return "CatcherGame";
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g) {

		g.setColor(Color.RED);
		g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		
		g.drawImage(imgBunny, 0, 0, null);
		
	}

}
