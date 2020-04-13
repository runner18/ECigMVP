package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        FileInputStream imgLoc = new FileInputStream("src/sample/lung healthbar1.png");
        Image lungHealth = new Image(imgLoc);
        ImageView imageView = new ImageView(lungHealth);
        Label prompt = new Label();
        Button choice1 = new Button();
        Button choice2 = new Button();
        Button choice3 = new Button();

        root.getChildren().addAll(imageView,prompt,choice1,choice2,choice3);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    //test
}
