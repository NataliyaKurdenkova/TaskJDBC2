package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (var connection = Util.openConnection()) {

            UserService userService = new UserServiceImpl();

            userService.createUsersTable();

            userService.saveUser("Ivan", "Ivanov", Byte.parseByte("27"));
            userService.saveUser("Maria", "Sidorova", Byte.parseByte("22"));
            userService.saveUser("Pavel", "Petrov", Byte.parseByte("54"));
            userService.saveUser("Tamara", "Vasina", Byte.parseByte("13"));

            userService.removeUserById(1l);

            userService.getAllUsers()
                    .stream()
                    .forEach(System.out::println);

            userService.cleanUsersTable();

            userService.dropUsersTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
