package com.roverandfriends.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


import com.roverandfriends.model.CalendarEvent;
import com.roverandfriends.model.User;
import com.sun.istack.internal.logging.Logger;

@Service
public class CalendarEventService {
	
	final static Logger logger = Logger.getLogger(CalendarEventService.class);
	
	private static List<CalendarEvent> calendarEvents = new ArrayList<CalendarEvent>();
	private static int calendarEventCount = 3;

	static {
		calendarEvents.add(new CalendarEvent(1, "Jorge Benavides", "test1", new Date(), false));
		calendarEvents.add(new CalendarEvent(2, "Jorge Benavides", "test2", new Date(), false));
		calendarEvents.add(new CalendarEvent(3, "Jorge Benavides", "test3", new Date(), false));
		logger.info("show calendar events after static" + calendarEvents);
	}

	public List<CalendarEvent> retrieveCalendarEvents(String user) {
		List<CalendarEvent> filteredCalendarEvents = new ArrayList<CalendarEvent>();
		for (CalendarEvent calendarEvent : calendarEvents) {
			if (calendarEvent.getUser().equals(user))
				filteredCalendarEvents.add(calendarEvent);
		}
		return filteredCalendarEvents;
	}
	
	public String getCurrentUserName(User user) {
		return user.getUserName();
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