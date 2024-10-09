package Exception;

public class InvalidCustomerNameException extends Exception {
    public InvalidCustomerNameException() {
        super();
    }
    public InvalidCustomerNameException(String message) {
        super(message);
    }
    public InvalidCustomerNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
