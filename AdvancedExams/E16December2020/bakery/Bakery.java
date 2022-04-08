package JavaAdvanced.AdvancedExams.E16December2020.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if(getCount() < this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean remove(String name){
        for (Employee employee : this.employees){
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee(){
        int maxAge = 0;
        Employee employee = null;
        for (Employee currEmployee : this.employees){
            if(currEmployee.getAge() > maxAge){
                maxAge = currEmployee.getAge();
                employee = currEmployee;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        Employee returnedEmployee = null;
        for (Employee currEmployee : this.employees){
            if(currEmployee.getName().equals(name)){
                returnedEmployee = currEmployee;
                break;
            }
        }
        return returnedEmployee;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ").append(this.name).append(":\n");
        for (Employee employee : this.employees){
            sb.append(employee).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}


