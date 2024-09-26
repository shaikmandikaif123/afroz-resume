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

        // Perform operation based on the operator using switch-case
        int result = 0;
        boolean validOperator = true;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperator = false;
                }
                break;
            default:
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


import java.util.Scanner;

public class Calculator {
    
    // Method for addition
    public static int add(int a, int b) {
        return a + b;
    }

    // Method for subtraction
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Method for multiplication
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method for division
    public static int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero is not allowed.");
            return Integer.MIN_VALUE; // Return some default error value
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Perform operation using methods based on the operator
        int result = 0;
        boolean validOperator = true;

        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator! Please use one of (+, -, *, /).");
                validOperator = false;
        }

        // Print the result if the operator is valid
        if (validOperator && result != Integer.MIN_VALUE) {
            System.out.println("The result is: " + result);
        }

        scanner.close();
    }
}









package org.example;

import org.example.Abstraction.ApplicationStatusManager;
import org.example.Inheritance.PremiumCardApplication;
import org.example.Inheritance.StandardCardApplication;
import org.example.composition.Address;
import org.example.composition.ContactInfo;


public class CreditCardSystem {
    public static void main(String[] args) {
        // User and Address (Composition Example)
        Address userAddress = new Address("RCT", "Kadapa", "516269");
        ContactInfo userContacts = new ContactInfo("9121205990","kaif@gmail.com");
        User customer = new User("Kaif", userAddress,userContacts);
        System.out.println(customer.getUserDetails());
        System.out.println(customer.getContsctDetails());

        // Inheritance and Polymorphism Example
        CreditCardApplication standardApplication = new StandardCardApplication("Kaif", 30000);
        CreditCardApplication premiumApplication = new PremiumCardApplication("Kaif", 50000);

        standardApplication.approveApplication();  // Approval based on income
        premiumApplication.approveApplication();  // Special conditions for premium card

        // Abstract class example for Admin
        ApplicationStatusManager adminManager = new AdminStatusManager();

        adminManager.approveApplication();  // Admin approval
    }

}


