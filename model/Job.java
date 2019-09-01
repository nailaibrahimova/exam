package exam.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Job {
    private String position;
    private Department department;
    private LocalDate jobEnterDate;

    public Job() {
    }

    public Job(String position, Department department, LocalDate jobEnterDate) {
        this.position = position;
        this.department = department;
        this.jobEnterDate = jobEnterDate;
    }

    public String getPosition() {
        return position;
    }

    public Job setPosition(String position) {
        this.position = position;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public Job setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public LocalDate getJobEnterDate() {
        return jobEnterDate;
    }

    public Job setJobEnterDate(LocalDate jobEnterDate) {
        this.jobEnterDate = jobEnterDate;
        return this;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = jobEnterDate.format(dateTimeFormatter);
        return "Job{" +
                "position='" + position + '\'' +
                ", department=" + department +
                ", jobEnterDate=" + date +
                '}';
    }
}
