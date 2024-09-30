package Entiy;

public class Account extends Customer{
    private int ID;
    Customer customer;
    private double balance = 0.0;
    private String accountName;
    public Account() {}
    public Account(int ID, Customer customer) {
        this.ID = ID;
        this.customer = customer;
    }
    public Account(int ID, Customer customer, double balance,String accountName) {
        this.ID = ID;
        this.customer = customer;
        this.balance = balance;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", customer=" + customer +
                ", balance=" + String.format("%.2f", balance) +
                ", accountName='" + accountName + '\'' +
                '}';
    }

}
