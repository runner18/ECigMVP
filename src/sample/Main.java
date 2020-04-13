package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    Choice currentChoice;
    boolean[] choiceCorrect = new boolean[4];
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        FileInputStream imgLoc = new FileInputStream("src/sample/lung healthbar1.png");
        Image lungHealth = new Image(imgLoc,100,100,true,true);
        ImageView lungHealthBar= new ImageView(lungHealth);
        Text prompt = new Text();
        Button choice1 = new Button();
        Button choice2 = new Button();
        Button choice3 = new Button();
        Button choice4 = new Button();
        Text response = new Text();
        prompt.wrappingWidthProperty().bind(root.widthProperty());
        response.wrappingWidthProperty().bind(root.widthProperty());
        root.getChildren().addAll(lungHealthBar,prompt,choice1,choice2,choice3,choice4,response);
        writeScenarios();
        prompt.setText(currentChoice.getText());
        choice1.setText(currentChoice.getChoices()[0]);
        choice2.setText(currentChoice.getChoices()[1]);
        choice3.setText(currentChoice.getChoices()[2]);
        choice4.setText(currentChoice.getChoices()[3]);
        choice1.setOnAction(click -> {
            if(choiceCorrect[0]){
                response.setText(currentChoice.getCorrect());
            }else{
                response.setText(currentChoice.getIncorrect()[0]);
                Stats.damageLung();
            }
        });
        choice2.setOnAction(click -> {
            if(choiceCorrect[1]){
                response.setText(currentChoice.getCorrect());
            }else{
                response.setText(currentChoice.getIncorrect()[1]);
                Stats.damageLung();
            }
        });
        choice3.setOnAction(click -> {
            if(choiceCorrect[2]){
                response.setText(currentChoice.getCorrect());
            }else{
                response.setText(currentChoice.getIncorrect()[1]);
                Stats.damageLung();
            }
        });
        choice4.setOnAction(click -> {
            if(choiceCorrect[3]){
                response.setText(currentChoice.getCorrect());
            }else{
                response.setText(currentChoice.getIncorrect()[2]);
                Stats.damageLung();
            }
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 375));
        primaryStage.show();
    }

    public void writeScenarios(){
        String text = "You go over to your friends house after school. Once up in his room you see him pull out a vape. He asks you if you want to try it, what do you do?\n";
        String correct = "Correct! You should always try and provide facts as a lot of people who start vaping are ill informed on the facts of what it does to you.\n";
        String[] incorrect = {"Replying with “those things are disgusting” is an initial reaction a lot of people may have and they may try to sway a friend with that, however that may put the person you are trying to help in the mindset that “you just don’t understand”.", "Replying with “where did you get that?” is the worst response here as it leads them to believe that you show interest in it which you should always try to avoid.", "You can leave, but while you may be helping yourself you are at the same time abandoning a friend who is in need of help."};
        String[] choices = {"Reply “Those things are disgusting!”","Reply: “Where did you get that?”","Reply: “Do you know what those things do to you?”","Leave"};
        currentChoice = new Choice(text, correct, incorrect, choices);
        choiceCorrect[0] = false;
        choiceCorrect[1] = false;
        choiceCorrect[2] = true;
        choiceCorrect[3] = false;
    }
    public static void main(String[] args) {
        launch(args);
    }

}
