package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private DBUtil(){}
    public static Connection connection;
    public static Connection getConnection() throws DBException {
        try {
            String url = "jdbc:postgresql://localhost:5433/foodpanda_db";
            String username = "postgres";
            String password = "221198";
            connection = DriverManager.getConnection(
                    url, username, password
            );
            System.out.println("Connection is successful");
            return connection;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    public static void closeConnection() throws DBException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DBException(e);
            } finally {
                connection = null;
            }
        }
    }
}
