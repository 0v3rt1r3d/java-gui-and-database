package ru.overtired.database;


import ru.overtired.hibernate.HibernateManager;
import ru.overtired.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class H2Database {
    private HibernateManager hibernate;

    public H2Database() {
        hibernate = new HibernateManager();
        initDB();
        List<User> users = hibernate.getAllUsers();
        for (User user : users) {
            System.out.println(String.format(
                    "%s\nИмя: %s\nДата рождения: %s\nРост: %s",
                    user.getId(),
                    user.getUsername(),
                    user.getDateOfBirth().toString(),
                    user.getGrowth())
            );
        }
    }

    private void initDB() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setDateOfBirth(LocalDate.now());
            user.setUsername("username" + i);
            user.setGrowth(rnd.nextDouble());

            hibernate.save(user);
        }

    }
}
