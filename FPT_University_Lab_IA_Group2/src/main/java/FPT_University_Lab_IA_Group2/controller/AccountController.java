/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller;

import FPT_University_Lab_IA_Group2.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import FPT_University_Lab_IA_Group2.service.AccountService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chuoiz
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/account-list"})
    public String listAccount(Model model) {
        model.addAttribute("listAccount", accountService.findAll());
        return "account-list";
    }

    @RequestMapping("/account-save")
    public String insertAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account-save";
    }

    @RequestMapping("/saveAccount")
    public String doSaveAccount(@ModelAttribute("Account") Account account, Model model) {
        accountService.save(account);
        model.addAttribute("listAccount", accountService.findAll());
        return "account-list";
    }

    @RequestMapping("/updateAccount")
    public String doUpdateAccount(@ModelAttribute("Account") Account account, Model model) {
        accountService.update(account);
        model.addAttribute("listAccount", accountService.findAll());
        return "account-list";
    }

    // -- authentication ---
    @GetMapping("/login")
    public String login() {
        return "authentication/login";
    }

    @PostMapping("/login")
    public String submitLogin(HttpServletRequest req, Model model) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = accountService.accountAuthentication(username, password);
        req.getSession().setAttribute("account", account);
        if (account != null) {
            String role = account.getRoles().get(0).getRoleName().toLowerCase(); // student - teacher
            return "redirect: " + role + "/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "authentication/login";
        }
    }

    @RequestMapping("/login_fail")
    public String loginFail() {
        return "authentication/login_fail";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        // do something to logout
        req.getSession().removeAttribute("account");
        return "authentication/login";
    }

    //---- home -----
    @RequestMapping("/student/home")
    public String studentHome() {
        return "student/student-home";
    }

    @RequestMapping("/teacher/home")
    public String intructorHome() {
        return "teacher/teacher-home";
    }
}
