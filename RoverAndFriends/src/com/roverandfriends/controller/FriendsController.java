package com.roverandfriends.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.roverandfriends.model.Friends;
import com.roverandfriends.model.User;
import com.roverandfriends.service.FriendsListService;
import com.sun.istack.internal.logging.Logger;

@Controller
@SessionAttributes({"name" ,"user"})
public class FriendsController {

	final static Logger logger = Logger.getLogger(FriendsController.class);
	
	@Autowired
	private FriendsListService service;
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String showFriends(ModelMap model) {
		Object name = model.get("user");
		String userNameModel = service.getCurrentUserName((User) name);
		//logger.info("***********************Tetsing load frends page and getusername***********************" + userNameModel);
		model.addAttribute("CurrentUserName");
		//List<Friends> friendlistforiterator = service.retrieveFriendsList(userNameModel);
		service.printFriendsListWithIterator();
		
		model.addAttribute("friendsList", service.retrieveFriendsList(userNameModel));
		return "friends";
	}
	
	@RequestMapping(value = "/add-friends", method = RequestMethod.GET)
	public String addFriend(ModelMap model, @Valid Friends friends, BindingResult result, @RequestParam String friendnamename) {

		model.addAttribute("friendnamename", friendnamename);
		/*if (result.hasErrors())
			return "calendarEvent";*/
		Object name = model.get("user");
		String CurrentUserName = service.getCurrentUserName((User) name);
		logger.info("****************************print friends name " + model.get("friendnamename"));
		logger.info("****************************print users name" + CurrentUserName);
		service.addFriends(CurrentUserName, (String)model.get("friendnamename"));
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/friends";
	}
	

	@RequestMapping(value = "/delete-friends", method = RequestMethod.GET)
	public String deleteCalendarEvent(@RequestParam int id) {
		service.deleteFriends(id);

		return "redirect:/friends";
	}

}