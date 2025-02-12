package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class UserServiceImpl implements UserService {
    private final UserDaoHibernateImpl userDaoHib = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaoHib.createUsersTable();
        System.out.println("Таблица создана");
    }

    public void dropUsersTable() {
        userDaoHib.dropUsersTable();
        System.out.println("Таблица удалена");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHib.saveUser(name, lastName, age);
        System.out.println("Пользователь с именем " + name + " " + lastName + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDaoHib.removeUserById(id);
        System.out.println("Пользователь с id " + id + " удален из базы данных");
    }

    public List<User> getAllUsers() {
        List<User> users = userDaoHib.getAllUsers();
        System.out.println("Все пользователи из базы: ");
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public void cleanUsersTable() {
        userDaoHib.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
