package catcher;

public interface Trigger {
	
	public boolean checkConditions();
	public void runLogic();
	public boolean runOnce();
	
}
