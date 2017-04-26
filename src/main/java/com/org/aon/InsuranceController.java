package com.org.aon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.aon.to.Customer;
import com.org.aon.to.Quotes;

@RestController
public class InsuranceController {

	private static Logger log = LoggerFactory.getLogger(InsuranceController.class);

	private final InsuranceService insuranceService;

	@Autowired
	public InsuranceController(InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
	}

	@RequestMapping(value = "/quotes", method = RequestMethod.GET, produces = "application/json")
	public List<Quotes> getQuestions(@RequestParam(required = true) String postcode,
			@RequestParam(required = true) String occupation, @RequestParam(required = true) int turnover) {

		Customer customer = new Customer(postcode, occupation, turnover);
		log.debug("insurance quote request received for: " + customer);
		List<Quotes> quotes = insuranceService.getQuotes(customer);
		return quotes;
	}
}
