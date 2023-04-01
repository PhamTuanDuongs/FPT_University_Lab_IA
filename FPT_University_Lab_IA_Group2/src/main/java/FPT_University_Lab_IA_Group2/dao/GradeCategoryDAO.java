/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FPT_University_Lab_IA_Group2.dao;

import FPT_University_Lab_IA_Group2.model.GradeCategory;
import FPT_University_Lab_IA_Group2.model.Group;
import FPT_University_Lab_IA_Group2.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author chuoiz
 */
@Repository(value = "gradeCategoryDAO")
@Transactional(rollbackFor = Exception.class)
public class GradeCategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<GradeCategory> listGradeCategory(String studentId, String semesterId, String courseId) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "SELECT gc\n"
                + "FROM Student s\n"
                + "JOIN s.groups g\n"
                + "JOIN g.course c\n"
                + "JOIN c.gradeCategorys gc\n"
                + "JOIN gc.grades gr\n"
                + "JOIN gr.semester ses\n"
                + "where s.studentId = 'HE171578' and gc.gradeItemName != 'Total' AND c.courseId = 'PRJ301'\n"
                + "AND ses.semesterId = 'SP2023' and s.studentId = gr.student.studentId";
        Query q = session.createQuery(hql);
//        q.setParameter("sid", studentId);
//        q.setParameter("couid", courseId);
//        q.setParameter("sesid", semesterId);

        List<GradeCategory> gcs = q.getResultList();
        for (GradeCategory gc : gcs) {
            System.out.println(gc.getGrades());
        }

        return gcs;

    }

}
