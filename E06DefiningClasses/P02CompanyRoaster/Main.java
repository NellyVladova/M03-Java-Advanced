package JavaAdvanced.E06DefiningClasses.P02CompanyRoaster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departmentsList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee newEmployee;
            if (input.length == 4) {
                newEmployee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                String forthElement = input[4];
                if (forthElement.contains("@")) {
                    String email = forthElement;
                    newEmployee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(forthElement);
                    newEmployee = new Employee(name, salary, position, department, age);
                }
            } else {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                newEmployee = new Employee(name, salary, position, department, email, age);
            }

            if (!departmentsList.containsKey(department)) {
                departmentsList.put(department, new ArrayList<>());
                departmentsList.get(department).add(newEmployee);
            } else {
                departmentsList.get(department).add(newEmployee);
            }
        }
        String maxAverageSalary = departmentsList.entrySet().stream()
                .max(Comparator.comparing(entry -> getAverageSalary(entry.getValue())))
                .get().getKey();

        System.out.printf("Highest Average Salary: %s\n", maxAverageSalary);
        List<Employee> employeesList = departmentsList.get(maxAverageSalary);
        employeesList.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employeesList);

        for (Employee employee : employeesList){
            System.out.println(employee);
        }
    }

    private static double getAverageSalary(List<Employee> employeesList) {
        double avgSalary = 0;
        for (Employee employee : employeesList) {
            avgSalary += employee.getSalary();
        }
        return avgSalary /= employeesList.size();
    }
}
