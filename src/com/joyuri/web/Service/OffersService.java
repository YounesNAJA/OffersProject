package com.joyuri.web.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}
}
