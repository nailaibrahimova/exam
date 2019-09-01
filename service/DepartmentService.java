package exam.service;

import exam.model.Department;
import exam.model.Employee;
import exam.repo.DepartmentRepo;

import java.util.List;

public class DepartmentService {
    private DepartmentRepo departmentRepo = new DepartmentRepo();

    public List<Department> departmentList() {
        return departmentRepo.departmentList();
    }

    public void setDepartmentDirector(Department department, Employee e) {
        departmentRepo.setDepartmentDirector(department, e);
    }
}
