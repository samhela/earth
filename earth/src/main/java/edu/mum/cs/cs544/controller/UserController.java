package edu.mum.cs.cs544.controller;

import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.model.UserProfile;
import edu.mum.cs.cs544.service.UserProfileService;
import edu.mum.cs.cs544.service.UserService;
import edu.mum.cs.cs544.ws.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes("roles")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/user/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		System.out.println("The list of users are : " + users.size());
		return "user/userslist";
	}
	
	@RequestMapping(value = {"/user/attendance" })
	public String userAttendance(ModelMap model) {
		List<User> users = userService.findAllUsers();
			System.out.println("The user attendance: " + users.size());
		return "user/attendance";
	}


	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);		
		model.addAttribute("loggedinuser", getPrincipal());
		return "user/signUp";
	}

	@RequestMapping(value = "/user/userGrid", method = RequestMethod.GET, produces = {"application/json"})
	@ResponseBody
	public UserResponse listUsers() {

		List<User> users = this.userService.findAllUsers();
		UserResponse response = new UserResponse();

		response.setRows(users);
		return response;
	}


	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "user/signUp";
		}

		if(!userService.isUserNameUnique(user.getId(), user.getUserName())){
			FieldError userNameError =new FieldError("user","userName",messageSource.getMessage("non.unique.userName", new String[]{user.getUserName()}, Locale.getDefault()));
		    result.addError(userNameError);
			return "user/signUp";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());		
		return "user/listUser";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{userName}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String userName, ModelMap model) {
		User user = userService.findByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "user/signUp";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{userName}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String userName) {

		if (result.hasErrors()) {
			return "user/signUp";
		}

		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "user/listUser";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{userName}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String userName) {
		userService.deleteUserByUserName(userName);
		return "redirect:/user/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		System.out.println("****************User profiles called *******************************");
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "user/accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		
		System.out.println("*****************************LOGIN CALED********************");
		if (isCurrentAuthenticationAnonymous()) {
			System.out.println("*****************************Anonymous********************");
			return "index";
	    } else {
	    	System.out.println("*****************************Redirected to USER Dashboard********************");
	    	return "redirect:/admin/adminDashboard";
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();

		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}

	@RequestMapping("/")
	public String indexHome(Model model){
		//Filter attendace of user from the username, considering username = barcode 
		model.addAttribute("loggedinuser", getPrincipal());
		//if a user has a role admin

		//if not it will return  another
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println("Controller is called");
		return "admin/adminDashboard";
	}

}