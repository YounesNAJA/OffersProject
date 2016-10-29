package com.joyuri.web.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joyuri.web.DAO.User;
import com.joyuri.web.Service.UsersService;

@Controller
public class LoginController {
	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/newuser")
	public String newuser(Model model) {
		model.addAttribute("user", new User());
		return "newuser";
	}

	@RequestMapping("/createuser")
	public String usercreated() {
		return "usercreated";
	}
	
	/* ===================================
	 * After submitting a new user's form
	 ================================== */
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String usercreated(Model model, @Valid User user, BindingResult result){
		
		// If the form has errors on it
		if(result.hasErrors()){
			model.addAttribute("user", user);
			return "newuser";
		}
		
		// If the form is validated
		else {
			// Adding the user to the Database
			user.setAuthority("admin");
			user.setEnabled(true);
			
			if(usersService.exists(user.getUsername())){
				result.rejectValue("username", "DuplicateKey.user.username");
				return "newuser";
			}
			
			try {
				usersService.create(user);
			} catch (Exception e) {
				System.out.println("Error");
			}
			
			return "usercreated";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "logout";
	}
}
