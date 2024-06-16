package view;

public class View {
    public static void menu() {
        System.out.println("====================================");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Order");
        System.out.println("====================================");
    }
    public static void customerMenu() {
        System.out.println("-------------------------------------");
        System.out.println("1. Add new Customer");
        System.out.println("2. List all Customers");
        System.out.println("3. Delete Customer by Id");
        System.out.println("4. Update Customer by Id");
        System.out.println("5. Search customer by Id");
        System.out.println("-------------------------------------");
    }
    public static void productMenu() {
        System.out.println("-------------------------------------");
        System.out.println("1. Add new Product");
        System.out.println("2. List all Products");
        System.out.println("3. Delete Product by Id");
        System.out.println("4. Update Product by Id");
        System.out.println("5. Search Product by Id");
        System.out.println("-------------------------------------");
    }
    public static void orderMenu() {
        System.out.println("-------------------------------------");
        System.out.println("1. Add new Order");
        System.out.println("2. List all Orders");
        System.out.println("3. Delete Ordered by Id");
        System.out.println("4. Update Ordered by Id");
        System.out.println("5. Search Order by Id");
        System.out.println("-------------------------------------");
    }
}
