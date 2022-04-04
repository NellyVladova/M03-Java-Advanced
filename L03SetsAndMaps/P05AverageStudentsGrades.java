package JavaAdvanced.L03SetsAndMaps;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double studentGrade = Double.parseDouble(input[1]);

            if (studentsGrades.containsKey(studentName)) {
                List<Double> newMarks = new ArrayList<>();
                newMarks.addAll(studentsGrades.get(studentName));
                newMarks.add(studentGrade);
                studentsGrades.put(studentName, newMarks);
            } else {
                List<Double> toPut = new ArrayList<>();
                toPut.add(studentGrade);
                studentsGrades.put(studentName, toPut);
            }
        }
        studentsGrades.forEach((student, grades) -> {
            System.out.printf("%s -> ", student);
            grades.forEach(grade -> System.out.printf("%.2f ", grade));
            double averageGrade = 0;
            for (double num : grades) {
                averageGrade += num;
            }
            averageGrade /= (grades.size());
            System.out.printf("(avg: %.2f)\n", averageGrade);
        });
    }
}
