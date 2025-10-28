package solutions_yeye.question7ec8;
import java.util.Random;

public class GameEngine {

    private final Random dice;
    
    public GameEngine() {
        this.dice = new Random();
    }

    public int rollDice() {
        return dice.nextInt(6) + 1;
    }

}
