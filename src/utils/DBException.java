package utils;

import java.sql.SQLException;

public class DBException extends Exception {
    public DBException(SQLException e) {}
    public DBException(String message) {
        super(message);
    }
}
