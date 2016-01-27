package models.admin;

/**
 * Created by Anna on 12/13/2015.
 */
public class MarkModel {

    private int id;
    private String nameCourse;
    private String nameStudent;
    private String comment;

    public MarkModel(String nameCourse, String nameStudent, String comment) {
        this.setNameCourse(nameCourse);
        this.setNameStudent(nameStudent);
        this.setComment(comment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
