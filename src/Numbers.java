package Roulette;
import java.util.concurrent.ThreadLocalRandom;

public class Numbers {
    private boolean black;
    private int number;

    public Numbers(){
        number = ThreadLocalRandom.current().nextInt(0, 37 + 1);
    }

    public int getNumber(){
        return number;
    }

}
