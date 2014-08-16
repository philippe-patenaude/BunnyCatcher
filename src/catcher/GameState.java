package catcher;

import java.awt.Graphics2D;

public interface GameState {

	public String getName();
	public void update(long gameFrame);
	public void draw(Graphics2D g, long gameFrame);
	
}
