package Controller;

import java.util.List;
import java.util.regex.Pattern;

import Entity.Customer;
import Exception.InvalidCustomerNameException;
import Exception.InvalidCustomerIdException;
import Service.CustomerService;
import Exception.NotFoundCustomerIdException;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }

    public String validateCustomerName(String cusName) throws InvalidCustomerNameException{
        if (!Pattern.matches("[a-zA-Z ]{3,50}", cusName)) {
            throw new InvalidCustomerNameException("Định Dạng Tên Customer Không hợp lệ!");
        }
        else{
            return cusName;
        }
    }

    public int validateCustomerId(String cusId) throws InvalidCustomerIdException {
        try {
            int customerId = Integer.parseInt(cusId);
            if (customerId < 0) {
                throw new InvalidCustomerIdException("Id của customer phải là 1 số dương!");
            }
            return customerId;
        } catch (NumberFormatException e) {
            throw new InvalidCustomerIdException("Id của customer phải là 1 số hợp lệ!");
        }
    }


    public Customer getCustomerById(String id) {
        try {
            Customer customer = cs.getCustomerById(id);
            return customer;
        } catch (NotFoundCustomerIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
