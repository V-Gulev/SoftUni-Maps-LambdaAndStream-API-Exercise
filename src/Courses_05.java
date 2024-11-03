import java.util.*;

public class Courses_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" : ");
            String course = parts[0];
            String student = parts[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            List<String> studentNames = entry.getValue();
            System.out.printf("%s: %d\n", entry.getKey(), studentNames.size());
            studentNames.forEach(name -> System.out.printf("-- %s\n", name));
        }
    }
}
