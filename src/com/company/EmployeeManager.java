package com.company;
import java.util.*;

public class EmployeeManager {

   private List<Employee> list = new ArrayList<Employee>();

   public void add(Employee obj)
   {
       list.add(obj);
   }

   public int returrr(Employee obj)
   {
       return obj.getOfficeType();
   }

   public  void remove(Employee obj)
   {
       list.remove(obj);
   }

   public void contains(List<Employee> list, String name)
   {
       for(Employee employee : list)
       {
           if(employee.getName().equals(name))
           {
               System.out.println("It's contain " + name);
           }
       }
   }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}
