package com.company;

public class PhysicalEmployee extends Employee {

    private int numberOfTools;
    private boolean workToday;

    public int getNumberOfTools() {
        return numberOfTools;
    }
    public String toString() {
        return "Name: '" + this.getName() + "', ID: '" + this.getID() + "', Salary: '" + this.getSalary() + "', Tools number: '" + this.numberOfTools + "', Work today: '" + this.workToday + "'" ;
    }

    public void setNumberOfTools(int numberOfTools) {
        this.numberOfTools = numberOfTools;
    }

    public boolean isWorkToday() {
        return workToday;
    }

    public void setWorkToday(boolean workToday) {
        this.workToday = workToday;
    }

    public PhysicalEmployee(String name, int ID, int salary, int numberOfTools, boolean workToday) {
        super(name, ID, salary);
        this.numberOfTools = numberOfTools;
        this.workToday = workToday;
    }
}
