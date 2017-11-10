package com.roverandfriends.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roverandfriends.model.CalendarEvent;

@Service
public class CalendarEventService {
	private static List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
	private static int calendarEventCount = 3;

	static {
		calendarEvents.add(new CalendarEvent(1, "Jorge Benavides", "test1", new Date(), false));
		calendarEvents.add(new CalendarEvent(2, "Jorge Benavides", "test2", new Date(), false));
		calendarEvents.add(new CalendarEvent(3, "Jorge Benavides", "test3", new Date(), false));
	}

	public List<CalendarEvent> retrieveCalendarEvents(String user) {
		List<CalendarEvent> filteredCalendarEvents = new ArrayList<CalendarEvent>();
		for (CalendarEvent calendarEvent : calendarEvents) {
			if (calendarEvent.getUser().equals(user))
				filteredCalendarEvents.add(calendarEvent);
		}
		return filteredCalendarEvents;
	}

	public CalendarEvent retrieveCalendarEvent(int id) {
		for (CalendarEvent calendarEvent : calendarEvents) {
			if (calendarEvent.getId() == id)
				return calendarEvent;
		}
		return null;
	}

	public void updateCalendarEvent(CalendarEvent calendarEvent) {
		calendarEvents.remove(calendarEvent);
		calendarEvents.add(calendarEvent);
	}

	public void addCalendarEvent(String name, String desc, Date targetDate, boolean isDone) {
		calendarEvents.add(new CalendarEvent(++calendarEventCount, name, desc, targetDate, isDone));
	}

	public void deleteCalendarEvent(int id) {
		Iterator<CalendarEvent> iterator = calendarEvents.iterator();
		while (iterator.hasNext()) {
			CalendarEvent calendarEvent = iterator.next();
			if (calendarEvent.getId() == id) {
				iterator.remove();
			}
		}
	}
}