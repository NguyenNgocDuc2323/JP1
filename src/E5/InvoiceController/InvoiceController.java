package InvoiceController;

import Entiy.Account;
import Entiy.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceController {
    private List<Invoice> invoices;
    public InvoiceController(List<Invoice> invoices) {
        this.invoices = invoices;
    }
    public Optional<Invoice> getCustomerName(String name) {
        Optional<Invoice> filterCus =  invoices.stream()
                .filter(invoice -> invoice.getCustomer().getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();
        return filterCus;
    }
    public Optional<Invoice> getCustomerId(int id) {
        Optional<Invoice> filterCus =  invoices.stream()
                .filter(invoice -> invoice.getCustomer().getID() == id)
                .findFirst();
        return filterCus;
    }
    public int getCustomerDiscount(int discount) {
        Optional<Invoice> filterCus =  invoices.stream()
                .filter(invoice -> invoice.getCustomer().getDiscount() == discount)
                .findFirst();
        return filterCus.get().getCustomer().getDiscount();
    }
    public double getAmountAfterDiscount(int discount,int id) {
        Optional<Invoice> filterCst = getCustomerId(id);
        double amount = filterCst.get().getAmount();
        double discountAmount = amount * discount / 100;
        return  amount - discountAmount;
    }
    public Optional<Invoice> getInvoiceById(int id) {
        return invoices.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst();
    }
    public List<Invoice> getInvoiceByAmount(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getAmount() == amount)
                .toList();
    }
}
