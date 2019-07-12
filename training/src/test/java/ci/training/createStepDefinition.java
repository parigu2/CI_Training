package ci.training;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import ci.training.beans.Customer;
import ci.training.beans.Wallet;
import ci.training.repo.WalletRepoTemp;
import ci.training.service.WalletService;
import ci.training.service.WalletServiceImpl;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createStepDefinition {
	
	private WalletService service;
	private Customer customer;
	private Customer createCustomer;
	private WalletRepoTemp repo = new WalletRepoTemp();
	
	@Before
	public void init(){	
		MockitoAnnotations.initMocks(this);
		service = new WalletServiceImpl(repo);
	}
	
	@Given("^I have a customer$")
	public void i_have_a_customer() throws Throwable {
	    customer = new Customer("AAA", "9850276767", new Wallet(new BigDecimal(400)));
	}

	@When("^I save a new customer \"([^\"]*)\" \"([^\"]*)\" and (\\d+)$")
	public void i_save_a_new_customer(String name, String phoneNumber, int balance) throws Throwable {
		createCustomer = new Customer(name, phoneNumber, new Wallet(new BigDecimal(balance)));
		assertThat(repo.save(customer)).isEqualTo(true);
	}

	@Then("^I should get customer$")
	public void i_should_get_customer() throws Throwable {
		service = new WalletServiceImpl(repo);
		assertEquals(customer, service.createWallet("AAA", "9850276767", new BigDecimal(400)));
		assertEquals(customer, createCustomer);
	}
}
