package bank.regional.app.accountmanager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountManagerRepository extends CrudRepository<AccountManager, Integer> {

}
