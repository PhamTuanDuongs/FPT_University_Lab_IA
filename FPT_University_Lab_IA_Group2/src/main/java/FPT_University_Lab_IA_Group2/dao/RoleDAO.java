/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.Role;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "roleDAO")
@Transactional(rollbackFor = Exception.class)
public class RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(final Role role) {
        sessionFactory.getCurrentSession().persist(role);
    }

    public Role findById(final int id) {
        return sessionFactory.getCurrentSession().find(Role.class, id);
    }

    public void delete(final Role role) {
        sessionFactory.getCurrentSession().remove(role);
    }

    public List<Role> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Role", Role.class).getResultList();
    }
}
