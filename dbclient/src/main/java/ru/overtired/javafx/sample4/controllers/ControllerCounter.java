package ru.overtired.javafx.sample4.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCounter implements Initializable {

    private int counter = 0;

    @FXML
    private Label label;
    @FXML
    private Button increaseButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateLabel();
        increaseButton.setOnAction(event -> {
            counter++;
            updateLabel();
        });
    }

    private void updateLabel() {
        label.setText("Counter = " + counter);
    }
}
