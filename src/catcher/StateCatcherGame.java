package catcher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
public class StateCatcherGame implements GameState {

//	private BufferedImage imgBunny;
	private Basket userBasket;
	private InputManager IM = Main.INPUT;
	
	public StateCatcherGame() {
//		imgBunny = getImg("Bunny");
		userBasket = new Basket();
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
		
		// handle keyboard inputs
		if (IM.isPressed(KeyEvent.VK_LEFT)) {
			if (userBasket.getX() > 0) {
				userBasket.setVx(-1);
			} else {
				userBasket.setX(0);
				userBasket.setVx(0);
			}
		} else if (IM.isPressed(KeyEvent.VK_RIGHT)) {
			if (userBasket.getX() < Main.GAME_WIDTH - userBasket.getWidth()) {
				userBasket.setVx(1);
			} else {
				userBasket.setX(Main.GAME_WIDTH - userBasket.getWidth());
				userBasket.setVx(0);
			}
		} else {
			userBasket.setVx(0);
		}
		
		// run the game physics
		ObjectManager.updateObjects();
		// run the game logic
		LogicManager.runLogic();
		
	}

	@Override
	public void draw(Graphics2D g, long gameFrame) {

		// draw background
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Main.GAME_WIDTH, Main.GAME_HEIGHT);
		
		// draw objects
		ObjectManager.drawObjects(g, gameFrame);
		
	}

}
