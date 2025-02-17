import java.util.Scanner;

class NormalCalculator  {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }

    public int crazyOperation(int a, int b) {
        return (-1) * (99) + (a) + (3*b);
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

public class NormalCalculatorApp {
    public static void main(String[] args) {
        NormalCalculator calculator = new NormalCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter operation (add, subtract, multiply, divide, crazy) followed by two numbers (or 'exit' to quit):");
            
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input. Format: operation num1 num2");
                continue;
            }
            
            String operation = parts[0];
            try {
                int num1 = Integer.parseInt(parts[1]);
                int num2 = Integer.parseInt(parts[2]);
                
                long startTime = System.nanoTime();
                int result = 0;
                
                switch (operation.toLowerCase()) {
                    case "add":
                        result = calculator.add(num1, num2);
                        break;
                    case "subtract":
                        result = calculator.subtract(num1, num2);
                        break;
                    case "multiply":
                        result = calculator.multiply(num1, num2);
                        break;
                    case "divide":
                        result = calculator.divide(num1, num2);
                        break;
                    case "crazy":
                        result = calculator.crazyOperation(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        continue;
                }
                
                long endTime = System.nanoTime();
                System.out.println("Result: " + result);
                System.out.println("Execution time: " + (endTime - startTime) + " ns");
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers provided.");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
