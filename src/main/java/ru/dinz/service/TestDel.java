package ru.dinz.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.dinz.model.PDF;
import ru.dinz.model.User;
import ru.dinz.persistence.PDFStore;
import ru.dinz.persistence.UserStore;

import java.sql.Timestamp;
import java.util.List;

public class TestDel {
    public static void main(String[] args) {
        UserStore userStore = UserStore.instOf();
        User user = User.of("q", "a", "2", "login", "p");
        UserService userService = new UserService(userStore);
        userService.add(user);
/*
        List<User> list = userService.findAll();
        for (User p : list) {
            System.out.print(p);
        }


 */

        /*
        PDFStore pdfStore = PDFStore.instOf();
        PDF pdf = new PDF(0, "qwe", "qwasd", new Timestamp(System.currentTimeMillis()), new byte[]{2, 43});
        pdfStore.add(pdf);
        List<PDF> list = pdfStore.findAll();
        for (PDF p : list) {
            System.out.print(p);
        }

         */
    }
}