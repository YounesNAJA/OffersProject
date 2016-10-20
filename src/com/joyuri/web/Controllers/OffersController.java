package com.joyuri.web.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joyuri.web.DAO.Offer;
import com.joyuri.web.Service.OffersService;

@Controller
public class OffersController {
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String home(Model model){
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping(value = "/createoffer")
	public String createOffer(Model model){
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result){
		if(result.hasErrors()){
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors){
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("offer", offer);
			return "createoffer";
		} else {
			return "docreate";
		}
	}
}
