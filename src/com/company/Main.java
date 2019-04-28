package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

	OfficeEmployee e1 = new OfficeEmployee("Bartek", 1476, 4500, 1, 2,false);
	OfficeEmployee e2 = new OfficeEmployee("Bartek", 1477, 4500, 1,2,false);
	PhysicalEmployee e3 = new PhysicalEmployee("Robert",1235,3000,2,12,true);
	OfficeEmployee e4 = new OfficeEmployee("Darek", 1417, 6500,1, 2,true);
	PhysicalEmployee e5 = new PhysicalEmployee("Marcin",1479,4000,2,12,true);
	OfficeEmployee e6 = new OfficeEmployee("Pawel", 1896, 4000, 1,2,true);
	OfficeEmployee e7 = new OfficeEmployee("Aaaaa",1111,4000,2,12,true);
	OfficeEmployee e8 = new OfficeEmployee("Bbbbb", 1111, 4000,2, 2,true);

	e1.biggerSalary(600);
	e2.biggerSalary(300);

	System.out.println(e1.equals(e2));
	System.out.println(e1.equals(e3));
	System.out.println(e1.equals(e1));

	System.out.println(e1.toString());
	System.out.println(e3.toString());

        EmployeeManager employeeManager= new EmployeeManager();
        employeeManager.add(e1);
        employeeManager.add(e2);
        employeeManager.add(e3);
        employeeManager.add(e4);
        employeeManager.contains(employeeManager.getList(),"Robert");
		employeeManager.contains(employeeManager.getList(),"Adam");
		System.out.println(Arrays.toString(employeeManager.getList().toArray()));
		employeeManager.remove(e2);
		employeeManager.add(e5);
		employeeManager.add(e6);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("SaveArrayList.txt");

            oos = new ObjectOutputStream(fos);

            oos.writeObject(employeeManager.getList());
            oos.flush();
            oos.close();
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        System.out.println("ArrayList object saved"
                + " to SaveArrayList.txt file");
	System.out.println(Arrays.toString(employeeManager.getList().toArray()));

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        EmployeeManager employeeManagerList = new EmployeeManager();

        try {
            fis = new FileInputStream("SaveArrayList.txt");

            ois = new ObjectInputStream(fis);

            employeeManagerList.setList((ArrayList<Employee>) ois.readObject());
        }
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }

        System.out.println("ArrayList object de-serialized from "
                + "SaveArrayList.txt file\n");
        System.out.println(Arrays.toString(employeeManagerList.getList().toArray()));

        WriteThisToCSV writeThisToCSV = new WriteThisToCSV();

        writeThisToCSV.writeToCSV(employeeManager);

        List<OfficeEmployee> list = writeThisToCSV.readEmployeeFromCSV("List3.csv");
        System.out.println("Office"+Arrays.toString(list.toArray()));

        List<PhysicalEmployee> list1 = writeThisToCSV.readEmployeeFromCSV2("List4.csv");
        System.out.println("Physical"+Arrays.toString(list1.toArray()));

	System.out.println("Compare by name");
	CompareByName compareByName = new CompareByName();
	System.out.println(compareByName.compare(e1,e2));
	System.out.println(compareByName.compare(e2,e3));

	System.out.println("Compare by salary");
	CompareBySalary compareBySalary = new CompareBySalary();
	System.out.println(compareBySalary.compare(e5,e6));
	System.out.println(compareBySalary.compare(e1,e3));

	System.out.println("Compare by ID");
	CompareByID compareByID = new CompareByID();
	System.out.println(compareByID.compare(e7,e8));
	System.out.println(compareByID.compare(e7,e1));

	SortBySalary sortBySalary = new SortBySalary();
	SortByID sortByID = new SortByID();
	SortByName sortByName = new SortByName();

	System.out.println("List before sort by salary: "+Arrays.toString(employeeManager.getList().toArray()));
	sortBySalary.sortThisBySalary(employeeManager.getList());
	System.out.println("List after sort by salary: "+Arrays.toString(employeeManager.getList().toArray()));

	System.out.println("List before sort by ID: "+Arrays.toString(employeeManager.getList().toArray()));
	sortByID.sortThisByID(employeeManager.getList());
	System.out.println("List after sort by ID: "+Arrays.toString(employeeManager.getList().toArray()));

	System.out.println("List before sort by name: "+Arrays.toString(employeeManager.getList().toArray()));
	sortByName.sortThisByName(employeeManager.getList());
	System.out.println("List after sort by name: "+Arrays.toString(employeeManager.getList().toArray()));

    }
}
