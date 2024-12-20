package bank.regional.app.accountmanager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountManagerService {

	@Autowired
	private AccountManagerRepository accountManagerRepository;
	
	public AccountManager addAccountManager(AccountManager accountManager) {
		return accountManagerRepository.save(accountManager);
	}
	
	public Optional<AccountManager> getAccountManager(int id) {
		return accountManagerRepository.findById(id);
	}
	
	public List<AccountManager> getAccountManagers() {
		return (List<AccountManager>) accountManagerRepository.findAll();
	}
	
	public void deleteAccountManager(int id) {
		accountManagerRepository.deleteById(id);
	}
}
