package view;

import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import model.dto.CreateCustomerDto;
import utils.DBException;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);
    private void homeThumbnail() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\tWelcome to FoodPanda Console Application");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    private void option() {
        System.out.println("""
                -------------------------------------
                1. Customer
                2. Product
                3. Order products
                0/99. to Exit
                -------------------------------------
                """);
    }
    private void processOption() throws DBException {
        homeThumbnail();
        while(true) {
            String option = "";
            while (!option.equalsIgnoreCase("exit")) {
                option();
                System.out.print("Insert option: ");
                option = sc.nextLine();
                switch (option) {
                    case "0":
                        System.out.println("0. Exit");
                        System.exit(0);
                        break;
                    case "1":
                        CustomerController.processOption();
                        break;
                    case "2":
                        ProductController.processOption();
                        break;
                    case "3":
                        OrderController.processOption();
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            }
        }
    }
    public static void customerServicesMenu() {
        System.out.println("""
                1. Add new Customer
                2. List all Customers
                3. Delete customer by Id
                4. Update customer by Id
                5. Search customer by Id
                B/Back: Back to Main Menu
                """);
    }
    public static void productProcessMenu() {
        System.out.println("""
                1. Add new Product
                2. List all Products
                3. Delete product by Id
                B/Back: Back to Main Menu
                """);
    }
    public static void orderProcessMenu() {
        System.out.println("""
                1. Add new Order
                2. List all orders
                B/Back: Back to Main Menu
                """);
    }
    public void userInterface() throws DBException {
        processOption();
    }
}
