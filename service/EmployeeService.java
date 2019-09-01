package exam.service;

import static exam.model.Department.*;

import exam.exception.WrongEmployeeException;
import exam.model.*;
import exam.repo.EmployeeRepo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void addEmployee(Employee e) throws WrongEmployeeException {
        if (employeeRepo.isPresent(e)) throw new WrongEmployeeException("Such user exists");
        else {
            if (e.getJob().getDepartment() == FINANCE) employeeRepo.addEmployee(financeList(), e);
            else if (e.getJob().getDepartment() == HR) employeeRepo.addEmployee(hrsList(), e);
            else if (e.getJob().getDepartment() == IT) employeeRepo.addEmployee(itsList(), e);
            else if (e.getJob().getDepartment() == MARKETING) employeeRepo.addEmployee(marketingsList(), e);
        }
    }

    public void removeEmployee(Employee e) {
        if (e.getJob().getDepartment() == FINANCE) employeeRepo.removeEmployee(financeList(), e);
        else if (e.getJob().getDepartment() == HR) employeeRepo.removeEmployee(hrsList(), e);
        else if (e.getJob().getDepartment() == IT) employeeRepo.removeEmployee(itsList(), e);
        else if (e.getJob().getDepartment() == MARKETING) employeeRepo.removeEmployee(marketingsList(), e);
    }

    public void removeEmployee(int id) throws WrongEmployeeException {
        Employee employee = null;
        for (Employee e : allEmployeesList()) {
            if (e.getId() == id) {
                employee = e;
                break;
            }
        }
        if (employee != null) removeEmployee(employee);
        else if (employee == null) throw new WrongEmployeeException("Employee with such id doesn't exist");
    }

    public Employee findEmployeeById(int id) throws WrongEmployeeException {
        Employee employee = employeeRepo.findEmployeeById(id);
        if (employee != null) return employee;
        else throw new WrongEmployeeException("No employee with such id");
    }

    public Employee findEmployeeByName(String name) throws WrongEmployeeException {
        Employee employee = employeeRepo.findEmployeeByName(name);
        if (employee != null) return employee;
        else throw new WrongEmployeeException("No such employee");

    }

    public List<Employee> findEmployeesByPosition(String position) throws WrongEmployeeException {
        List<Employee> list = employeeRepo.findEmployeesByPosition(position);
        if (list.isEmpty()) throw new WrongEmployeeException("No employee with such position");
        else return list;
    }

    public List<Employee> findEmployeesByDepartment(Department department) {
        return employeeRepo.findEmployeesByDepartment(department);
    }

    public List<Employee> findEmployeesByBoss(String name) throws WrongEmployeeException {
        List<Employee> list = employeeRepo.findEmployeesByBoss(name);
        if (list.isEmpty() == true) throw new WrongEmployeeException("No employees with such boss");
        else return list;
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

    public void printAverageSalary() {
        int averageSalary = 0;
        int numberOfEmployees = 0;
        int averageSalaryPerDepartment = 0;

        System.out.print("\033[0;36m" + FINANCE + "\033[0m");
        for (Employee e : financeList()) {
            averageSalaryPerDepartment = averageSalary += e.getSalary();
        }
        numberOfEmployees += financeList().size();
        averageSalaryPerDepartment /= financeList().size();
        System.out.println(":\n\tAverage salary : " + averageSalaryPerDepartment);

        averageSalaryPerDepartment = 0;
        System.out.print("\033[0;36m" + HR + "\033[0m");
        for (Employee e : hrsList()) {
            averageSalary += e.getSalary();
            averageSalaryPerDepartment += e.getSalary();
        }
        numberOfEmployees += hrsList().size();
        averageSalaryPerDepartment /= hrsList().size();
        System.out.println(":\n\tAverage salary : " + averageSalaryPerDepartment);

        averageSalaryPerDepartment = 0;
        System.out.print("\033[0;36m" + IT + "\033[0m");
        for (Employee e : itsList()) {
            averageSalary += e.getSalary();
            averageSalaryPerDepartment += e.getSalary();
        }
        numberOfEmployees += itsList().size();
        averageSalaryPerDepartment /= itsList().size();
        System.out.println(":\n\tAverage salary : " + averageSalaryPerDepartment);

        averageSalaryPerDepartment = 0;
        System.out.print("\033[0;36m" + MARKETING + "\033[0m");
        for (Employee e : marketingsList()) {
            averageSalary += e.getSalary();
            averageSalaryPerDepartment += e.getSalary();
        }
        numberOfEmployees += marketingsList().size();
        averageSalaryPerDepartment /= marketingsList().size();
        System.out.println(":\n\tAverage salary : " + averageSalaryPerDepartment);

        averageSalary /= numberOfEmployees;
        System.out.println("Average salary for organization : " + averageSalary);
    }

    public void topEmployeesForSalary() {
        List<Employee> list = allEmployeesList();
        list.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.println("\033[0;35m" + "Top-10 employees for salary:" + "\033[0m");
        for (int i = 0; i < list.size() && i < 10; i++)
            System.out.println("\t" + list.get(i).getName() + " " + list.get(i).getSalary());
    }

    public void topEmployeesForWorkYears() {
        List<Employee> list = allEmployeesList();
        Comparator<Employee> comparator = Comparator.comparing(e -> e.getJob().getJobEnterDate());
        list.sort(comparator);
        System.out.println("\033[0;35m" + "Top-10 employees for working years:" + "\033[0m");
        Period period = null;
        for (int i = 0; i < list.size() && i < 10; i++) {
            period = Period.between(list.get(i).getJob().getJobEnterDate(), LocalDate.now());
            System.out.println("\t" + list.get(i).getName() + "\t" + period.getYears() + " years");
        }
    }

    public void changeName(int id, String name) {
        employeeRepo.changeName(id, name);
    }

    public void changePosition(int id, String position) {
        employeeRepo.changePosition(id, position);
    }

    public void changeDepartment(int id, String department) {
        employeeRepo.changeDepartment(id, department);
    }

    public void changeTelephone(int id, String telephone) {
        employeeRepo.changeTelephone(id, telephone);
    }

    public void changeSalary(int id, double salary) {
        employeeRepo.changeSalary(id, salary);
    }
}
