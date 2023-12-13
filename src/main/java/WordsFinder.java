import com.sun.source.tree.UsesTree;

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.Comparator;
public class WordsFinder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj tekst z dowolnymi powtarzającymi się słowami: ");
        String text = scan.nextLine();

        Map<String, Integer> foundWords = wordsFinder(text);

        System.out.print(foundWords);
    }

    public static Map<String, Integer> wordsFinder(String text) {
        Map<String, Integer> repeatedWords = new TreeMap<>();
        List<String> separatedWords = separateWords(text.toLowerCase());

        for (String word : separatedWords) {
            repeatedWords.put(word, 0);
        }

        for (String word : separatedWords) {
            if (repeatedWords.containsKey(word)) {
                int oneMore = repeatedWords.get(word) + 1;
                repeatedWords.put(word, oneMore);
            }
        }

        //zrobic sortowanie

        Map<String, Integer> sortedByValue = new HashMap<>(repeatedWords);

        repeatedWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedByValue.put(x.getKey(), x.getValue()));


        return sortedByValue;
    }

    public static List<String> separateWords(String text) {
        List<String> separatedWords = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;
        text = text.concat(" ");

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == ' ') {
                endIndex = i;
                String word = text.substring(startIndex, endIndex);
                separatedWords.add(word.trim());
                startIndex = endIndex;
            }
        }

        return separatedWords;
    }
}