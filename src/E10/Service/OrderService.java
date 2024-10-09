package Service;

import Entity.Order;

import java.util.List;
import java.util.Optional;
import Exception.NotFoundOrderIdException;
import Global.Global;

public class OrderService {
    private List<Order> orders;
    public OrderService(List<Order> orders) {
        this.orders = orders;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrderById(String id) throws NotFoundOrderIdException {
        Optional<Order> foundOrder =  orders.stream()
                .filter(order -> Global.ignoreCase(order.getId(),id))
                .findFirst();
        if(foundOrder.isPresent()) {
            System.out.println(foundOrder.get());
        }
        else {
            throw new NotFoundOrderIdException("Không tìm thấy order có id "+id);
        }
        return null;
    }
}
