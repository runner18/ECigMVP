package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    Image[] healthbarPics = new Image[4];
    int lungHealth = 0;
    Choice[] choiceList = new Choice[5];
    int currentChoice = 0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        FileInputStream imgLoc = new FileInputStream("src/sample/lung healthbar1.png");
        healthbarPics[0] = new Image(imgLoc,100,100,true,true);
        imgLoc = new FileInputStream("src/sample/lung healthbar2.png");
        healthbarPics[1] = new Image(imgLoc,100,100,true,true);
        imgLoc = new FileInputStream("src/sample/lung healthbar3.png");
        healthbarPics[2] = new Image(imgLoc,100,100,true,true);
        imgLoc = new FileInputStream("src/sample/lung healthbar4.png");
        healthbarPics[3] = new Image(imgLoc,100,100,true,true);

        ImageView lungHealthBar= new ImageView(healthbarPics[0]);

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
        prompt.setText(choiceList[currentChoice].getText());
        choice1.setText(choiceList[currentChoice].getChoices()[0]);
        choice2.setText(choiceList[currentChoice].getChoices()[1]);
        choice3.setText(choiceList[currentChoice].getChoices()[2]);
        choice4.setText(choiceList[currentChoice].getChoices()[3]);
        choice1.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[0]){
                response.setText(choiceList[currentChoice].getCorrect());
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[0]);
                lungHealth--;
            }
            lungHealthBar.setImage(healthbarPics[lungHealth]);
        });
        choice2.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[1]){
                response.setText(choiceList[currentChoice].getCorrect());
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[1]);
                lungHealth--;
            }
        });
        choice3.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[2]){
                response.setText(choiceList[currentChoice].getCorrect());
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[1]);
                lungHealth--;
            }
        });
        choice4.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[3]){
                response.setText(choiceList[currentChoice].getCorrect());
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[2]);
                lungHealth--;
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
        boolean[] choiceCorrect = {false,false,true,false};
        choiceList[0] = new Choice(text, correct, incorrect, choices,choiceCorrect);

        text = "The same friend comes up to you the next day. “Hey man I’m sorry about yesterday. My brother got me started on vaping and it’s really cool!”.\n";
        correct = "Correct. You should always make an attempt to hinder the idea that vaping is cool.";
        incorrect[0] = "Replying “Don’t worry about it man” is the worst choice here as it will help him support his thoughts that vaping isn’t that bad.";
        incorrect[1] = "Ignoring your friend is good in the regard that you are avoiding vaping; however, it provides a problem in that you have a friend that needs your support.";
        incorrect[2] = "Leaving the situation is good in the regard that you are avoiding vaping however it provides a problem in that you have a friend that needs your support.";
        choices[0] = "Reply: “Don’t worry about it.”";
        choices[1] = "Ignore Him";
        choices[2] = "Leave";
        choices[3] = "Reply: “Just because your brother does it doesn’t make it cool.”";
        choiceCorrect[0] = false;
        choiceCorrect[1] = false;
        choiceCorrect[2] = false;
        choiceCorrect[3] = true;
        choiceList[1] = new Choice(text,correct,incorrect,choices,choiceCorrect);

        text = "Later that week at school you are waiting outside of the bathroom for your friend but he is taking a lot longer than usual so you decide to check on him. When you enter the bathroom he is hitting his vape. What do you do?\n";
        correct = "Correct. Telling is the right option even if it’s not the easy choice. The incident in his room was obviously not a one time deal and he is at serious risk of becoming addicted if not already. \n";
        incorrect[0] = " Leaving without saying anything again falls under the category of not helping a friend in need.";
        incorrect[1] = "Replying “You need to stop it what if you get in trouble” is not correct if he is vaping at school, he has begun to develop a habit in which he is not afraid of getting in trouble";
        incorrect[2] = "Trying to take the vape from him may end in a physical confrontation which will make you lose any chance of convincing him to stop.";
        choices[0] = "Leave and report the incident to a teacher/principal";
        choices[1] = "Leave and stay quiet about his actions";
        choices[2] = "Reply: “You need to stop it, what if you get in trouble?”";
        choices[3] = "Try to take the vape from him";
        choiceCorrect[0] = true;
        choiceCorrect[1] = false;
        choiceCorrect[2] = false;
        choiceCorrect[3] = false;
        choiceList[2] = new Choice(text,correct,incorrect,choices,choiceCorrect);


        
    }
    public static void main(String[] args) {
        launch(args);
    }

}
