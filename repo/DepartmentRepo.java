package exam.repo;

import exam.model.Department;
import exam.model.Employee;

import java.util.Arrays;
import java.util.List;

public class DepartmentRepo {
    public List<Department> departmentList() {
        return Arrays.asList(Department.values());
    }

    public void setDepartmentDirector(Department department, Employee e) {
        Employee employee = department.getDirector();
        employee.getJob().setPosition(null);
        department.setDirector(e);
        e.getJob().setPosition("Director");
        e.getJob().setDepartment(department);
    }
}
