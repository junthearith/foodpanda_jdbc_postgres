package view;

import model.dto.ResponseCustomerDto;
import model.entity.Customer;
import model.service.CustomerService;
import model.service.CustomerServiceImp;
import utils.CustomerTableModel;
import utils.DBException;

import java.util.List;
import java.util.Scanner;

public class RenderDataToTable {
    static final CustomerService customerService = new CustomerServiceImp();
    static List<ResponseCustomerDto> customers;
    private static final int rowSize = 4;
    public static void getAllCustomersDataTable() throws DBException {
        customers = customerService.getAllCustomers();
        if (customers == null) {
            System.out.println("Unable to get customers data.");
        }
        int currentPage = 1;
        int totalPages = (int)Math.ceil((double)customers.size() / rowSize);
        int totalRecords = customers.size();
        while (true) {
            int startIndex = (currentPage -1) * rowSize;
            int endIndex = Math.min(startIndex + rowSize, customers.size());
            List<ResponseCustomerDto> pageCustomers = customers.subList(startIndex, endIndex);

            System.out.println();
            CustomerTableModel.renderCustomersToTable(pageCustomers, rowSize, currentPage, totalPages, totalRecords);
            CustomerTableModel.renderPagination();

            System.out.print("Enter the option(pagination): ");
            String pageOption = new Scanner(System.in).nextLine();
            if (pageOption.equalsIgnoreCase("p")) {
                if (currentPage > 1) {
                    currentPage--;
                } else {
                    System.out.println("You're already on the first page.");
                }
            } else if (pageOption.equalsIgnoreCase("n")){
                if (currentPage < totalPages) {
                    currentPage++;
                } else {
                    System.out.println("You're already on the last page.");
                }
            } else if (pageOption.equalsIgnoreCase("f")) {
                currentPage = 1;
            } else if (pageOption.equalsIgnoreCase("l")) {
                currentPage = totalPages;
            } else if (pageOption.equalsIgnoreCase("b")) {
                return;
            } else {
                try {
                    int pageNumber = Integer.parseInt(pageOption);
                    if (pageNumber >= 1 && pageNumber <= totalPages) {
                        currentPage = pageNumber;
                    } else {
                        System.out.println("Invalid page number. Please enter a number between 1 and " + totalPages);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }
        }
    }
}
