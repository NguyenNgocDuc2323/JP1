package Service;

import Entity.Product;

import java.util.List;
import java.util.Optional;
import Exception.NotFoundProductIdException;
import Global.Global;

public class ProductService {
    private List<Product> products;
    public ProductService(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product getProductById(String id) throws NotFoundProductIdException {
        Optional<Product> foundProduct =  products.stream()
                .filter(product -> Global.ignoreCase(product.getId(), id))
                .findFirst();
        if(foundProduct.isPresent()) {
            return foundProduct.get();
        }
        else{
            throw new NotFoundProductIdException("Không tìm thấy sản phẩm có id :"+id);
        }
    }
}
