package exam.service;

import static exam.model.Department.*;

import exam.model.*;
import exam.repo.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    private EmployeeRepo employeeRepo = new EmployeeRepo();

    public List<Employee> financeList() {
        return employeeRepo.financeList();
    }

    public List<Employee> hrsList() {
        return employeeRepo.hrsList();
    }

    public List<Employee> itsList() {
        return employeeRepo.itsList();
    }

    public List<Employee> marketingsList() {
        return employeeRepo.marketingsList();
    }

    public List<Employee> allEmployeesList() {
        return employeeRepo.allEmployeesList();
    }

    public Map<Department, List<Employee>> employeeDepartmentMap() {
        return employeeRepo.employeeDepartmentMap();
    }

    public void addEmployee(Employee e) {
        if (e.getJob().getDepartment() == FINANCE) employeeRepo.addEmployee(financeList(), e);
        else if (e.getJob().getDepartment() == HR) employeeRepo.addEmployee(hrsList(), e);
        else if (e.getJob().getDepartment() == IT) employeeRepo.addEmployee(itsList(), e);
        else if (e.getJob().getDepartment() == MARKETING) employeeRepo.addEmployee(marketingsList(), e);
    }

    public void removeEmployee(Employee e) {
        if (e.getJob().getDepartment() == FINANCE) employeeRepo.removeEmployee(financeList(), e);
        else if (e.getJob().getDepartment() == HR) employeeRepo.removeEmployee(hrsList(), e);
        else if (e.getJob().getDepartment() == IT) employeeRepo.removeEmployee(itsList(), e);
        else if (e.getJob().getDepartment() == MARKETING) employeeRepo.removeEmployee(marketingsList(), e);
    }

    public void removeEmployee(String name) {
        Employee employee = null;
        for (Employee e : allEmployeesList()) {
            if (e.getName().equals(name))
                employee = e;
        }
        if (employee == null) System.out.println("No employee with such name");
        else removeEmployee(employee);
    }

    public Employee findEmployeeByName(String name) {
        Employee employee = null;
        for (Employee e : allEmployeesList()) {
            if (e.getName().equals(name)) {
                employee = e;
            }
        }
        return employee;
    }

    public List<Employee> findEmployeesByPosition(String position) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : allEmployeesList()) {
            if (e.getJob().getPosition().equals(position)) list.add(e);
        }
        return list;
    }

    public List<Employee> findEmployeesByDepartment(Department department) {
        List<Employee> list = new ArrayList<>();
        for (Map.Entry<Department, List<Employee>> entry : employeeDepartmentMap().entrySet()) {
            if (entry.getKey() == department) list = entry.getValue();
        }
        return list;
    }

    public List<Employee> findEmployeesByBoss(String name) {
        List<Employee> list = new ArrayList<>();
        for (Employee e : allEmployeesList()) {
            if (e.getBoss() != null && e.getBoss().getName().equals(name)) list.add(e);
        }
        return list;
    }

    public void printAllInformation() {
        System.out.print("\033[0;36m" + FINANCE + "\033[0m");
        System.out.println(":\n\tDirector: " + FINANCE.getDirector().getName());
        System.out.println("\t" + financeList().size() + " employees\n");

        System.out.print("\033[0;36m" + HR + "\033[0m");
        System.out.println(":\n\tDirector: " + HR.getDirector().getName());
        System.out.println("\t" + hrsList().size() + " employees\n");

        System.out.print("\033[0;36m" + IT + "\033[0m");
        System.out.println(":\n\tDirector: " + IT.getDirector().getName());
        System.out.println("\t" + itsList().size() + " employees\n");

        System.out.print("\033[0;36m" + MARKETING + "\033[0m");
        System.out.println(":\n\tDirector: " + MARKETING.getDirector().getName());
        System.out.println("\t" + marketingsList().size() + " employees\n");
    }
}
