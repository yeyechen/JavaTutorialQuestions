import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class WordCount {

    private static int lines = 0;

    private static int words = 0;

    private static int chars = 0;

    private static void countWordsAndChars(String line) {
        boolean inWord = false;

        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetterOrDigit(line.charAt(i))) {
                chars++;
                if (!inWord) {
                    words++;
                }
                inWord = true;
            } else {
                inWord = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (line != null) {
            lines++;
            countWordsAndChars(line);
            line = br.readLine();
        }

        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Characters: " + chars);
    }
}
