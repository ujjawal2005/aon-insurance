package com.org.aon;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.org.aon.to.Customer;
import com.org.aon.to.Quotes;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InsuranceApp.class)
@WebAppConfiguration
public class InsuranceWebServiceTest {

	@Autowired
	private InsuranceService insuranceService;

	@Test
	public void shouldgetQuotesFromAllInsurers() {
		Customer customer = new Customer("2000", "Builder", 600000);
		List<Quotes> quotesList = insuranceService.getQuotes(customer);
		assertEquals(quotesList.size(), 4);
	}

	@Test
	public void shouldgetQuotesFromIns1AndIns2() {
		Customer customer = new Customer("2000", "Builder", 100000);
		List<Quotes> quotesList = insuranceService.getQuotes(customer);
		assertEquals(quotesList.size(), 2);
		List<Quotes> newQuotesList = quotesList.stream()
				.filter(quotes -> quotes.getName().equals("insurer1") || quotes.getName().equals("insurer2"))
				.collect(Collectors.toList());
		assertEquals(newQuotesList.size(), 2);
	}

	@Test
	public void shouldgetQuotesFromIns1AndIns2AndIns4() {
		Customer customer = new Customer("2000", "Plumber", 600000);
		List<Quotes> quotesList = insuranceService.getQuotes(customer);
		assertEquals(quotesList.size(), 3);
		List<Quotes> newQuotesList = quotesList.stream().filter(quotes -> quotes.getName().equals("insurer1")
				|| quotes.getName().equals("insurer2") || quotes.getName().equals("insurer4"))
				.collect(Collectors.toList());
		assertEquals(newQuotesList.size(), 3);
	}

	@Test
	public void shouldgetQuotesFromIns1AndIns3() {
		Customer customer = new Customer("2001", "Butcher", 300000);
		List<Quotes> quotesList = insuranceService.getQuotes(customer);
		assertEquals(quotesList.size(), 2);
		List<Quotes> newQuotesList = quotesList.stream()
				.filter(quotes -> quotes.getName().equals("insurer1") || quotes.getName().equals("insurer3"))
				.collect(Collectors.toList());
		assertEquals(newQuotesList.size(), 2);
	}

}
