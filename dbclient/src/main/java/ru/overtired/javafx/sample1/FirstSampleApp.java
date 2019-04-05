package ru.overtired.javafx.sample1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstSampleApp extends Application {

    private int clickCounter = 0;
    private Text text = null;

    @Override
    public void start(Stage stage) {
        final Button button = new Button();
        button.setText("button");
        button.setOnAction(eventHandler);
        button.setPadding(new Insets(10));

        text = new Text("Click on button, please");
        final FlowPane root = new FlowPane(button, text);
        root.setHgap(20);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);

        stage.setTitle("The clicker counter");
        stage.setScene(new Scene(root));
        stage.setWidth(400);
        stage.setHeight(400);
        stage.show();
    }

    private EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            clickCounter++;
            text.setText("You clicked " + clickCounter + " times");
        }
    };
}
