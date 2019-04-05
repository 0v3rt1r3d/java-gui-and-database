package ru.overtired.javafx.sample2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClickerController {

    private int clickedCounter = 0;

    @FXML
    private Label text;

    @FXML
    private void doThisOnClick(ActionEvent event) {
        clickedCounter++;
        text.setText("You clicked " + clickedCounter + " times");
    }
}
