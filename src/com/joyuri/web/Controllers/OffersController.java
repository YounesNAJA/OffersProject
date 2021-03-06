package com.joyuri.web.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.joyuri.web.DAO.Offer;
import com.joyuri.web.Service.OffersService;

@Controller
public class OffersController {
	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	/*
	 * ============================================ Showing all offers available
	 * in the database ===========================================
	 */
	@RequestMapping("/offers")
	public String home(Model model) {

		// Getting all the offers from the service layer
		List<Offer> offers = offersService.getCurrents();

		// Setting the model with a list of all offers
		model.addAttribute("offers", offers);
		return "offers";
	}

	/*
	 * ======================= Create a new offer form ======================
	 */
	@RequestMapping(value = "/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}

	/*
	 * ===================================
	 * After submitting a new offer's form
	 * ==================================
	 */
	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

		// If the form has errors on it
		if (result.hasErrors()) {
			model.addAttribute("offer", offer);
			return "createoffer";
		}

		// If the form is validated
		else {
			// Adding the offer to the Database
			offersService.create(offer);
			return "docreate";
		}
	}

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String api(Model model) {
		// Getting all the offers from the service layer
		List<Offer> offers = offersService.getCurrents();

		String offersJSON = new Gson().toJson(offers);
		// Setting the model with a list of all offers
		model.addAttribute("offers", offersJSON);
		return "api";
	}
}
