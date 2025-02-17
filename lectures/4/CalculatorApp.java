import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

interface Calculator {
    int add(int a, int b);
    int mult(int a, int b);
    int sub(int a, int b);
    int divide(int a, int b);
    int doubleUp(int a, int b);
}

class CalculatorImpl implements Calculator {
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
        return a / b;
    }
    public int doubleUp(int a, int b) {
        for(int i=1; i<10000; i++){}
        
        return a + b;
    }
}

class TimingInvocationHandler implements InvocationHandler {
    private final Object target;

    public TimingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();

        for (int i=0; i<100000000; i++) {
          System.out.println(i);
        }

        Object result = method.invoke(target, args);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }
}

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = (Calculator) Proxy.newProxyInstance(
            Calculator.class.getClassLoader(),
            new Class<?>[]{Calculator.class},
            new TimingInvocationHandler(new CalculatorImpl())
        );

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
