package com.company;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String Name;
    private int ID;
    private int salary;
    private int officeType;

    public Employee(String name, int id, int salary/*, int officeType, int specialField1, boolean specialField2*/) {
        this.Name = name;
        this.ID = id;
        this.salary = salary;
    }

    public Employee() {

    }

    public boolean equals(Employee obj)
    {
        if (this==obj) return true;
        if (this==null) return false;
        Employee that = (Employee) obj;
        if (this.ID == that.ID) return true;
        return false;
    }

    public int getOfficeType() {
        return officeType;
    }

    public Employee(String name, int ID, int salary, int officeType) {
        Name = name;
        this.ID = ID;
        this.salary = salary;
        this.officeType = officeType;
    }

    public abstract void writeEmployeeToCSV(EmployeeManager employeeManager);

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
