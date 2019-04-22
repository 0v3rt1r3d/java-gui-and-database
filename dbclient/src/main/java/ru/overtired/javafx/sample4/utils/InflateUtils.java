package ru.overtired.javafx.sample4.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;

import java.io.IOException;

public class InflateUtils {
    private InflateUtils() {
    }

    public static Parent loadFxml(String resource) {
        try {
            return FXMLLoader.load(resource.getClass().getResource(resource));
        } catch (IOException e) {
            throw new RuntimeException("Could not load fxml: " + resource, e);
        }
    }

    public static Parent loadFxmlWithCustomController(String resource, Object controller) {
        try {
            Callback<Class<?>, Object> controllerFactory = param -> {
                if (param == controller.getClass()) {
                    return controller;
                } else {
                    throw new RuntimeException("Cannot not bind custom controller with " + resource);
                }
            };
            return FXMLLoader.load(
                    resource.getClass().getResource(resource),
                    null,
                    null,
                    controllerFactory
            );
        } catch (IOException e) {
            throw new RuntimeException("Could not load fxml: " + resource, e);
        }
    }
}
