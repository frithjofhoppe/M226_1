package hz_3_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * These are all test that use input parameters to show,
 * that the program is not yet fully implemented.
 * These values should (in real life) give another output,
 * or even throw an exception.
 */
public class AccountTest_NegativeInputNotCovered {
        Account account;

        @Before
        public void init() {
            account = new Account(0);
        }

        @Test
        public void depositNegativeMoney() {
            Assert.assertEquals(account.getBalance(),0,0);
            account.deposit(-20);
            Assert.assertEquals(account.getBalance(),-20,0); // Assert that case is not covered
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
            Assert.assertEquals(account.getBalance(), 20, 0);
            account.payInterest(-365);
            Assert.assertEquals(account.getBalance(), 0, 0); // Assert that case is not covered
        }
}
