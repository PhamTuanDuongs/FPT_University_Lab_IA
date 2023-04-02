/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.Grade;
import java.util.List;
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
@Repository(value = "gradeDAO")
@Transactional(rollbackFor = Exception.class)
public class GradeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Grade> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Grade", Grade.class).getResultList();
    }

    public List<Grade> listGrade(String studentId, String semesterId, String courseId) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT gr\n"
                + "FROM Student s\n"
                + "JOIN s.groups g\n"
                + "JOIN g.course c\n"
                + "JOIN c.gradeCategorys gc\n"
                + "JOIN gc.grades gr\n"
                + "JOIN gr.semester ses\n"
                + "where s.studentId = :sid and gc.gradeItemName != 'Total' AND c.courseId = :couid \n"
                + "AND ses.semesterId = :sesid and s.studentId = gr.student.studentId";
        Query q = session.createQuery(hql);
        q.setParameter("sid", studentId);
        q.setParameter("couid", courseId);
        q.setParameter("sesid", semesterId);

        List<Grade> grades = q.getResultList();
        return grades;

    }

    public List<Grade> listGradeByStudent(String studentId) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT \n"
                + "FROM Grade g"
                + "WHERE g.studentId = :sid ";

        Query q = session.createQuery(hql);
        q.setParameter("sid", studentId);

        List<Grade> grades = q.getResultList();
        return grades;
    }
}
