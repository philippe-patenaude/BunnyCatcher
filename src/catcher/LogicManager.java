package catcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LogicManager {
	
	public static final LogicManager instance = new LogicManager();
	
	public static void addLogic(Trigger lgc) {
		instance.add(lgc);
	}
	
	public static void runLogic() {
		instance.run();
	}
	
	private List<Trigger> logics = new ArrayList<Trigger>();
	
	private void add(Trigger lgc) {
		logics.add(lgc);
	}
	
	private void run() {
		
		final List<Trigger> removeList = new LinkedList<Trigger>();
		for (Trigger lgc : logics) {
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
