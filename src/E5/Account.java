package E5;

public class Account extends Customer{
    private int ID;
    Customer customer;
    double balance = 0.0;
    public Account() {}
    public Account(int ID, Customer customer) {
        this.ID = ID;
        this.customer = customer;
    }
    public Account(int ID, Customer customer, double balance) {
        this.ID = ID;
        this.customer = customer;
        this.balance = balance;
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
                ", balance=" + balance +
                '}';
    }
}
