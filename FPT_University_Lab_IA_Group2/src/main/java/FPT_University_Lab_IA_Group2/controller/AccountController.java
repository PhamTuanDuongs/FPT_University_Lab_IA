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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("")
    public String home() {
        return "authentication/login";
    }

    // ------------------------------------------------------------------------------------------
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("account", new Account());
        return "authentication/login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("Account") Account account, Model model) {

        Account accDB = accountService.findByAccountname(account.getUsername());
        if (accDB != null && account.getUsername().equalsIgnoreCase(accDB.getUsername())
                && account.getPassword().equals(accDB.getPassword())) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "authentication/login";
        }
    }

}
