package sample;

public class Choice {
    private String text;
    private String correct;
    private String[] incorrect;
    private String[] choices;
    private boolean[] choiceCorrect;
    public Choice(String text, String correct, String[] incorrect, String[] choices,boolean[] choiceCorrect) {
        this.text = text;
        this.correct = correct;
        this.incorrect = incorrect;
        this.choices = choices;
        this.choiceCorrect = choiceCorrect;
    }

    public String getText() {
        return text;
    }

    public String getCorrect() {
        return correct;
    }

    public String[] getIncorrect() {
        return incorrect;
    }


    public String[] getChoices() {
        return choices;
    }

    public boolean[] getChoiceCorrect() {
        return choiceCorrect;
    }
}