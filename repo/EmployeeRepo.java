package exam.repo;

import exam.model.Department;
import exam.model.Employee;

import java.util.List;
import java.util.Map;

import static exam.db.MockDB.*;
import static exam.model.Department.*;

public class EmployeeRepo {
    public List<Employee> financeList() {
        return finances;
    }

    public List<Employee> hrsList() {
        return hrs;
    }

    public List<Employee> itsList() {
        return its;
    }

    public List<Employee> marketingsList() {
        return marketings;
    }

    public List<Employee> allEmployeesList() {
        return allEmployees;
    }

    public Map<Department, List<Employee>> employeeDepartmentMap() {
        return employeeDepartmentMap;
    }

    public void addEmployeeToMap(Department department, List<Employee> list) {
        for (Map.Entry<Department, List<Employee>> entry : employeeDepartmentMap.entrySet()) {
            if (entry.getKey() == department) entry.setValue(list);
        }
    }

    public void addEmployee(List<Employee> list, Employee e) {
        list.add(e);
        allEmployees.add(e);
        addEmployeeToMap(e.getJob().getDepartment(), list);
    }

    public void removeEmployeeFromMap(Department department, List<Employee> list) {
        for (Map.Entry<Department, List<Employee>> entry : employeeDepartmentMap.entrySet()) {
            if (entry.getKey() == department) entry.setValue(list);
        }
    }

    public void removeEmployee(List<Employee> list, Employee e) {
        if (list.contains(e)) {
            list.remove(e);
            allEmployees.remove(e);
            removeEmployeeFromMap(e.getJob().getDepartment(), list);
        }
    }
}
