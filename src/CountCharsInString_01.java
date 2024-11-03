import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();
        char[] text = sc.nextLine().toCharArray();

        for (char c : text) {
            if (!Character.isSpaceChar(c)) {
                charOccurrences.putIfAbsent(c, 0);
                charOccurrences.put(c, charOccurrences.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
