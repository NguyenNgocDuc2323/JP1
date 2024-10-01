package Banking.Controller;

import Banking.Account;
import Banking.Customer;
import Banking.Service.Transaction;

public class AccountController extends Transaction {
    public static Account account;
    public AccountController(Account account) {
        AccountController.account = account;
    }
    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }
    @Override
    public void withdraw(double amount) {
        if (account.getBalance() < amount) {
            System.out.println("Tài Khoản Của Bạn Không Đủ Số Dư!");
        }
        else {
            account.setBalance(account.getBalance() - amount);
        }
    }
}
