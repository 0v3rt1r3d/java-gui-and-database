package ru.overtired.javafx.sample4.navigation;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.overtired.javafx.sample4.controllers.ControllerForScene2;
import ru.overtired.javafx.sample4.utils.InflateUtils;

public class NavigationManager {

    private Stage stage;

    public NavigationManager(Stage stage) {
        this.stage = stage;
    }

    public static NavigationManager from(Node node) {
        return (NavigationManager) node.getScene().getUserData();
    }

    public void goToScene1() {
        final Parent root = InflateUtils.loadFxml("/fxml/sample4/controller_scene_1.fxml");
        final Scene scene = createSceneWithThisNavigationManager(root);

        stage.setScene(scene);
    }


    public void goToScene2(int countOfCounters) {
        final ControllerForScene2 controller = new ControllerForScene2(countOfCounters);
        final Parent root = InflateUtils.loadFxmlWithCustomController(
                "/fxml/sample4/controller_scene_2.fxml",
                controller
        );
        final Scene scene = createSceneWithThisNavigationManager(root);
        stage.setScene(scene);
    }

    private Scene createSceneWithThisNavigationManager(Parent root) {
        final Scene scene = new Scene(root);
        scene.setUserData(this);
        return scene;
    }
}
