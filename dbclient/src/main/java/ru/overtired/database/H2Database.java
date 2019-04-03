package ru.overtired.database;


import ru.overtired.hibernate.HibernateInitializer;
import ru.overtired.model.User;

import java.time.LocalDate;

public class H2Database {
    private HibernateInitializer hibernate;

    public H2Database() {
        hibernate = new HibernateInitializer();
        initDB();
    }

    private void initDB() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setDateOfBirth(LocalDate.now());
            user.setUsername("username" + i);

            hibernate.save(user);
        }

    }
}
