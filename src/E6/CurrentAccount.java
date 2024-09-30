package E6;

public class CurrentAccount extends  BankAccount{

    public CurrentAccount() {}
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        System.out.println("Deposit of $"+amount+" successfull Current balance : $"+super.getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if(super.getBalance() >= amount) {
            super.setBalance(super.getBalance() - amount);
            System.out.println("Withdraw of $"+amount+" successfull Current balance : $"+super.getBalance());
        }
        else{
            System.out.println("Insufficient funds.Withdrawal failed");
        }
    }
}
