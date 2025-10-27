import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class RandomNumbers {

    public static void main(String[] args) {

        assert args.length == 1;

        int x = Integer.parseInt(args[0]);
        Random generator = new Random();
        Set<Integer> seen = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Generating random numbers:");

        while (seen.size() < x) {
            int num = generator.nextInt(x);
            seen.add(num);
            numbers.add(num);
        }
        String line = numbers.stream().map(String::valueOf).reduce((s1, s2) -> s1 + ", " + s2).orElse("no value");
        System.out.println(line);
        System.out.println("I had to generate " + numbers.size() + " random numberes between 0 and " + (x - 1) + 
        " to have produced all such numbers at least once." );
    }
}
