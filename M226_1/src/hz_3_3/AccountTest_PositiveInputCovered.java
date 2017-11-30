package hz_3_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * These are all test that use input parameters to show,
 * which functionalities are fully implemented.
 * These values should (in real life) give another output,
 * or even throw an exception.
 */
public class AccountTest_PositiveInputCovered {
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
        account.deposit(2200);
        Assert.assertEquals(account.getBalance(),0,0);
    }

    @Test
    public void depositNoMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.deposit(0);
        Assert.assertEquals(account.getBalance(),0,0); // This is no error, because it could happen
    }

    @Test
    public void payInterestNoMoney() {
        Assert.assertEquals(account.getBalance(),0,0);
        account.payInterest(10);
        Assert.assertEquals(account.getBalance(),0,0); // This is no error, because it could happen
    }

    @Test
    public void payInterestWithMoney() {
        account.deposit(20);
        Assert.assertEquals(account.getBalance(),20,0);
        account.payInterest(365);
        Assert.assertEquals(account.getBalance(),40,0);
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
        account.withdrawMoney(300);
        Assert.assertEquals(account.getBalance(),200,0);
    }
}
