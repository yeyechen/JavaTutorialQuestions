import java.util.Set;
import java.util.HashSet;
import java.util.Random;
public class LotteryNumbers {
    
    private static final int numNumbers = 7;

    private static final int lotteryMax = 49;

    public static void main(String[] args) {
        Random generator = new Random();
        Set<Integer> seen = new HashSet<>();
        for (int i = 1; i <= numNumbers; i++) {
            int x = generator.nextInt(lotteryMax) + 1;
            while (seen.contains(x)) {
                x = generator.nextInt(lotteryMax) + 1;
            }

            if (i == numNumbers) {
                System.out.println("Bonus Number " + ": " + x);
            }
            else {
                System.out.println("Number " + i + ": " + x);
            }
            seen.add(x);
        }
    }
}
