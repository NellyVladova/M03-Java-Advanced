package JavaAdvanced.AdvancedExams.E18August2021.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if(getCount() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        for (Employee employee : this.employees){
            if(employee.getName().equals(name)){
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee oldestEmployee = null;
        int latestYear = 0;
        for (Employee employee : this.employees){
            if (employee.getAge() > latestYear){
                latestYear = employee.getAge();
                oldestEmployee = employee;
            }
        }
        return oldestEmployee;
    }

    public Employee getEmployee(String name){
        for (Employee employee : this.employees){
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Employees working at Cafe %s:", this.name)).append(System.lineSeparator());
        for (Employee employee : this.employees){
            stringBuilder.append(employee.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

