package ru.overtired.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ProgressBar progressbar;

    @FXML
    private ResourceBundle resourceBundle;


    @FXML
    private void clicked() {
        System.out.println("Hello, world!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resources
    }
}
