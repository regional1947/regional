package bank.regional.app.accountmanager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String accountManager;
	private String accountManagerContact;
	private String accountManagerEmail;
	private String accountType;
	private String accountLimit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	public String getAccountManagerContact() {
		return accountManagerContact;
	}
	public void setAccountManagerContact(String accountManagerContact) {
		this.accountManagerContact = accountManagerContact;
	}
	public String getAccountManagerEmail() {
		return accountManagerEmail;
	}
	public void setAccountManagerEmail(String accountManagerEmail) {
		this.accountManagerEmail = accountManagerEmail;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountLimit() {
		return accountLimit;
	}
	public void setAccountLimit(String accountLimit) {
		this.accountLimit = accountLimit;
	}
	
}
