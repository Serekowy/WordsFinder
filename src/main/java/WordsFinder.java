import java.util.*;
import java.util.stream.Collectors;

public class WordsFinder {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj tekst z dowolnymi powtarzającymi się słowami: ");
        String text = scan.nextLine();

        Map<String, Integer> foundWords = wordsFinder(text);

        System.out.print(foundWords);
    }

    public static Map<String, Integer> wordsFinder(String text) {
        List<String> separatedWords = separateWords(text.toLowerCase());
        Map<String, Integer> repeatedWords = new LinkedHashMap<>();

        for (String word : separatedWords) {
            if (repeatedWords.containsKey(word)) {
                repeatedWords.compute(word, (key, value) -> value += 1);
            } else {
                repeatedWords.compute(word, (key, value) -> value = 1);
            }
        }

        return repeatedWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o,n) -> o,
                        LinkedHashMap::new
                ));
    }

    public static List<String> separateWords(String text) {
        return Arrays.asList(text.split(" "));
    }
}