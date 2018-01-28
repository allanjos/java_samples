import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Fx01 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        StackPane stackPaneRoot = new StackPane();
        Label label = new Label();

        label.setText("A simple label");
        stackPaneRoot.getChildren().add(label);

        Scene scene = new Scene(stackPaneRoot, 250, 100);
        palco.setTitle("JavaFX scene");
        palco.setScene(scene);
        palco.show();

    }
}