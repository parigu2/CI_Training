package ci.training.repo;

import ci.training.beans.Customer;

public class WalletRepoTemp implements WalletRepo {

	public boolean save(Customer c) {
		return c instanceof Customer;
	}

	public Customer find(String phoneNumber) {
		return null;
	}

}
