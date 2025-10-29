package solutions_yeye.question8d24;

public class Main {

    public static void main(String[] args) {
        
        GameEngine engine = new GameEngine();
        LuckyFighter fighter1 = new LuckyFighter("Joe", "Human Warrior", 16, 12, 12, engine, Strategy.AGGRESIVE);
        LuckyFighter fighter2 = new LuckyFighter("Alex", "Elf Lord", 18, 6, 11, engine, Strategy.DEFENSIVE);

        engine.simulateBattle(fighter1, fighter2);
    }
    
}
