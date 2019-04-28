package com.company;

import java.io.*;

public class OfficeEmployee extends Employee {
    //private static int officeType = 1;
    private int howManyComputers;
    private boolean coffeeToday;

    /*public int getOfficeType() {
        return officeType;
    }*/

    public OfficeEmployee(String name, int ID, int salary, int officeType, int howManyComputers, boolean coffeeToday/*, int officeType*/) throws UnsupportedEncodingException, FileNotFoundException {
        super(name, ID, salary, officeType);
        this.howManyComputers = howManyComputers;
        this.coffeeToday = coffeeToday;
        //this.officeType = officeType;
    }

    public OfficeEmployee() {

    }

    public String toString() {
        return "Name: '" + this.getName() + "', ID: '" + this.getID() + "', Salary: '" + this.getSalary() + "', Computers: '" + this.howManyComputers + "', CoffeToday: '" + this.coffeeToday + "', OfficeType: " + this.getOfficeType() + "'" ;
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
    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeEmployeeToCSV(EmployeeManager employeeManagerList) {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("List3.csv"), "UTF-8"));
          for (Employee employee: employeeManagerList.getList()) {
              if(employee.getOfficeType() == 1) {
                  OfficeEmployee officeEmployee = (OfficeEmployee) employee;
                  StringBuffer oneLine = new StringBuffer();
                  oneLine.append(officeEmployee.getName().trim().length() == 0 ? "" : officeEmployee.getName());
                  oneLine.append(CSV_SEPARATOR);
                  oneLine.append(officeEmployee.getID() <= 0 ? "" : officeEmployee.getID());
                  oneLine.append(CSV_SEPARATOR);
                  oneLine.append(officeEmployee.getSalary() < 0 ? "" : officeEmployee.getSalary());
                  oneLine.append(CSV_SEPARATOR);
                  oneLine.append(officeEmployee.getOfficeType() < 0 ? "" : officeEmployee.getOfficeType());
                  oneLine.append(CSV_SEPARATOR);
                  oneLine.append(officeEmployee.getHowManyComputers() < 0 ? "" : officeEmployee.getHowManyComputers());
                  oneLine.append(CSV_SEPARATOR);
                  oneLine.append(officeEmployee.isCoffeeToday()  ?  officeEmployee.isCoffeeToday() : officeEmployee.isCoffeeToday());
                  oneLine.append(CSV_SEPARATOR);

                  bw.append(oneLine.toString());
                  bw.newLine();
              }
          }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }
}
