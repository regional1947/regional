package bank.regional.app.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	public Optional<User> findByAccountNumberAndPassword(String accountNumber, String password);
	public Optional<User> findByAccountNumber(String accountNumber);

}
