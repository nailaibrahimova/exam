package exam.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Job {
    private String position;
    private Department department;
    private LocalDate jobEnterDate;

    public Job(String position, Department department, LocalDate jobEnterDate) {
        this.position = position;
        this.department = department;
        this.jobEnterDate = jobEnterDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getJobEnterDate() {
        return jobEnterDate;
    }

    public void setJobEnterDate(LocalDate jobEnterDate) {
        this.jobEnterDate = jobEnterDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date=jobEnterDate.format(dateTimeFormatter);
        return "Job{" +
                "position='" + position + '\'' +
                ", department=" + department +
                ", jobEnterDate=" + date +
                '}';
    }
}
