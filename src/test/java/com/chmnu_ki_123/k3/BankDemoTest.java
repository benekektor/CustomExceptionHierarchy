package com.chmnu_ki_123.k3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankDemoTest {
    private CheckingAccount account;

    @Test
    public void testDeposit() {
        account = new CheckingAccount(101);
        account.deposit(500.00);
        assertEquals(500.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawSuccess() {
        account = new CheckingAccount(101);
        account.deposit(500.00);
        account.withdraw(100.00);
        assertEquals(400.00, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawFailure() {
        account = new CheckingAccount(101);
        account.deposit(500.00);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(600.00));
    }

    @Test
    public void testInsufficientFundsException() {
        account = new CheckingAccount(101);
        account.deposit(500.00);
        try {
            account.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            assertEquals(100.00, e.getAmount(), 0.01);
        }
    }
}
