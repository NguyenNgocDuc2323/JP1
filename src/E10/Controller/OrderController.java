package Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Exception.InvalidOrderIdException;
import Service.OrderDetailService;
import Service.OrderService;
import Exception.NotFoundOrderIdException;
import Exception.NotEnoughInventoryNumberException;
import Service.ProductService;
import Exception.NotFoundProductIdException;
public class OrderController {
    private List<Order> orders;
    private OrderService os;
    private OrderDetailService ods;
    private OrderDetailController odc;
    private Product product;
    private ProductService ps;
    public OrderController(OrderService os, OrderDetailService ods, OrderDetailController odc, ProductService ps) {
        this.os = os;
        this.orders = os.getOrders();
        this.ods = ods;
        this.odc = odc;
        this.ps = ps;
    }
    public String validateOrderId(String orderId) throws InvalidOrderIdException {
        if (!Pattern.matches("(ORDPM)[0-9]{8}", orderId)) {
            throw new InvalidOrderIdException("Order Id phải là một chuỗi hợp lệ!");
        }
        return orderId;
    }

    public void getOrderById(String id){
        try{
            Order foundOrder = os.getOrderById(id);
            System.out.println(foundOrder);
        } catch (NotFoundOrderIdException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addOrder(String customerId, List<OrderDetail> orderDetails, String orderId) throws NotEnoughInventoryNumberException, InvalidOrderIdException {
        odc.CheckInventoryNumber(orderDetails);
        orderId = validateOrderId(orderId);
        Order newOrder = new Order(orderId, customerId, LocalDate.now());
        orders.add(newOrder);
        String finalOrderId = orderId;
        orderDetails.forEach(orderDetail -> {
            orderDetail.setOrderId(finalOrderId);
            try {
                Product product = ps.getProductById(orderDetail.getProductId());
                if (product != null) {
                    product.setQuantity(product.getQuantity() - orderDetail.getQuantity()); // update qty
                    orderDetails.add(orderDetail);
                }
            } catch (NotFoundProductIdException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("Đơn hàng đã được thêm thành công với ID: " + orderId);
    }

}

