package Service;

import Entity.OrderDetail;
import Global.Global;

import java.util.List;
import java.util.Optional;
import Exception.NotFoundOrderIdException;
import Exception.NotEnoughInventoryNumberException;
public class OrderDetailService {
    private List<OrderDetail> orderDetails;
    public OrderDetailService(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public OrderDetail getOrderDetailById(String id) throws NotFoundOrderIdException {
        Optional<OrderDetail> foundOrderDetail =  orderDetails.stream()
                .filter(orderDetail -> Global.ignoreCase( orderDetail.getId(),id))
                .findFirst();
        if(foundOrderDetail.isPresent()){
            return foundOrderDetail.get();
        }
        else{
            throw new NotFoundOrderIdException("Không tìm thấy order detail có id "+id);
        }
    }


}
