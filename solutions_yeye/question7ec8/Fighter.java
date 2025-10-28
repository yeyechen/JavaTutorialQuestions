package solutions_yeye.question7ec8;
import java.util.Random;

public class Fighter {
    
    private final String name;

    private final String type;

    private final int skill;

    private int stamina;

    private GameEngine engine;

    private static final int DAMAGE_VALUE = 2;

    public Fighter(String name, String type, int skill, int stamina, GameEngine gameEngine) {
        this.name = name;
        this.type = type;
        this.skill = skill;
        this.stamina = stamina;
        this.engine = gameEngine;
    }

    // Reduce the fighter's stamina accordingly
    public void takeDamage(int damage) {
        this.stamina = Math.max(this.stamina - damage, 0);
    }

    // Return the number of damage points to be inflicted on opponent
    public int calculateDamage() {
        return DAMAGE_VALUE;
    }

    // Calculate an attack score for the fighter using the procedure described above
    public int calculateAttackScore() {
        
        int attackScore = this.skill;

        attackScore += engine.rollDice();
        attackScore += engine.rollDice();

        return attackScore;
    }

    // Determine whether fighter is still alive
    public boolean isDead() {
        return this.stamina == 0;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - skill: %d; stamina: %d", name, type, skill, stamina);
    }

    public String getName() {
        return this.name;
    }
}
