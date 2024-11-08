package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Util {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/userDB";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Util() {

    }

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection openConnection() {
        try {
            return DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
