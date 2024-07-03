package controller;

import model.dao.OrderDao;
import model.dto.CreateCustomerDto;
import model.dto.CreateOrderDto;
import model.entity.Customer;
import model.service.OrderService;
import model.service.OrderServiceImp;
import utils.DBException;
import view.RenderDataToTable;
import view.UI;

import java.util.Scanner;

public class OrderController {
    private static final Scanner sc = new Scanner(System.in);
    private static final OrderService orderService = new OrderServiceImp();
    public static void processOption() throws DBException {
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            UI.orderProcessMenu();
            System.out.print("Insert option: ");
            option = sc.nextLine();
            switch (option) {
                case "1":
                    addNewOrder();
                    break;
                case "2":
                    RenderDataToTable.getAllOrdersDataTable();
                    break;
                case "3":
                    System.out.print("Insert id to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    int rowAffected = orderService.deleteOrderById(id);
                    if (rowAffected > 0) {
                        System.out.println("id " + id + " successfully.");
                    }
                    break;
                case "b":
                    option = "exit";
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
    private static void addNewOrder() throws DBException {
        System.out.print("Order name: ");
        String orderName = sc.nextLine();
        System.out.print("Order description: ");
        String orderDescription = sc.nextLine();
        System.out.print("Customer id: ");
        Integer cusId = Integer.parseInt(sc.nextLine());
        orderService.addNewOrder(new CreateOrderDto(
                orderName, orderDescription, new Customer(cusId)
        ));
    }
}
