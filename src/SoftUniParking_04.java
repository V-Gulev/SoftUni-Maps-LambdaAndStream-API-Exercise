import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(sc.nextLine());
        Map<String, String> users = new LinkedHashMap<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String[] parts = sc.nextLine().split(" ");
            String command = parts[0];
            String username = parts[1];
            switch (command) {
                case "register":
                    String licensePlateNumber = parts[2];
                    if (users.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s\n", users.get(username));
                    } else {
                        users.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (!users.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    }
                    break;
                default:
                    break;
            }
        }
        users.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
