package Controllers;

import Entity.Student;
import Infrastructure.ServiceLocator;
import levelDAO.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 12/9/2015.
 */
@WebServlet(
        name = "StudentController",
        urlPatterns = {"/student"}
)


public class StudentController extends HttpServlet {
    StudentDAO studentDAO = ServiceLocator.getFactory().getStudentDAO();

    //private static final Logger log = Logger.getLogger(StudentController.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action != null) {
            switch (action) {
                case "searchById":
                    searchStudentById(req, resp);
                    break;
                case "searchByName":
                    searchStudentByName(req, resp);
                    break;
            }
        } else {
            List<Student> result = studentDAO.getAll();
            List<String> list = new ArrayList<String>();
            //String json = new Gson().toJson(list);
            forwardListStudents(req, resp, result);

        }
    }

    private void searchStudentById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idStudent = Integer.valueOf(req.getParameter("idStudent"));
        Student student = null;
        try {
            student = studentDAO.find(idStudent);
        } catch (Exception ex) {
            //log.error("Error: ", ex);//Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("student", student);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-student.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void searchStudentByName(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String studentName = req.getParameter("studentName");
        List<Student> result = studentDAO.find(studentName);
        forwardListStudents(req, resp, result);
    }

    private void forwardListStudents(HttpServletRequest req, HttpServletResponse resp, List studentList)
            throws ServletException, IOException {
        String nextJSP = "/Views/Student/Index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("studentList", studentList);
        dispatcher.forward(req, resp);
    }

}

