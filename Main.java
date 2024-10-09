
public class Main {
    public static void main(String[] args) {

        try(Scanner scanner =  new Scanner(System.in);){
            System.out.println("Enter number: ");
            double scannerNumber = scanner.nextDouble();
        }
        catch (ArithmeticException e){
            System.out.println("Bạn phải nhập vào 1 số!");
        }
        finally {
            System.out.println("Valid Number");
        }
    }
}