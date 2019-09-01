package exam.repo;

import exam.model.Department;
import exam.model.Employee;
import exam.model.Gender;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static exam.db.MockDB.*;
import static exam.model.Department.*;
import static exam.model.Department.MARKETING;

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

    public boolean isPresent(Employee e) {
        for (Employee employee : allEmployeesList()) {
            if (employee.getId() == e.getId()) {
                return true;
            } else if (employee.getName().equals(e.getName()))
                return true;
        }
        return false;
    }

    public void addEmployeeToMap(Department department, List<Employee> list) {
        for (Map.Entry<Department, List<Employee>> entry : employeeDepartmentMap.entrySet()) {
            if (entry.getKey() == department) entry.setValue(list);
        }
    }

    public void addEmployee(List<Employee> list, Employee e) {
        list.add(e);
        allEmployees.add(e);
        allEmployees.sort(Comparator.comparingInt(Employee::getId));
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
            allEmployees.sort(Comparator.comparingInt(Employee::getId));
            removeEmployeeFromMap(e.getJob().getDepartment(), list);
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee e : allEmployeesList()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Employee findEmployeeByName(String name) {
        Employee employee = null;
        for (Employee e : allEmployeesList()) {
            if (e.getName().equals(name)) {
                employee = e;
                break;
            }
        }
        return employee;
    }

    public List<Employee> findEmployeesByPosition(String position) {
        return allEmployeesList().stream().filter(emp -> emp.getJob().getPosition().equals(position)).collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByDepartment(Department department) {
        return allEmployeesList().stream().filter(emp -> emp.getJob().getDepartment() == department).collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByBoss(String name) {
        List<Employee> list = allEmployeesList().stream().filter(emp -> emp.getBoss() != null && emp.getBoss().getName().equals(name)).collect(Collectors.toList());
        return list;
    }

    public void changeName(int id, String name) {
        Employee e = findEmployeeById(id);
        e.setName(name);
    }

    public void changePosition(int id, String position) {
        Employee e = findEmployeeById(id);
        e.getJob().setPosition(position);
    }

    public void changeDepartment(int id, String department) {
        Employee e = findEmployeeById(id);
        if (department.equals("finance")) e.getJob().setDepartment(FINANCE);
        else if (department.equals("hr")) e.getJob().setDepartment(HR);
        else if (department.equals("it")) e.getJob().setDepartment(IT);
        else if (department.equals("marketing")) e.getJob().setDepartment(MARKETING);
    }

    public void changeTelephone(int id, String telephone) {
        Employee e = findEmployeeById(id);
        e.setTelephone(telephone);
    }

    public void changeSalary(int id, double salary) {
        Employee e = findEmployeeById(id);
        e.setSalary(salary);
    }

    public void changeBoss(int id, int bossId) {
        Employee employee = findEmployeeById(id);
        Employee boss = findEmployeeById(bossId);
        employee.setBoss(boss);
    }

    public void changeGender(int id, Gender gender) {
        Employee e = findEmployeeById(id);
        e.setGender(gender);
    }

    public void changeBirthDate(int id, LocalDate birthDate) {
        Employee e = findEmployeeById(id);
        e.setBirthDate(birthDate);
    }

    public void changeJobEnterDate(int id, LocalDate enterDate) {
        Employee e = findEmployeeById(id);
        e.getJob().setJobEnterDate(enterDate);
    }
}
