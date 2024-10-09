package Controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Pattern;

import Entity.Product;
import Exception.InvalidProducIdException;
import  Exception.InvalidProductNameException;
import Exception.InvalidQuantityException;
import Service.ProductService;
import Exception.NotFoundProductIdException;
public class ProductController {
    private List<Product> products;
    private ProductService ps;
    public ProductController(ProductService ps) {
        this.ps = ps;
        this.products = ps.getProducts();
    }
    public  void validateProductId(String productId) {
        try {
            if (!Pattern.matches("(MS|NE|SE)[0-9]{6}", productId)) {
                throw new InvalidProducIdException("Định dạng ID Sản Phẩm KhôngHợp Lệ");
            }else{
                System.out.println("Định dạng ID Sản Phẩm Hợp Lệ");
            }
        } catch (InvalidProducIdException e) {
            System.out.println("Định dạng ID Sản Phẩm Hợp Lệ");
        }
        finally {
            System.out.println(productId);
        }
    }
    public void validateProductName(String productName) throws InvalidProductNameException {
        try{
            if (!Pattern.matches("[a-zA-Z\\s]+", productName)) {
                throw new InvalidProductNameException("Định Dạng Tên Sản Phẩm Không Đúng!");
            }
            else{
                System.out.println("Tên Sản phẩm đúng định dạng");
            }
        }
        catch (InvalidProductNameException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println(productName);
        }

    }
    public void validateProductQuantity(String productQuantity){
        try{
            int quantity = Integer.parseInt(productQuantity);
            if(quantity < 0){
                throw new InvalidQuantityException("Số lượng sản phẩm phải là số dương");
            }
        }catch (InvalidQuantityException ex){
            System.out.println("Định dạng số lượng không hợp lệ!");
        }
    }
    public void getProductById(String id){
        try{
            Product product = ps.getProductById(id);
            System.out.println(product);
        } catch (NotFoundProductIdException e) {
            System.out.println(e.getMessage());
        }
    }

}
