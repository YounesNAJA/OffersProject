package com.joyuri.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.joyuri.web.DAO.Offer;
import com.joyuri.web.DAO.OfferDAO;

@Service("offersService")
public class OffersService {
	private OfferDAO offersDao;

	@Autowired
	public void setOffersDao(OfferDAO offersDao) {
		this.offersDao = offersDao;
	}

	/* ============================================================
	 * Getting All offers available in the database using DAO layer
	============================================================ */
	public List<Offer> getCurrents() {
		return offersDao.getOffers();
	}
	
	/* ====================
	 * Creating a new offer
	==================== */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public boolean create(Offer offer) {
		return offersDao.create(offer);
	}
}
