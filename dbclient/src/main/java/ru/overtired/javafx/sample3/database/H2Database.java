package ru.overtired.javafx.sample3.database;


import ru.overtired.javafx.sample3.utils.HibernateManager;
import ru.overtired.javafx.sample3.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class H2Database {
    private HibernateManager hibernate;

    public H2Database() {
        hibernate = HibernateManager.getInstance();
        initDB();
    }

    private void initDB() {
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
