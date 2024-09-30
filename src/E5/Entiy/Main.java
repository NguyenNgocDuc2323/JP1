package Entiy;

import AccountController.AccountController;
import InvoiceController.InvoiceController;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Account> accounts = new ArrayList<Account>();
        List<Invoice> invoices = new ArrayList<Invoice>();

        customers.add(new Customer(1,"Nguyen Ngoc Duc",Gender.M,5));
        customers.add(new Customer(2,"Nguyen Thi Phuong",Gender.F,10));
        customers.add(new Customer(3,"Le Thi Dau",Gender.F,15));

        accounts.add(new Account(1,customers.get(0),1000,"Nguyen Ngoc Duc"));
        accounts.add(new Account(2,customers.get(1),1500,"Nguyen Thi Phuong"));
        accounts.add(new Account(3,customers.get(2),2000,"Le Thi Dau"));

        invoices.add(new Invoice(1,100,customers.get(0), LocalDate.of(2024,6,20)));
        invoices.add(new Invoice(2,1500,customers.get(1), LocalDate.of(2024,8,12)));
        invoices.add(new Invoice(3,2000,customers.get(2), LocalDate.of(2024,8,5)));

        AccountController ac = new AccountController(accounts);
        InvoiceController iv = new InvoiceController(invoices);
        Scanner scanner= new Scanner(System.in);
        System.out.println("Sort Customer By Name : ");
        customers.stream()
                        .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);
        System.out.println("Sort Customer By Account : ");
        accounts.stream()
                .sorted(Comparator.comparing(account -> account.getBalance()))
                .forEach(System.out::println);

        System.out.println("Sort Customer By Invoice : ");
        invoices.stream()
                .sorted(Comparator.comparing(invoice -> invoice.getAmount()))
                .forEach(System.out::println);

        System.out.print("\nInput Account ID : ");
        int accoutId = scanner.nextInt();
        Optional<Account> getAccById =  ac.getAccountById(accoutId);
        System.out.println(getAccById);
        scanner.nextLine();
        System.out.print("\nInput Account Name : ");
        String accountName = scanner.nextLine();
        List<Account> getAccByNames = ac.getAccountByName(accountName);
        getAccByNames.forEach(System.out::println);

        System.out.print("\nInput Invoice ID : ");
        int invoiceId = scanner.nextInt();
        Optional<Invoice> getInvoiceById = iv.getInvoiceById(invoiceId);
        System.out.println(getInvoiceById);
        scanner.nextLine();
        System.out.print("\nInput Invoice Amount : ");
        double invoiceAmount = scanner.nextDouble();
        List<Invoice> getInvoiceByAmount = iv.getInvoiceByAmount(invoiceAmount);
        getInvoiceByAmount.forEach(System.out::println);

//        D:
        System.out.println("\n Câu D : ");
        accounts.stream()
                .forEach(account -> {
                    double discount = account.getCustomer().getDiscount();
                    double balance = account.getBalance();
                    invoices.stream().forEach(invoice -> {
                        double amount = invoice.getAmount();
                        double discountedAmount = amount - (discount * amount / 100);
                        if (balance >= discountedAmount) {
                            System.out.println("Account " + account.getID() + " có thể thanh toán đơn hàng: " + invoice.getId());
                        }
                    });
                });

//         E:
        System.out.println("\n Câu E : ");
        accounts.stream()
                .forEach(account -> {
                    double discount = account.getCustomer().getDiscount();
                    double balance = account.getBalance();
                    invoices.stream().forEach(invoice -> {
                        double amount = invoice.getAmount();
                        double discountedAmount = amount - (discount * amount / 100);
                        if (balance < discountedAmount) {
                            System.out.println("Account " + account.getID() + " không thể thanh toán đơn hàng: " + invoice.getId());
                        }
                    });
                });

        System.out.println("\n Câu F : ");
        List<Invoice> eightMonthInvoices = invoices.stream()
                .filter(invoice -> invoice.getDateTime().getMonthValue() == 8)  // Sử dụng Month.AUGUST thay vì số 8
                .toList();
        eightMonthInvoices.stream()
                .forEach(invoice -> {
                    if (invoice.getCustomer().getGender() == Gender.F) {
                        invoice.getCustomer().setDiscount(invoice.getCustomer().getDiscount() + 10);
                        System.out.println(invoice.getCustomer());
                    }
                });
    }
}
