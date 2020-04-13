package sample;

public class Choice {
    private String text;
    private String correct;
    private String[] incorrect;
    private String[] choices;
    public Choice(String text, String correct, String[] incorrect, String[] choices) {
        this.text = text;
        this.correct = correct;
        this.incorrect = incorrect;
        this.choices = choices;
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
}