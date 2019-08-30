package exam.controller;

import exam.model.*;
import exam.service.EmployeeService;

import java.util.List;
import java.util.Map;

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

    public List<Employee> allEmployeesList(){ return employeeService.allEmployeesList(); }

    public Map<Department, List<Employee>> employeeDepartmentMap(){ return employeeService.employeeDepartmentMap(); }

    public void addEmployee(Employee e) {
        employeeService.addEmployee(e);
    }

    public void removeEmplpoyee(Employee e){
        employeeService.removeEmployee(e);
    }

    public void removeEmployee(String name) {
        employeeService.removeEmployee(name);
    }

    public Employee findEmployeeByName(String name) {
        return employeeService.findEmployeeByName(name);
    }

    public List<Employee> findEmployeesByPosition(String position) {
        return employeeService.findEmployeesByPosition(position);
    }

    public List<Employee> findEmployeesByDepartment(Department department){
        return employeeService.findEmployeesByDepartment(department);
    }

    public List<Employee> findEmployeesByBoss(String name){
        return employeeService.findEmployeesByBoss(name);
    }

    public void printAllInformation(){
        employeeService.printAllInformation();
    }
}
