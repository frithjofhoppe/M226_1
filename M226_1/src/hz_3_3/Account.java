package hz_3_3;

/**
 * A bank account used to place money
 * @author Philippe Krüttli
 *
 */
public class Account
{
	private double balance = 0; // Current amount of money on the account
	private double interestRate = 1; // The percentage value of the interest
	private Client depositor;

	/**
	 * Create a new account and set its balance
	 * @param balance: the balance to set initially for the account
	 */
	public Account(double balance)
	{
		this.balance = balance;
	}

	/**
	 * Create a new account and set its balance and depositor
	 * @param balance: the balance to set initially for the account
	 * @param depositor: the owner of the account
	 */
	public Account(double balance, Client depositor) {
		this.balance = balance;
		this.depositor = depositor;
	}

	/**
	 * Create a new account and set its balance and depositor
	 * @param balance: the balance to set initially for the account
	 * @param firstName: the first name of the owner of the account
	 * @param lastName: the last name of the owner of the account
	 * @param clientNr: the client number of the owner of the account
	 */
	public Account(double balance, String firstName, String lastName, int clientNr) {
		this.balance = balance;
		this.depositor = new Client(firstName,lastName,clientNr);
	}

	/**
	 * Create a new account and set its balance and interest rate
	 * @param balance: the balance to set initially for the account
	 * @param interestRate: the interest rate to set initially for the account
	 */
	public Account(double balance, double interestRate)
	{
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	/**
	 * Get the current balance of the account
	 * @return: current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Get the owner of the account
	 * @return: owner of the account as Client-object
	 */
	public Client getDepositor() {
		return depositor;
	}

	/**
	 * Get the current interest rate of the account
	 * @return: interest rate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * Deposit a specified amount of money on the account
	 * @param value: amount of money to deposit on the account
	 */
	public void deposit(double value)
	{
		if(value <= 2000)
		{
			balance+=value;
		}
	}
	
	/**
	 * Withdraw a specified amount of money from the account
	 * @param value: amount of money to withdraw from the account
	 */
	public void withdrawMoney(double value)
	{
		if(value <= balance)
		{
			balance -= value;
		}
	}
	
	/**
	 * Pay interest on that account for a specified amount of days
	 * Calculating like: balance * interest rate * (days/365 days)
	 * @param days: amount of days to pay interest for
	 */
	public void payInterest(double days)
	{
		double interest = balance * interestRate * (days/365);
		balance += interest;
	}
}
