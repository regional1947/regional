package bank.regional.app.creditdebit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditDebitTransactionService {

	@Autowired
	CreditDebitTransactionRepository creditDebitTransactionRepository;
	
	public CreditDebitTransaction addCreditDebitTransaction(CreditDebitTransaction creditDebitTransaction) {
		return creditDebitTransactionRepository.save(creditDebitTransaction);
	}
	
	public Optional<CreditDebitTransaction> getCreditDebitTransaction(int id) {
		return creditDebitTransactionRepository.findById(id);
	}
	
	public List<CreditDebitTransaction> getCreditDebitTransactions() {
		return (List<CreditDebitTransaction>) creditDebitTransactionRepository.findAll();
	}
	
	public void deleteCreditDebitTransaction(int id) {
		creditDebitTransactionRepository.deleteById(id);
	}
}
