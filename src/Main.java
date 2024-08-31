import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> stats = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("no more time")) {
                break;
            }
            String[] tokens = input.split(" -> ");
            String name = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            contests.putIfAbsent(contest, new LinkedHashMap<>());
            contests.get(contest).putIfAbsent(name, 0);

            if (contests.get(contest).get(name) < points) {
                stats.put(name, stats.getOrDefault(name, 0) + points - contests.get(contest).get(name));
                contests.get(contest).put(name, points);
            }
        }

        for (String contest : contests.keySet()) {
            System.out.printf("%s: %d participants%n", contest, contests.get(contest).size());

            List<Map.Entry<String, Integer>> sortedParticipants = new ArrayList<>(contests.get(contest).entrySet());
            sortedParticipants.sort((a, b) -> {
                int result = b.getValue().compareTo(a.getValue());
                if (result == 0) {
                    return a.getKey().compareTo(b.getKey());
                }
                return result;
            });

            int position = 1;
            for (Map.Entry<String, Integer> participant : sortedParticipants) {
                System.out.printf("%d. %s <::> %d%n", position, participant.getKey(), participant.getValue());
                position++;
            }
        }

        System.out.println("Individual standings:");

        List<Map.Entry<String, Integer>> sortedStats = new ArrayList<>(stats.entrySet());
        sortedStats.sort((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });

        int position = 1;
        for (Map.Entry<String, Integer> entry : sortedStats) {
            System.out.printf("%d. %s -> %d%n", position, entry.getKey(), entry.getValue());
            position++;
        }
    }
}
