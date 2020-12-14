package events;

import logic.Action;

public class EventContainer {
	private String domain, title; 
	Action eventType;
	
	public EventContainer (Action modify, String domain, String title) {
		this.eventType = modify; 
		this.domain = domain;
		this.title = title; 
	}
	
	public Action getEventType() {
		return eventType;
	}

	public void setEventType(Action eventType) {
		this.eventType = eventType;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	
}
