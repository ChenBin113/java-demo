package designpattern.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department[] departments;
    int numberOfDepartment = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java", "Java 专业");
        addDepartment("Python", "Python 专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        if (numberOfDepartment < departments.length) {
            Department department = new Department(name, des);
            departments[numberOfDepartment++] = department;
        } else {
            System.out.println("数组越界");
        }
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
