package com.company;

public class Employee {
    private String Name;
    private int ID;
    private int salary;

    public boolean equals(Employee obj)
    {
        if (this==obj) return true;
        if (this==null) return false;
        Employee that = (Employee) obj;
        if (this.ID == that.ID) return true;
        return false;
    }

    public Employee(String name, int ID, int salary) {
        Name = name;
        this.ID = ID;
        this.salary = salary;
    }

    public int biggerSalary(int howMuch)
    {
       return salary = salary + howMuch;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
