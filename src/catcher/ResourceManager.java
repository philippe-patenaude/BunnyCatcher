package catcher;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ResourceManager {

	public static final ResourceManager instance = new ResourceManager();
	
	public static BufferedImage getImg(String name) {
		return instance.imgMap.get(name);
	}
	
	private Map<String, BufferedImage> imgMap = new HashMap<String, BufferedImage>();
	
	private ResourceManager() {
		loadImages();
	}
	
//	public BufferedImage getImg(String name) {
//		return imgMap.get(name);
//	}
	
	private void loadImages() {
		try {
			imgMap.put("Bunny", loadImage("Bunny.png"));
			imgMap.put("BunnyAnim", loadImage("BunnyAnim.png"));
			imgMap.put("Basket", loadImage("Basket.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Image could not be loaded: " + e.getMessage());
		}
	}
	
	private BufferedImage loadImage(String name) throws IOException {
		
		BufferedImage img = null;

	    ClassLoader cldr = Main.class.getClassLoader();
	    URL url = cldr.getResource("" + name);

	    if (url == null) {
	        JOptionPane.showMessageDialog(null, "The image \"" + name + "\" could not be loaded.");
	        return null;
	    }

	    img = ImageIO.read(url);
	    return img;
		
	}
	
}
