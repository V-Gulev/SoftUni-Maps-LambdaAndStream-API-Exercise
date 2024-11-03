import java.util.*;

public class StudentAcademy_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, List<Double>> studentsGrades = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }

        LinkedHashMap<String, Double> averageGrades = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            List<Double> grades = entry.getValue();
            double averageGrade = grades.stream().mapToDouble(d -> d).average().orElse(0.0);

            if (averageGrade >= 4.50) {
                averageGrades.put(entry.getKey(), averageGrade);
            }
        }
        averageGrades.forEach((key, value) -> System.out.printf("%s -> %.2f\n", key, value));
    }
}
