package ru.overtired.javafx.sample2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondSampleApp extends Application {

    public static void main(String[] args) {
        SecondSampleApp.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample2/clicker_controller.fxml"));

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.show();
    }
}
