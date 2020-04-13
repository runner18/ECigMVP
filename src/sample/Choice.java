package sample;

public class Choice {
    private boolean isGood;
    private String text;
    public Choice(String text, boolean isGood){
        this.text = text;
        this.isGood = isGood;
    }

    public boolean isGood() {
        return isGood;
    }

    public String getText() {
        return text;
    }
}
