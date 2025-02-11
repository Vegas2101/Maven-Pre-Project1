package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("John", "Doe", (byte) 25);
        userService.saveUser("Jane", "Doe", (byte) 30);
        userService.saveUser("Bob", "Smith", (byte) 40);
        userService.saveUser("Alice", "Johnson", (byte) 35);

        userService.removeUserById(1);

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.sessionShutDown();
    }
}
