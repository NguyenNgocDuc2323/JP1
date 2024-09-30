package AccountController;

import Entiy.Account;

import java.util.List;
import java.util.Optional;

public class AccountController {
    private List<Account> accounts;
    public AccountController(List<Account> accounts) {
        this.accounts = accounts;
    }
    public String getCustomerName(String name) {
        Optional<Account> filterCus =  accounts.stream()
                .filter(account -> account.getCustomer().getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();
        return filterCus.get().getCustomer().getName();
    }
    public void withdraw(double amount,String accountName) {
        Optional<Account> withdrawAccount =  accounts.stream()
                .filter(account -> account.getAccountName().toLowerCase().equals(accountName.toLowerCase()))
                .findFirst();
        if(withdrawAccount.isPresent()) {
            Account account = withdrawAccount.get();
            if(account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                System.out.println("Bạn Đã Rút Thành Công!");
            }
            else{
                System.out.println("Số tiền trong tài khoản không đủ!");
            }
        }
    }
    public void deposit(String accountName,double amount) {
        Optional<Account> withdrawAccount =  accounts.stream()
                .filter(account -> account.getAccountName().toLowerCase().equals(accountName.toLowerCase()))
                .findFirst();
        if(withdrawAccount.isPresent()) {
            Account account = withdrawAccount.get();
            account.setBalance(account.getBalance() + amount);
            System.out.println("Bạn Đã Nạp Tiền Thành Công!");
        }
    }
    public Optional<Account> getAccountById(int id) {
        return accounts.stream()
                .filter(account -> account.getID() == id)
                .findFirst();
    }
    public List<Account> getAccountByName(String name) {
        return accounts.stream()
                .filter(account -> account.getAccountName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
