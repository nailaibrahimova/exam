package exam.db;

import exam.model.*;

import static exam.model.Department.*;
import static exam.model.Gender.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDB {
    public static final List<Employee> finances = new ArrayList<>();
    public static final List<Employee> hrs = new ArrayList<>();
    public static final List<Employee> its = new ArrayList<>();
    public static final List<Employee> marketings = new ArrayList<>();
    public static final List<Employee> allEmployees = new ArrayList<>();
    public static final Map<Department, List<Employee>> employeeDepartmentMap = new HashMap<>();

    static {
        Employee e1 = new Employee("Aminov Zaur Vidadi", MALE, "+994501234567", LocalDate.now().minusYears(30)).
                setBoss(null).setJob(new Job("Director", FINANCE, LocalDate.now().minusYears(10))).setSalary(1000);
        Employee e2 = new Employee("Bayramova Leyla Resid", FEMALE, "+994550987654", LocalDate.now().minusYears(25)).
                setBoss(null).setJob(new Job("Director", HR, LocalDate.now().minusYears(10))).setSalary(800);
        Employee e3 = new Employee("Babayeva Sona Baba", FEMALE, "+994701234567", LocalDate.of(1995, 5, 24)).
                setBoss(null).setJob(new Job("Director", IT, LocalDate.now().minusYears(10))).setSalary(1500);
        Employee e4 = new Employee("Aliyeva Rena Vaqif", FEMALE, "+994770127654", LocalDate.now().minusYears(20)).
                setBoss(null).setJob(new Job("Director", MARKETING, LocalDate.now().minusYears(10))).setSalary(900);

        FINANCE.setDirector(e1);
        HR.setDirector(e2);
        IT.setDirector(e3);
        MARKETING.setDirector(e4);

        Employee e5 = new Employee("Najafov Senan Rufat", MALE, "+994501597536", LocalDate.now().minusYears(23)).
                setBoss(e1).setJob(new Job("Manager", FINANCE, LocalDate.now().minusYears(2))).setSalary(700);
        Employee e6 = new Employee("Behbudova Lala Oguz", FEMALE, "+994557539514", LocalDate.now().minusYears(25)).
                setBoss(e2).setJob(new Job("Intern", HR, LocalDate.now().minusMonths(8))).setSalary(100);
        Employee e7 = new Employee("Behbudov Qedir Oguz", MALE, "+994708520167", LocalDate.of(1999, 1, 2)).
                setBoss(e3).setJob(new Job("Junior Developer", IT, LocalDate.now().minusYears(3))).setSalary(500);
        Employee e8 = new Employee("Residov Eyvaz Ehsan", MALE, "+994779631475", LocalDate.now().minusYears(19).minusMonths(6)).
                setBoss(e4).setJob(new Job("Manager", MARKETING, LocalDate.now().minusYears(6))).setSalary(600);

        finances.add(e1); finances.add(e5);
        hrs.add(e2); hrs.add(e6);
        its.add(e3); its.add(e7);
        marketings.add(e4); marketings.add(e8);

        allEmployees.add(e1); allEmployees.add(e2);
        allEmployees.add(e3); allEmployees.add(e4);
        allEmployees.add(e5); allEmployees.add(e6);
        allEmployees.add(e7); allEmployees.add(e8);

        employeeDepartmentMap.put(FINANCE, finances);
        employeeDepartmentMap.put(HR, hrs);
        employeeDepartmentMap.put(IT, its);
        employeeDepartmentMap.put(MARKETING, marketings);
    }
}
