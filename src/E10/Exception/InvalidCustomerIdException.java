package Exception;

public class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException() {
        super();
    }
    public InvalidCustomerIdException(String message) {
        super(message);
    }
    public InvalidCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
