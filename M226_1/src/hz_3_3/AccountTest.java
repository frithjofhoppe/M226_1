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
        account.deposit(2000);
        Assert.assertEquals(account.getBalance(),2000,0);
    }

    @Test
    public void depositToMuchMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(2001);
        Assert.assertEquals(account.getBalance(),0,0);
    }

    @Test
    public void depositNoMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(0);
        Assert.assertEquals(account.getBalance(),0,0); // This is no error, because it could happen
    }

    @Test
    public void depositNegativeMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(-20);
        Assert.assertEquals(account.getBalance(),-20,0); // Assert that case is not covered
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
        Assert.assertEquals(account.getBalance(),-40,0); // Assert that case is not covered
    }

    @Test
    public void payInterestNegativeDays() {
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
        account.payInterest(-365);
        Assert.assertEquals(account.getBalance(),0,0); // Assert that case is not covered
    }

    @Test
    public void withdrawMoney() {
        account.deposit(200);
        Assert.assertEquals(account.getBalance(),200,0);
        account.withdrawMoney(100);
        Assert.assertEquals(account.getBalance(),100,0);
    }

    @Test
    public void withdrawToMuchMoney() {
        account.deposit(200);
        Assert.assertEquals(account.getBalance(),200,0);
        account.withdrawMoney(201);
        Assert.assertEquals(account.getBalance(),200,0);
    }
}