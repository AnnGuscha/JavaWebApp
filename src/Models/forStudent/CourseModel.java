package Models.forStudent;

/**
 * Created by Anna on 12/16/2015.
 */
public class CourseModel {

    private int id;
    private String name;
    private int idProfessor;
    private String professor;

    public CourseModel() {
    }

    public CourseModel(int id, String name, int idProfessor, String professor) {
        this.id = id;
        this.name = name;
        this.idProfessor = idProfessor;
        this.professor = professor;
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

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
