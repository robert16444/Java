package com.company;

import java.util.Comparator;

public class CompareByName implements Comparator<Employee>
{
    @Override
    public int compare(Employee o1, Employee o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    }
}
