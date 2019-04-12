package com.company;

import java.util.Comparator;

public class CompareByID implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2)
    {
        return Integer.compare(e1.getID(), e2.getID());
    }
}
