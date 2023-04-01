/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.AccountDAO;
import java.util.List;
import FPT_University_Lab_IA_Group2.model.Account;
import FPT_University_Lab_IA_Group2.model.Feature;
import FPT_University_Lab_IA_Group2.model.Role;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    public Account findByAccountname(final String username) {
        return accountDAO.findByUsername(username);
    }

    public void save(final Account account) {
        // check if account exist -> throw exception
        accountDAO.persist(account);
    }

    public void update(final Account account) {
        // if accountDB = null -> throw Exception
        Account accountDB = accountDAO.findByUsername(account.getUsername());
        accountDB.setUsername(account.getUsername());
        accountDB.setPassword(account.getPassword());
        accountDAO.persist(accountDB);
    }

    public void delete(final String username) {
        Account account = accountDAO.findByUsername(username);
        if (account != null) {
            accountDAO.delete(account);
        }
    }

     private boolean isAuthorized(HttpServletRequest req) {
        Account account = (Account) req.getSession().getAttribute("user");
        String currentUrl = req.getServletPath();//"/student/add"
        try {
            for (Role role : account.getRoles()) {
                //System.out.println(role.getRole_name());
                for (Feature feature : role.getFeatures()) {
                    //System.out.println(feature.getFeature_name());
                    if (feature.getUrl().equals(currentUrl)) {
                        //System.out.println(feature.getUrl());
                        return true;
                    }
                }
            }
        } catch (Exception e) {

        }
        return false;
    }
    
    public Account accountAuthentication(String username, String password) {
        Account accDB = accountDAO.accountAuthentication(username, password);
        return accDB;
    }
    
}
