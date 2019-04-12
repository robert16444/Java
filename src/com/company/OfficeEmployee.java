package com.company;

public class OfficeEmployee extends Employee {
    private int howManyComputers;
    private boolean coffeeToday;

    public OfficeEmployee(String name, int ID, int salary, int howManyComputers, boolean coffeeToday) {
        super(name, ID, salary);
        this.howManyComputers = howManyComputers;
        this.coffeeToday = coffeeToday;
    }
    public String toString() {
        return "Name: '" + this.getName() + "', ID: '" + this.getID() + "', Salary: '" + this.getSalary() + "', Computers: '" + this.howManyComputers + "', CoffeToday: '" + this.coffeeToday + "'" ;
    }

    public int getHowManyComputers() {
        return howManyComputers;
    }

    public void setHowManyComputers(int howManyComputers) {
        this.howManyComputers = howManyComputers;
    }

    public boolean isCoffeeToday() {
        return coffeeToday;
    }

    public void setCoffeeToday(boolean coffeeToday) {
        this.coffeeToday = coffeeToday;
    }
}
