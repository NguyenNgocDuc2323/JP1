package ExceptionCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner =  new Scanner(System.in);){
            System.out.println("Enter number: ");
            double scannerNumber = scanner.nextDouble();
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Valid Number");
        }
    }
}
