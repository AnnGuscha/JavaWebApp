package Models;

/**
 * Created by Anna on 12/13/2015.
 */
public class MarkModel {

    public int id;
    public String nameCourse;
    public String nameStudent;
    public String comment;

    public MarkModel(String nameCourse, String nameStudent, String comment) {
        this.nameCourse = nameCourse;
        this.nameStudent = nameStudent;
        this.comment = comment;
    }
}
