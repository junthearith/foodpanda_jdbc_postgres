import controller.CustomerController;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImp;
import model.entity.Customer;
import utils.DBException;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws DBException {
        CustomerDao customerDao = new CustomerDaoImp();
//        customerDao.addNewCustomer(new Customer(
//                1, "nice nona", "nicenona@gmail.com", "!@#$", false, Date.valueOf(LocalDate.now())
//        ));
//        customerDao.queryAllCustomers().forEach(System.out::println);
        CustomerController.display();
    }
}
