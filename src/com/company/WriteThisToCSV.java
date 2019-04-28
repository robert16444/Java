package com.company;

import sun.font.PhysicalStrike;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteThisToCSV{

    private static final String CSV_SEPARATOR = ",";

    public void writeToCSV(EmployeeManager employeeManagerList)
    {
            OfficeEmployee officeEmployee = new OfficeEmployee();
            officeEmployee.writeEmployeeToCSV(employeeManagerList);

            PhysicalEmployee physicalEmployee = new PhysicalEmployee();
            physicalEmployee.writeEmployeeToCSV(employeeManagerList);

        /*try
        {
            List<PhysicalEmployee> physicalEmployees = null;
            List<OfficeEmployee> officeEmployees = null;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("List1.csv"), "UTF-8"));
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("List2.csv"), "UTF-8"));
            for (Employee employee: employeeManagerList.getList())
            { StringBuffer oneLine = new StringBuffer();
                oneLine.append(employee.getName().trim().length() == 0 ? "" : employee.getName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getID() <= 0 ? "" : employee.getID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getSalary() < 0 ? "" : employee.getSalary());
                oneLine.append(CSV_SEPARATOR);


               /* if(employee.getOfficeType() == 1)
                {
                     officeEmployees.add(employee);
                }
                else if(employee.getOfficeType() == 2)
                {
                    physicalEmployees.add(employee);
                }
                System.out.println("AAAAAAAAAA"+Arrays.toString(officeEmployees.toArray()));
                System.out.println(Arrays.toString(physicalEmployees.toArray()));*/

               /* if(employee.getOfficeType() == 1)
                {
                    bw.append(oneLine.toString());
                    bw.newLine();
                }
                else if(employee.getOfficeType() == 2)
                {
                    bw2.append(oneLine.toString());
                    bw2.newLine();
                }
            }
            bw.flush();
            bw.close();
            bw2.flush();
            bw2.close();
        }*/
        /*catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}*/
    }


    public static List<OfficeEmployee> readEmployeeFromCSV(String fileName)
    {
        List<OfficeEmployee> employess = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
    {
        String line = br.readLine();
     while (line != null)
     {
          String[] attributes = line.split(",");
          OfficeEmployee ep = (OfficeEmployee) createEmployee(attributes);
          employess.add(ep);
          line = br.readLine();
     }
    } catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
    return employess;
    }

    private static OfficeEmployee createEmployee(String[] metadata) throws UnsupportedEncodingException, FileNotFoundException {
        String name = metadata[0];
        int ID = Integer.parseInt((metadata[1]));
        int salary = Integer.parseInt(metadata[2]);
        int officeType = Integer.parseInt(metadata[3]);
        int specialField1 = Integer.parseInt(metadata[4]);
        boolean specialField2 = Boolean.valueOf(metadata[5]);

        return new OfficeEmployee(name, ID, salary,officeType, specialField1, specialField2);
     }




    public static List<PhysicalEmployee> readEmployeeFromCSV2(String fileName)
    {
        List<PhysicalEmployee> employess = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();
            while (line != null)
            {
                String[] attributes = line.split(",");
                PhysicalEmployee ep = (PhysicalEmployee) createEmployee1(attributes);
                employess.add(ep);
                line = br.readLine();
            }
        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        return employess;
    }

    private static PhysicalEmployee createEmployee1(String[] metadata) throws UnsupportedEncodingException, FileNotFoundException {
        String name = metadata[0];
        int ID = Integer.parseInt((metadata[1]));
        int salary = Integer.parseInt(metadata[2]);
        int officeType = Integer.parseInt(metadata[3]);
        int specialField1 = Integer.parseInt(metadata[4]);
        boolean specialField2 = Boolean.valueOf(metadata[5]);

        return new PhysicalEmployee(name, ID, salary,officeType, specialField1, specialField2);
    }

}