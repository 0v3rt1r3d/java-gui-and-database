package ru.overtired.javafx.sample4;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.overtired.javafx.sample4.navigation.NavigationManager;

public class FourthSampleApp extends Application {

    public static void main(String[] args) {
        FourthSampleApp.launch(args);
    }

    @Override
    public void start(Stage stage) {
        NavigationManager nm = new NavigationManager(stage);
        nm.goToScene1();
        stage.show();
    }
}

