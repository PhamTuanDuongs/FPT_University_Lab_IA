/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.RoleDAO;
import FPT_University_Lab_IA_Group2.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    public Role findByUsername(final int id) {
        return roleDAO.findById(id);
    }

    public void save(final Role role) {
        // check if role exist -> throw exception
        roleDAO.persist(role);
    }

    public void update(final Role role) {
        // if roleDB = null -> throw Exception
        Role roleDB = roleDAO.findById(role.getRoleId());
        roleDB.setRoleName(role.getRoleName());
        roleDB.setRoleId(role.getRoleId());
        roleDAO.persist(roleDB);
    }

    public void delete(final int id) {
        Role role = roleDAO.findById(id);
        if (role != null) {
            roleDAO.delete(role);
        }
    }
}
