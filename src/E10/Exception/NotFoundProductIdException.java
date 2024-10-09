package Exception;

public class NotFoundProductIdException  extends Exception{
    private int id;
    public NotFoundProductIdException(){
        super();
    }
    public NotFoundProductIdException(int id){
        this.id=id;
    }
    public NotFoundProductIdException(String message){
        super(message);
    }
    public NotFoundProductIdException(String message, Throwable cause){
        super(message, cause);
    }
}
