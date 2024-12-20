package bank.regional.app.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}
	
	public Optional<Account> getAccount(int id) {
		return accountRepository.findById(id);
	}
	
	public List<Account> getAccounts() {
		return (List<Account>) accountRepository.findAll();
	}
	
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
	}
}
