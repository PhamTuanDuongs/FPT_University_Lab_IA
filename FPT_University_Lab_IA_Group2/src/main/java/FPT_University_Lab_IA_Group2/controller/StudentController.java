/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller;

import FPT_University_Lab_IA_Group2.model.Account;
import FPT_University_Lab_IA_Group2.model.Student;
import FPT_University_Lab_IA_Group2.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chuoiz
 */
@Controller
public class StudentController {

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
}
