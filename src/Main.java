import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
        int times = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < times; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);

        }
        for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
            String word = entry.getKey();
            ArrayList<String> synonyms = entry.getValue();
            System.out.println(word + " - " + String.join(", ", synonyms));
        }
    }
}
