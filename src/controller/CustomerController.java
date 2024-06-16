package controller;

import model.dto.CreateCustomerDto;
import model.service.CustomerService;
import model.service.CustomerServiceImp;
import utils.DBException;
import view.View;

import java.util.Scanner;

public class CustomerController {
    static Scanner sc = new Scanner(System.in);
    static final CustomerService customerService = new CustomerServiceImp();
    public static void display() throws DBException {
        System.out.println("====================================");
        System.out.println("Food-Panda System");
        View.menu();
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            System.out.print("Insert option:");
            option = sc.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Customer");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    customerService.addNewCustomer(new CreateCustomerDto(
                            name, email, password
                    ));

                    break;
                case "2":
                    System.out.println("Product");
                    break;
                case "3":
                    System.out.println("Order");
                    break;

            }
        }

    }
}
