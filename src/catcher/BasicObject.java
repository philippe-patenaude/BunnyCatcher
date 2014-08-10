package catcher;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BasicObject extends GameObject {

	private BufferedImage img;
	
	public BasicObject(BufferedImage img) {
		this.img = img;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, (int)Math.floor(getX()), (int)Math.floor(getY()), null);
	}

}
