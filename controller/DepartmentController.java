package exam.controller;

import exam.model.Department;
import exam.model.Employee;
import exam.service.DepartmentService;

import java.util.List;

public class DepartmentController {
    private DepartmentService departmentService = new DepartmentService();

    public List<Department> departmentList() {
        return departmentService.departmentList();
    }

    public void setDepartmentDirector(Department department, Employee e) {
        departmentService.setDepartmentDirector(department, e);
    }

}
