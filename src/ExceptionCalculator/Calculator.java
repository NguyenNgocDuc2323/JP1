package ExceptionCalculator;
import ExceptionCalculator.CalculatorException;
public class Calculator {
    public void devide(int a,int b) {
        try {
            int result = a/b;
            System.out.println("Result is : "+result);
        }catch (ArithmeticException e){
            System.out.println("Không thể chia hết cho 0"+e.getMessage());
        }
        catch (CalculatorException ex){
            System.out.println("Không thể chia hết cho 0"+ex.getCause());
        }
    }
}
