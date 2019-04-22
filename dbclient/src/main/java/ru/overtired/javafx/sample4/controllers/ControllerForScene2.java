package ru.overtired.javafx.sample4.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import ru.overtired.javafx.sample4.navigation.NavigationManager;
import ru.overtired.javafx.sample4.utils.InflateUtils;

import java.net.URL;
import java.util.ResourceBundle;

// You can implements Initializable to make some things on Controller created
public class ControllerForScene2 implements Initializable {

    private int countOfCounters;

    @FXML
    private HBox container;
    @FXML
    private Button goBackButton;

    private ControllerForScene2() {
        throw new RuntimeException("This controller can be initialized only with custom data");
    }

    public ControllerForScene2(int countOfCounters) {
        this.countOfCounters = countOfCounters;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // For example, create background
        container.setBackground(new Background(new BackgroundFill(new Color(0.1, 0.8, 0.1, 0.1), null, null)));

        // Or set listener for button
        goBackButton.setOnAction(event -> NavigationManager.from(container).goToScene1());

        // Or add your custom controllers to the screen
        for (int i = 0; i < countOfCounters; i++) {
            Parent counterNode = InflateUtils.loadFxml("/fxml/sample4/controller_counter.fxml");
            container.getChildren().add(counterNode);
        }
    }
}
