package JDBC.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySQLConnector  {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/web_project?serverTimezone=UTC";



    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection =  DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
