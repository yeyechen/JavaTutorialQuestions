import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReversedOrderOfInput2 {

    public static void main(String[] args) throws IOException{

        Deque<String> myDeque = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (line != null) {
            myDeque.push(line);
            line = br.readLine();
        }
        // print in reverse order
        while (!myDeque.isEmpty()) {
            System.out.println(myDeque.pop());
        }
    }
}
