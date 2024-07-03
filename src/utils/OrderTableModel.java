package utils;

import model.dto.ResponseCustomerDto;
import model.dto.ResponseOrderDto;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class OrderTableModel {
    public static void renderOrdersToTable(List<ResponseOrderDto> ordersList, int rows, int currentPage, int totalPages, int totalRecords) {
        Table table = new Table(6, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.ALL);
        for (int i = 0; i < 6; i++) {
            table.setColumnWidth(i, 20, 25);
        }

        // header table
        table.addCell("Id");
        table.addCell("Order Name");
        table.addCell("Order Description");
        table.addCell("Customer Id");
        table.addCell("Customer Name");
        table.addCell("Order At");

        // date rows
        for (int i = 0; i < Math.min(ordersList.size(), rows); i++) {
            ResponseOrderDto responseOrderDto = ordersList.get(i);

            table.addCell(String.valueOf(responseOrderDto.orderId()));
            table.addCell(responseOrderDto.orderName());
            table.addCell(responseOrderDto.orderDescription());
            table.addCell(String.valueOf(responseOrderDto.customer().getId()));
            table.addCell(responseOrderDto.customer().getName());
            table.addCell(String.valueOf(responseOrderDto.orderAt()));
        }
        table.addCell("Page: " + currentPage + "/" + totalPages, 2);
        table.addCell("Total record: " + totalRecords, 3);

        System.out.println(table.render());

    }
    public static void renderPagination() {
        Table table = new Table(6, BorderStyle.UNICODE_BOX_HEAVY_BORDER);

        for (int i = 0; i < 6; i++) {
            table.setColumnWidth(i, 20, 25);
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
