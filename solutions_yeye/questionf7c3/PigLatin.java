import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
public class PigLatin {

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    private static String translate(String word) {
        if (!Character.isAlphabetic(word.charAt(0))) {
            return word;
        }
        if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
            return word + "way";
        }
        if (word.length() == 1) {
            return word + "ay";
        }
        else {
            if (Character.isUpperCase(word.charAt(0))) {
                return Character.toUpperCase(word.charAt(1)) 
                + word.substring(2) 
                + Character.toLowerCase(word.charAt(0)) 
                + "ay";
            }
            else {
                return word.charAt(1) + word.substring(2) + word.charAt(0) + "ay";
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Deque<String> myDeque = new ArrayDeque<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        while (line != null) {
            myDeque.push(line);
            line = br.readLine();
        }

        String sentence = "";
        while (!myDeque.isEmpty()) {
            sentence = myDeque.poll();
            StringBuilder outputSentence = new StringBuilder();
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < sentence.length(); i++) {
                if (Character.isLetterOrDigit(sentence.charAt(i))) {
                    word.append(sentence.charAt(i));
                }
                else {
                    if (word.length() > 0) {
                        outputSentence.append(translate(word.toString()));
                        word = new StringBuilder();
                    }
                    outputSentence.append(sentence.charAt(i));
                }
            }
            System.out.println(outputSentence.toString());
        }
    }
}
