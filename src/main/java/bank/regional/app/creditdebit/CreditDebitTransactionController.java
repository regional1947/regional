package bank.regional.app.creditdebit;

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
public class CreditDebitTransactionController {

	@Autowired
	private CreditDebitTransactionService creditDebitTransactionService;
	
	@RequestMapping(method = RequestMethod.POST, value= "/creditdebittransaction")
	public CreditDebitTransaction addCreditDebitTransaction(@RequestBody CreditDebitTransaction creditDebitTransaction) {
		return creditDebitTransactionService.addCreditDebitTransaction(creditDebitTransaction);
	}
	
	@RequestMapping("/creditdebittransaction/{id}")
	public Optional<CreditDebitTransaction> getCreditDebitTransaction(@PathVariable int id) {
		return creditDebitTransactionService.getCreditDebitTransaction(id);
	}
	
	@RequestMapping("/creditdebittransactions")
	public List<CreditDebitTransaction> getCreditDebitTransactions() {
		return creditDebitTransactionService.getCreditDebitTransactions();
	}
	@RequestMapping("/creditdebittransaction/{id}/delete")
	public void deleteCreditDebitTransaction(@PathVariable int id) {
		creditDebitTransactionService.deleteCreditDebitTransaction(id);
	}
}
