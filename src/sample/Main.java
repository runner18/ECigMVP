package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Main extends Application {
    Image[] healthbarPics = new Image[4];
    Image[] scenarioPics = new Image [5];
    int lungHealth = 0;
    Choice[] choiceList = new Choice[5];
    int currentChoice = 0;
    Label prompt = new Label();
    Button choice1 = new Button();
    Button choice2 = new Button();
    Button choice3 = new Button();
    Button choice4 = new Button();
    Label response = new Label();
    ImageView lungHealthBar = null;
    ImageView scenarioImage = null;
    MenuItem citation = new MenuItem("View Citation");
    MenuItem about = new MenuItem("About");
    Menu options = new Menu("Options");
    MenuBar topBar = new MenuBar();
    String[] citations = new String[5];
    boolean currentChoiceWrong = false;

    @Override
    public void start(Stage primaryStage){
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf("d0ffff"), new CornerRadii(0), new Insets(0))));

        prompt.setWrapText(true);
        prompt.setMinHeight(100);
        prompt.setMaxHeight(100);
        prompt.setAlignment(Pos.BOTTOM_CENTER);
        prompt.setPadding(new Insets(10));

        response.setWrapText(true);
        response.setMinHeight(200);
        response.setMaxHeight(200);
        response.setAlignment(Pos.TOP_CENTER);
        response.setPadding(new Insets(10));

        choice1.prefWidthProperty().bind(root.widthProperty());
        choice2.prefWidthProperty().bind(root.widthProperty());
        choice3.prefWidthProperty().bind(root.widthProperty());
        choice4.prefWidthProperty().bind(root.widthProperty());

        healthbarPics[0] = new Image("resources/healthbar1.png",100,100,true,true);
        healthbarPics[1] = new Image("resources/healthbar2.png",100,100,true,true);
        healthbarPics[2] = new Image("resources/healthbar3.png",100,100,true,true);
        healthbarPics[3] = new Image("resources/healthbar4.png",100,100,true,true);
        lungHealthBar = new ImageView(healthbarPics[0]);

        scenarioPics[0] = new Image("resources/scenario1.png",300,300,true,true);
        scenarioPics[1] = new Image("resources/scenario2.png",300,300,true,true);
        scenarioPics[2] = new Image("resources/scenario3.png",300,300,true,true);
        scenarioPics[3] = new Image("resources/scenario4.png",300,300,true,true);
        scenarioPics[4] = new Image("resources/scenario5.png",300,300,true,true);
        scenarioImage = new ImageView((scenarioPics[0]));
        scenarioImage.setFitHeight(300);

        topBar.getMenus().add(options);
        options.getItems().addAll(citation,about);
        citation.setOnAction(click ->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Citation");
            alert.setHeaderText(null);
            alert.setContentText(citations[currentChoice]);
            alert.showAndWait();
        });
        about.setOnAction(click ->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("By Max Gerckens, Noah Evans, and Alex Diehl, 2020");
            alert.showAndWait();
        });

        root.getChildren().addAll(topBar,lungHealthBar,scenarioImage,prompt,choice1,choice2,choice3,choice4,response);
        writeScenarios();
        prompt.setText(choiceList[currentChoice].getText());
        choice1.setText(choiceList[currentChoice].getChoices()[0]);
        choice2.setText(choiceList[currentChoice].getChoices()[1]);
        choice3.setText(choiceList[currentChoice].getChoices()[2]);
        choice4.setText(choiceList[currentChoice].getChoices()[3]);
        choice1.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[0]){
                response.setText(choiceList[currentChoice].getCorrect());
                currentChoice++;
                currentChoiceWrong = false;

            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[0]);
                if(!currentChoiceWrong) {lungHealth++;}
                currentChoiceWrong = true;

            }
            redraw();
        });
        choice2.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[1]){
                response.setText(choiceList[currentChoice].getCorrect());
                currentChoice++;
                currentChoiceWrong = false;
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[1]);
                if(!currentChoiceWrong) {lungHealth++;}
                currentChoiceWrong = true;
            }
            redraw();
        });
        choice3.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[2]){
                response.setText(choiceList[currentChoice].getCorrect());
                currentChoice++;
                currentChoiceWrong = false;
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[1]);
                if(!currentChoiceWrong) {lungHealth++;}
                currentChoiceWrong = true;
            }
            redraw();
        });
        choice4.setOnAction(click -> {
            if(choiceList[currentChoice].getChoiceCorrect()[3]){
                response.setText(choiceList[currentChoice].getCorrect());
                currentChoice++;
                currentChoiceWrong = false;
            }else{
                response.setText(choiceList[currentChoice].getIncorrect()[2]);
                if(!currentChoiceWrong) {lungHealth++;}
                currentChoiceWrong = true;
            }
            redraw();
        });
        primaryStage.setTitle("Erase the Vape");
        primaryStage.setScene(new Scene(root, 550, 800));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void redraw(){
        try{
            lungHealthBar.setImage(healthbarPics[lungHealth]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Lose!");
            alert.setHeaderText(null);
            alert.setContentText("Your friend has become completely addicted to nicotine!");
            alert.showAndWait();
            System.exit(0);
        }
        try {
            scenarioImage.setImage(scenarioPics[currentChoice]);
            prompt.setText(choiceList[currentChoice].getText());
        }
        catch(ArrayIndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Win!");
            alert.setHeaderText(null);
            alert.setContentText("Your friend has successfully stopped vaping!");
            alert.showAndWait();
            System.exit(0);
        }
        choice1.setText(choiceList[currentChoice].getChoices()[0]);
        choice2.setText(choiceList[currentChoice].getChoices()[1]);
        choice3.setText(choiceList[currentChoice].getChoices()[2]);
        choice4.setText(choiceList[currentChoice].getChoices()[3]);
    }

    public void writeScenarios(){
        String text = "You go over to your friends house after school. Once up in his room you see him pull out a vape. He asks you if you want to try it, what do you do?";
        String correct = "Correct! You should always try and provide facts. A lot of people who start vaping are ill informed on the facts of what it does to you.\n\nAccording to the CDC, E-Cig aerosol can contain many substances harmful to the user’s lungs and overall health. This includes nicotine, which is a highly addictive substance that can harm brain development for adolescents and young adults. The aerosol also contains many cancer-causing substances, and diacetyl, which is tied to serious lung disease.";
        String[] incorrect = {"Replying with “those things are disgusting” is an initial reaction a lot of people may have and they may try to sway a friend with that, however that may put the person you are trying to help in the mindset that “you just don’t understand”.", "Replying with “where did you get that?” is the worst response here as it leads them to believe that you show interest in it which you should always try to avoid.", "You can leave, but while you may be helping yourself you are at the same time abandoning a friend who is in need of help."};
        String[] choices = {"“Those things are disgusting!”","“Where did you get that?”","“Do you know what those things do to you?”","Leave"};
        boolean[] choiceCorrect = {false,false,true,false};
        choiceList[0] = new Choice(text, correct, incorrect, choices,choiceCorrect);

        text = "The same friend comes up to you the next day. “Hey man I’m sorry about yesterday. My brother got me started on vaping and it’s really cool!”";
        correct = "Correct. You should always make an attempt to challenge the idea that vaping is cool.\n\nAccording to a 2019 study, students are only likely to vape in schools where it was common among other students, and these students were more likely to believe e-cigs aren’t harmful. Vaping happens because they are peer pressured by others, and don’t know a harmful effect. Don’t be a statistic.";
        incorrect = new String[]{"Replying “Don’t worry about it” is the worst choice here as it will support his thoughts that vaping isn’t that bad.","Ignoring your friend will let you avoid vaping, but it doesn't address your friend's problem","Leaving will let you avoid vaping, but it doesn't address your friend's problem"};
        choices = new String[]{"“Don’t worry about it.”","Ignore Him","Leave","“Just because your brother does it doesn’t make it cool.”"};
        choiceCorrect = new boolean[]{false,false,false,true};
        choiceList[1] = new Choice(text,correct,incorrect,choices,choiceCorrect);

        text = "Later that week at school you are waiting outside of the bathroom for your friend but he is taking a lot longer than usual so you decide to check on him. When you enter the bathroom he is hitting his vape. What do you do?";
        correct = "Correct. Telling is the right option even if it’s not the easy choice. The incident in his room was obviously not a one time deal and he is at serious risk of becoming addicted if not already.\n\nAccording to the National Institute  of Drug Abuse, nicotine trains the brain to repeat the same action in order to get more nicotine. So when you use a e-cig, your brain is being taught to not be able to stop. This can also train the body to take more dangerous drugs as well.";
        incorrect = new String[]{"Leaving without saying anything wouldn't help your friend at all","Replying “If he is vaping at school, he has begun to develop a habit in which he is not afraid of getting in trouble","Trying to take the vape from him may end in a physical confrontation which will make you lose any chance of convincing him to stop."};
        choices = new String[]{"Leave and report the incident to a teacher/principal","Leave and stay quiet","“You need to stop it, what if you get in trouble?”","Try to take the vape from him"};
        choiceCorrect = new boolean[]{true,false,false,false};
        choiceList[2] = new Choice(text,correct,incorrect,choices,choiceCorrect);

        text = "A few days after you reported the incident your friend approaches you at the bus stop. He begins to yell that he got in serious trouble because of you. How do you reply?";
        correct = "Correct. Your friend is feeling betrayed and probably extremely stressed out after losing his source of nicotine. Reassurance will help him understand that you have his health in mind\n\nA little more than 1 out of every 10 middle school students (10.5%) reported in 2019 that they used electronic cigarettes in the past 30 days.";
        incorrect = new String[]{"A confrontational attitude will make him less likely to listen to you in the future.","A confrontational attitude will make him less likely to listen to you in the future.","Taking the moral high ground is unlikely to make your friend see the situation any differently."};
        choices = new String[]{"“Vaping was a dumb idea in the first place”","“You should have listened to me”","“I was just trying to help you, I was worried”","“I did what I thought was right”"};
        choiceCorrect = new boolean[]{false,false,true,false};
        choiceList[3] = new Choice(text,correct,incorrect,choices,choiceCorrect);

        text = "A few weeks later, your friend comes up to you and apologizes about the way he acted and confides in you that he is still using the vape but wants to stop. How do you reply?";
        correct = "Correct. Your friend is feeling betrayed and probably extremely stressed out after losing his source of nicotine. Reassurance will help him understand that you have his health in mind. This may may not seem like it will work as his parents were already notified and it didn’t seem to help, however he wants to quit now which is the most crucial part of getting anyone who is addicted to quit.\n\nA study in 2002 found that roughly 60 to 90% of people attempting to quit nicotine products relapsed within the first year.";
        incorrect = new String[]{"This is the worst choice you can make here. It will leave your friend feeling abandoned which would ruin his chances of quitting.","This is a valid way of stopping nicotine abuse, but he's unlikely to succeed without a support network.","This is a valid way of stopping nicotine abuse, but he's unlikely to succeed without a support network."};
        choices = new String[]{"“It’s not my problem anymore”","“You need to tell your parents.”","“Lean yourself off.”","“Stop cold turkey.”"};
        choiceCorrect = new boolean[]{false,true,false,false};
        choiceList[4] = new Choice(text,correct,incorrect,choices,choiceCorrect);

        citations[0] = "About Electronic Cigarettes (E-Cigarettes). (2020, February 24). Retrieved from https://www.cdc.gov/tobacco/basic_information/e-cigarettes/about-e-cigarettes.html";
        citations[1] = "Lippert, A.M., Corsi, D.J. & Venechuk, G.E. Schools Influence Adolescent E-Cigarette use, but when? Examining the Interdependent Association between School Context and Teen Vaping over time. J Youth Adolescence 48, 1899–1911 (2019). https://doi.org/10.1007/s10964-019-01106-y";
        citations[2] = "National Institute on Drug Abuse. (2018, September 28). Recent Research Sheds New Light on Why Nicotine is So Addictive. Retrieved from https://www.drugabuse.gov/about-nida/noras-blog/2018/09/recent-research-sheds-new-light-why-nicotine-so-addictive";
        citations[3] = "T. W. Wang et al., “Tobacco Product Use and Associated Factors Among Middle and High School Students,” Centers for Disease Control and Prevention, 05-Dec-2019. [Online]. Available: http://dx.doi.org/10.15585/mmwr.ss6812a1. [Accessed: 27-Apr-2020].";
        citations[4] = "“Smoking relapse rates drop off sharply after two years,” EurekAlert!, 27-Feb-2002. [Online]. Available: https://www.eurekalert.org/pub_releases/2002-02/cfta-srr022702.php. [Accessed: 27-Apr-2020].";
    }
    public static void main(String[] args) {
        launch(args);
    }

}
