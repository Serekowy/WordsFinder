import java.util.*;

public class WordsFinder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj tekst z dowolnymi powtarzającymi się słowami: ");
        String text = scan.nextLine();

        Map<String, Integer> foundWords = wordsFinder(text);
    }

    public static Map<String, Integer> wordsFinder(String text) {
        Map<String, Integer> repeatedWords = new HashMap<>();
        List<String> separatedWords = new ArrayList<>();
        String separator = " ";

        text = text.toLowerCase();

        separatedWords = separateWords(text);

        //dodac zliczanie slow i reszte

        System.out.print(separatedWords);

        return repeatedWords;
    }

    public static List<String> separateWords(String text) {
        List<String> separatedWords = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;
        text = text.concat(" ");

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == ' ') {
                endIndex = i;
                String word = text.substring(startIndex,endIndex);
                separatedWords.add(word.trim());
                startIndex = endIndex;
            }
        }

        return separatedWords;
    }
}