package bank.regional.app.accountmanager;

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
public class AccountManagerController {

	@Autowired
	private AccountManagerService accountManagerService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/accountmanager")
	public AccountManager addAccountManager(@RequestBody AccountManager accountManager) {
		return accountManagerService.addAccountManager(accountManager);
	}
	
	@RequestMapping("/accountmanager/{id}")
	public Optional<AccountManager> getAccountManager(@PathVariable int id) {
		return accountManagerService.getAccountManager(id);
	}
	
	@RequestMapping("/accountmanagers")
	public List<AccountManager> getAccountManagers() {
		return accountManagerService.getAccountManagers();
	}
	
	@RequestMapping("/accountmanager/{id}/delete")
	public void deleteAccountManager(@PathVariable int id) {
		accountManagerService.deleteAccountManager(id);
	}
}
