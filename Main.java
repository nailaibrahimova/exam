package exam;

import exam.controller.EmployeeController;
import exam.model.*;

import java.time.LocalDate;

import static exam.model.Department.*;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        Employee e = new Employee("Ibrahimova Naila Qabil", Gender.FEMALE, "+994507609917", LocalDate.of(1999, 8, 24))
                .setJob(new Job("Intern", IT, LocalDate.now().minusMonths(3)));
        employeeController.addEmployee(e);
//        System.out.println(employeeController.itsList() + "\n");
//        System.out.println(employeeController.allEmployeesList() + "\n");
//        employeeController.employeeDepartmentMap().forEach((key, value) -> System.out.println(key + "  " + value));

//        System.out.println("\n");
//        employeeController.removeEmployee(e);
//        employeeController.employeeDepartmentMap().forEach((key, value) -> System.out.println(key + "  " + value));

//        System.out.println("\n");
//        employeeController.removeEmployee("Ibrahimova Naila Qabil");
//        employeeController.employeeDepartmentMap().forEach((key, value) -> System.out.println(key + "  " + value));

//        System.out.println("\n");
//        System.out.println(employeeController.findEmployeeByName("Aliyeva Rena Vaqif"));

//        System.out.println("\n");
//        System.out.println(employeeController.findEmployeesByPosition("Director"));

//        System.out.println("\n");
//        System.out.println(employeeController.findEmployeesByDepartment(FINANCE));

//        System.out.println("\n");
//        System.out.println(employeeController.findEmployeesByBoss("Aminov Zaur Vidadi"));

//        System.out.println("\n");
        employeeController.printAllInformation();
    }
}
