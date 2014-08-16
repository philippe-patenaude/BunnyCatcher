package catcher;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {

	public static final ObjectManager instance = new ObjectManager();
	
	public static void addObject(GameObject obj) {
		instance.objects.add(obj);
	}
	
	public static void removeObject(GameObject obj) {
		instance.objects.remove(obj);
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
		for (int i = 0; i < objects.size()-1; i++) {
			for (int j = i+1; j < objects.size(); j++) {
				GameObject obj1 = objects.get(i);
				GameObject obj2 = objects.get(j);
				if (obj1.doesCollide(obj2)) {
					obj1.onCollide(obj2);
					obj2.onCollide(obj1);
				}
			}
		}
	}
	
	private void draw(Graphics2D g) {
		for (GameObject obj : objects) {
			obj.draw(g);
		}
	}
	
}
