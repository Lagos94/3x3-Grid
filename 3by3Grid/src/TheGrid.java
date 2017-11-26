import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TheGrid extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane mainPane = new Pane();
        primaryStage.setTitle("This is the 3x3 Grid");
        primaryStage.setScene(new Scene(mainPane, 300, 200));

        double dividerYLines = 3;
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.RED);
            line.startXProperty().bind(mainPane.widthProperty().divide(dividerYLines));
            line.startYProperty().bind(mainPane.layoutYProperty());
            line.endXProperty().bind(line.startXProperty());
            line.endYProperty().bind(mainPane.heightProperty());
            mainPane.getChildren().add(line);
            dividerYLines /= 2;
        }
        double dividerXLines = 3;
        for (int i = 0; i < 2; i++) {
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.startXProperty().bind(mainPane.layoutXProperty());
            line.startYProperty().bind(mainPane.heightProperty().divide(dividerXLines));
            line.endXProperty().bind(mainPane.widthProperty());
            line.endYProperty().bind(mainPane.heightProperty().divide(dividerXLines));
            mainPane.getChildren().add(line);
            dividerXLines /= 2;
        }
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}