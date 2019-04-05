package ru.overtired.javafx.sample3.controllers;

import javafx.fxml.FXML;
import ru.overtired.javafx.sample3.models.User;
import ru.overtired.javafx.sample3.utils.HibernateManager;

public class MainController {

    @FXML
    private void loadUsers() {
        HibernateManager instance = HibernateManager.getInstance();
        for (User user : instance.getAllUsers()) {
            System.out.println(String.format(
                    "%s\nИмя: %s\nДата рождения: %s\nРост: %s",
                    user.getId(),
                    user.getUsername(),
                    user.getDateOfBirth().toString(),
                    user.getGrowth())
            );
        }
    }
}
