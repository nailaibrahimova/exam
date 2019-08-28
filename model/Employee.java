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

    private static int nextId=1;

    {
        id=nextId;
        nextId++;
    }

    public Employee(String name, Gender gender, String telephone){
        this.name=name;
        this.gender=gender;
        this.telephone=telephone;
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

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
