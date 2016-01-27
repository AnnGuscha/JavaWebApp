package models.professor;

/**
 * Created by Anna on 12/19/2015.
 */
public class StudentsForProfessorModel {

    private int id;
    private String name;
    private String mark;

    public StudentsForProfessorModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
