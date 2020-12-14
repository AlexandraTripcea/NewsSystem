package listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import events.EventContainer;
import logic.Action;
import logic.EventBusManager;

public class Reader implements EventListener {
	String domain;
	Action eventType;

	public Reader(String domain, Action modify) {
		this.domain = domain;
		this.eventType = modify;
	}

	@Subscribe
	public void listen(EventContainer handler) {
		if (handler.getDomain().equals(domain) && handler.getEventType().equals(eventType)) {
			System.out.println("Something changed in article: " + handler.getTitle() + " (domain: "
					+ handler.getDomain() + ")" + " --- " + handler.getEventType());
		}
	}

	public void read(String title) {
		EventBus eventBus = EventBusManager.getInstance();
		eventBus.post(new EventContainer(Action.READ, "", title));
	}
}
