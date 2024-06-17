import controller.CustomerController;
import model.dao.CustomerDao;
import model.dao.CustomerDaoImp;
import model.entity.Customer;
import utils.DBException;
import view.UI;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws DBException {
        new UI().userInterface();
    }
}
