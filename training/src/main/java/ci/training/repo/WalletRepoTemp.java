package ci.training.repo;

import ci.training.beans.Customer;

public class WalletRepoTemp implements WalletRepo {

	public boolean save(Customer c) {
		if(c != null) {
			return true;
		}
		return false;
	}

	public Customer find(String phoneNumber) {
		return null;
	}

}