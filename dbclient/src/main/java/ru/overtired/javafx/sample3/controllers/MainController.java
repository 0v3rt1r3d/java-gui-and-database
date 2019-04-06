package ru.overtired.javafx.sample3.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.overtired.javafx.sample3.models.User;
import ru.overtired.javafx.sample3.utils.HibernateManager;

public class MainController {

    @FXML
    private VBox vboxLayout;

    @FXML
    private void loadUsers() {
        HibernateManager instance = HibernateManager.getInstance();
        for (User user : instance.getAllUsers()) {
            final String labelText = String.format(
                    "%s\nИмя: %s\nДата рождения: %s\nРост: %s",
                    user.getId(),
                    user.getUsername(),
                    user.getDateOfBirth().toString(),
                    user.getGrowth());

            vboxLayout.getChildren().add(new Label(labelText));
            vboxLayout.requestLayout();
        }
    }
}
