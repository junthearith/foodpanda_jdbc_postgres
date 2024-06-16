package utils;

import model.entity.Customer;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class CustomerTableModel {
    public static void renderCustomersToTable(List<Customer> customersList, int rows, int currentPage, int totalPages, int totalRecords) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 20, 20);
        }

        // header table
        table.addCell("Id");
        table.addCell("Customer Name");
        table.addCell("Email");
        table.addCell("Created Date");

        // date rows
        for (int i = 0; i < Math.min(customersList.size(), rows); i++) {
            Customer customer = customersList.get(i);
            table.addCell(String.valueOf(customer.getId()));
            table.addCell(customer.getName());
            table.addCell(customer.getEmail());
            table.addCell(String.valueOf(customer.getCreatedDate()));
        }
        table.addCell("Page: " + currentPage + "/" + totalPages, 2);
        table.addCell("Total record: " + totalRecords, 3);

        System.out.println(table.render());

    }
    public static void renderPagination() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_HEAVY_BORDER);

        for (int i = 0; i < 5; i++) {
            table.setColumnWidth(i, 20, 20);
        }

        table.addCell("F). First Page");
        table.addCell("L). Last Page");
        table.addCell("P). Previous Page");
        table.addCell("N). Next Page");
        table.addCell("B). Back To MENU");
        table.addCell("Note: Enter number to go to specific page", 5);

        System.out.println(table.render());
    }
}
