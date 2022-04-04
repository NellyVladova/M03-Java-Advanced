package JavaAdvanced.L03SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsInfo = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String studentsName = scanner.nextLine();
            String[] grades = scanner.nextLine().split("\\s+");
            double averageGrade = 0;
            for (int j = 0; j < grades.length; j++) {
                averageGrade+=Double.parseDouble(grades[j]);
            }
            averageGrade/=(grades.length);
            studentsInfo.put(studentsName, averageGrade);
        }

        studentsInfo.forEach((student, grade) -> {
            System.out.println(student + " is graduated with " + grade);
        });
    }
}
