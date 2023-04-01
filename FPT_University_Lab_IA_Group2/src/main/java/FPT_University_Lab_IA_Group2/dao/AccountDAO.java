/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import java.util.List;
import FPT_University_Lab_IA_Group2.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Account acc = sessionFactory.getCurrentSession().find(Account.class, username);
        return acc;
    }

    public void delete(final Account account) {
        sessionFactory.getCurrentSession().remove(account);
    }

    public List<Account> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Account", Account.class).getResultList();
    }

    public Account accountAuthentication(String username, String password) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "from Account a\n"
                + "where a.username = :u and a.password = :p";
        Query q = session.createQuery(hql);

        q.setParameter("u", username);
        q.setParameter("p", password);
        Account account = (Account) q.uniqueResult();

        System.out.println(account.getRoles());

        return account;
    }

}
