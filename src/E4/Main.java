package E4;

import javax.swing.text.html.Option;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        List<Invoice> invoices = new ArrayList<>();
        customers.add(new Customer(1,"Nguyen Ngoc Duc",50));
        customers.add(new Customer(2,"Nguyen Thi Huyen",10));
        customers.add(new Customer(3,"Le Thi Nhu Huyen",5));

        invoices.add(new Invoice(1,customers.get(0),90));
        invoices.add(new Invoice(2,customers.get(1),10));
        invoices.add(new Invoice(3,customers.get(2),20));
        invoices.add(new Invoice(4,customers.get(0),30));
        invoices.add(new Invoice(6,customers.get(1),25));
        invoices.add(new Invoice(6,customers.get(2),5));
        customers.forEach(customer -> {
            List<Invoice> lstInvoice = invoices.stream()
                    .filter((invoice -> invoice.getCustomer().getId() == customer.getId()))
                    .toList();
            System.out.println("Customer ID " + customer.getId());
            lstInvoice.forEach(System.out::println);
        });
        System.out.println("\nMax Amount Of Customer : ");
        Optional maxAmount =  invoices.stream()
                .max(Comparator.comparing(Invoice::getAmount));
        System.out.println(maxAmount.get());

        System.out.println("\nMin Discount Of Customer : ");
        Optional minDiscount = invoices.stream()
                .min(Comparator.comparing(invoice -> invoice.getCustomer().getDiscount()));
        System.out.println(minDiscount.get());
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Customer Name Or Invoice Id : ");
        String NameOrID = scanner.nextLine();
        List<Invoice> lstFiltered =  invoices.stream()
                .filter(invoice -> IgnoreCase(invoice.getCustomer().getName(),NameOrID)
                        || IgnoreCase(Integer.toString(invoice.getId()),NameOrID))
                .toList();
        lstFiltered.stream()
                .map(Invoice::getCustomer)
                .distinct()
                .forEach(customer -> System.out.println(customer));
//        lstFiltered.forEach(System.out::println);
    }
    public static boolean IgnoreCase(String parrentString, String childString) {
        int length = childString.length();
        int max = parrentString.length() - length;
        for (int i = 0; i <= max; i++) {
            if (parrentString.regionMatches(true, i, childString, 0, length)) {
                return true;
            }
        }
        return false;
    }
}
