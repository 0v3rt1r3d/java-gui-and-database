package ru.overtired.javafx.sample4.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import ru.overtired.javafx.sample4.navigation.NavigationManager;

public class ControllerForScene1 {

    @FXML
    private Button goToScene2Button;
    @FXML
    private Slider slider;

    @FXML
    private void goToScene2() {
        NavigationManager.from(goToScene2Button).goToScene2((int) slider.getValue());
    }
}
