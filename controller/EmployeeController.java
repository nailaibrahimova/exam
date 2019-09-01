package exam.controller;

import exam.exception.WrongEmployeeException;
import exam.model.*;
import exam.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    public List<Employee> financeList() {
        return employeeService.financeList();
    }

    public List<Employee> hrsList() {
        return employeeService.hrsList();
    }

    public List<Employee> itsList() {
        return employeeService.itsList();
    }

    public List<Employee> marketingsList() {
        return employeeService.marketingsList();
    }

    public List<Employee> allEmployeesList() {
        return employeeService.allEmployeesList();
    }

    public Map<Department, List<Employee>> employeeDepartmentMap() {
        return employeeService.employeeDepartmentMap();
    }

    public void addEmployee(Employee e) throws WrongEmployeeException {
        employeeService.addEmployee(e);
    }

    public void removeEmplpoyee(Employee e) {
        employeeService.removeEmployee(e);
    }

    public void removeEmployee(int id) throws WrongEmployeeException {
        employeeService.removeEmployee(id);
    }

    public Employee findEmployeeById(int id) throws WrongEmployeeException {
        return employeeService.findEmployeeById(id);
    }

    public Employee findEmployeeByName(String name) throws WrongEmployeeException {
        return employeeService.findEmployeeByName(name);
    }

    public List<Employee> findEmployeesByPosition(String position) throws WrongEmployeeException {
        return employeeService.findEmployeesByPosition(position);
    }

    public List<Employee> findEmployeesByDepartment(Department department) {
        return employeeService.findEmployeesByDepartment(department);
    }

    public List<Employee> findEmployeesByBoss(String name) throws WrongEmployeeException {
        return employeeService.findEmployeesByBoss(name);
    }

    public void printAllInformation() {
        employeeService.printAllInformation();
    }

    public void printAverageSalary() {
        employeeService.printAverageSalary();
    }

    public void topEmployeesForSalary() {
        employeeService.topEmployeesForSalary();
    }

    public void topEmployeesForWorkYears() {
        employeeService.topEmployeesForWorkYears();
    }

    public void changeName(int id, String name) {
        employeeService.changeName(id, name);
    }

    public void changePosition(int id, String position) {
        employeeService.changePosition(id, position);
    }

    public void changeDepartment(int id, String department) {
        employeeService.changeDepartment(id, department);
    }

    public void changeTelephone(int id, String telephone) {
        employeeService.changeTelephone(id, telephone);
    }

    public void changeSalary(int id, double salary) {
        employeeService.changeSalary(id, salary);
    }
}
