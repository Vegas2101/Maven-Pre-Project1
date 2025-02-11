package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJDBCImpl();
    private final UserDao userDaoHib = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaoHib.createUsersTable();
        userDao.createUsersTable();
        System.out.println("Таблица создана");
    }

    public void dropUsersTable() {
        userDaoHib.dropUsersTable();
        userDao.dropUsersTable();
        System.out.println("Таблица удалена");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHib.saveUser(name, lastName, age);
        userDao.saveUser(name, lastName, age);
        System.out.println("Пользователь с именем " + name + " " + lastName + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDaoHib.removeUserById(id);
        userDao.removeUserById(id);
        System.out.println("Пользователь с id " + id + " удален из базы данных");
    }

    public List<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        users.addAll(userDaoHib.getAllUsers());
        users.addAll(userDao.getAllUsers());
        System.out.println("Все пользователи из базы: ");
        return new ArrayList<>(users);
    }

    public void cleanUsersTable() {
        userDaoHib.cleanUsersTable();
        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
