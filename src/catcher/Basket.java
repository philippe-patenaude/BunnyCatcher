package catcher;

import java.util.ArrayList;
import java.util.List;

public class Basket extends BasicObject {
	
	private Trigger catchBunny;
	private List<Bunny> collisionList = new ArrayList<Bunny>();

	public Basket() {
		super(ResourceManager.getImg("Basket"));
		setVx(0);
		setVy(0);
		setWidth(32);
		setHeight(32);
		setX(0);
		setY(Main.GAME_HEIGHT-getHeight());
		
		catchBunny = new Trigger() {
			
			@Override
			public boolean runOnce() {
				return false;
			}
			
			@Override
			public void runLogic() {
				for (Bunny obj : collisionList) {
					ObjectManager.removeObject(obj);
				}
				collisionList.clear();
			}
			
			@Override
			public boolean checkConditions() {
				return Basket.this.collisionList.size() != 0;
			}
		};
		
		LogicManager.addLogic(catchBunny);
		
	}
	
	@Override
	public void onCollide(GameObject obj) {
		Bunny bunny = null;
		if (obj.getClass() == Bunny.class) {
			bunny = (Bunny)obj;
			collisionList.add(bunny);
		} else {
			return;
		}
	}
	
}
