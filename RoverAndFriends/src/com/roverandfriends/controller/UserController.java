package com.roverandfriends.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.roverandfriends.model.AddToCart;
import com.roverandfriends.model.ExecuteCommand;
import com.roverandfriends.model.Getshoppingcart;
import com.roverandfriends.model.RemoveFromCart;
import com.roverandfriends.model.ShoppingCart;
import com.roverandfriends.model.User;
import com.roverandfriends.model.UserLoginCredential;
import com.roverandfriends.service.UserService;
import com.sun.istack.internal.logging.Logger;

@Controller
@SessionAttributes({"user", "userNameModel", "cart"})
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	@RequestMapping(value = { "/buy-pet-tag" }, method = RequestMethod.GET)
	public ModelAndView showBuyPetTag(ModelMap model) {
		ShoppingCart newCart = Getshoppingcart.getShoppingCart();
		AddToCart addCommand = new AddToCart(newCart);
		ExecuteCommand onexcute = new ExecuteCommand(addCommand);
		ModelAndView modelAndView = new ModelAndView("buy-pet-tag");
		//modelAndView.addObject("cart", newCart.getItem_number());
		modelAndView.addObject("cart", newCart);
		logger.info("******************************************"+ "get item number" + newCart.getItem_number());
		logger.info("******************************************"+ "get item number" + newCart);
		onexcute.E_excute();
		onexcute.E_undo();
		onexcute.E_excute();
		onexcute.E_excute();
		onexcute.E_undo();
		RemoveFromCart removeCommand = new RemoveFromCart(newCart);
		ExecuteCommand R_execute = new ExecuteCommand(removeCommand);
		R_execute.E_excute();
		R_execute.E_undo();
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = { "/find-pet-sitter" }, method = RequestMethod.GET)
	public ModelAndView addShowFindPetSitterPage(){
		 ModelAndView modelAndView = new ModelAndView("find-pet-sitter");
		 List<User> userList = userService.getDogSitters();
		 modelAndView.addObject("userList", userList);
		 return modelAndView;
	}	
	
	
	@RequestMapping(value = { "/pet-store-locator" }, method = RequestMethod.GET)
	public String showPetStoreLocator(ModelMap model) {
		return "pet-store-locator";
	}
	
	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public String showProfile(ModelMap model) {
		//Object name = model.get("user");
		//String userName = userService.getUserName((User) name);
		//logger.info("***********************this is what is returned from model user input " + name);
		//logger.info("***********************this is what is returned from model user input " + userName);
		return "profile";
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showWelcome(ModelMap model) {
		return "welcome";
	}
	
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("userLoginCredential", new UserLoginCredential());
		
		return "login";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value ="/addFriends" ,method=RequestMethod.GET)
	public ModelAndView addFriendsPage(){
		 ModelAndView modelAndView = new ModelAndView("addFriends");
		 List<User> userList = userService.getUserList();
		 modelAndView.addObject("userList", userList);
		 return modelAndView;
	}	
	
	@RequestMapping(value ="/home" ,method=RequestMethod.GET)
	public ModelAndView showHomePage(ModelMap model){
		//logger.info("****************************" userService.g);
		ModelAndView modelAndView = new ModelAndView("home");
		Object name = model.get("user");
		String userNameModel = userService.getUserName((User) name);
		
		model.addAttribute("userNameModel", userNameModel);
		 return modelAndView;
	}
	
	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("user") User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getUserService().registerUser(user);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("userLoginCredential") UserLoginCredential userLoginCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("home");
		User user = getUserService().validateUserCredential(userLoginCredential.getEmail(), userLoginCredential.getPassword());
		

		if(user!= null){
			modelAndView.addObject("user", user);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;

	

	}
	

	@RequestMapping(value ="/deleteAccount" ,method=RequestMethod.POST)
	public ModelAndView unregisterSuccess(@Valid @ModelAttribute("user") User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("home");
		}
		int newuser = user.getId();
		String name = user.getUserName();
		System.out.println("Testing to find this fucking user id" + newuser + name);
		getUserService().registerUser(user);
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	
	@RequestMapping(value ="/changeDogSittingStatusToTrue" ,method=RequestMethod.GET)
	public String showUpdatedHomePage(ModelMap model){
		//logger.info("****************************" userService.g)
		
		User name =(User) model.get("user");
		userService.updateUserDogSitterStatusToTrue(name);
		
		logger.info("******************************************" + name);
		 return "home";
	}
	
	@RequestMapping(value ="/changeDogSittingStatusToFalse" ,method=RequestMethod.GET)
	public String showUpdatedHomePageFalse(ModelMap model){
		//logger.info("****************************" userService.g)
		
		User name =(User) model.get("user");
		userService.updateUserDogSitterStatusToFalse(name);
		
		logger.info("******************************************" + name);
		 return "home";
	}
	
	@RequestMapping(value ="/addPettag" ,method=RequestMethod.GET)
	public String showAddBuyPetTagPage(ModelMap model){
		//logger.info("****************************" userService.g)
		ShoppingCart newCart = Getshoppingcart.getShoppingCart();
		AddToCart addCommand = new AddToCart((ShoppingCart) model.get("cart"));
		ExecuteCommand onexcute = new ExecuteCommand(addCommand);
		
		onexcute.E_excute();
		//onexcute.E_undo();
		
		//logger.info("******************************************" + name);
		 return "buy-pet-tag";
	}
	
	@RequestMapping(value ="/deletePettag" ,method=RequestMethod.GET)
	public String showDeleteBuyPetTagPage(ModelMap model){
		
		ShoppingCart newCart = Getshoppingcart.getShoppingCart();
		AddToCart addCommand = new AddToCart((ShoppingCart) model.get("cart"));
		ExecuteCommand onexcute = new ExecuteCommand(addCommand);
		
		//onexcute.E_excute();
		onexcute.E_undo();
		
		 return "buy-pet-tag";
	}
	
	@RequestMapping(value ="/returnHome", method=RequestMethod.GET)
	public String returnHome(ModelMap model) {
		return "home";
	}
	
}
