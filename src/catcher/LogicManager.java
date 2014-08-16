package catcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LogicManager {
	
	public static final LogicManager instance = new LogicManager();
	
	public static void addLogic(Logic lgc) {
		instance.add(lgc);
	}
	
	public static void runLogic() {
		instance.run();
	}
	
	private List<Logic> logics = new ArrayList<Logic>();
	
	private void add(Logic lgc) {
		logics.add(lgc);
	}
	
	private void run() {
		
		final List<Logic> removeList = new LinkedList<Logic>();
		for (Logic lgc : logics) {
			if (lgc.checkConditions()) {
				lgc.runLogic();
				if (lgc.runOnce()) {
					removeList.add(lgc);
				}
			}
		}
		logics.removeAll(removeList);

	}
	
}
