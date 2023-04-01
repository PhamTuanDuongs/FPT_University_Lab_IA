/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller.authentication;

import FPT_University_Lab_IA_Group2.model.Account;
import FPT_University_Lab_IA_Group2.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chuoiz
 */
@Controller
public class AuthenticationCotnroller {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String loginPage() {
        return "redirect: login";
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
            String role = account.getRoles().get(0).getRoleName().toLowerCase(); // student -- teacher
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
        return "redirect: login";
    }

}
