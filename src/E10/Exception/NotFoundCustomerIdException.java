package Exception;

public class NotFoundCustomerIdException extends Exception {
    private int id;
    public NotFoundCustomerIdException() {
        super();
    }
    public NotFoundCustomerIdException(int id) {
        this.id = id;
    }
    public NotFoundCustomerIdException(String message) {
        super(message);
    }
    public NotFoundCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
