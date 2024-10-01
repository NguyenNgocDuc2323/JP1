package Banking;

import Banking.Controller.AccountController;
import Banking.Service.ValidateData;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Duc", Gender.M, "Thanh Hoa", "0886189630", "nguyenngocduc332@gmail.com"));
        customers.add(new Customer(2, "Nam", Gender.M, "Ha Noi", "123456789", "lebanam@gmail.com"));
        customers.add(new Customer(3, "Ngoc", Gender.M, "HCM", "0234432423", "nguyenhongngoc@gmail.com"));

        Account account = new Account("1234", customers.get(0), 2000);
        AccountController accController = new AccountController(account);
        ValidateData validate = new ValidateData(account);

        Scanner sc = new Scanner(System.in);
        double amount = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("\nNhập Số Tiền : ");
            String input = sc.nextLine();
            amount = validate.validateAmount(account, input);
            if (amount > 0) {
                valid = true;
            }
        }
        accController.deposit(amount);
        System.out.println(account);
        accController.withdraw(amount);
        System.out.println(account);
    }
}
