package catcher;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {

	public static final ObjectManager instance = new ObjectManager();
	
	public static void addObject(GameObject obj) {
		instance.objects.add(obj);
	}
	
	public static void updateObjects() {
		instance.update();
	}
	
	public static void drawObjects(Graphics2D g) {
		instance.draw(g);
	}
	
	private List<GameObject> objects;
	
	private ObjectManager() {
		objects = new ArrayList<GameObject>();
	}
	
	private void update() {
		for (GameObject obj : objects) {
			obj.update();
		}
	}
	
	private void draw(Graphics2D g) {
		for (GameObject obj : objects) {
			obj.draw(g);
		}
	}
	
}
