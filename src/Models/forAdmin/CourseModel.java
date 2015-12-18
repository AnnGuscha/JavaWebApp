package Models.forAdmin;

/**
 * Created by Anna on 12/13/2015.
 */
public class CourseModel {

    int id;
    int idProfessor;
    String name;
    String nameProfessor;
    String description;
    String mark;

    public CourseModel() {
    }

    public CourseModel(String name, int idProfessor, String description, String nameProfessor) {
        this.name = name;
        this.idProfessor = idProfessor;
        this.nameProfessor = nameProfessor;
        this.description = description;
    }

    public CourseModel(int id, String name, int idProfessor, String description, String nameProfessor) {
        this.id = id;
        this.name = name;
        this.idProfessor = idProfessor;
        this.nameProfessor = nameProfessor;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNameProfessor() {
        return nameProfessor;
    }

    public void setNameProfessor(String nameProfessor) {
        this.nameProfessor = nameProfessor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
