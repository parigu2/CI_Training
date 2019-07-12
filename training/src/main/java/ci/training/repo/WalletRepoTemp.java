package ci.training.repo;

import java.util.ArrayList;
import java.util.List;

import ci.training.beans.Customer;

public class WalletRepoTemp implements WalletRepo {
	
	public List<Customer> customerDB = new ArrayList<Customer>();

	public boolean save(Customer c) {
		return customerDB.add(c);
	}

	public Customer find(String phoneNumber) {
		return null;
	}

}
