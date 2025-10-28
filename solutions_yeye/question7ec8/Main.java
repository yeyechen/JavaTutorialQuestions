package solutions_yeye.question7ec8;

public class Main {

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        Fighter fighter1 = new Fighter("Joe", "Human Warrior", 16, 12, engine);
        Fighter fighter2 = new Fighter("Alex", "Elf Lord", 18, 6, engine);

        System.out.println("At start of battle, stats are:");
        System.out.println(fighter1.toString());
        System.out.println(fighter2.toString());

        while (!fighter1.isDead() && !fighter2.isDead()) {
            System.out.println("------------------------------");
            int score1 = fighter1.calculateAttackScore();
            int score2 = fighter2.calculateAttackScore();

            if (score1 > score2) {
                fighter2.takeDamage(fighter1.calculateDamage());
                System.out.println(String.format("%s hits %s", fighter1.getName(), fighter2.getName()));
            } else if (score1 < score2) {
                fighter1.takeDamage(fighter2.calculateDamage());
                System.out.println(String.format("%s hits %s", fighter2.getName(), fighter1.getName()));
            } else {
                System.out.println(String.format("%s draws with %s", fighter1.getName(), fighter2.getName()));
            }
            System.out.println(fighter1.toString());
            System.out.println(fighter2.toString());
        }
    }
    
}
