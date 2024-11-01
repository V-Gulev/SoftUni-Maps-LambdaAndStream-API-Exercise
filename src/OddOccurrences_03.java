import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String lowerCase = word.toLowerCase();

            if (counts.containsKey(lowerCase)) {
                counts.put(lowerCase, counts.get(lowerCase) + 1);
            } else {
                counts.put(lowerCase, 1);
            }
        }

        ArrayList<String> odds = new ArrayList<>();


        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
