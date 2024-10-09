package Exception;

public class NotFoundOrderIdException extends Exception {
    private int id;
    public NotFoundOrderIdException(int id) {
        this.id = id;
    }
    public NotFoundOrderIdException() {
        super();
    }
    public NotFoundOrderIdException(String message) {
        super(message);
    }
    public NotFoundOrderIdException(String message,Throwable cause){
        super(message,cause);
    }
}
