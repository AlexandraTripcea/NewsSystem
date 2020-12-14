package logic;

import com.google.common.eventbus.EventBus;

public class EventBusManager {
	public static EventBus eventBus = null;
	
	public static EventBus getInstance() {
		if (eventBus == null)
			eventBus = new EventBus();

		return eventBus;
	}
}
