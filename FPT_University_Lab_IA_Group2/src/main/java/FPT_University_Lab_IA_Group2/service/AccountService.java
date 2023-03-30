/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.service;

import FPT_University_Lab_IA_Group2.dao.AccountDAO;
import java.util.List;
import FPT_University_Lab_IA_Group2.model.Account;
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

    public boolean isValid(Account account) {

        return accountDAO.isValidAccount(account.getUsername(), account.getPassword());
    }

}
