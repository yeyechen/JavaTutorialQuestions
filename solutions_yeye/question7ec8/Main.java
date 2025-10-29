package solutions_yeye.question7ec8;

public class Main {

    public static void main(String[] args) {
        
        GameEngine engine = new GameEngine();
        Fighter fighter1 = new Fighter("Joe", "Human Warrior", 16, 12, engine);
        Fighter fighter2 = new Fighter("Alex", "Elf Lord", 18, 6, engine);

        engine.simulateBattle(fighter1, fighter2);
    }
    
}
