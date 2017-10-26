package hz_3_3;

public class Account
{
	private double saldo = 0;
	private double zinssatz = 1;
	
	Account(double saldo)
	{
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void einzahlen(double wert)
	{
		saldo+=wert;
	}
	
	public void verzinsen(double tag)
	{
		double zins = saldo * zinssatz * (tag/365);
		saldo += zins;
	}
}
