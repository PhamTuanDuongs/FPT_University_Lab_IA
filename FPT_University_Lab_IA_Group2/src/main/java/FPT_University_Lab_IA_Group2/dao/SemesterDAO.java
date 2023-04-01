/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.Semester;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "semesterDAO")
@Transactional(rollbackFor = Exception.class)
public class SemesterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Semester> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Semester", Semester.class).getResultList();
    }

}
