package hz_3_3;

/**
 * A test class to test the functionality of the Account-class
 * @author Philippe Krüttli
 *
 */
public class TestAccount
{
	
	/**
	 * Main method where everything is done
	 * @param args: ignore
	 */
	public static void main(String[] args)
	{
		Account a1 = new Account(500.75); // Create new account with balance 500.75
		Account a2 = new Account(720.50); // Create new account with balance 720.50

		a1.payInterest(365); // Pay interest for 1 year
		a2.payInterest(750); // Pay interest for 750 days
		System.out.println("Balance of account 'a2' before deposit: \t" + a2.getBalance()); // Print out current balance of account a2

		a2.deposit(200); // Deposit value of 200 on account a2
		System.out.println("Balance of account 'a2' after deposit: \t\t" + a2.getBalance()); // Print out current balance of account a2
	}

}
