package exam.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private String telephone;
    private Job job;
    private Employee boss;
    private double salary;
    private static int nextId = 0;

    public Employee(){
        id=getNextId();
    }

    public Employee(String name, Gender gender){
        id = getNextId();
        this.name = name;
        this.gender = gender;
    }

    public Employee(String name, Gender gender, String telephone, LocalDate birthDate) {
        id = getNextId();
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public Job getJob() {
        return job;
    }

    public Employee getBoss() {
        return boss;
    }

    public double getSalary() {
        return salary;
    }

    public static int getNextId() {
        nextId++;
        return nextId;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Employee setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Employee setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Employee setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Employee setJob(Job job) {
        this.job = job;
        return this;
    }

    public Employee setBoss(Employee boss) {
        this.boss = boss;
        return this;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id + ", " +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", telephone='" + telephone + '\'' +
                ", job=" + job +
                ", boss=" + boss +
                ", salary=" + salary +
                '}';
    }
}
