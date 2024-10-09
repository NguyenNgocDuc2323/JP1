package Exception;

public class InvalidProducIdException extends Exception {
    public InvalidProducIdException(){
        super();
    }
    public InvalidProducIdException(String message){
        super(message);
    }
    public InvalidProducIdException(String message,Throwable cause){
        super(message,cause);
    }
}
