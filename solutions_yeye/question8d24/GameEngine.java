package solutions_yeye.question8d24;
import java.util.Random;

public class GameEngine {

    private final Random dice;
    
    public GameEngine() {
        this.dice = new Random();
    }

    public int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public void log(String message) {
        System.out.println(message);
    }

    // Simulate battle between two fighters, displaying how the battle
    // progresses and who wins
    public void simulateBattle(LuckyFighter fighter1, LuckyFighter fighter2) {
        log("At start of battle, stats are:");
        log(fighter1.toString());
        log(fighter2.toString());

        while (!fighter1.isDead() && !fighter2.isDead()) {
            log("------------------------------");
            int score1 = fighter1.calculateAttackScore();
            int score2 = fighter2.calculateAttackScore();

            if (score1 > score2) {
                fighter2.takeDamage(fighter1.calculateDamage());
                log(String.format("%s hits %s", fighter1.getName(), fighter2.getName()));
            } else if (score1 < score2) {
                fighter1.takeDamage(fighter2.calculateDamage());
                log(String.format("%s hits %s", fighter2.getName(), fighter1.getName()));
            } else {
                log(String.format("%s draws with %s", fighter1.getName(), fighter2.getName()));
            }
            log(fighter1.toString());
            log(fighter2.toString());
        }
        LuckyFighter winner = fighter1.isDead() ? fighter2 : fighter1;
        log("End of battle, " + winner.toString() + " wins!");
    }
}
