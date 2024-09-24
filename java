import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Perform operation based on the operator using if-else
        int result = 0;
        boolean validOperator = true;

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Division by zero is not allowed.");
                validOperator = false;
            }
        } else {
            System.out.println("Invalid operator! Please use one of (+, -, *, /).");
            validOperator = false;
        }

        // Print the result if the operator is valid
        if (validOperator) {
            System.out.println("The result is: " + result);
        }

        scanner.close();
    }
}
