package Assignments;

import java.util.Scanner; // import scanner 

public class CalculatorTest {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // create object scanner
    System.out.println("Calculator");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
    System.out.println("5. Exit");

    while (true) {
      System.out.print("Choose an operation (1-5): ");
      int choice = scanner.nextInt();

      if (choice == 5) {
        System.out.println("Exiting...");
        break;
      }

      System.out.print("Enter the first number: ");
      double num1 = scanner.nextDouble();

      System.out.print("Enter the second number: ");
      double num2 = scanner.nextDouble();

      switch (choice) {
        case 1:
          System.out.println("Result: " + add(num1, num2));
          break;
        case 2:
          System.out.println("Result: " + subtract(num1, num2));
          break;
        case 3:
          System.out.println("Result: " + multiply(num1, num2));
          break;
        case 4:
          if (num2 != 0) {
            System.out.println("Result: " + divide(num1, num2));
          } else {
            System.out.println("Error: Division by zero!");
          }
          break;
        default:
          System.out.println("Invalid choice!");
      }
    }

    scanner.close();
  }

  private static double add(double num1, double num2) {
    return num1 + num2;
  }

  private static double subtract(double num1, double num2) {
    return num1 - num2;
  }

  private static double multiply(double num1, double num2) {
    return num1 * num2;
  }

  private static double divide(double num1, double num2) {
    return num1 / num2;
  }
}