import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contests = new HashMap<>();
        Map<String, Map<String, Integer>> people = new TreeMap<>();


        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end of contests")) {
                break;
            }
            String[] data = input.split(":");
            contests.put(data[0], data[1]);
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end of submissions")) {
                break;
            }
            String[] data = input.split("=>");
            String contestType = data[0];
            String password = data[1];
            String name = data[2];
            int points = Integer.parseInt(data[3]);


            if (contests.containsKey(contestType) && contests.get(contestType).equals(password)) {
                people.putIfAbsent(name, new HashMap<>());
                Map<String, Integer> userContests = people.get(name);

                userContests.put(contestType, Math.max(userContests.getOrDefault(contestType, 0), points));
            }
        }

        String bestUser = "";
        int bestPoints = 0;

        for (Map.Entry<String, Map<String, Integer>> userEntry : people.entrySet()) {
            int totalPoints = userEntry.getValue().values().stream().mapToInt(Integer::intValue).sum();

            if (totalPoints > bestPoints) {
                bestPoints = totalPoints;
                bestUser = userEntry.getKey();
            }
        }


        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, bestPoints);

        System.out.println("Ranking:");
        for (Map.Entry<String, Map<String, Integer>> userEntry : people.entrySet()) {
            System.out.println(userEntry.getKey());

            userEntry.getValue().entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(contestEntry ->
                            System.out.printf("#  %s -> %d%n", contestEntry.getKey(), contestEntry.getValue())
                    );
        }
    }
}