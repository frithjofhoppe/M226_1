package hz_3_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account;

    @Before
    public void init() {
        account = new Account(0);
    }

    @Test
    public void deposit() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
    }

    @Test
    public void payInterest() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.payInterest(10);
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
        account.payInterest(365);
        Assert.assertEquals(account.getBalance(),40,0);
    }
}