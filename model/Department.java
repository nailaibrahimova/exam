package exam.model;

public enum Department {
    FINANCE, IT, HR, MARKETING, SALES, LOGISTICS, SECURITY;

    private String director;

    public void setDirector(String director) {
        this.director = director;
    }
}
