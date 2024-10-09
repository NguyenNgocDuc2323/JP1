package Service;

import Entity.Customer;

import java.util.List;
import java.util.Optional;
import Exception.NotFoundCustomerIdException;
import Global.Global;

public class CustomerService {
    private List<Customer> customers;
    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public Customer getCustomerById(String id) throws NotFoundCustomerIdException {
        Optional<Customer> foundCus = customers.stream()
                .filter(customer -> Global.ignoreCase(customer.getId(), id))
                .findFirst();

        if (foundCus.isPresent()) {
            return foundCus.get();
        } else {
            throw new NotFoundCustomerIdException("Không tìm thấy khách hàng có id là : "+id);
        }
    }
}
