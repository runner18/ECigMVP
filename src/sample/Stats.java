package sample;

public class Stats {
    private static int lungHealth = 3;
    private static int addiction = 0;

    public static int getLungHealth() {
        return lungHealth;
    }

    public static int getAddiction() {
        return addiction;
    }
    public static void damageLung(){
        lungHealth--;
    }
    public static void addAddiction(){
        addiction++;
    }
}
