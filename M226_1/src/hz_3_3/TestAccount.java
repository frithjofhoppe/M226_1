package hz_3_3;

public class TestAccount
{

	public static void main(String[] args)
	{
		Account k1 = new Account(500.75);
		k1.verzinsen(365);
		
		Account k2 = new Account(720.50);
		k2.verzinsen(750);
		System.out.println(k2.getSaldo());
		k2.einzahlen(200);
		System.out.println(k2.getSaldo());
	}

}
