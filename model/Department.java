package exam.model;

public enum Department {
    FINANCE, IT, HR, MARKETING;

    private Employee director;

    public void setDirector(Employee director) {
        this.director = director;
    }
}
