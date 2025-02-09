package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/1example";
    private static final String USER = "root";
    private static final String PASSWORD = "gfhjkm100901.";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(Driver);
            connection= DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection not OK");
        }
        return connection;
    }
}
