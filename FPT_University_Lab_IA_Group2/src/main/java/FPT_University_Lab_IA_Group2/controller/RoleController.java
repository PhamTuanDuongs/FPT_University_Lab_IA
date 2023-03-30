/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.controller;

import FPT_University_Lab_IA_Group2.model.Role;
import FPT_University_Lab_IA_Group2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author chuoiz
 */

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/role-list"})
    public String listRole(Model model) {
        model.addAttribute("listRole", roleService.findAll());
        return "role-list";
    }

    @RequestMapping("/role-save")
    public String insertRole(Model model) {
        model.addAttribute("role", new Role());
        return "role-save";
    }

    @RequestMapping("/saveRole")
    public String doSaveRole(@ModelAttribute("Role") Role role, Model model) {
        roleService.save(role);
        model.addAttribute("listRole", roleService.findAll());
        return "role-list";
    }

    @RequestMapping("/updateRole")
    public String doUpdateRole(@ModelAttribute("Role") Role role, Model model) {
        roleService.update(role);
        model.addAttribute("listRole", roleService.findAll());
        return "role-list";
    }
}
