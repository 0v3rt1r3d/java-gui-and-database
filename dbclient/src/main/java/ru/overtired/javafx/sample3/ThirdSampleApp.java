package ru.overtired.javafx.sample3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.overtired.javafx.sample3.database.H2Database;

import java.io.IOException;

public class ThirdSampleApp extends Application {

    public static void main(String[] args) {
        H2Database.initDatabase();
        ThirdSampleApp.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        final Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample3/main_controller.fxml"));

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}

