package catcher;


public class Bunny extends BasicObject {
	
	private Trigger deleteOnTouchBottom;
	
	public Bunny() {
		
//		super(ResourceManager.getImg("Bunny"));
		super(ResourceManager.getImg("BunnyAnim"), 32, 32, 4, (int)(Math.floor(Math.random()*4)), 5);
		
		// add logic
		deleteOnTouchBottom = new Trigger() {

			@Override
			public boolean checkConditions() {
				return (getY() > Main.GAME_HEIGHT);
			}

			@Override
			public void runLogic() {
				ObjectManager.removeObject(Bunny.this);
			}

			@Override
			public boolean runOnce() {
				return true;
			}
			
		};
		
		LogicManager.addLogic(deleteOnTouchBottom);
		
		setWidth(32);
		setHeight(32);
		
		setX(Math.random()*(Main.GAME_WIDTH-getWidth()));
		setY(-getHeight());
		
		setVy(1);
		
	}
	
	@Override
	public void onCollide(GameObject obj) {
//		if (obj.getClass().equals(Bunny.class)) {
//			System.out.println("Bunny Hugs!!!!");
//		}
	}

}
