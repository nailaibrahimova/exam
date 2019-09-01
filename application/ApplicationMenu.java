package exam.application;

import exam.controller.DepartmentController;
import exam.controller.EmployeeController;
import exam.controller.UserController;
import exam.exception.WrongEmployeeException;
import exam.exception.WrongUserException;
import exam.logger.MyLogger;
import exam.model.*;
import exam.validator.Validation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static exam.model.Department.*;
import static exam.model.Gender.FEMALE;
import static exam.model.Gender.MALE;

public class ApplicationMenu {
    public static EmployeeController employeeController = new EmployeeController();
    public static final Logger LOGGER = MyLogger.myLoggerWithFileHandler();

    public static void start() {
        UserController userController = new UserController();

        Employee employee = new Employee("Ibrahimova Naila Qabil", Gender.FEMALE, "+994507609917", LocalDate.of(1999, 8, 24));
        employee.setJob(new Job("Intern", IT, LocalDate.now().minusMonths(3)));
        try {
            employeeController.addEmployee(employee);
        } catch (WrongEmployeeException ex) {
            System.out.println(ex.getMessage());
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }

        System.out.println("1-Войти\n2-Выйти");
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        User user = new User();
        loop1:
        while (true) {
            if (action.equals("1")) {
                System.out.println("login: ");
                String login = sc.nextLine();
                System.out.println("password: ");
                String password = sc.nextLine();
                user.setLogin(login).setPassword(password);
                try {
                    userController.signin(user);
                    loop2:
                    while (true) {
                        System.out.println("\n1-добавить сотрудника\n2-удалить сотрудника\n3-найти сотрудников\n4-просмотреть отчёты\n" +
                                "5-изменить информацию\n6-выйти");
                        action = sc.nextLine();
                        if (action.equals("6")) break loop1;
                        if (action.equals("1")) {
                            loop3:
                            while (true) {
                                System.out.println("1-Add employee\n2-Back");
                                action = sc.nextLine();
                                if (action.equals("1")) {
                                    Employee e = new Employee();
                                    System.out.println();
                                    System.out.println("name(FIO) : ");
                                    String name = sc.nextLine();
                                    e.setName(name);

                                    System.out.println("gender(1-male, 2-female) : ");
                                    String gender = sc.nextLine();
                                    if (gender.equals("1")) e.setGender(MALE);
                                    else if (gender.equals("2")) e.setGender(FEMALE);

                                    System.out.println("birth date(dd/mm/yyyy) : ");
                                    String birthDate = sc.nextLine();
                                    String[] date = birthDate.split("/");
                                    if (date.length == 3)
                                        e.setBirthDate(LocalDate.of(Integer.valueOf(date[2]), Integer.valueOf(date[1]), Integer.valueOf(date[0])));
                                    System.out.println("telephone : ");
                                    String telephone = sc.nextLine();
                                    if (Validation.validateTelephone(telephone)) {
                                        e.setTelephone(telephone);
                                        LOGGER.info("Telephone number successfully read");
                                    } else {
                                        System.out.println("Wrong telephone description");
                                        LOGGER.info("Wrong telephone description");
                                    }

                                    e.setJob(new Job());
                                    System.out.println("position(example: Intern, Manager) : ");
                                    String position = sc.nextLine();
                                    e.getJob().setPosition(position);

                                    System.out.println("department(finance, it, hr, marketing) : ");
                                    String department = sc.nextLine();
                                    if (department.equals("finance")) e.getJob().setDepartment(FINANCE);
                                    else if (department.equals("hr")) e.getJob().setDepartment(HR);
                                    else if (department.equals("it")) e.getJob().setDepartment(IT);
                                    else if (department.equals("marketing")) e.getJob().setDepartment(MARKETING);
                                    System.out.println("job enter date(dd/mm/yyyy) : ");
                                    String jobEnterDate = sc.nextLine();
                                    String[] enterDate = jobEnterDate.split("/");
                                    if (enterDate.length == 3) {
                                        LocalDate date1 = LocalDate.of(Integer.valueOf(enterDate[2]), Integer.valueOf(enterDate[1]), Integer.valueOf(enterDate[0]));
                                        if (Validation.validateAge(e.getBirthDate())) {
                                            e.getJob().setJobEnterDate(date1);
                                            LOGGER.info("Acceptable for work age");
                                        } else {
                                            System.out.println("Unacceptable age");
                                            LOGGER.info("Unacceptable age");
                                            System.out.println("Try again to add employee!!!");
                                            continue loop2;
                                        }
                                    }
                                    System.out.println("salary : ");
                                    double salary = sc.nextDouble();
                                    e.setSalary(salary);
                                    System.out.println();
                                    try {
                                        employeeController.addEmployee(e);
                                        System.out.println(e.getId() + " " + e.getName());
                                        LOGGER.info("Successfully added");
                                    } catch (WrongEmployeeException ex) {
                                        System.out.println(ex.getMessage());
                                    }
                                } else if (action.equals("2")) break loop3;
                            }
                        } else if (action.equals("2")) {
                            loop4:
                            while (true) {
                                System.out.println("1-Delete\n2-Back");
                                action = sc.nextLine();
                                if (action.equals("1")) {
                                    System.out.print("id : ");
                                    int id = sc.nextInt();
                                    try {
                                        employeeController.removeEmployee(id);
                                        LOGGER.info("Successfully removed");
                                        employeeController.allEmployeesList().forEach((Employee employee1) -> System.out.println(employee1.getId() + " " + employee1.getName()));
                                    } catch (WrongEmployeeException ex) {
                                        System.out.println(ex.getMessage());
                                        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                    }
                                } else if (action.equals("2")) break loop4;
                            }
                        } else if (action.equals("3")) {
                            loop5:
                            while (true) {
                                System.out.println("1-Find employee\n2-Back");
                                action = sc.nextLine();
                                if (action.equals("1")) {
                                    System.out.println("1-By name\n2-By position\n3-By department\n4-By boss\n5-By id");
                                    action = sc.nextLine();
                                    if (action.equals("1")) {
                                        Employee e2;
                                        System.out.println("Enter name: ");
                                        String name = sc.nextLine();
                                        System.out.println(name);
                                        try {
                                            e2 = employeeController.findEmployeeByName(name);
                                            LOGGER.info("Employee with name  " + name + "is found");
                                            System.out.println(e2.getId() + " " + e2.getName() + " " + e2.getJob().getPosition() + " " + e2.getJob().getDepartment() + " " + e2.getSalary());
                                        } catch (WrongEmployeeException ex) {
                                            System.out.println(ex.getMessage());
                                            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                        }
                                    } else if (action.equals("2")) {
                                        System.out.println("position(example: Intern, Manager): ");
                                        String position = sc.nextLine();
                                        try {
                                            employeeController.findEmployeesByPosition(position).forEach((Employee employee1) -> System.out.println(employee1.getId() + " " + employee1.getName()));
                                            LOGGER.info("Employees in position " + position + " are found");
                                        } catch (WrongEmployeeException ex) {
                                            System.out.println(ex.getMessage());
                                            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                        }
                                    } else if (action.equals("3")) {
                                        System.out.println("department(finance, it, hr, marketing): ");
                                        String department = sc.nextLine();
                                        List<Employee> employeesList = employeeController.findEmployeesByDepartment(Enum.valueOf(Department.class, department.toUpperCase()));
                                        LOGGER.info("Employees in department " + department + " are found");
                                        employeesList.forEach((Employee employee1) -> System.out.println(employee1.getId() + " " + employee1.getName()));
                                    } else if (action.equals("4")) {
                                        List<Employee> employeeList;
                                        System.out.println("boss name: ");
                                        String bossName = sc.nextLine();
                                        System.out.println(bossName);
                                        try {
                                            employeeList = employeeController.findEmployeesByBoss(bossName);
                                            LOGGER.info("Employees with boss " + bossName + " are found");
                                            employeeList.forEach((Employee employee1) -> System.out.println(employee1.getId() + " " + employee1.getName()));
                                        } catch (WrongEmployeeException ex) {
                                            System.out.println(ex.getMessage());
                                            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                        }
                                    } else if (action.equals("5")) {
                                        System.out.println("id: ");
                                        int id = sc.nextInt();
                                        try {
                                            System.out.println(employeeController.findEmployeeById(id));
                                            LOGGER.info("Employees with id " + id + " is found");
                                        } catch (WrongEmployeeException ex) {
                                            System.out.println(ex.getMessage());
                                            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                        }
                                    }
                                } else if (action.equals("2")) break loop5;
                            }
                        } else if (action.equals("4")) {
                            loop6:
                            while (true) {
                                System.out.println("1-Report\n2-Back");
                                action = sc.nextLine();
                                if (action.equals("1")) {
                                    System.out.println("1-структура организации (информация об отделах, ФИО начальников отделов)\n" +
                                            "2-средняя зарплата по организации и по отделам\n" +
                                            "3-топ–10 самых дорогих сотрудников по зарплате\n" +
                                            "4-топ–10 самых преданных сотрудников по количеству лет работы в организации\n");
                                    action = sc.nextLine();
                                    if (action.equals("1")) {
                                        employeeController.printAllInformation();
                                        LOGGER.info("All information about organization is printed");
                                    } else if (action.equals("2")) {
                                        employeeController.printAverageSalary();
                                        LOGGER.info("All information about average salaries in organization and in each department is printed");
                                    } else if (action.equals("3")) {
                                        employeeController.topEmployeesForSalary();
                                        LOGGER.info("Top-10 employees for their salary are printed");
                                    } else if (action.equals("4")) {
                                        employeeController.topEmployeesForWorkYears();
                                        LOGGER.info("Top-10 employees for their working years are printed");
                                    }
                                } else if (action.equals("2")) break loop6;
                            }
                        } else if (action.equals("5")) {
                            loop7:
                            while (true) {
                                System.out.println("1-Change information\n2-Back");
                                action = sc.nextLine();
                                if (action.equals("1")) {
                                    System.out.println("1-name\n2-salary\n3-position\n4-department\n5-telephone\n6-boss\n" +
                                            "7-director of department\n8-birth date\n9-gender\n10-employment start date");
                                    action = sc.nextLine();
                                    employeeController.allEmployeesList().forEach((Employee employee1) -> System.out.println(employee1.getId() + " " + employee1.getName()));
                                    System.out.println("id of employee to change information : ");
                                    int id = sc.nextInt();
                                    if (action.equals("1")) {
                                        System.out.println("name : ");
                                        String name = sc.next() + sc.nextLine();
                                        employeeController.changeName(id, name);
                                        LOGGER.info("Name of employee with id=" + id + " is changed");
                                    } else if (action.equals("2")) {
                                        System.out.println("salary: ");
                                        double salary = sc.nextDouble();
                                        sc.nextLine();
                                        employeeController.changeSalary(id, salary);
                                        LOGGER.info("Salary of employee with id=" + id + " is changed");
                                    } else if (action.equals("3")) {
                                        System.out.println("position(example: Intern, Manager): ");
                                        String position = sc.next() + sc.nextLine();
                                        employeeController.changePosition(id, position);
                                        LOGGER.info("Position of employee with id=" + id + " is changed");
                                    } else if (action.equals("4")) {
                                        System.out.println("department(finance, it, hr, marketing): ");
                                        String department = sc.next() + sc.nextLine();
                                        employeeController.changeDepartment(id, department);
                                        LOGGER.info("Department of employee with id=" + id + " is changed");
                                    } else if (action.equals("5")) {
                                        System.out.println("telephone: ");
                                        String telephone = sc.next() + sc.nextLine();
                                        employeeController.changeTelephone(id, telephone);
                                        LOGGER.info("Telephone of employee with id=" + id + " is changed");
                                    } else if (action.equals("6")) {
                                        System.out.println("id of boss: ");
                                        int bossId = sc.nextInt();
                                        employeeController.changeBoss(id, bossId);
                                        LOGGER.info("Boss of employee is changed");
                                    } else if (action.equals("7")) {
                                        DepartmentController departmentController = new DepartmentController();
                                        System.out.println("department(finance, it, hr, marketing): ");
                                        String department = sc.next() + sc.nextLine();
                                        Department department1 = null;
                                        if (department.equals("finance")) department1 = FINANCE;
                                        else if (department.equals("hr")) department1 = HR;
                                        else if (department.equals("it")) department1 = IT;
                                        else if (department.equals("marketing")) department1 = MARKETING;
                                        try {
                                            Employee e = employeeController.findEmployeeById(id);
                                            departmentController.setDepartmentDirector(department1, e);
                                            LOGGER.info("Director of department successfully changed");
                                        } catch (WrongEmployeeException ex) {
                                            System.out.println(ex.getMessage());
                                            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                                        }
                                    } else if (action.equals("8")) {
                                        System.out.println("birth date(dd/mm/yyyy): ");
                                        String date = sc.next() + sc.nextLine();
                                        String[] dates = date.split("/");
                                        if (dates.length == 3) {
                                            LocalDate birthDate = LocalDate.of(Integer.valueOf(dates[2]), Integer.valueOf(dates[1]), Integer.valueOf(dates[0]));
                                            employeeController.changeBirthDate(id, birthDate);
                                            LOGGER.info("Birth date of employee with id " + id + " successfully changed");
                                        }
                                    } else if (action.equals("9")) {
                                        System.out.println("gender(1-male,2-female): ");
                                        action = sc.nextLine();
                                        if (action.equals("1")) {
                                            employeeController.changeGender(id, MALE);
                                        } else if (action.equals("2")) employeeController.changeGender(id, FEMALE);
                                        LOGGER.info("Gender of employee with id " + id + " successfully changed");
                                    } else if (action.equals("10")) {
                                        System.out.println("job enter date(dd/mm/yyyy): ");
                                        String date = sc.next() + sc.nextLine();
                                        String[] dates = date.split("/");
                                        if (dates.length == 3) {
                                            LocalDate enterDate = LocalDate.of(Integer.valueOf(dates[2]), Integer.valueOf(dates[1]), Integer.valueOf(dates[0]));
                                            employeeController.changeJobEnterDate(id, enterDate);
                                            LOGGER.info("Job enter date of employee with id " + id + " successfully changed");
                                        }
                                    }
                                } else if (action.equals("2")) break loop7;
                            }
                        }
                    }
                } catch (WrongUserException ex) {
                    System.out.println(ex.getMessage());
                    LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                }
            } else if (action.equals("2")) {
                LOGGER.info("Successfully exited");
                break loop1;
            }//else
        }//while
    }
}
