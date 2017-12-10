
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
import com.roverandfriends.model.User;
import com.roverandfriends.service.CalendarEventService;
import com.sun.istack.internal.logging.Logger;



@Controller
@SessionAttributes({"name" ,"user"})
public class CalendarEventController {

	final static Logger logger = Logger.getLogger(CalendarEventController.class);
	
	@Autowired
	private CalendarEventService service;
	/*adding a comment*/

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value = "/list-calendarEvents", method = RequestMethod.GET)
	public String showCalendarEventsList(ModelMap model) {
		Object name = model.get("user");
		String userNameModel = service.getCurrentUserName((User) name);
		//logger.info("***********************Tetsing load calendar page and getusername***********************" + userNameModel);
		model.addAttribute("CurrentUserName");
		model.addAttribute("calendarEvents", service.retrieveCalendarEvents(userNameModel));
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
		Object name = model.get("user");
		String CurrentUserName = service.getCurrentUserName((User) name);
		service.addCalendarEvent(CurrentUserName, calendarEvent.getDesc(), new Date(),
				false);
		model.clear();
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

		Object name = model.get("user");
		String CurrentUserName = service.getCurrentUserName((User) name);
		calendarEvent.setUser(CurrentUserName); 
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