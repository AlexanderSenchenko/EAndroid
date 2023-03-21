package ru.eltex;

public class Manager extends User {

    private Integer countProjects;

    public Manager() {}

    Manager(Integer id, String name, Integer countProjects) {
        super(id, name);
        this.countProjects = countProjects;
    }

    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countProjects='" + countProjects + '\'' +
                '}';
    }

    public Integer getCountProjects() {
        return countProjects;
    }

    public void setCountProjects(Integer countProjects) {
        this.countProjects = countProjects;
    }
}
