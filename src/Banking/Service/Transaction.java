package Banking.Service;

public abstract class Transaction {
    protected abstract void deposit(double amount);
    protected abstract void withdraw(double amount);
}
