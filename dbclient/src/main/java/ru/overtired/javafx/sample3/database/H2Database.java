package ru.overtired.javafx.sample3.database;


import ru.overtired.javafx.sample3.utils.HibernateManager;
import ru.overtired.javafx.sample3.models.User;

import java.time.LocalDate;
import java.util.Random;

public class H2Database {
    private H2Database() {
        // static class
    }

    public static void initDatabase() {
        final HibernateManager hibernate = HibernateManager.getInstance();
        hibernate.beginTransaction();

        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setDateOfBirth(LocalDate.now());
            user.setUsername("username" + i);
            user.setGrowth(rnd.nextDouble());

            hibernate.save(user);
        }

        hibernate.endTransaction();
    }
}
