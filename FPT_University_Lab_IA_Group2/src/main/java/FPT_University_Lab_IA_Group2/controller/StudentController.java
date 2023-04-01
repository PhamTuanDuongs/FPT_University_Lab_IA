/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller;

import FPT_University_Lab_IA_Group2.model.Account;
import FPT_University_Lab_IA_Group2.model.Course;
import FPT_University_Lab_IA_Group2.model.Curriculum;
import FPT_University_Lab_IA_Group2.model.Grade;
import FPT_University_Lab_IA_Group2.model.Semester;
import FPT_University_Lab_IA_Group2.model.Student;
import FPT_University_Lab_IA_Group2.service.CourseService;
import FPT_University_Lab_IA_Group2.service.GradeService;
import FPT_University_Lab_IA_Group2.service.SemesterService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chuoiz
 */
@Controller
public class StudentController {

    @Autowired
    private CourseService coureCourseService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SemesterService semesterService;

    @RequestMapping("/student/home")
    public String studentHome(Account account, HttpServletRequest req) {

        req.setAttribute("account", account);
        return "student/student-home";
    }

    @RequestMapping("/student/info")
    public ModelAndView studentInfo(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();

        Account acc = (Account) req.getSession().getAttribute("account");
        Student student = acc.getStudent();

        mv.addObject("student", student);
        mv.setViewName("student/student-info");
        return mv;
    }

    @RequestMapping("/student/curriculum")
    public ModelAndView studentCurriculum(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView mv = new ModelAndView();

        Account acc = (Account) req.getSession().getAttribute("account");
        Student student = acc.getStudent();
        Curriculum cu = student.getCurriculum();

        List<Course> courses = coureCourseService.listCourseByCurriculum(cu.getCurriculumId());

        mv.addObject("curriculum", cu);
        mv.addObject("courses", courses);
        mv.setViewName("student/student-curriculum");

        return mv;
    }

    @RequestMapping("/student/viewGrade")
    public ModelAndView viewGrade(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();

        Account acc = (Account) req.getSession().getAttribute("account");
        Student st = acc.getStudent();

        List<Semester> semesters = semesterService.findAll();
        mv.addObject("semesters", semesters);
        String semesterId = req.getParameter("semesterId");
        semesterId = "SP2023";
        List<Course> courses = coureCourseService.listCourseBySemesterAndStudentId(semesterId, st.getStudentId());
        mv.addObject("courses", courses);
        String courseId = req.getParameter("courseId");

        List<Grade> grades = new ArrayList<>();

        if (courseId != null && semesterId != null) {
            grades = gradeService.listGrade(st.getStudentId(), semesterId, courseId);
        }
        float sum = 0;
        float percentage = 0;
        for (Grade grade : grades) {
            if (!grade.getGradeCategory().getGradeCategoryName().equalsIgnoreCase("Final Exam")) {
                sum += grade.getGradeValue() * grade.getGradeCategory().getWeight() / 100;
                percentage += grade.getGradeCategory().getWeight();
            }
        }
        if (percentage == 100) {
            mv.addObject("sum",  Math.round(sum * 10.0) / 10.0 );

        }
        mv.addObject("grades", grades);
        mv.addObject("semesterId", semesterId);
        mv.addObject("courseId", courseId);

        mv.setViewName("student/student-view-grade");
        return mv;
    }

}
