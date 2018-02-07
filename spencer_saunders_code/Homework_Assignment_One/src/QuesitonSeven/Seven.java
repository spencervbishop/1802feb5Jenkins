package QuesitonSeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//a class to represent the employee
class Employee{
    String name;
    String department;
    int age;

    //Constructor
    public Employee(String name, String department, int age){
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public String toString()
    {
        return this.age + " " + this.name +
                " " + this.department;
    }

}

class SortbyName implements Comparator<Employee>{
    //Sort in alphabetical order
    public int compare(Employee a, Employee b){
        return a.name.compareTo(b.name);
    }
}

class SortbyDepartment implements Comparator<Employee>{
    //Sort in alphabetical order
    public int compare(Employee a, Employee b){
        return a.department.compareTo(b.department);
    }
}

class SortbyAge implements Comparator<Employee>{
    //Sort by ascending order
    public int compare(Employee a, Employee b){
        return a.age-b.age;
    }
}

public class Seven {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Johnny", "Confidential", 45));
        employees.add(new Employee( "Mark", "Football", 19));

        Collections.sort(employees, new SortbyName());
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));

        Collections.sort(employees, new SortbyDepartment());
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));

        Collections.sort(employees, new SortbyAge());
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));


    }
}
