package hz_3_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * These are all test for the Account-class.
 * There are good functionality tests, as well
 * as those which check if it does not yet work
 * as it should.
 */
public class AccountTest {
    Account account;

    @Before
    public void init() {
        account = new Account(0);
    }

    @Test
    public void depositMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
    }

    @Test
    public void depositNegativeMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(-20);
        Assert.assertEquals(account.getBalance(),-20,0); // Assert that case is not caught
    }

    @Test
    public void payInterestNoMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.payInterest(10);
        Assert.assertEquals(account.getBalance(),0,0);
    }

    @Test
    public void payInterestWithMoney() {
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
        account.payInterest(365);
        Assert.assertEquals(account.getBalance(),40,0);
    }

    @Test
    public void payInterestNegativeMoney() {
        account.deposit(-20);
        Assert.assertEquals(account.getBalance(),-20,0);
        account.payInterest(365);
        Assert.assertEquals(account.getBalance(),-40,0); // Assert that case is not caught
    }

    @Test
    public void payInterestNegativeDays() {
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
        account.payInterest(-365);
        Assert.assertEquals(account.getBalance(),0,0); // Assert that case is not caught
    }
}