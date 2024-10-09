package ExceptionCalculator;

public class TestCalcultor {
    public TestCalcultor() {
    }
    public static void main(String[] args) {
        try{
            Calculator calc = new Calculator();
            calc.devide(15,0);
        }catch (CalculatorException ex){
            System.out.println(ex.getMessage());
        }
    }
}
