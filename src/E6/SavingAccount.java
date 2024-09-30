package E6;

public class SavingAccount extends BankAccount {
    public SavingAccount() {};
    public double oddNumber = 0.00001;
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        System.out.println("Deposit of $"+amount+" successfull Current balance : $"+super.getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (super.getBalance() - amount >= oddNumber) {
            super.setBalance(super.getBalance() - amount);
            System.out.println("Withdraw of $" + amount + " successful. Current balance: $" + super.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed");
        }
    }


}
