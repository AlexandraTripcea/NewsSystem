package listener;
import com.google.common.eventbus.Subscribe;

import events.EventContainer;

public interface EventListener {
	@Subscribe
	public void listen(EventContainer handler);
}