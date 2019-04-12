package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByID {
    public void sortThisByID (final List<Employee> list)
    {
        List<Employee> copy = new ArrayList<>(list);
        copy.sort(new CompareBySalary());
        System.out.println("List sort by ID: "+ Arrays.toString(copy.toArray()));
    }
}
