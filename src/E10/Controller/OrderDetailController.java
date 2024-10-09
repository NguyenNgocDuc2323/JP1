package Controller;
import Entity.OrderDetail;
import Entity.OrderStatus;
import Entity.Product;
import Exception.InvalidQuantityException;
import Service.OrderDetailService;
import Service.ProductService;
import Exception.NotFoundProductIdException;

import java.util.ArrayList;
import java.util.List;
import Exception.NotEnoughInventoryNumberException;
import Exception.NotFoundOrderIdException;
public class OrderDetailController {
    private List<OrderDetail> orderDetails;
    private ProductService ps;
    private OrderStatus orderStatus;
    private OrderDetailService ods;
    public OrderDetailController(OrderDetailService ods, ProductService ps) {
        this.ods = ods;
        this.orderDetails = ods.getOrderDetails();
        this.ps = ps;
        this.orderStatus = OrderStatus.PENDING;
    }
    public void validateQuantitySold(String soldQty){
        try{
            int qty = Integer.parseInt(soldQty);
            if(qty < 0){
                throw new InvalidQuantityException("Số Lượng Phải là số nguyên dương!");
            }
        }
        catch (InvalidQuantityException e){
            System.out.println("Số lượng phải là 1 số!");
        }
    }
    public void CheckInventoryNumber(List<OrderDetail> orderDetails) throws NotEnoughInventoryNumberException {
        List<String> checkNotEnough = new ArrayList<>();
        orderDetails.stream()
                .forEach(orderDetail -> {
                    try {
                        Product product = ps.getProductById(orderDetail.getProductId());
                        if (product.getQuantity() < orderDetail.getQuantity()) {
                            checkNotEnough.add("Không đủ số lượng tồn kho cho sản phẩm: " + product.getName());
                        }
                    } catch (NotFoundProductIdException e) {
                        checkNotEnough.add("Không tìm thấy sản phẩm có id là: " + orderDetail.getProductId());
                    }
                });
        if (!checkNotEnough.isEmpty()) {
            checkNotEnough.forEach(System.out::println);
            throw new NotEnoughInventoryNumberException("Có lỗi tồn kho trong đơn hàng.");
        }
        System.out.println("Tất cả sản phẩm đủ số lượng trong kho để thực hiện đơn hàng.");
    }
    public OrderDetail getOrderDetailById(String id){
        try{
            OrderDetail foundOrderDetail = ods.getOrderDetailById(id);
            return foundOrderDetail;
        } catch (NotFoundOrderIdException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateOrderDetailStatus(String orderDetailId, OrderStatus newStatus) {
        OrderDetail orderDetail = getOrderDetailById(orderDetailId);
        if (orderDetail != null) {
            orderDetail.setStatus(newStatus);
            System.out.println("Trạng thái của chi tiết đơn hàng " + orderDetailId + " đã được cập nhật thành " + newStatus.getDescription());
        } else {
            System.out.println("Chi tiết đơn hàng không tồn tại.");
        }
    }
    public void completeOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.COMPLETED);
    }

    public void cancelOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.CANCEL);
    }

    public void payOrderDetail(String orderDetailId) {
        updateOrderDetailStatus(orderDetailId, OrderStatus.PAID);
    }


}
