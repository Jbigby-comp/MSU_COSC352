import java.util.Scanner;
import java.lang.reflect.Method;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int mult(int a, int b) {
        return a * b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
    public int crazy1(int a, int b) {
        return a - b + -9;
    }
    public int crazy2(int a, int b) {
        return a - b - 88;
    }
}

public class SimpleCalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Class<?> clazz = calculator.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available operations:");
            for (Method method : methods) {
                if (method.getParameterCount() == 2) {
                    System.out.println("- " + method.getName() + " (int, int)");
                }
            }
            System.out.println("Enter method name and arguments (or 'exit' to quit):");
            
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input. Format: methodName num1 num2");
                continue;
            }
            
            String methodName = parts[0];
            try {
                int num1 = Integer.parseInt(parts[1]);
                int num2 = Integer.parseInt(parts[2]);
                
                if (methodName.equalsIgnoreCase("all")) {
                    executeAllOperations(calculator, num1, num2);
                } else {
                    Method method = Calculator.class.getMethod(methodName, int.class, int.class);
                    Object result = method.invoke(calculator, num1, num2);
                    System.out.println("Result: " + result);
                }
            } catch (NoSuchMethodException e) {
                System.out.println("Operation doesn't exist");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void executeAllOperations(Calculator calculator, int num1, int num2) {
        Method[] methods = Calculator.class.getMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 2) {
                try {
                    Object result = method.invoke(calculator, num1, num2);
                    System.out.println(method.getName() + "(" + num1 + ", " + num2 + ") = " + result);
                } catch (Exception e) {
                    System.out.println("Error executing " + method.getName() + ": " + e.getMessage());
                }
            }
        }
    }
}
