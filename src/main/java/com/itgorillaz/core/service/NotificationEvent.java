package com.itgorillaz.core.service;

public class NotificationEvent {

	private String name;
	private Object payload;
	private Object eventFilterAttributes;

	public NotificationEvent(String name, Object payload) {
		this.name = name;
		this.payload = payload;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public Object getEventFilterAttributes() {
		return eventFilterAttributes;
	}

	public void setEventFilterAttributes(Object eventFilterAttributes) {
		this.eventFilterAttributes = eventFilterAttributes;
	}

}
