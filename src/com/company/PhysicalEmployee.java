package com.company;

import java.io.*;

public class PhysicalEmployee extends Employee {

    //private static int officeType = 2;
    private int numberOfTools;
    private boolean workToday;

    public PhysicalEmployee() {

    }

    /*public int getOfficeType() {
        return officeType;
    }*/

    public int getNumberOfTools() {
        return numberOfTools;
    }
    public String toString() {
        return "Name: '" + this.getName() + "', ID: '" + this.getID() + "', Salary: '" + this.getSalary() + "', Tools number: '" + this.numberOfTools + "', Work today: '" + this.workToday + "', Office type: " + this.getOfficeType() + "'" ;
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

    public PhysicalEmployee(String name, int ID, int salary, int officeType, int numberOfTools, boolean workToday/*, int officeType*/) {
        super(name, ID, salary, officeType);
        this.numberOfTools = numberOfTools;
        this.workToday = workToday;
        //this.officeType = officeType;
    }

    private static final String CSV_SEPARATOR = ",";
    @Override
    public void writeEmployeeToCSV(EmployeeManager employeeManagerList) {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("List4.csv"), "UTF-8"));
            for (Employee employee: employeeManagerList.getList()) {
                if(employee.getOfficeType() == 2) {
                    PhysicalEmployee physicalEmployee= (PhysicalEmployee) employee;
                    StringBuffer oneLine = new StringBuffer();
                    oneLine.append(physicalEmployee.getName().trim().length() == 0 ? "" : physicalEmployee.getName());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(physicalEmployee.getID() <= 0 ? "" : physicalEmployee.getID());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(physicalEmployee.getSalary() < 0 ? "" : physicalEmployee.getSalary());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(physicalEmployee.getOfficeType() < 0 ? "" : physicalEmployee.getOfficeType());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(physicalEmployee.getNumberOfTools() < 0 ? "" : physicalEmployee.getNumberOfTools());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(physicalEmployee.isWorkToday()  ?  physicalEmployee.isWorkToday() : physicalEmployee.isWorkToday());
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
