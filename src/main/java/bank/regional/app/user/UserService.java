package bank.regional.app.user;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.regional.app.account.Account;
import bank.regional.app.account.AccountService;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountService accountService;

	public User addUser(User user) {
		user.setAccountNumber(generateAccount());
		int accountId = accountService.addAccount(new Account()).getId();
		user.getAccount().setId(accountId);
		
		return userRepository.save(user);
	}
	
	public Optional<User> getUserByAccountNumber(String accountNumber) {
		return userRepository.findByAccountNumber(accountNumber);
	}
	
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	public void deleteUser(String accountNumber) {
		userRepository.deleteById(accountNumber);
	}
	
	public User signIn(User user) {
		Optional<User> user2 = userRepository.findByAccountNumberAndPassword(user.getAccountNumber(), user.getPassword());
		if(user2.isPresent()) {
			user2.get().setIp(user.getIp());
			user2.get().setDate(user.getDate());
			userRepository.save(user2.get());
			return user2.get();
		}
		return new User();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String generateAccount() {
		Random random = new Random();
        StringBuilder concatenatedNumbers = new StringBuilder("660");

        for (int i = 0; i < 7; i++) {
            int number = random.nextInt(10); // Generates a digit between 0-9
            concatenatedNumbers.append(number);
        }

        return concatenatedNumbers.toString();

	}
}
