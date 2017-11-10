package com.roverandfriends.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roverandfriends.model.CalendarEvent;
import com.roverandfriends.service.CalendarEventService;


@Controller
@SessionAttributes({"name" ,"user"})
public class CalendarEventController {

	@Autowired
	private CalendarEventService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-calendarEvents", method = RequestMethod.GET)
	public String showCalendarEventsList(ModelMap model) {
		String user = (String) model.get("name");
		System.out.println();
		model.addAttribute("calendarEvents", service.retrieveCalendarEvents(user));
		return "list-calendarEvents";
	}

	@RequestMapping(value = "/add-calendarEvent", method = RequestMethod.GET)
	public String showAddCalendarEventPage(ModelMap model) {
		model.addAttribute("calendarEvent", new CalendarEvent());
		return "calendarEvent";
	}

	@RequestMapping(value = "/add-calendarEvent", method = RequestMethod.POST)
	public String addCalendarEvent(ModelMap model, @Valid CalendarEvent calendarEvent, BindingResult result) {

		if (result.hasErrors())
			return "calendarEvent";

		service.addCalendarEvent((String) model.get("name"), calendarEvent.getDesc(), new Date(),
				false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-calendarEvents";
	}

	@RequestMapping(value = "/update-calendarEvent", method = RequestMethod.GET)
	public String showUpdateCalendarEventPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("calendarEvent", service.retrieveCalendarEvent(id));
		return "calendarEvent";
	}

	@RequestMapping(value = "/update-calendarEvent", method = RequestMethod.POST)
	public String updateCalendarEvent(ModelMap model, @Valid CalendarEvent calendarEvent,
			BindingResult result) {
		if (result.hasErrors())
			return "calendarEvent";

		calendarEvent.setUser("Jorge Benavides"); //CalendarEvent:Remove Hardcoding Later
		service.updateCalendarEvent(calendarEvent);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-calendarEvents";
	}

	@RequestMapping(value = "/delete-calendarEvent", method = RequestMethod.GET)
	public String deleteCalendarEvent(@RequestParam int id) {
		service.deleteCalendarEvent(id);

		return "redirect:/list-calendarEvents";
	}

}