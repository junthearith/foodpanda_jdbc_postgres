package controller;

import model.dto.CreateCustomerDto;
import model.dto.CreateProductDto;
import model.service.CustomerService;
import model.service.CustomerServiceImp;
import model.service.ProductService;
import model.service.ProductServiceImp;
import utils.DBException;
import view.RenderDataToTable;
import view.UI;

import java.util.Scanner;

public class ProductController {
    static Scanner sc = new Scanner(System.in);
    static final ProductService productService = new ProductServiceImp();
    public static void processOption() throws DBException {
        String option = "";
        while (!option.equalsIgnoreCase("exit")) {
            UI.productProcessMenu();
            System.out.print("Insert option: ");
            option = sc.nextLine();
            switch (option) {
                case "1":
                    addNewProduct();
                    break;
                case "2":
                    System.out.println(productService.getAllProducts());
                    break;
                case "3":
                    System.out.print("Insert id to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    int rowAffected = productService.deleteProductById(id);
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
    private static void addNewProduct() throws DBException {
        System.out.print("Insert product name: ");
        String productName = sc.nextLine();
        System.out.print("Insert product code: ");
        String productCode = sc.nextLine();
        System.out.print("Insert product description: ");
        String description = sc.nextLine();
        int rowAffected = productService.addNewProduct(new CreateProductDto(
                productName, productCode, description
        ));
        if (rowAffected > 0) {
            System.out.println("Add new product successfully.");
        }
    }
}
