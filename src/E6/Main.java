package E6;

public class Main {
    public static void main(String[] args) {
        double ibal,damt,wamt;
        ibal = 1000.00;
        SavingAccount savingAccount = new SavingAccount("SA001", ibal);
        System.out.println("Saving A/c : Initial Balance : $"+ibal);
        damt = 500.00;
        savingAccount.deposit(damt);
        wamt = 250.00;
        savingAccount.withdraw(wamt);
        wamt = 100.00;
        System.out.println("\nTry to withdraw : $"+wamt);
        savingAccount.withdraw(wamt);
        System.out.println("");
        ibal = 5000.00;
        CurrentAccount currentAccount = new CurrentAccount("CA001", ibal);
        System.out.println("Current A/c : Initial Balance : $"+ibal);
        damt = 2500.00;
        currentAccount.deposit(1000.0);
        wamt = 1250.00;
        currentAccount.withdraw(3000.0);
        wamt = 6000.00;
        System.out.println("\nTry to withdraw : $"+wamt);
        savingAccount.withdraw(wamt);
    }
}
