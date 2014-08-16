package catcher;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BasicObject extends GameObject {

	private BufferedImage img;
	private int width, height, frameCount, startFrame, delay;
	private boolean animated = false;
	private long startTime = -1; 
	
	public BasicObject(BufferedImage img) {
		this.img = img;
		ObjectManager.addObject(this);
	}
	
	public BasicObject(BufferedImage img, int width, int height, int frame_count, int start_frame, int delay) {
		this.img = img;
		this.width = width;
		this.height = height;
		this.frameCount = frame_count;
		this.startFrame = start_frame;
		this.delay = delay;
		animated = true;
		ObjectManager.addObject(this);
	}
	
	@Override
	public void draw(Graphics2D g, long gameFrame) {
		if (animated == false) {
			g.drawImage(img, (int)Math.floor(getX()), (int)Math.floor(getY()), null);
		} else {
			if (startTime < 0) {
				startTime = gameFrame;
			}
			
			long diff = gameFrame-startTime;
			int newFrames = (int)Math.floor((double)diff / (double)delay);
			int currentFrame = (startFrame + newFrames) % frameCount;
			
			g.drawImage(img, (int)Math.floor(getX()), (int)Math.floor(getY()), width, height, currentFrame*width, 0, width, height, null);
			
		}
	}

}
