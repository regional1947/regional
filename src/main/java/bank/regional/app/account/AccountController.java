package bank.regional.app.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.POST, value="/account")
	public Account addAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}
	
	@RequestMapping("/account/{id}")
	public Optional<Account> getAccount(@PathVariable int id) {
		return accountService.getAccount(id);
	}
	
	@RequestMapping("/accounts")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}
	
	@RequestMapping("/account/{id}/delete")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}
}
