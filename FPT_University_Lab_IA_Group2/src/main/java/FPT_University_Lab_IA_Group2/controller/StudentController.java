/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller;

import FPT_University_Lab_IA_Group2.dao.AccountDAO;
import FPT_University_Lab_IA_Group2.dao.CourseDAO;
import FPT_University_Lab_IA_Group2.dao.GradeDAO;
import FPT_University_Lab_IA_Group2.model.Account;
import FPT_University_Lab_IA_Group2.model.Course;
import FPT_University_Lab_IA_Group2.model.Curriculum;
import FPT_University_Lab_IA_Group2.model.Grade;
import FPT_University_Lab_IA_Group2.model.Student;
import FPT_University_Lab_IA_Group2.service.AccountService;
import FPT_University_Lab_IA_Group2.service.CourseService;
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
    CourseService coureCourseService;

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

    
}
