import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReversedOrderOfInput {

    private static final int maxLines = 100;

    public static void main(String[] args) throws IOException{

        String[] inputLines = new String[maxLines];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int counter = 0;

        while (line != null && counter < maxLines) {
            inputLines[counter] = line;
            counter++;
            line = br.readLine();
        }
        
        // print in reverse order
        for (int i = counter - 1; i >= 0; i--) {
            System.out.println(inputLines[i]);
        }
    }
}
