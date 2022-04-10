package ru.dinz.service;

import ru.dinz.model.User;
import ru.dinz.persistence.UserStore;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final UserStore store;

    public UserService(UserStore userStore) {
        this.store = userStore;
    }

    public List<User> findAll() {
        return new ArrayList<>(store.findAll());
    }

    public void add(User user) {
        store.add(user);
    }

    public User findById(int id) {
        return store.get(id);
    }

    public User findByLoginAndPassword(String login, String password) {
        List<User> list = store.findAll();
        for (User user : list) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
                /*
                id_user
                from pdf select pdf_name where user_id == id

                * */
            }
        }
        return new User();
    }
}
