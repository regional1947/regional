package bank.regional.app.creditdebit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditDebitTransactionRepository extends CrudRepository<CreditDebitTransaction, Integer> {

}
