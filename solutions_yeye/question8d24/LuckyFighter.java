package solutions_yeye.question8d24;

import solutions_yeye.question7ec8.Fighter;

public class LuckyFighter{

    private static final int DAMAGE_VALUE = 2;
    
    private final String name;

    private final String type;

    private final int skill;

    private int stamina;

    private int luck;

    private GameEngine engine;

    private final Strategy strategy;

    public LuckyFighter(String name, String type, int skill, int stamina, int luck, GameEngine engine, Strategy strategy) {
        this.name = name;
        this.type = type;
        this.skill = skill;
        this.stamina = stamina;
        this.luck = luck;
        this.engine = engine;
        this.strategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public void takeDamage(int incomingDamage) {

        final int aggresiveResistanceThreshold = 2;
        final int averageResistanceThreshold = 10;

        int resultDamage = incomingDamage;

        if ((strategy == Strategy.DEFENSIVE)
            || (strategy == Strategy.AVERAGE && stamina <= averageResistanceThreshold)
            || (strategy == Strategy.AGGRESIVE && stamina <= aggresiveResistanceThreshold)) {
            
            engine.log(name + " tries to resist the damage...");
            resultDamage = applyLuckOnDefence(resultDamage);

        }
        
        this.stamina = Math.max(this.stamina - resultDamage, 0);
    }

    public int calculateDamage() {
        int resultDamage = DAMAGE_VALUE;
        if (strategy == Strategy.AGGRESIVE) {
            engine.log(name + " goes for an aggresive hit...");
            resultDamage = applyLuckOnAttack(resultDamage);
        }
        return resultDamage;
    }

    public int calculateAttackScore() {
        
        int attackScore = this.skill;

        attackScore += engine.rollDice();
        attackScore += engine.rollDice();

        return attackScore;
    }

    public boolean isDead() {
        return this.stamina == 0;
    }

    public boolean isLucky() {
        if (luck == 0) {
            engine.log(name + " is out of luck...");
            return false;
        }
        boolean isLucky = engine.rollDice() + engine.rollDice() < luck;
        luck = Math.min(luck - 1, 0);
        String logMessage = isLucky ? name + " is lucky!" : name + " is not lucky...";
        engine.log(logMessage);
        return isLucky;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - skill: %d; stamina: %d", name, type, skill, stamina);
    }

    private int applyLuckOnAttack(int baseDamage) {
        final int damageMult = 2;
        final int missPenalty = 1;
        if (isLucky()) {
            engine.log("The hit is aggresive!");
            return damageMult * baseDamage;
        } else {
            engine.log("The hit is missed with panalty...");
            return baseDamage - missPenalty;
        }
    }

    private int applyLuckOnDefence(int incomingDamage) {
        if (isLucky()) {
            engine.log("The damage is partially resisted!");
            return incomingDamage - 1;
        } else {
            engine.log("The damage is even worse!");
            return incomingDamage + 1;
        }
    }
}
