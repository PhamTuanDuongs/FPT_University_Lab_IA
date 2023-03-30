/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import java.util.List;
import FPT_University_Lab_IA_Group2.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "accountDAO")
@Transactional(rollbackFor = Exception.class)
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(final Account account) {
        sessionFactory.getCurrentSession().persist(account);
    }

    public Account findByUsername(final String username) {
        return sessionFactory.getCurrentSession().find(Account.class, username);
    }

    public void delete(final Account account) {
        sessionFactory.getCurrentSession().remove(account);
    }

    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Account", Account.class).getResultList();
    }

    public boolean isValidAccount(String username, String password) {

        String sql = "Select * from Account\n"
                + "where username = ? and `password` = ?;";
        System.out.println(sessionFactory.getCurrentSession().createQuery(sql).getSingleResult());

        return false;
    }
}
